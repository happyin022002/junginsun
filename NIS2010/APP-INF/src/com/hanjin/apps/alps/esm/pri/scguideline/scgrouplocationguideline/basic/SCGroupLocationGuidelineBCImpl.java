/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCGuidelineMainBCImpl.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.15
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.04.15 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.integration.SCGroupLocationGuidelineDBDAO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.vo.GrpLocGlineVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocExcelVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scgrouplocationguideline.vo.RsltPriSgGrpLocVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriSgGrpLocVO;
import com.hanjin.syscommon.common.table.PriSgMnVO;

/**
 * NIS2010-SCGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-SCGuideline에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Park Sungsoo
 * @see UI_PRI_0001EventResponse,SCGuidelineMainBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SCGroupLocationGuidelineBCImpl extends BasicCommandSupport implements SCGroupLocationGuidelineBC {

	// Database Access Object
	private transient SCGroupLocationGuidelineDBDAO dbDao = null;

	/**
	 * SCGuidelineMainBCImpl 객체 생성<br>
	 * SCGuidelineMainDBDAO를 생성한다.<br>
	 */
	public SCGroupLocationGuidelineBCImpl() {
		dbDao = new SCGroupLocationGuidelineDBDAO();
	}

	/**
	 * Guideline - GroupLocation을 조회한다.<br>
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
	 * Guideline - GroupLocation Detail을 조회한다.<br>
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
	 * Group Location삭제시, Rate에서 사용하고 있는 코드인지 확인한다.<br>
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
	 * Excel Download를 위해 Group Location을 조회한다.<br>
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
	 * Group Location 데이터에 대한 CUD 이벤트를 처리합니다.<br>
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
	 * Guideline Main에서 Guideline을 삭제한다.<br>
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
	 * Group Guideline Copy를 처리합니다. <br>
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