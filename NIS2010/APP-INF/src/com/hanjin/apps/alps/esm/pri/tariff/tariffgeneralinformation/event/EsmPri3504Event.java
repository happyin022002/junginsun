/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri3504Event.java
*@FileTitle : Tariff General Information History
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.01
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.10.12 서미진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.event;

import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.PriTrfBzcHistoryAmendVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffgeneralinformation.vo.PriTrfBzcHistoryVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriTrfBzcVO;

/**
 * ESM_PRI_3504 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3504HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO	MIJIN
 * @see ESM_PRI_3504HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3504Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmPri3504Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfBzcHistoryVO priTrfBzcHistoryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriTrfBzcHistoryVO[] priTrfBzcHistoryVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfBzcHistoryAmendVO priTrfBzcHistoryAmendVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriTrfBzcHistoryAmendVO[] priTrfBzcHistoryAmendVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTrfBzcVO priTrfBzcVO = null;
	
	public PriTrfBzcVO getPriTrfBzcVO() {
		return priTrfBzcVO;
	}

	public void setPriTrfBzcVO(PriTrfBzcVO priTrfBzcVO) {
		this.priTrfBzcVO = priTrfBzcVO;
	}

	public PriTrfBzcVO[] getPriTrfBzcVOs() {
		return priTrfBzcVOs;
	}

	public void setPriTrfBzcVOs(PriTrfBzcVO[] priTrfBzcVOs) {
		this.priTrfBzcVOs = priTrfBzcVOs;
	}

	/** Table Value Object Multi Data 처리 */
	private PriTrfBzcVO[] priTrfBzcVOs = null;
	
	
	
	
	
	public PriTrfBzcHistoryAmendVO getPriTrfBzcHistoryAmendVO() {
		return priTrfBzcHistoryAmendVO;
	}

	public void setPriTrfBzcHistoryAmendVO(PriTrfBzcHistoryAmendVO priTrfBzcHistoryAmendVO) {
		this.priTrfBzcHistoryAmendVO = priTrfBzcHistoryAmendVO;
	}

	public PriTrfBzcHistoryAmendVO[] getPriTrfBzcHistoryAmendVOs() {
		return priTrfBzcHistoryAmendVOs;
	}

	public void setPriTrfBzcHistoryAmendVOs(PriTrfBzcHistoryAmendVO[] priTrfBzcHistoryAmendVOs) {
		this.priTrfBzcHistoryAmendVOs = priTrfBzcHistoryAmendVOs;
	}

	public PriTrfBzcHistoryVO getPriTrfBzcHistoryVO() {
		return priTrfBzcHistoryVO;
	}

	public void setPriTrfBzcHistoryVO(PriTrfBzcHistoryVO priTrfBzcHistoryVO) {
		this.priTrfBzcHistoryVO = priTrfBzcHistoryVO;
	}

	public PriTrfBzcHistoryVO[] getPriTrfBzcHistoryVOs() {
		return priTrfBzcHistoryVOs;
	}

	public void setPriTrfBzcHistoryVOs(PriTrfBzcHistoryVO[] priTrfBzcHistoryVOs) {
		this.priTrfBzcHistoryVOs = priTrfBzcHistoryVOs;
	}

}