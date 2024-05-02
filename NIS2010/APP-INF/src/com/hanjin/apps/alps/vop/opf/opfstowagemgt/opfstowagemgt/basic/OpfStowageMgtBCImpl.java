/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OpfStowageMgtBCImpl.java
*@FileTitle : COD Approve Main Screen
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.03
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.06.03 김도현
* 1.0 Creation
*=========================================================
* History
*=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.basic;


import java.util.List;
import com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.integration.OpfStowageMgtDBDAO;
import com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.vo.OpfStowageBayPlanListVO;
import com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.vo.BayPlanCntrDtlVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-OpfStowageMgt Business Logic Basic Command implementation<br>
 * - ALPS-OpfStowageMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Jong Ock
 * @see VOP_OPF_0033EventResponse,OpfStowageMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class OpfStowageMgtBCImpl extends BasicCommandSupport implements OpfStowageMgtBC {

	// Database Access Object
	private transient OpfStowageMgtDBDAO dbDao = null;

	/**
	 * OpfStowageMgtBCImpl 객체 생성<br>
	 * OpfStowageMgtDBDAO를 생성한다.<br>
	 */
	public OpfStowageMgtBCImpl() {
		dbDao = new OpfStowageMgtDBDAO();
	}

	/**
	 * Bay Plan 정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @exception EventException
	 */
	public List<OpfStowageBayPlanListVO> searchBayPlanList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws EventException {
		
		try {
			return dbDao.searchBayPlanList(opfStowageBayPlanListVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
	}

	/**
	 * Bay Plan의 Contailner 정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<BayPlanCntrDtlVO>
	 * @exception EventException
	 */
	public List<BayPlanCntrDtlVO> searchBayPlanCntrDtl(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws EventException {
		
		try {
			return dbDao.searchBayPlanCntrDtl(opfStowageBayPlanListVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
	}
	
	/**
	 * Bay Plan Hach Cover정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @exception EventException
	 */
	public List<OpfStowageBayPlanListVO> searchBayPlanHtchCvrList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws EventException {
		
		try {
			return dbDao.searchBayPlanHtchCvrList(opfStowageBayPlanListVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
	}
	
	/**
	 * Bay Plan에서 조회조건 Container의 Bay 위치정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @exception EventException
	 */
	public List<OpfStowageBayPlanListVO> searchBayPlanCntrPositionList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws EventException {
		
		try {
			return dbDao.searchBayPlanCntrPositionList(opfStowageBayPlanListVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
	}
	
	/**
	 *Bay Plan에서 해당Container의 Bay Index정보를 조회 합니다.<br>
	 *
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @exception EventException
	 */
	public List<OpfStowageBayPlanListVO> searchBayPlanCntrBayIdx(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws EventException {
		try {
			return dbDao.searchBayPlanCntrBayIdx(opfStowageBayPlanListVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
	 *Bay Plan의 Container에 해당되는 Bay List를 조회 합니다.<br>
	 *
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @exception EventException
	 */
	public List<OpfStowageBayPlanListVO> searchBayPlanCntrBayList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws EventException {
		try {
			return dbDao.searchBayPlanCntrBayList(opfStowageBayPlanListVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
	 * Bay Plan의 Container에 해당되는 VVD 및 Port를 조회 합니다.<br>
	 *
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @exception EventException
	 */
	public List<OpfStowageBayPlanListVO> searchBayPlanCntrVvdPortList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws EventException {
		try {
			return dbDao.searchBayPlanCntrVvdPortList(opfStowageBayPlanListVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * Bay Plan Port별 Color정보를 조회 합니다.<br>
	 * 
	 * @param OpfStowageBayPlanListVO opfStowageBayPlanListVO
	 * @return List<OpfStowageBayPlanListVO>
	 * @exception EventException
	 */
	public List<OpfStowageBayPlanListVO> searchPortColorList(OpfStowageBayPlanListVO opfStowageBayPlanListVO) throws EventException {
		
		try {
			return dbDao.searchPortColorList(opfStowageBayPlanListVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Bay Plan Retrieve"}).getMessage(), ex);
		}		
	}
	
	/**
	 * 타선사 Container 조회시 VESSEL정보가 없는경우 관련테이블에 데이터를 생성하기 위해 STO_TPL_CRE_PRC 호출<br>
	 * 
	 * @param String vslCd
	 * @exception EventException
	 */
	public void addBBayPlanVslCd(String vslCd) throws EventException {
		try {
			dbDao.addBBayPlanVslCd(vslCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("INV00053", new String[] {}).getMessage(), ex);
		}
	}
	
	
}
