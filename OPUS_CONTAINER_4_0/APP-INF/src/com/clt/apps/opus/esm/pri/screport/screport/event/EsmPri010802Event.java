/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri010802Event.java
*@FileTitle : S/C Performance Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.02 김대호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.event;

import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCInfromationVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerformanceBulletListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailListVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailSumVO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCTradeSubTradeLaneListVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ComBakEndJbVO;

/**
 * ESM_PRI_0108_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0108_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh Kim
 * @see ESM_PRI_0108_02HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri010802Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComBakEndJbVO comBakEndJbVO = null;
	/** Table Value Object Multi Data 처리 */
	private ComBakEndJbVO[] comBakEndJbVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchSCTradeSubTradeLaneListVO rsltSearchSCTradeSubTradeLaneListVO = null;
	/** Table Value Object Multi Data 처리 */
	private RsltSearchSCTradeSubTradeLaneListVO[] rsltSearchSCTradeSubTradeLaneListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchSCInfromationVO rsltSearchSCInfromationVO = null;
	/** Table Value Object Multi Data 처리 */
	private RsltSearchSCInfromationVO[] rsltSearchSCInfromationVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchSCPerformanceBulletListVO rsltSearchSCPerformanceBulletListVO = null;
	/** Table Value Object Multi Data 처리 */
	private RsltSearchSCPerformanceBulletListVO[] rsltSearchSCPerformanceBulletListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO = null;
	/** Table Value Object Multi Data 처리 */
	private RsltSearchSCPerformanceDetailListVO[] rsltSearchSCPerformanceDetailListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchSCPerformanceDetailSumVO rsltSearchSCPerformanceDetailSumVO = null;
	/** Table Value Object Multi Data 처리 */
	private RsltSearchSCPerformanceDetailSumVO[] rsltSearchSCPerformanceDetailSumVOs= null;

	public EsmPri010802Event(){}
	
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
	
	public void setRsltSearchSCTradeSubTradeLaneListVO(RsltSearchSCTradeSubTradeLaneListVO rsltSearchSCTradeSubTradeLaneListVO){
		this.rsltSearchSCTradeSubTradeLaneListVO = rsltSearchSCTradeSubTradeLaneListVO;
	}
	public void setRsltSearchSCTradeSubTradeLaneListVOS(RsltSearchSCTradeSubTradeLaneListVO[] rsltSearchSCTradeSubTradeLaneListVO){
		if (rsltSearchSCTradeSubTradeLaneListVO != null) {
			RsltSearchSCTradeSubTradeLaneListVO[] tmpVOs = new RsltSearchSCTradeSubTradeLaneListVO[rsltSearchSCTradeSubTradeLaneListVO.length];
			System.arraycopy(rsltSearchSCTradeSubTradeLaneListVO, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltSearchSCTradeSubTradeLaneListVOs = tmpVOs;
		}
	}
	
	public void setRsltSearchSCInfromationVO(RsltSearchSCInfromationVO rsltSearchSCInfromationVO){
		this.rsltSearchSCInfromationVO = rsltSearchSCInfromationVO;
	}
	public void setRsltSearchSCInfromationVOS(RsltSearchSCInfromationVO[] rsltSearchSCInfromationVO){
		if (rsltSearchSCInfromationVO != null) {
			RsltSearchSCInfromationVO[] tmpVOs = new RsltSearchSCInfromationVO[rsltSearchSCInfromationVO.length];
			System.arraycopy(rsltSearchSCInfromationVO, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltSearchSCInfromationVOs = tmpVOs;
		}
	}

	public void setRsltSearchSCPerformanceBulletListVO(RsltSearchSCPerformanceBulletListVO rsltSearchSCPerformanceBulletListVO){
		this.rsltSearchSCPerformanceBulletListVO = rsltSearchSCPerformanceBulletListVO;
	}
	public void setRsltSearchSCPerformanceBulletListVOS(RsltSearchSCPerformanceBulletListVO[] rsltSearchSCPerformanceBulletListVO){
		if (rsltSearchSCPerformanceBulletListVO != null) {
			RsltSearchSCPerformanceBulletListVO[] tmpVOs = new RsltSearchSCPerformanceBulletListVO[rsltSearchSCPerformanceBulletListVO.length];
			System.arraycopy(rsltSearchSCPerformanceBulletListVO, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltSearchSCPerformanceBulletListVOs = tmpVOs;
		}
	}

	public void setRsltSearchSCPerformanceDetailListVO(RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO){
		this.rsltSearchSCPerformanceDetailListVO = rsltSearchSCPerformanceDetailListVO;
	}
	public void setRsltSearchSCPerformanceDetailListVOS(RsltSearchSCPerformanceDetailListVO[] rsltSearchSCPerformanceDetailListVO){
		if (rsltSearchSCPerformanceDetailListVO != null) {
			RsltSearchSCPerformanceDetailListVO[] tmpVOs = new RsltSearchSCPerformanceDetailListVO[rsltSearchSCPerformanceDetailListVO.length];
			System.arraycopy(rsltSearchSCPerformanceDetailListVO, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltSearchSCPerformanceDetailListVOs = tmpVOs;
		}
	}

	public void setRsltSearchSCPerformanceDetailSumVO(RsltSearchSCPerformanceDetailSumVO rsltSearchSCPerformanceDetailSumVO){
		this.rsltSearchSCPerformanceDetailSumVO = rsltSearchSCPerformanceDetailSumVO;
	}
	public void setRsltSearchSCPerformanceDetailSumVOS(RsltSearchSCPerformanceDetailSumVO[] rsltSearchSCPerformanceDetailSumVO){
		if (rsltSearchSCPerformanceDetailSumVO != null) {
			RsltSearchSCPerformanceDetailSumVO[] tmpVOs = new RsltSearchSCPerformanceDetailSumVO[rsltSearchSCPerformanceDetailSumVO.length];
			System.arraycopy(rsltSearchSCPerformanceDetailSumVO, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltSearchSCPerformanceDetailSumVOs = tmpVOs;
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
	
	public RsltSearchSCTradeSubTradeLaneListVO getRsltSearchSCTradeSubTradeLaneListVO(){
		return rsltSearchSCTradeSubTradeLaneListVO;
	}
	public RsltSearchSCTradeSubTradeLaneListVO[] getRsltSearchSCTradeSubTradeLaneListVOS(){
		RsltSearchSCTradeSubTradeLaneListVO[] tmpVOs = null;
		if (this.rsltSearchSCTradeSubTradeLaneListVOs != null) {
			tmpVOs = new RsltSearchSCTradeSubTradeLaneListVO[rsltSearchSCTradeSubTradeLaneListVOs.length];
			System.arraycopy(rsltSearchSCTradeSubTradeLaneListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public RsltSearchSCInfromationVO getRsltSearchSCInfromationVO(){
		return rsltSearchSCInfromationVO;
	}
	public RsltSearchSCInfromationVO[] getRsltSearchSCInfromationVOS(){
		RsltSearchSCInfromationVO[] tmpVOs = null;
		if (this.rsltSearchSCInfromationVOs != null) {
			tmpVOs = new RsltSearchSCInfromationVO[rsltSearchSCInfromationVOs.length];
			System.arraycopy(rsltSearchSCInfromationVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public RsltSearchSCPerformanceBulletListVO getRsltSearchSCPerformanceBulletListVO(){
		return rsltSearchSCPerformanceBulletListVO;
	}
	public RsltSearchSCPerformanceBulletListVO[] getRsltSearchSCPerformanceBulletListVOS(){
		RsltSearchSCPerformanceBulletListVO[] tmpVOs = null;
		if (this.rsltSearchSCPerformanceBulletListVOs != null) {
			tmpVOs = new RsltSearchSCPerformanceBulletListVO[rsltSearchSCPerformanceBulletListVOs.length];
			System.arraycopy(rsltSearchSCPerformanceBulletListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public RsltSearchSCPerformanceDetailListVO getRsltSearchSCPerformanceDetailListVO(){
		return rsltSearchSCPerformanceDetailListVO;
	}
	public RsltSearchSCPerformanceDetailListVO[] getRsltSearchSCPerformanceDetailListVOS(){
		RsltSearchSCPerformanceDetailListVO[] tmpVOs = null;
		if (this.rsltSearchSCPerformanceDetailListVOs != null) {
			tmpVOs = new RsltSearchSCPerformanceDetailListVO[rsltSearchSCPerformanceDetailListVOs.length];
			System.arraycopy(rsltSearchSCPerformanceDetailListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	
	public RsltSearchSCPerformanceDetailSumVO getRsltSearchSCPerformanceDetailSumVO(){
		return rsltSearchSCPerformanceDetailSumVO;
	}
	public RsltSearchSCPerformanceDetailSumVO[] getRsltSearchSCPerformanceDetailSumVOS(){
		RsltSearchSCPerformanceDetailSumVO[] tmpVOs = null;
		if (this.rsltSearchSCPerformanceDetailSumVOs != null) {
			tmpVOs = new RsltSearchSCPerformanceDetailSumVO[rsltSearchSCPerformanceDetailSumVOs.length];
			System.arraycopy(rsltSearchSCPerformanceDetailSumVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}