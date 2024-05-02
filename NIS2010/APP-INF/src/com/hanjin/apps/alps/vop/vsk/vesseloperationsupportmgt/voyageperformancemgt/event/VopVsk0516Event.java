/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0516Event.java
*@FileTitle : Voyage Performance
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0 
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.event;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.vo.VoyagePerformanceVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *  VOP_VSK_0516에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0516HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi, DukWoo
 * @see VOP_VSK_0516HTMLAction 참조
 * @since J2EE 1.6 VoyagePerfromanceVO
 */
public class VopVsk0516Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private VoyagePerformanceVO voyagePerformanceVO = null;

	/** Table Value Object Multi Data 처리 */
//	private DepositInvoiceVO[] depositInvoiceVOs = null;

	public VopVsk0516Event(){}

	
	public VoyagePerformanceVO getVoyagePerformanceVO() {
		return voyagePerformanceVO;
	}

	public void setVoyagePerformanceVO(VoyagePerformanceVO voyagePerformanceVO) {
		this.voyagePerformanceVO = voyagePerformanceVO;
	}

	
}
