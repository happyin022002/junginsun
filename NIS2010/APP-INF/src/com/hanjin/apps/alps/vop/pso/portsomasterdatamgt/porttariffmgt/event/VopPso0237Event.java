/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiPso0205Event.java
*@FileTitle : Service Provider Help
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.04.28 김진일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event;

import com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo.YdChgNoDataInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * UI_PSO-0205 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_PSO-0205HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jin Ihl
 * @see UI_PSO-0205HTMLAction 참조
 * @since J2EE 1.4
 */
public class VopPso0237Event extends EventSupport {
	
	
	private String newYdCd1 = "";
	private String newYdCd2 = "";
	private String newYdCd3 = "";
	private String newYdCd4 = "";
	private String newYdCd5 = "";
	private String allInfo = "";
	private String vndrSeq2 = "";
	private String newYdCd  = "";
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */

	
	private YdChgNoDataInfoVO ydChgNoDataInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */


	private YdChgNoDataInfoVO[] ydChgNoDataInfoVOs = null; 

	public VopPso0237Event(){}
	
	/**
	 * @param vndrSeq2 the vndrSeq2 to set
	 */
	public void setVndrSeq2(String vndrSeq2) {
		this.vndrSeq2 = vndrSeq2;
	}
	
	/**
	 * @param newYdCd1 the newYdCd1 to set
	 */
	public void setNewYdCd1(String newYdCd1) {
		this.newYdCd1 = newYdCd1;
	}
	
	/**
	 * @return the vndrSeq2
	 */
	public String getVndrSeq2() {
		return vndrSeq2;
	}
	
	/**
	 * @return the newYdCd1
	 */
	public String getNewYdCd1() {
		return newYdCd1;
	}
	
	/**
	 * @param newYdCd2 the newYdCd2 to set
	 */
	public void setNewYdCd2(String newYdCd2) {
		this.newYdCd2 = newYdCd2;
	}
	/**
	 * @return the newYdCd2
	 */
	public String getNewYdCd2() {
		return newYdCd2;
	}
	
	/**
	 * @param newYdCd3 the newYdCd3 to set
	 */
	public void setNewYdCd3(String newYdCd3) {
		this.newYdCd3 = newYdCd3;
	}
	/**
	 * @return the newYdCd3
	 */
	public String getNewYdCd3() {
		return newYdCd3;
	}
	
	/**
	 * @param newYdCd4 the newYdCd4 to set
	 */
	public void setNewYdCd4(String newYdCd4) {
		this.newYdCd4 = newYdCd4;
	}
	/**
	 * @return the newYdCd4
	 */
	public String getNewYdCd4() {
		return newYdCd4;
	}
	
	/**
	 * @param newYdCd5 the newYdCd5 to set
	 */
	public void setNewYdCd5(String newYdCd5) {
		this.newYdCd5 = newYdCd5;
	}
	/**
	 * @return the newYdCd5
	 */
	public String getNewYdCd5() {
		return newYdCd5;
	}
	
	/**
	 * @param newYdCd the newYdCd to set
	 */
	public void setNewYdCd(String newYdCd) {
		this.newYdCd = newYdCd;
	}
	/**
	 * @return the newYdCd
	 */
	public String getNewYdCd() {
		return newYdCd;
	}
	
	/**
	 * @param allInfo the allInfo to set
	 */
	public void setAllInfo(String allInfo) {
		this.allInfo = allInfo;
	}
	/**
	 * @return the allInfo
	 */
	public String getAllInfo() {
		return allInfo;
	}
	
	public void setYdChgNoDataInfoVOs(YdChgNoDataInfoVO[] ydChgNoDataInfoVOs){
		if (ydChgNoDataInfoVOs != null) {
			YdChgNoDataInfoVO[] tmpVOs = new YdChgNoDataInfoVO[ydChgNoDataInfoVOs .length];
			System.arraycopy(ydChgNoDataInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. ydChgNoDataInfoVOs = tmpVOs;
		}
	}

	public YdChgNoDataInfoVO[] getYdChgNoDataInfoVOs(){
		YdChgNoDataInfoVO[] tmpVOs = null;
		if (this. ydChgNoDataInfoVOs != null) {
			tmpVOs = new YdChgNoDataInfoVO[ydChgNoDataInfoVOs .length];
			System.arraycopy(ydChgNoDataInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setYdChgNoDataInfoVO(YdChgNoDataInfoVO ydChgNoDataInfoVO) {
		this.ydChgNoDataInfoVO = ydChgNoDataInfoVO;
	}

	public YdChgNoDataInfoVO getYdChgNoDataInfoVO() {
		return ydChgNoDataInfoVO;
	}

}