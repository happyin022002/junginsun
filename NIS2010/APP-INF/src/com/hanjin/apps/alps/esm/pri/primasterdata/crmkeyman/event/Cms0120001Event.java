/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Cms0120001Event.java
*@FileTitle : CRM Keyman Info
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.08.11 문동규
* 1.0 Creation
=========================================================
* History
* [CHM-201534517] Split02-2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.crmkeyman.event;

import com.hanjin.apps.alps.esm.pri.servicesio.PRIMasterDataJMSProxy;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriCrmCustKmanVO;


/**
 * JMS연동(CMS012_0001) 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - PRIMasterDataJMSProxy에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Moon Dong Gyu
 * @see PRIMasterDataJMSProxy 참조
 * @since J2EE 1.6
 */

public class Cms0120001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriCrmCustKmanVO priCrmCustKmanVO = null;

    /** Table Value Object Multi Data 처리 */
    private PriCrmCustKmanVO[] priCrmCustKmanVOs = null;

    /**
     * @return the priCrmCustKmanVO
     */
    public PriCrmCustKmanVO getPriCrmCustKmanVO () {
        return priCrmCustKmanVO;
    }

    /**
     * @param priCrmCustKmanVO the priCrmCustKmanVO to set
     */
    public void setPriCrmCustKmanVO (PriCrmCustKmanVO priCrmCustKmanVO) {
        this.priCrmCustKmanVO = priCrmCustKmanVO;
    }

    /**
     * @return the priCrmCustKmanVOs
     */
    public PriCrmCustKmanVO[] getPriCrmCustKmanVOs () {
    	PriCrmCustKmanVO[] rtnVOs = null;
		if (this.priCrmCustKmanVOs != null) {
			rtnVOs = new PriCrmCustKmanVO[priCrmCustKmanVOs.length];
			System.arraycopy(priCrmCustKmanVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;    	
//        return priCrmCustKmanVOs;
    }

    /**
     * @param priCrmCustKmanVOs the priCrmCustKmanVOs to set
     */
    public void setPriCrmCustKmanVOs (PriCrmCustKmanVO[] priCrmCustKmanVOs) {
		if(priCrmCustKmanVOs != null){
			PriCrmCustKmanVO[] tmpVOs = new PriCrmCustKmanVO[priCrmCustKmanVOs.length];
			System.arraycopy(priCrmCustKmanVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priCrmCustKmanVOs = tmpVOs;
		}    	
//        this.priCrmCustKmanVOs = priCrmCustKmanVOs;
    }


}