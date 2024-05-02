/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6051Event.java
*@FileTitle : Surcharge Adjust-Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.08 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeAdjustLocationGroupDetailVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeAdjustLocationGroupVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6051 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6051HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6051HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6051Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationGroupVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriSurchargeAdjustLocationGroupVO[] rsltPriSurchargeAdjustLocationGroupVOs = null;

	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationGroupDetailVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriSurchargeAdjustLocationGroupDetailVO[] rsltPriSurchargeAdjustLocationGroupDetailVOs = null;

	public EsmPri6051Event(){}

	public void setRsltPriSurchargeAdjustLocationGroupVO(RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationGroupVO){
		this. rsltPriSurchargeAdjustLocationGroupVO = rsltPriSurchargeAdjustLocationGroupVO;
	}

	public void setRsltPriSurchargeAdjustLocationGroupVOS(RsltPriSurchargeAdjustLocationGroupVO[] rsltPriSurchargeAdjustLocationGroupVOs){
		this. rsltPriSurchargeAdjustLocationGroupVOs = rsltPriSurchargeAdjustLocationGroupVOs;
	}

	public RsltPriSurchargeAdjustLocationGroupVO getRsltPriSurchargeAdjustLocationGroupVO(){
		return rsltPriSurchargeAdjustLocationGroupVO;
	}

	public RsltPriSurchargeAdjustLocationGroupVO[] getRsltPriSurchargeAdjustLocationGroupVOS(){
		return rsltPriSurchargeAdjustLocationGroupVOs;
	}

	
	
	public void setRsltPriSurchargeAdjustLocationGroupDetailVO(RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationGroupDetailVO){
		this. rsltPriSurchargeAdjustLocationGroupDetailVO = rsltPriSurchargeAdjustLocationGroupDetailVO;
	}

	public void setRsltPriSurchargeAdjustLocationGroupDetailVOS(RsltPriSurchargeAdjustLocationGroupDetailVO[] rsltPriSurchargeAdjustLocationGroupDetailVOs){
		this. rsltPriSurchargeAdjustLocationGroupDetailVOs = rsltPriSurchargeAdjustLocationGroupDetailVOs;
	}

	public RsltPriSurchargeAdjustLocationGroupDetailVO getRsltPriSurchargeAdjustLocationGroupDetailVO(){
		return rsltPriSurchargeAdjustLocationGroupDetailVO;
	}

	public RsltPriSurchargeAdjustLocationGroupDetailVO[] getRsltPriSurchargeAdjustLocationGroupDetailVOS(){
		return rsltPriSurchargeAdjustLocationGroupDetailVOs;
	}
}