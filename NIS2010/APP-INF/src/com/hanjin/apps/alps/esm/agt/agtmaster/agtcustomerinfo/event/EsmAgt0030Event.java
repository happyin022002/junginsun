/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_030Event.java
*@FileTitle : FAC Shipper 관계 관리 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-11-28 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.event;


import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.AgtFacCustRltVO;

/**
 * ESM_AGT_030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_AGT_030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang GyeongNam
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmAgt0030Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private AgtFacCustRltVO agtFacCustRltVO = null;
	
	private AgtFacCustRltVO[] agtFacCustRltVOs = null;

	public AgtFacCustRltVO getAgtFacCustRltVO() {
    	return agtFacCustRltVO;
    }

	public void setAgtFacCustRltVO(AgtFacCustRltVO agtFacCustRltVO) {
    	this.agtFacCustRltVO = agtFacCustRltVO;
    }

	public AgtFacCustRltVO[] getAgtFacCustRltVOs() {
    	return agtFacCustRltVOs;
    }

	public void setAgtFacCustRltVOs(AgtFacCustRltVO[] agtFacCustRltVOs) {
    	this.agtFacCustRltVOs = agtFacCustRltVOs;
    }
	
	
}
