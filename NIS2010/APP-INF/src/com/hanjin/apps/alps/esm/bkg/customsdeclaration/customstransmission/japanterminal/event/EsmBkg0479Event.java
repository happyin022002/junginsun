/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0730Event.java
*@FileTitle : ESM_BKG-0730
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.05.26 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.VvdJapanTerminalEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0730 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0730HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0730HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0479Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanTerminalEdiCondVO japanTerminalEdiCondVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private JapanTerminalEdiCondVO[] japanTerminalEdiCondVOs = null;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO = null; 
	
	/** Table Value Object Multi Data 처리 */
	private VvdJapanTerminalEdiVO[] vvdJapanTerminalEdiVOs = null;	
	

	
	//private String resultStr = "";	

	public EsmBkg0479Event(){} 
	
	public void setJapanTerminalEdiCondVO(JapanTerminalEdiCondVO japanTerminalEdiCondVO){
		this. japanTerminalEdiCondVO = japanTerminalEdiCondVO;
	}

	public void setJapanTerminalEdiCondVOS(JapanTerminalEdiCondVO[] japanTerminalEdiCondVOs){
		this. japanTerminalEdiCondVOs = japanTerminalEdiCondVOs;
	}
	
	public void setVvdJapanTerminalEdiVO(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO){
		this. vvdJapanTerminalEdiVO = vvdJapanTerminalEdiVO;
	}

	public void setVvdJapanTerminalEdiVOS(VvdJapanTerminalEdiVO[] vvdJapanTerminalEdiVOs){
		this. vvdJapanTerminalEdiVOs = vvdJapanTerminalEdiVOs;
	}	

	
	public JapanTerminalEdiCondVO getJapanTerminalEdiCondVO(){
		return japanTerminalEdiCondVO;
	}
 
	public JapanTerminalEdiCondVO[] getJapanTerminalEdiCondVOS(){
		return japanTerminalEdiCondVOs;
	}	
	
	public VvdJapanTerminalEdiVO getVvdJapanTerminalEdiVO(){
		return vvdJapanTerminalEdiVO;
	}

	public VvdJapanTerminalEdiVO[] getVvdJapanTerminalEdiVOS(){
		return vvdJapanTerminalEdiVOs;
	}

	
//	public void setResultStr(String resultStr) {
//		this.resultStr = resultStr;
//	}
//	public String getResultStr() {
//		return resultStr;
//	}		
}
