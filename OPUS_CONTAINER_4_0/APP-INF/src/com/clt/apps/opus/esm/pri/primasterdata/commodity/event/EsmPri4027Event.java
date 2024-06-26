/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri4027Event.java
*@FileTitle : Commodity Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.04.28 김재연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.commodity.event;

import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.CmdtParaVO;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.RsltCmdtListVO;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.RsltGrpCmdtListVO;
import com.clt.apps.opus.esm.pri.primasterdata.commodity.vo.RsltRepCmdtListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_4027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_4027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4027HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmPri4027Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltCmdtListVO rsltCmdtListVO = null;
	private RsltRepCmdtListVO rsltRepCmdtListVO = null;
	private RsltGrpCmdtListVO rsltGrpCmdtListVO = null;
	private CmdtParaVO cmdtParaVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltCmdtListVO[] rsltCmdtListVOs = null;
	private RsltRepCmdtListVO[] rsltRepCmdtListVOs = null;
	private RsltGrpCmdtListVO[] rsltGrpCmdtListVOs = null;
	private CmdtParaVO[] cmdtParaVOs = null;
	
	public EsmPri4027Event(){}
	
	public void setRsltCmdtVO(RsltCmdtListVO rsltCmdtListVO){
		this. rsltCmdtListVO = rsltCmdtListVO;
	}
	
	public void setRsltCmdtVOS(RsltCmdtListVO[] rsltCmdtListVOs){
		if (rsltCmdtListVOs != null) {
			RsltCmdtListVO[] tmpVOs = new RsltCmdtListVO[rsltCmdtListVOs.length];
			System.arraycopy(rsltCmdtListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltCmdtListVOs = tmpVOs;
		}
	}

	public RsltCmdtListVO getRsltCmdtVO(){
		return rsltCmdtListVO;
	}

	public RsltCmdtListVO[] getRsltCmdtVOS(){
		RsltCmdtListVO[] tmpVOs = null;
		if (this.rsltCmdtListVOs != null) {
			tmpVOs = new RsltCmdtListVO[rsltCmdtListVOs.length];
			System.arraycopy(rsltCmdtListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setRepRsltCmdtVO(RsltRepCmdtListVO rsltRepCmdtListVO){
		this. rsltRepCmdtListVO = rsltRepCmdtListVO;
	}
	
	public void setRsltRepCmdtVOS(RsltRepCmdtListVO[] rsltRepCmdtListVOs){
		if (rsltRepCmdtListVOs != null) {
			RsltRepCmdtListVO[] tmpVOs = new RsltRepCmdtListVO[rsltRepCmdtListVOs.length];
			System.arraycopy(rsltRepCmdtListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRepCmdtListVOs = tmpVOs;
		}
	}

	public RsltRepCmdtListVO getRsltRepCmdtVO(){
		return rsltRepCmdtListVO;
	}

	public RsltRepCmdtListVO[] getRsltRepCmdtVOS(){
		RsltRepCmdtListVO[] tmpVOs = null;
		if (this.rsltRepCmdtListVOs != null) {
			tmpVOs = new RsltRepCmdtListVO[rsltRepCmdtListVOs.length];
			System.arraycopy(rsltRepCmdtListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setRsltGrpCmdtListVO(RsltGrpCmdtListVO rsltGrpCmdtListVO){
		this. rsltGrpCmdtListVO = rsltGrpCmdtListVO;
	}
	
	public void setRsltGrpCmdtListVOS(RsltGrpCmdtListVO[] rsltGrpCmdtListVOs){
		if (rsltGrpCmdtListVOs != null) {
			RsltGrpCmdtListVO[] tmpVOs = new RsltGrpCmdtListVO[rsltGrpCmdtListVOs.length];
			System.arraycopy(rsltGrpCmdtListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltGrpCmdtListVOs = tmpVOs;
		}
	}

	public RsltGrpCmdtListVO getRsltGrpCmdtListVO(){
		return rsltGrpCmdtListVO;
	}

	public RsltGrpCmdtListVO[] getRsltGrpCmdtListVOS(){
		RsltGrpCmdtListVO[] tmpVOs = null;
		if (this.rsltGrpCmdtListVOs != null) {
			tmpVOs = new RsltGrpCmdtListVO[rsltGrpCmdtListVOs.length];
			System.arraycopy(rsltGrpCmdtListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public void setCmdtParaVO(CmdtParaVO cmdtParaVO){
		this. cmdtParaVO = cmdtParaVO;
	}
	
	public void setCmdtParaVOS(CmdtParaVO[] cmdtParaVOs){
		if (cmdtParaVOs != null) {
			CmdtParaVO[] tmpVOs = new CmdtParaVO[cmdtParaVOs.length];
			System.arraycopy(cmdtParaVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cmdtParaVOs = tmpVOs;
		}
	}

	public CmdtParaVO getCmdtParaVO(){
		return cmdtParaVO;
	}

	public CmdtParaVO[] getCmdtParaVOS(){
		CmdtParaVO[] tmpVOs = null;
		if (this.cmdtParaVOs != null) {
			tmpVOs = new CmdtParaVO[cmdtParaVOs.length];
			System.arraycopy(cmdtParaVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
}