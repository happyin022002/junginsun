/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JooExcelEvent.java
*@FileTitle : Excel Title
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.10.15 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.ComExcelVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 


/**
 * JOO_EXCEL 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  JOO_EXCELHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see JOO_EXCELHTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJooExcelEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComExcelVO comExcelVO = null;

    /**
     * @return the comExcelVO
     */
    public ComExcelVO getComExcelVO() {
        return comExcelVO;
    }

    /**
     * @param comExcelVO the comExcelVO to set
     */
    public void setComExcelVO(ComExcelVO comExcelVO) {
        this.comExcelVO = comExcelVO;
    }
	 

}