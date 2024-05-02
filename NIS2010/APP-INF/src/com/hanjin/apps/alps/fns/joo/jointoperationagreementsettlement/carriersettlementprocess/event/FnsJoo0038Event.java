/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0038Event.java
*@FileTitle : Summary of Monthly Clearance Status by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.10 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsStatusVO;


/**
 * FNS_JOO_0038 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0038HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_0038HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0038Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private McsStatusVO mcsStatusVO = null;

    /**
     * @return the mcsStatusVO
     */
    public McsStatusVO getMcsStatusVO() {
        return mcsStatusVO;
    }

    /**
     * @param mcsStatusVO the mcsStatusVO to set
     */
    public void setMcsStatusVO(McsStatusVO mcsStatusVO) {
        this.mcsStatusVO = mcsStatusVO;
    }
 
  
	
	

}