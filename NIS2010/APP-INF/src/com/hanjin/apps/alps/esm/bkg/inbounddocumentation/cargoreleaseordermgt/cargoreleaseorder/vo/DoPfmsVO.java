/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : DoMstVO.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-09-16
*@LastModifier   : 안진응
*@LastVersion    : 1.0
* 2009-09-16 안진응
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 안진응
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DoPfmsVO {

    private DoCheckListSummaryVO doCheckListSummaryVO;
    private List<DoCheckListVO> doCheckListVOs;
    
    
    /**
     * 생성자
     */
    public DoPfmsVO() {
    }

    /**
     * @return the doCheckListSummaryVO
     */
    public DoCheckListSummaryVO getDoCheckListSummaryVO() {
        return doCheckListSummaryVO;
    }

    /**
     * @param doCheckListSummaryVO the doCheckListSummaryVO to set
     */
    public void setDoCheckListSummaryVO(DoCheckListSummaryVO doCheckListSummaryVO) {
        this.doCheckListSummaryVO = doCheckListSummaryVO;
    }

   

	public List<DoCheckListVO> getDoCheckListVOs() {
		return doCheckListVOs;
	}

	public void setDoCheckListVOs(List<DoCheckListVO> doCheckListVOs) {
		this.doCheckListVOs = doCheckListVOs;
	}



}