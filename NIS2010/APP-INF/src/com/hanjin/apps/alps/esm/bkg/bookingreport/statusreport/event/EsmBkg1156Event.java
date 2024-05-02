/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1156Event.java
*@FileTitle : Multi Office
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.04
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.01.04 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BlStsReportOutVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1156 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1156HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JEONGMIN CHO
 * @see ESM_BKG_1156HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1156Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BlStsReportOutVO blStsReportOutVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BlStsReportOutVO[] blStsReportOutVOs = null;
	
	private String gso = null;
	
	public BlStsReportOutVO getBlStsReportOutVO() {
		return blStsReportOutVO;
	}

	public void setBlStsReportOutVO(BlStsReportOutVO blStsReportOutVO) {
		this.blStsReportOutVO = blStsReportOutVO;
	}

	public BlStsReportOutVO[] getBlStsReportOutVOs() {
		return blStsReportOutVOs;
	}

	public void setBlStsReportOutVOs(BlStsReportOutVO[] blStsReportOutVOs) {
		this.blStsReportOutVOs = blStsReportOutVOs;
	}


	public EsmBkg1156Event(){}

	public String getGso() {
		return gso;
	}

	public void setGso(String gso) {
		this.gso = gso;
	}
	

}