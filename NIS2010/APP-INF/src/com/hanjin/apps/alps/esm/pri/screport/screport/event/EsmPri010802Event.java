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
package com.hanjin.apps.alps.esm.pri.screport.screport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.ComBakEndJbVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCInfromationVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCTradeSubTradeLaneListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerformanceBulletListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailListVO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailSumVO;

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
		this.comBakEndJbVOs = comBakEndJbVOs;
	}
	
	public void setRsltSearchSCTradeSubTradeLaneListVO(RsltSearchSCTradeSubTradeLaneListVO rsltSearchSCTradeSubTradeLaneListVO){
		this.rsltSearchSCTradeSubTradeLaneListVO = rsltSearchSCTradeSubTradeLaneListVO;
	}
	public void setRsltSearchSCTradeSubTradeLaneListVOS(RsltSearchSCTradeSubTradeLaneListVO[] rsltSearchSCTradeSubTradeLaneListVO){
		this.rsltSearchSCTradeSubTradeLaneListVOs = rsltSearchSCTradeSubTradeLaneListVO;
	}
	
	public void setRsltSearchSCInfromationVO(RsltSearchSCInfromationVO rsltSearchSCInfromationVO){
		this.rsltSearchSCInfromationVO = rsltSearchSCInfromationVO;
	}
	public void setRsltSearchSCInfromationVOS(RsltSearchSCInfromationVO[] rsltSearchSCInfromationVO){
		this.rsltSearchSCInfromationVOs = rsltSearchSCInfromationVO;
	}

	public void setRsltSearchSCPerformanceBulletListVO(RsltSearchSCPerformanceBulletListVO rsltSearchSCPerformanceBulletListVO){
		this.rsltSearchSCPerformanceBulletListVO = rsltSearchSCPerformanceBulletListVO;
	}
	public void setRsltSearchSCPerformanceBulletListVOS(RsltSearchSCPerformanceBulletListVO[] rsltSearchSCPerformanceBulletListVO){
		this.rsltSearchSCPerformanceBulletListVOs = rsltSearchSCPerformanceBulletListVO;
	}

	public void setRsltSearchSCPerformanceDetailListVO(RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO){
		this.rsltSearchSCPerformanceDetailListVO = rsltSearchSCPerformanceDetailListVO;
	}
	public void setRsltSearchSCPerformanceDetailListVOS(RsltSearchSCPerformanceDetailListVO[] rsltSearchSCPerformanceDetailListVO){
		this.rsltSearchSCPerformanceDetailListVOs = rsltSearchSCPerformanceDetailListVO;
	}

	public void setRsltSearchSCPerformanceDetailSumVO(RsltSearchSCPerformanceDetailSumVO rsltSearchSCPerformanceDetailSumVO){
		this.rsltSearchSCPerformanceDetailSumVO = rsltSearchSCPerformanceDetailSumVO;
	}
	public void setRsltSearchSCPerformanceDetailSumVOS(RsltSearchSCPerformanceDetailSumVO[] rsltSearchSCPerformanceDetailSumVO){
		this.rsltSearchSCPerformanceDetailSumVOs = rsltSearchSCPerformanceDetailSumVO;
	}

	/* get */
	public ComBakEndJbVO getComBakEndJbVO(){
		return comBakEndJbVO;
	}
	public ComBakEndJbVO[] getComBakEndJbVOS(){
		return comBakEndJbVOs;
	}
	
	public RsltSearchSCTradeSubTradeLaneListVO getRsltSearchSCTradeSubTradeLaneListVO(){
		return rsltSearchSCTradeSubTradeLaneListVO;
	}
	public RsltSearchSCTradeSubTradeLaneListVO[] getRsltSearchSCTradeSubTradeLaneListVOS(){
		return rsltSearchSCTradeSubTradeLaneListVOs;
	}
	
	public RsltSearchSCInfromationVO getRsltSearchSCInfromationVO(){
		return rsltSearchSCInfromationVO;
	}
	public RsltSearchSCInfromationVO[] getRsltSearchSCInfromationVOS(){
		return rsltSearchSCInfromationVOs;
	}

	public RsltSearchSCPerformanceBulletListVO getRsltSearchSCPerformanceBulletListVO(){
		return rsltSearchSCPerformanceBulletListVO;
	}
	public RsltSearchSCPerformanceBulletListVO[] getRsltSearchSCPerformanceBulletListVOS(){
		return rsltSearchSCPerformanceBulletListVOs;
	}

	public RsltSearchSCPerformanceDetailListVO getRsltSearchSCPerformanceDetailListVO(){
		return rsltSearchSCPerformanceDetailListVO;
	}
	public RsltSearchSCPerformanceDetailListVO[] getRsltSearchSCPerformanceDetailListVOS(){
		return rsltSearchSCPerformanceDetailListVOs;
	}
	
	public RsltSearchSCPerformanceDetailSumVO getRsltSearchSCPerformanceDetailSumVO(){
		return rsltSearchSCPerformanceDetailSumVO;
	}
	public RsltSearchSCPerformanceDetailSumVO[] getRsltSearchSCPerformanceDetailSumVOS(){
		return rsltSearchSCPerformanceDetailSumVOs;
	}

}