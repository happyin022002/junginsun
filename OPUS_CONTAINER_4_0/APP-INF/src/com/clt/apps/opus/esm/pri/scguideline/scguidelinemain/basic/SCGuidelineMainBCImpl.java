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
package com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.integration.SCGuidelineMainDBDAO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.RsltGlineMnVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.RsltGlineScpEffDtListVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.RsltGlineTermsCntVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSgMnVO;

/**
 * SCGuideline Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCGuideline<br>
 * 
 * @author 
 * @see UI_PRI_0001EventResponse,SCGuidelineMainBC - refer to each DAO class
 * @since J2EE 1.4
 */

public class SCGuidelineMainBCImpl extends BasicCommandSupport implements SCGuidelineMainBC {

	// Database Access Object
	private transient SCGuidelineMainDBDAO dbDao = null;

	/**
	 * Creating SCGuidelineMainBCImpl Object<br>
	 * Creating SCGuidelineMainDBDAO<br>
	 */
	public SCGuidelineMainBCImpl() {
		dbDao = new SCGuidelineMainDBDAO();
	}

	/**
	 * Retrieving registered guideline list in selected Service scope<br>
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
	 * Retrieving SC Guideline's Main screen<br>
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
	 * Retrieving whether data exists on below tabs<br>
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
	 * Handing Guideline Main Transaction data<br>
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
	 * Confirming Guideline<br>
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
	 * Cancelling confirmed guideline<br>
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
	 * Cancelling guideline in Guideline Main<br>
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
	 * Copying Guideline Main<br>
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
	 * Checking whether duplicating Guideline Effective Date<br>
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
	 * Numbering SEQ from Guideline Main<br>
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
	 * Copying Guideline Main<br>
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