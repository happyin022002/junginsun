/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0111Event.java
*@FileTitle : S/C Performance Summary - View B/L
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.04 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.event;

import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCBlListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ComBakEndJbVO;

/**
 * ESM_PRI_0111 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0111HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh Kim
 * @see ESM_PRI_0111HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0111Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	/** Table Value Object Multi Data 처리 */
	private ComBakEndJbVO[] comBakEndJbVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchSCBlListVO rsltSearchSCBlListVO = null;
	/** Table Value Object Multi Data 처리 */
	private RsltSearchSCBlListVO[] rsltSearchSCBlListVOs = null;

	
	public EsmPri0111Event(){}
	
	/* set */
	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO){
		this.comBakEndJbVO = comBakEndJbVO;
	}
	public void setComBakEndJbVOS(ComBakEndJbVO[] comBakEndJbVOs){
		if (comBakEndJbVOs != null) {
			ComBakEndJbVO[] tmpVOs = new ComBakEndJbVO[comBakEndJbVOs.length];
			System.arraycopy(comBakEndJbVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.comBakEndJbVOs = tmpVOs;
		}
	}
	
	public void setRsltSearchSCBlListVO(RsltSearchSCBlListVO rsltSearchSCBlListVO){
		this.rsltSearchSCBlListVO = rsltSearchSCBlListVO;
	}
	public void setRsltSearchSCBlListVOS(RsltSearchSCBlListVO[] rsltSearchSCBlListVOs){
		if (rsltSearchSCBlListVOs != null) {
			RsltSearchSCBlListVO[] tmpVOs = new RsltSearchSCBlListVO[rsltSearchSCBlListVOs.length];
			System.arraycopy(rsltSearchSCBlListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltSearchSCBlListVOs = tmpVOs;
		}
	}
	
	/* get */
	public ComBakEndJbVO getComBakEndJbVO(){
		return comBakEndJbVO;
	}
	public ComBakEndJbVO[] getComBakEndJbVOS(){
		ComBakEndJbVO[] tmpVOs = null;
		if (this.comBakEndJbVOs != null) {
			tmpVOs = new ComBakEndJbVO[comBakEndJbVOs.length];
			System.arraycopy(comBakEndJbVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public RsltSearchSCBlListVO getRsltSearchSCBlListVO(){
		return rsltSearchSCBlListVO;
	}
	public RsltSearchSCBlListVO[] getRsltSearchSCBlListVOS(){
		RsltSearchSCBlListVO[] tmpVOs = null;
		if (this.rsltSearchSCBlListVOs != null) {
			tmpVOs = new RsltSearchSCBlListVO[rsltSearchSCBlListVOs.length];
			System.arraycopy(rsltSearchSCBlListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}