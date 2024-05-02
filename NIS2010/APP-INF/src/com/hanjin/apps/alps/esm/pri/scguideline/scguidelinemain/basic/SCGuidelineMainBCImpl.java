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
package com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.integration.SCGuidelineMainDBDAO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.RsltGlineMnVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.RsltGlineScpEffDtListVO;
import com.hanjin.apps.alps.esm.pri.scguideline.scguidelinemain.vo.RsltGlineTermsCntVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSgMnVO;

/**
 * NIS2010-SCGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-SCGuideline에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Park Sungsoo
 * @see UI_PRI_0001EventResponse,SCGuidelineMainBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SCGuidelineMainBCImpl extends BasicCommandSupport implements SCGuidelineMainBC {

	// Database Access Object
	private transient SCGuidelineMainDBDAO dbDao = null;

	/**
	 * SCGuidelineMainBCImpl 객체 생성<br>
	 * SCGuidelineMainDBDAO를 생성한다.<br>
	 */
	public SCGuidelineMainBCImpl() {
		dbDao = new SCGuidelineMainDBDAO();
	}

	/**
	 * 선택된 Service Scope에 등록된 Guideline 리스트를 조회한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return List<RsltGlineScpEffDtListVO>
	 * @exception EventException
	 */
	public List<RsltGlineScpEffDtListVO> searchGuidelineScopeEffectiveDateList(PriSgMnVO priSgMnVO)
			throws EventException {
		try {
			return dbDao.searchGuidelineScopeEffectiveDateList(priSgMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * SC Guideline 메인화면을 조회한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return List<RsltGlineMnVO>
	 * @exception EventException
	 */
	public List<RsltGlineMnVO> searchGuidelineMain(PriSgMnVO priSgMnVO) throws EventException {
		try {
			return dbDao.searchGuidelineMain(priSgMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 하위 탭들에 데이터가 존재하는지 조회한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return List<RsltGlineTermsCntVO>
	 * @exception EventException
	 */
	public List<RsltGlineTermsCntVO> searchGuidelineTermsCount(PriSgMnVO priSgMnVO) throws EventException {
		try {
			return dbDao.searchGuidelineTermsCount(priSgMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Guideline Main 트랜잭션 데이터를 처리한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGuidelineMain(PriSgMnVO priSgMnVO, SignOnUserAccount account) throws EventException {
		try {
			boolean isNew = (priSgMnVO.getGlineSeq() == null || "X".equals(priSgMnVO.getGlineSeq())) ? true : false;
			if ("X".equals(priSgMnVO.getGlineSeq())) {
				priSgMnVO.setGlineSeq("-1");
			}
			boolean isValidDate = dbDao.searchGuidelineEffectiveDate(priSgMnVO);

			if (!isValidDate) {
				throw new EventException(new ErrorHandler("PRI08018").getMessage());
			}

			if (isNew) {
				priSgMnVO.setCreUsrId(account.getUsr_id());
				priSgMnVO.setUpdUsrId(account.getUsr_id());
				dbDao.addGuidelineMain(priSgMnVO);
			} else {
				priSgMnVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyGuidelineMain(priSgMnVO, "N");
			}
		} catch(EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Guideline을 Confirm합니다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmGuidelineMain(PriSgMnVO priSgMnVO, SignOnUserAccount account) throws EventException {
		try {
			priSgMnVO.setCfmFlg("Y");
			priSgMnVO.setCfmUsrId(account.getUsr_id());
			priSgMnVO.setCfmOfcCd(account.getOfc_cd());
			priSgMnVO.setUpdUsrId(account.getUsr_id());
			
			boolean hasChild = dbDao.searchCommodityHeaderHasChild(priSgMnVO);
			if (!hasChild) {
				throw new EventException(new ErrorHandler("PRI08020").getMessage());
			}

			dbDao.modifyGuidelineMain(priSgMnVO, "Y");
		} catch(EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Confirm된 Guideline을 Cancel합니다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGuidelineMain(PriSgMnVO priSgMnVO, SignOnUserAccount account) throws EventException {
		try {
			priSgMnVO.setCfmFlg("N");
			priSgMnVO.setCfmUsrId(account.getUsr_id());
			priSgMnVO.setCfmOfcCd(account.getOfc_cd());
			priSgMnVO.setUpdUsrId(account.getUsr_id());

			dbDao.modifyGuidelineMain(priSgMnVO, "Y");
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
			dbDao.removeGuidelineMain(priSgMnVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Guideline Main을 Copy한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineMain(PriSgMnVO priSgMnVO, SignOnUserAccount account) throws EventException {
		try {
			String newGlineSeq = String.valueOf(dbDao.searchGuidelineCopyGuidelineSeq(priSgMnVO) + 1);

			priSgMnVO.setGlineSeq(newGlineSeq);
			priSgMnVO.setCreUsrId(account.getUsr_id());
			priSgMnVO.setUpdUsrId(account.getUsr_id());
			dbDao.addGuidelineMain(priSgMnVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Guideline Effective Date가 중복인지 조회합니다. <br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkGuidelineEffectiveDate(PriSgMnVO priSgMnVO) throws EventException {
		try {
			return dbDao.searchGuidelineEffectiveDate(priSgMnVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Guideline Main 테이블에서 Seq를 채번합니다. <br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return String
	 * @exception EventException
	 */
	public String getGuidelineSeq(PriSgMnVO priSgMnVO) throws EventException {
		try {
			return String.valueOf(dbDao.searchGuidelineCopyGuidelineSeq(priSgMnVO));
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Guideline Main을 Copy 합니다. <br>
	 * 
	 * @param GlineMnCpVO glineMnCpVO
	 * @exception EventException
	 */
	public void copyGuidelineMainAll(GlineMnCpVO glineMnCpVO) throws EventException {
		try {
			dbDao.copyGuidelineMainAll(glineMnCpVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
}