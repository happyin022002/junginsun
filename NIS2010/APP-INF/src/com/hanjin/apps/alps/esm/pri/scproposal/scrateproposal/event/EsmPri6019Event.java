/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6019Event.java
*@FileTitle : PRS-Surcharge Adjust
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.07 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.event;

import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriCheckSurchargeNoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeAdjustListVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.PriSpScpScgAdjVO;


/**
 * ESM_PRI_6019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6019HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6019Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriCheckSurchargeNoteListVO rsltPriCheckSurchargeNoteListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriCheckSurchargeNoteListVO[] rsltPriCheckSurchargeNoteListVOs = null;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriSurchargeAdjustListVO[] rsltPriSurchargeAdjustListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriSpScpScgAdjVO priSpScpScgAdjVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriSpScpScgAdjVO[] priSpScpScgAdjVOs = null;

	public EsmPri6019Event(){}
	
	public void setRsltPriCheckSurchargeNoteListVO(RsltPriCheckSurchargeNoteListVO rsltPriCheckSurchargeNoteListVO){
		this. rsltPriCheckSurchargeNoteListVO = rsltPriCheckSurchargeNoteListVO;
	}

	public void setRsltPriCheckSurchargeNoteListVOS(RsltPriCheckSurchargeNoteListVO[] rsltPriCheckSurchargeNoteListVOs){
		this. rsltPriCheckSurchargeNoteListVOs = rsltPriCheckSurchargeNoteListVOs;
	}
	
	
	public void setRsltPriSurchargeAdjustListVO(RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO){
		this. rsltPriSurchargeAdjustListVO = rsltPriSurchargeAdjustListVO;
	}

	public void setRsltPriSurchargeAdjustListVOS(RsltPriSurchargeAdjustListVO[] rsltPriSurchargeAdjustListVOs){
		this. rsltPriSurchargeAdjustListVOs = rsltPriSurchargeAdjustListVOs;
	}

	public void setPriSpScpScgAdjVO(PriSpScpScgAdjVO priSpScpScgAdjVO){
		this. priSpScpScgAdjVO = priSpScpScgAdjVO;
	}

	public void setPriSpScpScgAdjVOS(PriSpScpScgAdjVO[] priSpScpScgAdjVOs){
		this. priSpScpScgAdjVOs = priSpScpScgAdjVOs;
	}

	public RsltPriCheckSurchargeNoteListVO getRsltPriCheckSurchargeNoteListVO(){
		return rsltPriCheckSurchargeNoteListVO;
	}

	public RsltPriCheckSurchargeNoteListVO[] getRsltPriCheckSurchargeNoteListVOS(){
		return rsltPriCheckSurchargeNoteListVOs;
	}
	
	public RsltPriSurchargeAdjustListVO getRsltPriSurchargeAdjustListVO(){
		return rsltPriSurchargeAdjustListVO;
	}

	public RsltPriSurchargeAdjustListVO[] getRsltPriSurchargeAdjustListVOS(){
		return rsltPriSurchargeAdjustListVOs;
	}

	public PriSpScpScgAdjVO getPriSpScpScgAdjVO(){
		return priSpScpScgAdjVO;
	}

	public PriSpScpScgAdjVO[] getPriSpScpScgAdjVOS(){
		return priSpScpScgAdjVOs;
	}

}