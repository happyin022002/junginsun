/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri3005Event.java
*@FileTitle : Tariff Fomula Rule Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.11.17 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.event;

import com.hanjin.apps.alps.esm.pri.triproposal.trinoteconversionproposal.vo.PriTriNoteConvListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriTriNoteConvVO;
import com.hanjin.syscommon.common.table.PriTriNoteVO;


/**
 * ESM_PRI_3005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_3005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTriNoteConvVO priTriNoteConvVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriTriNoteConvVO[] priTriNoteConvVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTriNoteConvListVO priTriNoteConvListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriTriNoteConvListVO[] priTriNoteConvListVOs = null;
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriTriNoteVO priTriNoteVO = null;
	

	public EsmPri3005Event(){}

	public PriTriNoteConvVO getPriTriNoteConvVO() {
		return priTriNoteConvVO;
	}

	public PriTriNoteConvVO[] getPriTriNoteConvVOs() {
		return priTriNoteConvVOs;
	}

	public PriTriNoteConvListVO getPriTriNoteConvListVO() {
		return priTriNoteConvListVO;
	}

	public PriTriNoteConvListVO[] getPriTriNoteConvListVOs() {
		return priTriNoteConvListVOs;
	}

	public void setPriTriNoteConvVO(PriTriNoteConvVO priTriNoteConvVO) {
		this.priTriNoteConvVO = priTriNoteConvVO;
	}

	public void setPriTriNoteConvVOs(PriTriNoteConvVO[] priTriNoteConvVOs) {
		this.priTriNoteConvVOs = priTriNoteConvVOs;
	}

	public void setPriTriNoteConvListVO(PriTriNoteConvListVO priTriNoteConvListVO) {
		this.priTriNoteConvListVO = priTriNoteConvListVO;
	}

	public void setPriTriNoteConvListVOs(
			PriTriNoteConvListVO[] priTriNoteConvListVOs) {
		this.priTriNoteConvListVOs = priTriNoteConvListVOs;
	}

	public PriTriNoteVO getPriTriNoteVO() {
		return priTriNoteVO;
	}

	public void setPriTriNoteVO(PriTriNoteVO priTriNoteVO) {
		this.priTriNoteVO = priTriNoteVO;
	}
	
	

}