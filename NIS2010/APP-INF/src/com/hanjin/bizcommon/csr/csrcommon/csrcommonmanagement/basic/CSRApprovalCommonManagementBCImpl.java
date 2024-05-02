/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSRApprovalCommonManagementBCImpl.java
*@FileTitle : Approval Step & Comments
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.10
*@LastModifier : 9014787
*@LastVersion : 1.0
* 2014.07.10 9014787
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.basic;

import java.util.List;

import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.integration.CSRApprovalCommonManagementDBDAO;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.CSRApprovalCommonManagementVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-CSRCommonManagement Business Logic Basic Command implementation<br>
 * - ALPS-CSRCommonManagement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 9014787
 * @see Ui_csr_0020EventResponse 참조
 * @since J2EE 1.6
 */

public class CSRApprovalCommonManagementBCImpl extends BasicCommandSupport implements CSRApprovalCommonManagementBC {

    // Database Access Object
    private transient CSRApprovalCommonManagementDBDAO dbDao = null;
    

    /**
     * CSRApprovalCommonManagementBCImpl 객체 생성<br>
     * CSRApprovalCommonManagementDBDAO 생성한다.<br>
     */
    public CSRApprovalCommonManagementBCImpl() {
        dbDao = new CSRApprovalCommonManagementDBDAO();
    }

    
	/**
	 * COM_CSR_0020 조회 이벤트 처리
	 * Approval Step & Comments :COM_CSR_0020 화면에 대한 조회 이벤트 처리
	 * @param CSRApprovalCommonManagementVO vo
	 * @return List<CSRApprovalCommonManagementVO>
	 * @throws EventException
	 */
    public List<CSRApprovalCommonManagementVO> aproStepAndCmt(CSRApprovalCommonManagementVO vo) throws EventException {
        try {
        	return dbDao.aproStepAndCmt(vo);
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

	/**
	 * COM_CSR_0020 멀티 이벤트 처리
	 * Approval Step & Comments : COM_CSR_0020  화면에 대한 멀티 이벤트 처리
	 * @param CSRApprovalCommonManagementVO vo
	 * @throws EventException
	 */
    public void commentSave(CSRApprovalCommonManagementVO vo) throws EventException {
        try {
        	dbDao.commentSave(vo);
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
	 * COM_CSR_0016 멀티 이벤트 처리<br>
	 * CSR Approval Type Selection : COM_CSR_0016  화면에 대한 멀티 이벤트 처리<br>
	 * @author 2015513
	 * @param String csrNo
	 * @param String aproTpCd
	 * @exception EventException
	 */
    public void saveCsrAproTpCd(String csrNo, String aproTpCd) throws EventException {
        try {
        	dbDao.saveCsrAproTpCd(csrNo,aproTpCd);
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
}