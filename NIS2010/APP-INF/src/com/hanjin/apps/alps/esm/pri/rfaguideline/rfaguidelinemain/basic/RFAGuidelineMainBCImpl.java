/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAGuidelineMainBCImpl.java
 *@FileTitle : Guideline Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.15
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.07.15 박성수
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.integration.RFAGuidelineMainDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineMnVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineScpEffDtListVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltGlineTermsCntVO;
import com.hanjin.apps.alps.esm.pri.rfaguideline.rfaguidelinemain.vo.RsltRfaGlineCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRgMnVO;

/**
 * NIS2010-RFAGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-RFAGuideline에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Park Sungsoo
 * @see UI_PRI_0001EventResponse,RFAGuidelineMainBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class RFAGuidelineMainBCImpl extends BasicCommandSupport implements RFAGuidelineMainBC {

	// Database Access Object
	private transient RFAGuidelineMainDBDAO dbDao = null;

	/**
	 * RFAGuidelineMainBCImpl 객체 생성<br>
	 * RFAGuidelineMainDBDAO를 생성한다.<br>
	 */
	public RFAGuidelineMainBCImpl() {
		dbDao = new RFAGuidelineMainDBDAO();
	}

	/**
	 * 선택된 Service Scope에 등록된 Guideline 리스트를 조회한다.<br>
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
	 * 하위 탭들에 데이터가 존재하는지 조회한다.<br>
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
	 * Guideline Main을 조회합니다.<br>
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
	 * Guideline Main 트랜잭션 데이터를 처리한다.<br>
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
	 * Guideline을 Confirm합니다.<br>
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
	 * Confirm된 Guideline을 Cancel합니다.<br>
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
	 * Guideline Main에서 Guideline을 삭제한다.<br>
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
	 * RFA Guideline Main 정보를 Copy 합니다.<br>
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
	 * RFA Guideline 의 Effective Date 의 정합성을 체크합니다.<br>
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
	 * 생성할 Guideline 의 새로운 gline_seq 를 조회합니다.<br>
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
     * RFA Guideline Copy 대상들의 기존 데이터 유무를 조회합니다.<br>
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