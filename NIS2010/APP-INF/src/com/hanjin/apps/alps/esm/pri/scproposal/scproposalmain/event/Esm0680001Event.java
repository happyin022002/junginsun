/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Esm0680001Event.java
*@FileTitle : CRM Sales Lead Info
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.08.11 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event;

import com.hanjin.apps.alps.esm.pri.servicesio.SCProposalJMSProxy;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * JMS연동(ESM068_0001) 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - SCProposalJMSProxy에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see SCProposalJMSProxy 참조
 * @since J2EE 1.6
 */

public class Esm0680001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /** String Input 데이터 처리 */
	private String propNo = null;

    /** String Input 데이터 처리 */
    private String amdtNo = null;
    
    /** String Input 데이터 처리 */
    private String opCd = null;    

    /**
     * @return the propNo
     */
    public String getPropNo(){
        return propNo;
    }

    /**
     * @param propNo the propNo to set
     */
    public void setPropNo(String propNo){
        this.propNo = propNo;
    }

    /**
     * @return the amdtNo
     */
    public String getAmdtNo(){
        return amdtNo;
    }

    /**
     * @param amdtNo the amdtNo to set
     */
    public void setAmdtNo(String amdtNo){
        this.amdtNo = amdtNo;
    }
    
    /**
     * @return the opCd
     */
    public String getOpCd(){
        return opCd;
    }    
    
    /**
     * @param opCd the opCd to set
     */
    public void setOpCd (String opCd) {
        this.opCd = opCd;
    }    

}