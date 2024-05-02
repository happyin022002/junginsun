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
package com.clt.apps.opus.esm.pri.screport.screport.event;

import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCRateSearchBulletListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCRateSearchListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ComBakEndJbVO;

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
		if (comBakEndJbVOs != null) {
			ComBakEndJbVO[] tmpVOs = new ComBakEndJbVO[comBakEndJbVOs.length];
			System.arraycopy(comBakEndJbVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.comBakEndJbVOs = tmpVOs;
		}
	}
	
	public void setRsltSearchSCRateSearchListVO(RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO){
		this.rsltSearchSCRateSearchListVO = rsltSearchSCRateSearchListVO;
	}
	public void setRsltSearchSCRateSearchListVOS(RsltSearchSCRateSearchListVO[] rsltSearchSCRateSearchListVO){
		if (rsltSearchSCRateSearchListVO != null) {
			RsltSearchSCRateSearchListVO[] tmpVOs = new RsltSearchSCRateSearchListVO[rsltSearchSCRateSearchListVO.length];
			System.arraycopy(rsltSearchSCRateSearchListVO, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltSearchSCRateSearchListVOs = tmpVOs;
		}
	}
	
	public void setRsltSearchSCRateSearchBulletListVO(RsltSearchSCRateSearchBulletListVO rsltSearchSCRateSearchBulletListVO){
		this.rsltSearchSCRateSearchBulletListVO = rsltSearchSCRateSearchBulletListVO;
	}
	public void setRsltSearchSCRateSearchBulletListVOS(RsltSearchSCRateSearchBulletListVO[] rsltSearchSCRateSearchBulletListVO){
		if (rsltSearchSCRateSearchBulletListVO != null) {
			RsltSearchSCRateSearchBulletListVO[] tmpVOs = new RsltSearchSCRateSearchBulletListVO[rsltSearchSCRateSearchBulletListVO.length];
			System.arraycopy(rsltSearchSCRateSearchBulletListVO, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltSearchSCRateSearchBulletListVOs = tmpVOs;
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
	
	public RsltSearchSCRateSearchListVO getRsltSearchSCRateSearchListVO(){
		return rsltSearchSCRateSearchListVO;
	}
	public RsltSearchSCRateSearchListVO[] getRsltSearchSCRateSearchListVOS(){
		RsltSearchSCRateSearchListVO[] tmpVOs = null;
		if (this.rsltSearchSCRateSearchListVOs != null) {
			tmpVOs = new RsltSearchSCRateSearchListVO[rsltSearchSCRateSearchListVOs.length];
			System.arraycopy(rsltSearchSCRateSearchListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public RsltSearchSCRateSearchBulletListVO getRsltSearchSCRateSearchBulletListVO(){
		return rsltSearchSCRateSearchBulletListVO;
	}
	public RsltSearchSCRateSearchBulletListVO[] getRsltSearchSCRateSearchBulletListVOS(){
		RsltSearchSCRateSearchBulletListVO[] tmpVOs = null;
		if (this.rsltSearchSCRateSearchBulletListVOs != null) {
			tmpVOs = new RsltSearchSCRateSearchBulletListVO[rsltSearchSCRateSearchBulletListVOs.length];
			System.arraycopy(rsltSearchSCRateSearchBulletListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}