/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CRMKeymanBC.java
*@FileTitle : CRM Keyman Info
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.08.11 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.crmkeyman.basic;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriCrmCustKmanVO;

/**
 * NIS2010-Primasterdata Business Logic Command Interface<br>
 * - NIS2010-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Moon Dong Gyu
 * @see EventResponse 참조
 * @since J2EE 1.6
 */

public interface CRMKeymanBC {

    /**
     * CRM으로부터 받은 Keyman 정보를 저장합니다.<br>
     * 
     * @param PriCrmCustKmanVO[] priCrmCustKmanVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void receiveCRMKeyman(PriCrmCustKmanVO[] priCrmCustKmanVOs, SignOnUserAccount account) throws EventException;
}