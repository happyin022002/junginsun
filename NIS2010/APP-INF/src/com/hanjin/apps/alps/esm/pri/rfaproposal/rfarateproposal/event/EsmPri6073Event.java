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
=========================================================
* History
* [CHM-201534517] 1월 소스 보안 결함 건 조치 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustListVO;
import com.hanjin.syscommon.common.table.PriRpScpScgAdjVO;


/**
 * ESM_PRI_6019 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6019HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG MIN SEOK
 * @see ESM_PRI_6019HTMLAction 참조
 * @since J2EE 1.6
 */
 
public class EsmPri6073Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	 
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RsltPriSurchargeAdjustListVO[] rsltPriSurchargeAdjustListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PriRpScpScgAdjVO priRpScpScgAdjVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PriRpScpScgAdjVO[] priRpScpScgAdjVOs = null;

	public EsmPri6073Event(){}
	
	public void setRsltPriSurchargeAdjustListVO(RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO){
		this. rsltPriSurchargeAdjustListVO = rsltPriSurchargeAdjustListVO;
	}

	public void setRsltPriSurchargeAdjustListVOS(RsltPriSurchargeAdjustListVO[] rsltPriSurchargeAdjustListVOs){
		if(rsltPriSurchargeAdjustListVOs != null){
			RsltPriSurchargeAdjustListVO[] tmpVOs = new RsltPriSurchargeAdjustListVO[rsltPriSurchargeAdjustListVOs.length];
			System.arraycopy(rsltPriSurchargeAdjustListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltPriSurchargeAdjustListVOs = tmpVOs;
		}
	}

	public void setPriRpScpScgAdjVO(PriRpScpScgAdjVO priRpScpScgAdjVO){
		this. priRpScpScgAdjVO = priRpScpScgAdjVO;
	}

	public void setPriRpScpScgAdjVOS(PriRpScpScgAdjVO[] priRpScpScgAdjVOs){
		if(priRpScpScgAdjVOs != null){
			PriRpScpScgAdjVO[] tmpVOs = new PriRpScpScgAdjVO[priRpScpScgAdjVOs.length];
			System.arraycopy(priRpScpScgAdjVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpScgAdjVOs = tmpVOs;
		}
	}

	public RsltPriSurchargeAdjustListVO getRsltPriSurchargeAdjustListVO(){
		return rsltPriSurchargeAdjustListVO;
	}

	public RsltPriSurchargeAdjustListVO[] getRsltPriSurchargeAdjustListVOS(){
		RsltPriSurchargeAdjustListVO[] rtnVOs = null;
		if (this.rsltPriSurchargeAdjustListVOs != null) {
			rtnVOs = new RsltPriSurchargeAdjustListVO[rsltPriSurchargeAdjustListVOs.length];
			System.arraycopy(rsltPriSurchargeAdjustListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public PriRpScpScgAdjVO getPriRpScpScgAdjVO(){
		return priRpScpScgAdjVO;
	}

	public PriRpScpScgAdjVO[] getPriRpScpScgAdjVOS(){
		PriRpScpScgAdjVO[] rtnVOs = null;
		if (this.priRpScpScgAdjVOs != null) {
			rtnVOs = new PriRpScpScgAdjVO[priRpScpScgAdjVOs.length];
			System.arraycopy(priRpScpScgAdjVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	} 
}