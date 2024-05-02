/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri010801Event.java
*@FileTitle : S/C Performance Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.02 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerfromanceVO;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;

/**
 * ESM_PRI_0108_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0108_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh Kim
 * @see ESM_PRI_0108_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri010801Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	/** Table Value Object Multi Data 처리 */
	private ComBakEndJbVO[] comBakEndJbVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO = null;
	/** Table Value Object Multi Data 처리 */
	private RsltSearchSCPerfromanceVO[] rsltSearchSCPerfromanceVOs = null;
	
	public EsmPri010801Event(){}
	
	/* set */
	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO){
		this.comBakEndJbVO = comBakEndJbVO;
	}
	public void setComBakEndJbVOS(ComBakEndJbVO[] comBakEndJbVOs){
		this.comBakEndJbVOs = comBakEndJbVOs;
	}
	
	public void setRsltSearchSCPerfromanceVO(RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO){
		this.rsltSearchSCPerfromanceVO = rsltSearchSCPerfromanceVO;
	}
	public void setRsltSearchSCPerfromanceVOS(RsltSearchSCPerfromanceVO[] rsltSearchSCPerfromanceVOs){
		this.rsltSearchSCPerfromanceVOs = rsltSearchSCPerfromanceVOs;
	}
	
	/* get */
	public ComBakEndJbVO getComBakEndJbVO(){
		return comBakEndJbVO;
	}
	public ComBakEndJbVO[] getComBakEndJbVOS(){
		return comBakEndJbVOs;
	}
	
	public RsltSearchSCPerfromanceVO getRsltSearchSCPerfromanceVO(){
		return rsltSearchSCPerfromanceVO;
	}
	public RsltSearchSCPerfromanceVO[] getRsltSearchSCPerfromanceVOS(){
		return rsltSearchSCPerfromanceVOs;
	}

}