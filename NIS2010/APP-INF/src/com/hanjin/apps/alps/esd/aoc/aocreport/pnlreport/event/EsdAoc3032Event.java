/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsdAoc3032Event.java
*@FileTitle : Profit & Loss Report for Europe Inland BIZ
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.07.17 변종건 [CHM-201217633] Profit & Loss Report for Europe Inland BIZ 생성
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.event;

import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLRptOptionVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_AOC_3032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_AOC_3032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdAoc3032Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsdAoc3032Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PnLRptOptionVO pnLRptOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PnLRptOptionVO[] pnLRptOptionVOs = null;

	public PnLRptOptionVO getPnLRptOptionVO() {
		return pnLRptOptionVO;
	}

	public void setPnLRptOptionVO(PnLRptOptionVO pnLRptOptionVO) {
		this.pnLRptOptionVO = pnLRptOptionVO;
	}

	public PnLRptOptionVO[] getPnLRptOptionVOs() {
		PnLRptOptionVO[] rtnVOs = null;
		if (this.pnLRptOptionVOs != null) {
			rtnVOs = new PnLRptOptionVO[pnLRptOptionVOs.length];
			System.arraycopy(pnLRptOptionVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setPnLRptOptionVOs(PnLRptOptionVO[] pnLRptOptionVOs){
		if(pnLRptOptionVOs != null){
			PnLRptOptionVO[] tmpVOs = new PnLRptOptionVO[pnLRptOptionVOs.length];
			System.arraycopy(pnLRptOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pnLRptOptionVOs = tmpVOs;
		}
	}

}
