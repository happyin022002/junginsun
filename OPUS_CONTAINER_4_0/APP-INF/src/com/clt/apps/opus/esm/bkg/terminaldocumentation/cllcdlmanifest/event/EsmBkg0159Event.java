/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0159Event.java
*@FileTitle : ESM_BKG_0159
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.10
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.KorCllCdlCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.TerminalCllVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ComBakEndJbVO;
import com.sun.xml.bind.v2.TODO;


/**
 * ESM_BKG_0159 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0159HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Seung Min
 * @see ESM_BKG_0159HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0159Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TerminalCllVO terminalCllVO = null;

	/** Table Value Object Multi Data 처리 */
	private TerminalCllVO[] terminalCllVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private KorCllCdlCondVO korCllCdlCondVO = null;

	/** Table Value Object Multi Data 처리 */
	private KorCllCdlCondVO[] korCllCdlCondVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	/** Table Value Object Multi Data 처리 */
	private ComBakEndJbVO[] comBakEndJbVOs = null;

	private String key = "";
	private String command = "";

	public EsmBkg0159Event(){}

	public void setTerminalCllVO(TerminalCllVO terminalCllVO){
		this. terminalCllVO = terminalCllVO;
	}

	public void setKorCllCdlCondVO(KorCllCdlCondVO korCllCdlCondVO){
		this. korCllCdlCondVO = korCllCdlCondVO;
	}

	public TerminalCllVO getTerminalCllVO(){
		return terminalCllVO;
	}

	public KorCllCdlCondVO getKorCllCdlCondVO(){
		return korCllCdlCondVO;
	}

	/* get */
	public ComBakEndJbVO getComBakEndJbVO(){
		return comBakEndJbVO;
	}

	/* set */
	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO){
		this.comBakEndJbVO = comBakEndJbVO;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
	}


	public void setCommand(String command) {
		this.command = command;
	}
	public String getCommand() {
		return command;
	}

	public TerminalCllVO[] getTerminalCllVOS() {
		TerminalCllVO[] rtnVOs = null;
		if (this.terminalCllVOs != null) {
			rtnVOs = Arrays.copyOf(terminalCllVOs, terminalCllVOs.length);
		}
		return rtnVOs;
	}

	public void setTerminalCllVOS(TerminalCllVO[] terminalCllVOs) {
		if (terminalCllVOs != null) {
			TerminalCllVO[] tmpVOs = Arrays.copyOf(terminalCllVOs, terminalCllVOs.length);
			this.terminalCllVOs = tmpVOs;
		}
	}

	public KorCllCdlCondVO[] getKorCllCdlCondVOS() {
		KorCllCdlCondVO[] rtnVOs = null;
		if (this.korCllCdlCondVOs != null) {
			rtnVOs = Arrays.copyOf(korCllCdlCondVOs, korCllCdlCondVOs.length);
		}
		return rtnVOs;
	}

	public void setKorCllCdlCondVOS(KorCllCdlCondVO[] korCllCdlCondVOs) {
		if (korCllCdlCondVOs != null) {
			KorCllCdlCondVO[] tmpVOs = Arrays.copyOf(korCllCdlCondVOs, korCllCdlCondVOs.length);
			this.korCllCdlCondVOs = tmpVOs;
		}
	}

	public ComBakEndJbVO[] getComBakEndJbVOS() {
		ComBakEndJbVO[] rtnVOs = null;
		if (this.comBakEndJbVOs != null) {
			rtnVOs = Arrays.copyOf(comBakEndJbVOs, comBakEndJbVOs.length);
		}
		return rtnVOs;
	}

	public void setComBakEndJbVOS(ComBakEndJbVO[] comBakEndJbVOs) {
		if (comBakEndJbVOs != null) {
			ComBakEndJbVO[] tmpVOs = Arrays.copyOf(comBakEndJbVOs, comBakEndJbVOs.length);
			this.comBakEndJbVOs = tmpVOs;
		}
	}


}