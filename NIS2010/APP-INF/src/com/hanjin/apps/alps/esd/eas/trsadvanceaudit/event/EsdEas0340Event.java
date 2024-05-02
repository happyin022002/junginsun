/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : EsdEas0340Event.java
*@FileTitle : Transportation Invoice Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2015-5-15
*@LastModifier : Sung-Gil Hyun
*@LastVersion : 1.0
* 2015-5-15 Sung-Gil Hyun
* 1.0 최초 생성
*  
=========================================================*/

package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.event;

import java.util.Arrays;

import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudDtlListVO;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo.TrsPreAudListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESD_EAS_0340 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_EAS_0340HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HI
 * @see ESD_EAS_0340HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdEas0340Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TrsPreAudListVO TrsPreAudListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TrsPreAudListVO[] TrsPreAudListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private TrsPreAudDtlListVO TrsPreAudDtlListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TrsPreAudDtlListVO[] TrsPreAudDtlListVOs = null;

	public EsdEas0340Event(){}

	public TrsPreAudListVO getTrsPreAudListVO() {
		return TrsPreAudListVO;
	}

	public void setTrsPreAudListVO(TrsPreAudListVO trsPreAudListVO) {
		TrsPreAudListVO = trsPreAudListVO;
	}
	
	public TrsPreAudListVO[] getTrsPreAudListVOs() {
		TrsPreAudListVO[] rtnVOs = null;
		if (this.TrsPreAudListVOs != null) {
			rtnVOs = new TrsPreAudListVO[TrsPreAudListVOs.length];
			System.arraycopy(TrsPreAudListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setTrsPreAudListVOs(TrsPreAudListVO[] TrsPreAudListVOs) {
		if(TrsPreAudListVOs != null){
			TrsPreAudListVO[] tmpVOs = Arrays.copyOf(TrsPreAudListVOs, TrsPreAudListVOs.length);
			this.TrsPreAudListVOs = tmpVOs;
		}
	}
	
	public TrsPreAudDtlListVO getTrsPreAudDtlListVO() {
		return TrsPreAudDtlListVO;
	}

	public void setTrsPreAudDtlListVO(TrsPreAudDtlListVO trsPreAudDtlListVO) {
		TrsPreAudDtlListVO = trsPreAudDtlListVO;
	}
	
	public TrsPreAudDtlListVO[] getTrsPreAudDtlListVOs() {
		TrsPreAudDtlListVO[] rtnVOs = null;
		if (this.TrsPreAudDtlListVOs != null) {
			rtnVOs = new TrsPreAudDtlListVO[TrsPreAudDtlListVOs.length];
			System.arraycopy(TrsPreAudDtlListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}
	
	public void setTrsPreAudDtlListVOs(TrsPreAudDtlListVO[] TrsPreAudDtlListVOs) {
		if(TrsPreAudDtlListVOs != null){
			TrsPreAudDtlListVO[] tmpVOs = Arrays.copyOf(TrsPreAudDtlListVOs, TrsPreAudDtlListVOs.length);
			this.TrsPreAudDtlListVOs = tmpVOs;
		}
	}
	
}