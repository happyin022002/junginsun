/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCGuidelineMainBCImpl.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.integration.SCGroupLocationGuidelineDBDAO;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.vo.GrpLocGlineVO;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocDtlVO;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocExcelVO;
import com.clt.apps.opus.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgGrpLocDtlVO;
import com.clt.syscommon.common.table.PriSgGrpLocVO;
import com.clt.syscommon.common.table.PriSgMnVO;

/**
 * SCGuideline Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCGuideline<br>
 * 
 * @author Park Sungsoo
 * @see UI_PRI_0001EventResponse,SCGuidelineMainBC - refer to each DAO class
 * @since J2EE 1.4
 */

public class SCGroupLocationGuidelineBCImpl extends BasicCommandSupport implements SCGroupLocationGuidelineBC {

	// Database Access Object
	private transient SCGroupLocationGuidelineDBDAO dbDao = null;

	/**
	 * Creating SCGuidelineMainBCImpl object<br>
	 * Creating SCGuidelineMainDBDAO<br>
	 */
	public SCGroupLocationGuidelineBCImpl() {
		dbDao = new SCGroupLocationGuidelineDBDAO();
	}

	/**
	 * Retrieving Guideline - GroupLocation<br>
	 * 
	 * @param PriSgGrpLocVO priSgGrpLocVO
	 * @return List<RsltPriSgGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGrpLocVO> searchGroupLocationList(PriSgGrpLocVO priSgGrpLocVO) throws EventException {
		try {
			return dbDao.searchGroupLocationList(priSgGrpLocVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving Guideline - GroupLocation Detail<br>
	 * 
	 * @param PriSgGrpLocDtlVO priSgGrpLocVO
	 * @return List<RsltPriSgGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGrpLocDtlVO> searchGroupLocationDetailList(PriSgGrpLocDtlVO priSgGrpLocVO)
			throws EventException {
		try {
			return dbDao.searchGroupLocationDetailList(priSgGrpLocVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * checking whether code is in use at rate when deleting Group Location<br>
	 * 
	 * @param PriSgGrpLocVO priSgGrpLocVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkGroupLocationInUse(PriSgGrpLocVO priSgGrpLocVO) throws EventException {
		try {
			return dbDao.searchGroupLocationInUse(priSgGrpLocVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving group location to download excel<br>
	 * 
	 * @param PriSgGrpLocVO priSgGrpLocVO
	 * @return List<RsltPriSgGrpLocExcelVO>
	 * @exception EventException
	 */
	public List<RsltPriSgGrpLocExcelVO> searchGroupLocationListExcel(PriSgGrpLocVO priSgGrpLocVO) throws EventException {
		try {
			return dbDao.searchGroupLocationListExcel(priSgGrpLocVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Handling CUD event for Group Location data.<br>
	 * 
	 * @param GrpLocGlineVO grpLocGlineVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupLocationGuideline(GrpLocGlineVO grpLocGlineVO, SignOnUserAccount account)
			throws EventException {
		try {
			PriSgGrpLocVO[] vo = grpLocGlineVO.getPriSgGrpLocVOS();
			PriSgGrpLocDtlVO[] dtlvo = grpLocGlineVO.getPriSgGrpLocDtlVOS();

			List<PriSgGrpLocVO> insertVoList = new ArrayList<PriSgGrpLocVO>();
			List<PriSgGrpLocVO> updateVoList = new ArrayList<PriSgGrpLocVO>();
			List<PriSgGrpLocVO> deleteVoList = new ArrayList<PriSgGrpLocVO>();
			List<PriSgGrpLocDtlVO> insertDtlVoList = new ArrayList<PriSgGrpLocDtlVO>();
			List<PriSgGrpLocDtlVO> updateDtlVoList = new ArrayList<PriSgGrpLocDtlVO>();
			List<PriSgGrpLocDtlVO> deleteDtlVoList = new ArrayList<PriSgGrpLocDtlVO>();

			for (int i = 0; vo != null && i < vo.length; i++) {
				if (vo[i].getIbflag().equals("I")) {
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(vo[i]);
				} else if (vo[i].getIbflag().equals("U")) {
					vo[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vo[i]);
				} else if (vo[i].getIbflag().equals("D")) {
					deleteVoList.add(vo[i]);
				}
			}
			for (int i = 0; dtlvo != null && i < dtlvo.length; i++) {
				if (dtlvo[i].getIbflag().equals("I")) {
					dtlvo[i].setCreUsrId(account.getUsr_id());
					dtlvo[i].setUpdUsrId(account.getUsr_id());
					insertDtlVoList.add(dtlvo[i]);
				} else if (dtlvo[i].getIbflag().equals("U")) {
					dtlvo[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(dtlvo[i]);
				} else if (dtlvo[i].getIbflag().equals("D")) {
					deleteDtlVoList.add(dtlvo[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addGroupLocation(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addGroupLocationDetail(insertDtlVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyGroupLocation(updateVoList);
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyGroupLocationDetail(updateDtlVoList);
			}

			if (deleteDtlVoList.size() > 0) {
				dbDao.removeGroupLocationDetail(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeGroupLocationCascadeDetail(deleteVoList);
				dbDao.removeGroupLocation(deleteVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Deleting guideline from Guideline Main<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriSgMnVO priSgMnVO) throws EventException {
		try {
			dbDao.removeGuidelineMainGroupLocationDetail(priSgMnVO);
			dbDao.removeGuidelineMainGroupLocation(priSgMnVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Copying Group Guideline<br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMain(GlineMnCpVO glineMnCpVO) throws EventException {
		try {
			dbDao.addGuidelineMainGroupLocationCopy(glineMnCpVO);
			dbDao.addGuidelineMainGroupLocationDetailCopy(glineMnCpVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
}