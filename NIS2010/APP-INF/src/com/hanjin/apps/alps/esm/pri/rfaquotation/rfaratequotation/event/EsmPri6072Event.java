/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6073Event.java
*@FileTitle : PRS-Surcharge Adjust
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.07 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RsltPriSurchargeAdjustListVO;
import com.hanjin.syscommon.common.table.PriRqScgAdjVO;


/**
 * ESM_PRI_6073 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6073HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6073HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6072Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriSurchargeAdjustListVO[] rsltPriSurchargeAdjustListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRqScgAdjVO priRqScgAdjVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRqScgAdjVO[] priRqScgAdjVOs = null;

	public EsmPri6072Event(){}
	
	public void setRsltPriSurchargeAdjustListVO(RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO){
		this. rsltPriSurchargeAdjustListVO = rsltPriSurchargeAdjustListVO;
	}

	public void setRsltPriSurchargeAdjustListVOS(RsltPriSurchargeAdjustListVO[] rsltPriSurchargeAdjustListVOs){
		this. rsltPriSurchargeAdjustListVOs = rsltPriSurchargeAdjustListVOs;
	}

	public void setPriRqScgAdjVO(PriRqScgAdjVO priRqScgAdjVO){
		this. priRqScgAdjVO = priRqScgAdjVO;
	}

	public void setPriRqScgAdjVOS(PriRqScgAdjVO[] priRqScgAdjVOs){
		this. priRqScgAdjVOs = priRqScgAdjVOs;
	}

	public RsltPriSurchargeAdjustListVO getRsltPriSurchargeAdjustListVO(){
		return rsltPriSurchargeAdjustListVO;
	}

	public RsltPriSurchargeAdjustListVO[] getRsltPriSurchargeAdjustListVOS(){
		return rsltPriSurchargeAdjustListVOs;
	}

	public PriRqScgAdjVO getPriRqScgAdjVO(){
		return priRqScgAdjVO;
	}

	public PriRqScgAdjVO[] getPriRqScgAdjVOS(){
		return priRqScgAdjVOs;
	}
}