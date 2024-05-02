/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UiBkg0169Event.java
*@FileTitle : VGM Dashboard History
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event;
import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.VgmHistoryVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * UI_BKG-0169 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG-0169HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see UI_BKG-0169HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0169Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6766125147959177357L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private VgmHistoryVO vgmHistoryVO  = null;
	
	/** Table Value Object Multi Data 처리 */
	private VgmHistoryVO[] vgmHistoryVOs = null;

	public EsmBkg0169Event(){}

	/**
	 * @return the vgmHistoryVO
	 */
	public VgmHistoryVO getVgmHistoryVO() {
		return vgmHistoryVO;
	}

	/**
	 * @param vgmHistoryVO the vgmHistoryVO to set
	 */
	public void setVgmHistoryVO(VgmHistoryVO vgmHistoryVO) {
		this.vgmHistoryVO = vgmHistoryVO;
	}

	/**
	 * @return the vgmHistoryVOs
	 */
//	public VgmHistoryVO[] vgmHistoryVOs() {
//		return vgmHistoryVO;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public VgmHistoryVO[] getVgmHistoryVOs() {
		VgmHistoryVO[] tmpVOs = null;
		if (this.vgmHistoryVOs != null) {
			tmpVOs = new VgmHistoryVO[vgmHistoryVOs.length];
			System.arraycopy(vgmHistoryVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 	
	
	/**
	 * @param bkgDoHisVOs the bkgDoHisVOs to set
	 */
//	public void setDoHisVOs(DoHisVO[] doHisVOs) {
//		this.doHisVOs = doHisVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setVgmHistoryVOs(VgmHistoryVO[] vgmHistoryVOs) {
		if (vgmHistoryVOs != null) {
			VgmHistoryVO[] tmpVOs = new VgmHistoryVO[vgmHistoryVOs.length];
			System.arraycopy(vgmHistoryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vgmHistoryVOs = tmpVOs;
		}		
	} 
}