/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri2042Event.java
*@FileTitle : Rate Retrieve
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.22 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfareport.rfareport.event;

import com.clt.apps.opus.esm.pri.rfareport.rfareport.vo.RsltSearchRFARateSearchListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ComBakEndJbVO;


/**
 * ESM_PRI_2042 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_2042HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_2042HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri2042Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	/** Table Value Object Multi Data 처리 */
	private ComBakEndJbVO[] comBakEndJbVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO = null;
	/** Table Value Object Multi Data 처리 */
	private RsltSearchRFARateSearchListVO[] rsltSearchRFARateSearchListVOs = null;

	public EsmPri2042Event(){}
	
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
	
	public void setRsltSearchRFARateSearchListVO(RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO){
		this.rsltSearchRFARateSearchListVO = rsltSearchRFARateSearchListVO;
	}
	public void setRsltSearchRFARateSearchListVOS(RsltSearchRFARateSearchListVO[] rsltSearchRFARateSearchListVOs){
		if (rsltSearchRFARateSearchListVOs != null) {
			RsltSearchRFARateSearchListVO[] tmpVOs = new RsltSearchRFARateSearchListVO[rsltSearchRFARateSearchListVOs.length];
			System.arraycopy(rsltSearchRFARateSearchListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltSearchRFARateSearchListVOs = tmpVOs;
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
	
	public RsltSearchRFARateSearchListVO getRsltSearchRFARateSearchListVO(){
		return rsltSearchRFARateSearchListVO;
	}
	public RsltSearchRFARateSearchListVO[] getRsltSearchRFARateSearchListVOS(){
		RsltSearchRFARateSearchListVO[] tmpVOs = null;
		if (this.rsltSearchRFARateSearchListVOs != null) {
			tmpVOs = new RsltSearchRFARateSearchListVO[rsltSearchRFARateSearchListVOs.length];
			System.arraycopy(rsltSearchRFARateSearchListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}