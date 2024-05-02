/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAGuidelineMainBCImpl.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.15
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.integration.RFAGuidelineMainDBDAO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineMnVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineScpEffDtListVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineTermsCntVO;
import com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRgMnVO;

/**
 * RFAGuideline Business Logic Basic Command implementation<br>
 * - Handling a biz logic about RFAGuideline<br>
 * 
 * @author 
 * @see UI_PRI_0001EventResponse,RFAGuidelineMainBC refer to each DAO class
 * @since J2EE 1.4
 */

public class RFAGuidelineMainBCImpl extends BasicCommandSupport implements RFAGuidelineMainBC {

	// Database Access Object
	private transient RFAGuidelineMainDBDAO dbDao = null;

	/**
	 * Creating RFAGuidelineMainBCImpl Object <br>
	 * Creating RFAGuidelineMainDBDAO.<br>
	 */
	public RFAGuidelineMainBCImpl() {
		dbDao = new RFAGuidelineMainDBDAO();
	}

	/**
	 * Retrieving Guideline list registered in selected Service scope<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return List<RsltGlineScpEffDtListVO>
	 * @exception EventException
	 */
	public List<RsltGlineScpEffDtListVO> searchGuidelineScopeEffectiveDateList(PriRgMnVO vo)
			throws EventException {
		try {
			return dbDao.searchGuidelineScopeEffectiveDateList(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving whether data in sub-tab exists or not<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return List<RsltGlineTermsCntVO>
	 * @exception EventException
	 */
	public List<RsltGlineTermsCntVO> searchGuidelineTermsCount(PriRgMnVO vo) throws EventException {
		try {
			return dbDao.searchGuidelineTermsCount(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving Guideline Main<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return List<RsltGlineMnVO>
	 * @exception EventException
	 */
	public List<RsltGlineMnVO> searchGuidelineMain(PriRgMnVO vo) throws EventException {
		try {
			return dbDao.searchGuidelineMain(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * handling Guideline Main transaction data<br>
	 * 
	 * @param PriRgMnVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGuidelineMain(PriRgMnVO vo, SignOnUserAccount account) throws EventException {
		try {
			boolean isNew = (vo.getGlineSeq() == null || "X".equals(vo.getGlineSeq())) ? true : false;
			if ("X".equals(vo.getGlineSeq())) {
				vo.setGlineSeq("-1");
			}
			boolean isValidDate = dbDao.searchCheckGuidelineEffectiveDate(vo);

			if (!isValidDate) {
				throw new EventException(new ErrorHandler("PRI08018").getMessage());
			}

			if (isNew) {
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				dbDao.addGuidelineMain(vo);
			} else {
				vo.setUpdUsrId(account.getUsr_id());
				dbDao.modifyGuidelineMain(vo, "N");
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
	 * @param PriRgMnVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmGuidelineMain(PriRgMnVO vo, SignOnUserAccount account) throws EventException {
		try {
			vo.setCfmFlg("Y");
			vo.setCfmUsrId(account.getUsr_id());
			vo.setCfmOfcCd(account.getOfc_cd());
			vo.setUpdUsrId(account.getUsr_id());
			
			boolean hasChild = dbDao.searchCommodityHeaderHasChild(vo);
			if (!hasChild) {
				throw new EventException(new ErrorHandler("PRI08020").getMessage());
			}

			dbDao.modifyGuidelineMain(vo, "Y");
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
	 *Cancelling Confirmed Guideline.<br>
	 * 
	 * @param PriRgMnVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGuidelineMain(PriRgMnVO vo, SignOnUserAccount account) throws EventException {
		try {
			vo.setCfmFlg("N");
			vo.setCfmUsrId(account.getUsr_id());
			vo.setCfmOfcCd(account.getOfc_cd());
			vo.setUpdUsrId(account.getUsr_id());

			dbDao.modifyGuidelineMain(vo, "Y");
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
	 * @param PriRgMnVO vo
	 * @exception EventException
	 */
	public void removeGuidelineMain(PriRgMnVO vo) throws EventException {
		try {
			dbDao.removeGuidelineMain(vo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Copying RFA Guideline Main information<br>
	 * 
	 * @param RsltRfaGlineCopyVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineMain(RsltRfaGlineCopyVO vo, SignOnUserAccount account) throws EventException {
		try {
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			dbDao.addGlineCopyGuidelineMain(vo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Checking RFA Guideline Effective Date<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkGuidelineEffectiveDate(PriRgMnVO vo) throws EventException {
		try {
			return dbDao.searchCheckGuidelineEffectiveDate(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving new guide_SEQ of guideline to be created<br>
	 * 
	 * @param PriRgMnVO vo
	 * @return String
	 * @exception EventException
	 */
	public String getGuidelineSeq(PriRgMnVO vo) throws EventException {
		try {
			return String.valueOf(dbDao.searchGuidelineCopyGuidelineSeq(vo));
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

    /**
     * Retrieving wheter existing data of RFA Guideline for copying exists or not<br>
     * 
     * @param PriRgMnVO priRgMnVO
     * @return List<RsltRfaGlineCopyVO>
     * @exception EventException
     */
    public List<RsltRfaGlineCopyVO> searchGlineCopyCheckTermsExist(PriRgMnVO priRgMnVO) throws EventException {
        try {
            return dbDao.searchGlineCopyCheckTermsExist(priRgMnVO);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
    }
}