/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0092Event.java
*@FileTitle : Route Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.28 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PolPodVvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0092 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0092HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Byung Kyu
 * @see ESM_BKG_0092HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0092Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PolPodVvdVO polPodVvdVO = null;

	/** Table Value Object Multi Data 처리 */
	private PolPodVvdVO[] polPodVvdVOs = null;

	private String dataYn = null;
	private String editRow = null;
	private String befClptIndSeq = null;
    private String bkgNo = null;
    
	public EsmBkg0092Event(){}

	public void setPolPodVvdVO(PolPodVvdVO polPodVvdVO){
		this. polPodVvdVO = polPodVvdVO;
	}

	public void setPolPodVvdVOs(PolPodVvdVO[] polPodVvdVOs){
		this. polPodVvdVOs = polPodVvdVOs;
	}

	public PolPodVvdVO getPolPodVvdVO(){
		return polPodVvdVO;
	}

	public PolPodVvdVO[] getPolPodVvdVOs(){
		return polPodVvdVOs;
	}

	public void setDataYn(String dataYn){
		this.dataYn = dataYn;
	}

	public String getDataYn(){
		return dataYn;
	}

	public void setBefClptIndSeq(String befClptIndSeq){
		this.befClptIndSeq = befClptIndSeq;
	}

	public String getBefClptIndSeq(){
		return befClptIndSeq;
	}
	
	public String getEditRow() {
		return editRow;
	}

	public void setEditRow(String editRow) {
		this.editRow = editRow;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

}