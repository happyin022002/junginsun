/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0924Event.java
*@FileTitle : Yard Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.29 최영희
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainListInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainSumVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0924 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0924HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Choi Yeoung Hee
 * @see ESM_BKG_0924HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0924Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TSRemainSumVO tRemainSumVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TSRemainSumVO[] tRemainSumVOs = null;
    
	private TSRemainListInputVO tSRemainListInputVO = null;
	
	private TSRemainListInputVO[] tSRemainListInputVOs = null;
	
	 
	
	public EsmBkg0924Event(){}

	public TSRemainSumVO getTRemainSumVO() {
		return tRemainSumVO;
	}

	public void setTRemainSumVO(TSRemainSumVO remainSumVO) {
		tRemainSumVO = remainSumVO;
	}

	public TSRemainSumVO[] getTRemainSumVOs() {
		TSRemainSumVO[] rtnVOs = null;
		if(this.tRemainSumVOs != null){
			rtnVOs= Arrays.copyOf(tRemainSumVOs, tRemainSumVOs.length);
		}
		return rtnVOs;
	}

	public void setTRemainSumVOs(TSRemainSumVO[] remainSumVOs) {
		if(remainSumVOs != null){
			TSRemainSumVO[] tmpVOs = Arrays.copyOf(remainSumVOs, remainSumVOs.length);
			this.tRemainSumVOs = tmpVOs;
		}
	}

	public TSRemainListInputVO getTSRemainListInputVO() {
		return tSRemainListInputVO;
	}

	public void setTSRemainListInputVO(TSRemainListInputVO remainListInputVO) {
		tSRemainListInputVO = remainListInputVO;
	}

	public TSRemainListInputVO[] getTSRemainListInputVOs() {
		TSRemainListInputVO[] rtnVOs = null;
		if(this.tSRemainListInputVOs != null){
			rtnVOs= Arrays.copyOf(tSRemainListInputVOs, tSRemainListInputVOs.length);
		}
		return rtnVOs;
	}

	public void setTSRemainListInputVOs(TSRemainListInputVO[] remainListInputVOs) {
		if(remainListInputVOs != null){
			TSRemainListInputVO[] tmpVOs = Arrays.copyOf(remainListInputVOs, remainListInputVOs.length);
			this.tSRemainListInputVOs = tmpVOs;
		}
	}
	
	 

}