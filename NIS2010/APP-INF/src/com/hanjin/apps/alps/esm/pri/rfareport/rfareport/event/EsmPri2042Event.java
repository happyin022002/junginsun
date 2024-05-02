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
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltSearchRFARateSearchListVO;


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
		if(comBakEndJbVOs != null){
			ComBakEndJbVO[] tmpVOs = new ComBakEndJbVO[comBakEndJbVOs.length];
			System.arraycopy(comBakEndJbVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.comBakEndJbVOs = tmpVOs;
		}
	}
	
	public void setRsltSearchRFARateSearchListVO(RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO){
		this.rsltSearchRFARateSearchListVO = rsltSearchRFARateSearchListVO;
	}
	public void setRsltSearchRFARateSearchListVOS(RsltSearchRFARateSearchListVO[] rsltSearchRFARateSearchListVOs){
		if(rsltSearchRFARateSearchListVOs != null){
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
		ComBakEndJbVO[] rtnVOs = null;
		if (this.comBakEndJbVOs != null) {
			rtnVOs = new ComBakEndJbVO[comBakEndJbVOs.length];
			System.arraycopy(comBakEndJbVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public RsltSearchRFARateSearchListVO getRsltSearchRFARateSearchListVO(){
		return rsltSearchRFARateSearchListVO;
	}
	public RsltSearchRFARateSearchListVO[] getRsltSearchRFARateSearchListVOS(){
		RsltSearchRFARateSearchListVO[] rtnVOs = null;
		if (this.rsltSearchRFARateSearchListVOs != null) {
			rtnVOs = new RsltSearchRFARateSearchListVO[rsltSearchRFARateSearchListVOs.length];
			System.arraycopy(rsltSearchRFARateSearchListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}