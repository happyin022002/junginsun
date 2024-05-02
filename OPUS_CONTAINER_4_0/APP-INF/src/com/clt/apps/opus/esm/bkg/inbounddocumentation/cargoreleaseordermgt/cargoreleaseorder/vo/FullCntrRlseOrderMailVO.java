/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoRlseMailSendVO.java
*@FileTitle : CargoRlseMailSendVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.28 손윤석 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Customs Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @@author
 * @since J2EE 1.5
 * @see ESM_FMS_0079HTMLAction
 */

public class FullCntrRlseOrderMailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<FullCntrRlseOrderMailVO> models = new ArrayList<FullCntrRlseOrderMailVO>();	
	
	 private List<FullCntrRlseOrdVO> fullCntrRlseOrdVos ;
	 private List<FullCntrRlseOrderMailSendVO> fullCntrRlseOrderMailSendVos ;
	 
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public FullCntrRlseOrderMailVO() {}
	
	 /**
     * @param doStss the doStss to set
     */
    public void setFullCntrRlseOrdVos(List<FullCntrRlseOrdVO> fullCntrRlseOrdVos) {
        this.fullCntrRlseOrdVos = fullCntrRlseOrdVos;
    }

    /**
     * @return the doStss
     */
    public List<FullCntrRlseOrdVO> getFullCntrRlseOrdVos() {
        return fullCntrRlseOrdVos;
    }
    
    /**
     * @param doStss the doStss to set
     */
    public void setFullCntrRlseOrderMailSendVos(List<FullCntrRlseOrderMailSendVO> fullCntrRlseOrderMailSendVos) {
        this.fullCntrRlseOrderMailSendVos = fullCntrRlseOrderMailSendVos;
    }

    /**
     * @return the doStss
     */
    public List<FullCntrRlseOrderMailSendVO> getFullCntrRlseOrderMailSendVos() {
        return fullCntrRlseOrderMailSendVos;
    }
}
