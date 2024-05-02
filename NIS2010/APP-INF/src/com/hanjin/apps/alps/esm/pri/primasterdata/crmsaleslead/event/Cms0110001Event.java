/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Cms0110001Event.java
*@FileTitle : CRM Sales Lead Info
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.08.11 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.crmsaleslead.event;

import com.hanjin.apps.alps.esm.pri.servicesio.PRIMasterDataJMSProxy;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriCrmSlsLdVO;


/**
 * JMS연동(CMS011_0001) 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - PRIMasterDataJMSProxy에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see PRIMasterDataJMSProxy 참조
 * @since J2EE 1.6
 */

public class Cms0110001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriCrmSlsLdVO priCrmSlsLdVO = null;

    /** Table Value Object Multi Data 처리 */
    private PriCrmSlsLdVO[] priCrmSlsLdVOs = null;

    /**
     * @return the priCrmSlsLdVO
     */
    public PriCrmSlsLdVO getPriCrmSlsLdVO () {
        return priCrmSlsLdVO;
    }

    /**
     * @param priCrmSlsLdVO the priCrmSlsLdVO to set
     */
    public void setPriCrmSlsLdVO (PriCrmSlsLdVO priCrmSlsLdVO) {
        this.priCrmSlsLdVO = priCrmSlsLdVO;
    }

    /**
     * @return the priCrmSlsLdVOs
     */
    public PriCrmSlsLdVO[] getPriCrmSlsLdVOs () {
    	PriCrmSlsLdVO[] rtnVOs = null;
		if (this.priCrmSlsLdVOs != null) {
			rtnVOs = new PriCrmSlsLdVO[priCrmSlsLdVOs.length];
			System.arraycopy(priCrmSlsLdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;      	
//        return priCrmSlsLdVOs;
    }

    /**
     * @param priCrmSlsLdVOs the priCrmSlsLdVOs to set
     */
    public void setPriCrmSlsLdVOs (PriCrmSlsLdVO[] priCrmSlsLdVOs) {
		if(priCrmSlsLdVOs != null){
			PriCrmSlsLdVO[] tmpVOs = new PriCrmSlsLdVO[priCrmSlsLdVOs.length];
			System.arraycopy(priCrmSlsLdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priCrmSlsLdVOs = tmpVOs;
		}    	
//        this.priCrmSlsLdVOs = priCrmSlsLdVOs;
    }

}