/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0008Event.java
*@FileTitle : Standard Note Conversion Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.06.23 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scnoteconversionproposal.vo.PriScNoteConvListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriScNoteConvCpyVO;
import com.hanjin.syscommon.common.table.PriScNoteConvVO;


/**
 * ESM_PRI_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScNoteConvVO priScNoteConvVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScNoteConvCpyVO priScNoteConvCpyVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScNoteConvVO[] priScNoteConvVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScNoteConvCpyVO[] priScNoteConvCpyVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriScNoteConvListVO priScNoteConvListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriScNoteConvListVO[] priScNoteConvListVOs = null;

	public EsmPri0008Event(){}
	
	public void setPriScNoteConvVO(PriScNoteConvVO priScNoteConvVO){
		this. priScNoteConvVO = priScNoteConvVO;
	}
	
	public void setPriScNoteConvCpyVO(PriScNoteConvCpyVO priScNoteConvCpyVO) {
		this.priScNoteConvCpyVO = priScNoteConvCpyVO;
	}
	

	public void setPriScNoteConvVOS(PriScNoteConvVO[] priScNoteConvVOs){
		this. priScNoteConvVOs = priScNoteConvVOs;
	}
	
	public void setPriScNoteConvCpyVOS(PriScNoteConvCpyVO[] priScNoteConvCpyVOs){
		this. priScNoteConvCpyVOs = priScNoteConvCpyVOs;
	}

	public PriScNoteConvVO getPriScNoteConvVO(){
		return priScNoteConvVO;
	}

	public PriScNoteConvVO[] getPriScNoteConvVOS(){
		return priScNoteConvVOs;
	}
	
	public PriScNoteConvCpyVO[] getPriScNoteConvCpyVOS(){
		return priScNoteConvCpyVOs;
	}

	public PriScNoteConvCpyVO getPriScNoteConvCpyVO() {
		return priScNoteConvCpyVO;
	}

	public PriScNoteConvListVO getPriScNoteConvListVO() {
		return priScNoteConvListVO;
	}

	public PriScNoteConvListVO[] getPriScNoteConvListVOs() {
		return priScNoteConvListVOs;
	}

	public void setPriScNoteConvListVO(PriScNoteConvListVO priScNoteConvListVO) {
		this.priScNoteConvListVO = priScNoteConvListVO;
	}

	public void setPriScNoteConvListVOs(PriScNoteConvListVO[] priScNoteConvListVOs) {
		this.priScNoteConvListVOs = priScNoteConvListVOs;
	}

	

}