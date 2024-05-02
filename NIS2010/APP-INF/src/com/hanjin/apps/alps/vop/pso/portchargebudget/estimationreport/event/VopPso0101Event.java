/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopPso0101Event.java
*@FileTitle : Monthly Estimation Comparison
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.02
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2009.05.27 박명종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.event;


import com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.vo.MonEstmCompVO;
import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * VOP_PSO_0101 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_PSO_0101HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author myoungjong park
 * @see VOP_PSO_0101HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopPso0101Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MonEstmCompVO monEstmCompVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MonEstmCompVO[] monEstmCompVOs = null;
	
	private String revYrmon = null;
	private String chkRdo = null;
	private String rawFlg = null;
	private String scnCd = null;


	public VopPso0101Event(){}
	
	public void setMonEstmCompVO(MonEstmCompVO monEstmCompVO){
		this. monEstmCompVO = monEstmCompVO;
	}

	
	public void setMonEstmCompVOS(MonEstmCompVO[] monEstmCompVOs){
		if (monEstmCompVOs != null) {
			MonEstmCompVO[] tmpVOs = new MonEstmCompVO[monEstmCompVOs .length];
			System.arraycopy(monEstmCompVOs, 0, tmpVOs, 0, tmpVOs.length);
			this. monEstmCompVOs = tmpVOs;
		}
	}


	public MonEstmCompVO getMonEstmCompVO(){
		return monEstmCompVO;
	}


	public MonEstmCompVO[] getMonEstmCompVOS(){
		MonEstmCompVO[] tmpVOs = null;
		if (this. monEstmCompVOs != null) {
			tmpVOs = new MonEstmCompVO[monEstmCompVOs .length];
			System.arraycopy(monEstmCompVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public String getRevYrmon() {
		return revYrmon;
	}

	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
   

	public String getRawFlg() {
		return rawFlg;
	}

	public void setRawFlg(String rawFlg) {
		this.rawFlg = rawFlg;
	}

	public String getChkRdo() {
		return chkRdo;
	}

	public void setChkRdo(String chkRdo) {
		this.chkRdo = chkRdo;
	}
	
	
	public String getScnCd() {
		return scnCd;
	}

	public void setScnCd(String scnCd) {
		this.scnCd = scnCd;
	}


}