/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0060Event.java
*@FileTitle : Rate Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.09 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchBulletListVO;

/**
 * ESM_PRI_0060 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0060HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh Kim
 * @see ESM_PRI_0060HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0060Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	/** Table Value Object Multi Data 처리 */
	private ComBakEndJbVO[] comBakEndJbVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO = null;
	/** Table Value Object Multi Data 처리 */
	private RsltSearchSCRateSearchListVO[] rsltSearchSCRateSearchListVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchSCRateSearchBulletListVO rsltSearchSCRateSearchBulletListVO = null;
	/** Table Value Object Multi Data 처리 */
	private RsltSearchSCRateSearchBulletListVO[] rsltSearchSCRateSearchBulletListVOs = null;

	public EsmPri0060Event(){}
	
	/* set */
	public void setComBakEndJbVO(ComBakEndJbVO comBakEndJbVO){
		this.comBakEndJbVO = comBakEndJbVO;
	}
	public void setComBakEndJbVOS(ComBakEndJbVO[] comBakEndJbVOs){
		this.comBakEndJbVOs = comBakEndJbVOs;
	}
	
	public void setRsltSearchSCRateSearchListVO(RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO){
		this.rsltSearchSCRateSearchListVO = rsltSearchSCRateSearchListVO;
	}
	public void setRsltSearchSCRateSearchListVOS(RsltSearchSCRateSearchListVO[] rsltSearchSCRateSearchListVO){
		this.rsltSearchSCRateSearchListVOs = rsltSearchSCRateSearchListVO;
	}
	
	public void setRsltSearchSCRateSearchBulletListVO(RsltSearchSCRateSearchBulletListVO rsltSearchSCRateSearchBulletListVO){
		this.rsltSearchSCRateSearchBulletListVO = rsltSearchSCRateSearchBulletListVO;
	}
	public void setRsltSearchSCRateSearchBulletListVOS(RsltSearchSCRateSearchBulletListVO[] rsltSearchSCRateSearchBulletListVO){
		this.rsltSearchSCRateSearchBulletListVOs = rsltSearchSCRateSearchBulletListVO;
	}

	/* get */
	public ComBakEndJbVO getComBakEndJbVO(){
		return comBakEndJbVO;
	}
	public ComBakEndJbVO[] getComBakEndJbVOS(){
		return comBakEndJbVOs;
	}
	
	public RsltSearchSCRateSearchListVO getRsltSearchSCRateSearchListVO(){
		return rsltSearchSCRateSearchListVO;
	}
	public RsltSearchSCRateSearchListVO[] getRsltSearchSCRateSearchListVOS(){
		return rsltSearchSCRateSearchListVOs;
	}

	public RsltSearchSCRateSearchBulletListVO getRsltSearchSCRateSearchBulletListVO(){
		return rsltSearchSCRateSearchBulletListVO;
	}
	public RsltSearchSCRateSearchBulletListVO[] getRsltSearchSCRateSearchBulletListVOS(){
		return rsltSearchSCRateSearchBulletListVOs;
	}

}