/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CRMSalesLeadBCImpl.java
*@FileTitle : CRM Sales Lead Info
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.08.10 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.basic;

import com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.integration.CRMSalesLeadDBDAO;
import com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.vo.CstPriCrmSlsLdVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriCrmSlsLdVO;

/**
 * NIS2010-PRIMasterData Business Logic Basic Command implementation<br>
 * - NIS2010-PRIMasterData에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Moon Dong Gyu
 * @see EventResponse,CRMSalesLeadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class CRMSalesLeadBCImpl extends BasicCommandSupport implements CRMSalesLeadBC {

	// Database Access Object
	private transient CRMSalesLeadDBDAO dbDao = null;

	/**
	 * CRMSalesLeadBCImpl 객체 생성<br>
	 * CRMSalesLeadDBDAO를 생성한다.<br>
	 */
	public CRMSalesLeadBCImpl() {
		dbDao = new CRMSalesLeadDBDAO();
	}

    /**
     * CRM으로부터 받은 Sales Lead 정보를 저장합니다.<br>
     * 
     * @param PriCrmSlsLdVO[] priCrmSlsLdVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void receiveCRMSalesLead(PriCrmSlsLdVO[] priCrmSlsLdVOs, SignOnUserAccount account) throws EventException{
        try {
            String register = "SYSTEM";
            int count = 0;
            
            if (priCrmSlsLdVOs != null) {
                for (int i = 0, n = priCrmSlsLdVOs.length ; i < n ; i++) {
                    count = dbDao.searchCRMSalesLeadCnt(priCrmSlsLdVOs[i]);
                    
                    priCrmSlsLdVOs[i].setCreUsrId(register);
                    priCrmSlsLdVOs[i].setUpdUsrId(register);

                    if (count > 0) {
                        dbDao.modifyCRMSalesLead(priCrmSlsLdVOs[i]);
                    } else {
                        dbDao.addCRMSalesLead(priCrmSlsLdVOs[i]);
                    }
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
     * S/C Main 정보 수정시 Sale Lead 정보를 저장합니다.<br>
     * 
     * @param CstPriCrmSlsLdVO cstPriCrmSlsLdVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageSCCRMSalesLeadNo(CstPriCrmSlsLdVO cstPriCrmSlsLdVO, SignOnUserAccount account) throws EventException{
        try {
        	if (cstPriCrmSlsLdVO != null && !cstPriCrmSlsLdVO.getIbflag().equals("R")) {
            	if (cstPriCrmSlsLdVO.getPropStsCd().equals("F")){
            		cstPriCrmSlsLdVO.setSlsLdNoUp("N");
            		cstPriCrmSlsLdVO.setSlsLdStsCd("S");
                	cstPriCrmSlsLdVO.setUpdUsrId(account.getUsr_id());
                	dbDao.modifySCCRMSalesLeadNo(cstPriCrmSlsLdVO); 
            	}else if ("D".equals(cstPriCrmSlsLdVO.getPropStsCd())){
                	//기존 sls_ld_no의 상태를 P->I로 변경
                	cstPriCrmSlsLdVO.setSlsLdNoUp("N");
                	cstPriCrmSlsLdVO.setSlsLdStsCd("I");
                	cstPriCrmSlsLdVO.setUpdUsrId(account.getUsr_id());
                	dbDao.modifySCCRMSalesLeadNo(cstPriCrmSlsLdVO);
            	}else{
                	//기존 sls_ld_no의 상태를 P->I로 변경
                	cstPriCrmSlsLdVO.setSlsLdNoUp("N");
                	cstPriCrmSlsLdVO.setSlsLdStsCd("I");
                	cstPriCrmSlsLdVO.setUpdUsrId(account.getUsr_id());
                	dbDao.modifySCCRMSalesLeadNo(cstPriCrmSlsLdVO); 
                	//새로 입력된 sls_ld_no의 상태를 I->P로 변경
                	cstPriCrmSlsLdVO.setSlsLdNoUp("Y");
                	cstPriCrmSlsLdVO.setSlsLdStsCd("P");
                	dbDao.modifySCCRMSalesLeadNo(cstPriCrmSlsLdVO);
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
     * RFA Main 정보 수정시 Sale Lead 정보를 저장합니다.<br>
     * 
     * @param CstPriCrmSlsLdVO cstPriCrmSlsLdVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageRFACRMSalesLeadNo(CstPriCrmSlsLdVO cstPriCrmSlsLdVO, SignOnUserAccount account) throws EventException{
        try {
            if (cstPriCrmSlsLdVO != null) {
            	if (cstPriCrmSlsLdVO.getPropStsCd().equals("A")){
            		cstPriCrmSlsLdVO.setSlsLdNoUp("N");
            		cstPriCrmSlsLdVO.setSlsLdStsCd("R");
                	cstPriCrmSlsLdVO.setUpdUsrId(account.getUsr_id());
                	dbDao.modifyRFACRMSalesLeadNo(cstPriCrmSlsLdVO); 
            	}else if (cstPriCrmSlsLdVO.getPropStsCd().equals("Q")){
            		cstPriCrmSlsLdVO.setSlsLdNoUp("N");
            		cstPriCrmSlsLdVO.setSlsLdStsCd("I");
                	cstPriCrmSlsLdVO.setUpdUsrId(account.getUsr_id());
                	dbDao.modifyRFACRMSalesLeadNo(cstPriCrmSlsLdVO); 
            	}else if ("D".equals(cstPriCrmSlsLdVO.getPropStsCd())){
                	//기존 sls_ld_no의 상태를 P->I로 변경
                	cstPriCrmSlsLdVO.setSlsLdNoUp("N");
                	cstPriCrmSlsLdVO.setSlsLdStsCd("I");
                	cstPriCrmSlsLdVO.setUpdUsrId(account.getUsr_id());
                	dbDao.modifyRFACRMSalesLeadNo(cstPriCrmSlsLdVO);
            	}else{
                	//기존 sls_ld_no의 상태를 P->I로 변경
                	cstPriCrmSlsLdVO.setSlsLdNoUp("N");
                	cstPriCrmSlsLdVO.setSlsLdStsCd("I");
                	cstPriCrmSlsLdVO.setUpdUsrId(account.getUsr_id());
                	dbDao.modifyRFACRMSalesLeadNo(cstPriCrmSlsLdVO); 
                	//새로 입력된 sls_ld_no의 상태를 I->P로 변경
                	cstPriCrmSlsLdVO.setSlsLdNoUp("Y");
                	cstPriCrmSlsLdVO.setSlsLdStsCd("P");
                	dbDao.modifyRFACRMSalesLeadNo(cstPriCrmSlsLdVO); 
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
        
    
}