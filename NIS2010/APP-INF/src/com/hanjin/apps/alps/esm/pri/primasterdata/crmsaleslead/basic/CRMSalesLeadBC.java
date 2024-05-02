/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CRMSalesLeadBC.java
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

import com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.vo.CstPriCrmSlsLdVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriCrmSlsLdVO;

/**
 * NIS2010-Primasterdata Business Logic Command Interface<br>
 * - NIS2010-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Moon Dong Gyu
 * @see EventResponse 참조
 * @since J2EE 1.6
 */

public interface CRMSalesLeadBC {

    /**
     * CRM으로부터 받은 Sales Lead 정보를 저장합니다.<br>
     * 
     * @param PriCrmSlsLdVO[] priCrmSlsLdVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void receiveCRMSalesLead(PriCrmSlsLdVO[] priCrmSlsLdVOs, SignOnUserAccount account) throws EventException;
    
    /**
     * S/C Main 정보 수정시 Sale Lead 정보를 저장합니다.<br>
     * 
     * @param CstPriCrmSlsLdVO cstPriCrmSlsLdVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageSCCRMSalesLeadNo(CstPriCrmSlsLdVO cstPriCrmSlsLdVO, SignOnUserAccount account) throws EventException;  
    
    /**
     * RFA Main 정보 수정시 Sale Lead 정보를 저장합니다.<br>
     * 
     * @param CstPriCrmSlsLdVO cstPriCrmSlsLdVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageRFACRMSalesLeadNo(CstPriCrmSlsLdVO cstPriCrmSlsLdVO, SignOnUserAccount account) throws EventException;     
    
}