/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmBkg0449Event.java
*@FileTitle : Comparison Result between Split Candidates.
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.02
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.06.02 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DpcsSiSplitBkgCntrCompareResultVO;


/**
 * ESM_BKG_0449 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0449HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Jong
 * @see ESM_BKG_0449HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0449Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private DpcsSiSplitBkgCntrCompareResultVO dpcsSiSplitBkgCntrCompareResultVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private DpcsSiSplitBkgCntrCompareResultVO[] dpcsSiSplitBkgCntrCompareResultVOs = null;

	public EsmBkg0449Event(){}
	
	public void setDpcsSiSplitBkgCntrCompareResultVO(DpcsSiSplitBkgCntrCompareResultVO dpcsSiSplitBkgCntrCompareResultVO){
		this. dpcsSiSplitBkgCntrCompareResultVO = dpcsSiSplitBkgCntrCompareResultVO;
	}

	public void setDpcsSiSplitBkgCntrCompareResultVOS(DpcsSiSplitBkgCntrCompareResultVO[] dpcsSiSplitBkgCntrCompareResultVOs){
		if(dpcsSiSplitBkgCntrCompareResultVOs != null){
			DpcsSiSplitBkgCntrCompareResultVO[] tmpVOs = Arrays.copyOf(dpcsSiSplitBkgCntrCompareResultVOs, dpcsSiSplitBkgCntrCompareResultVOs.length);
			this.dpcsSiSplitBkgCntrCompareResultVOs = tmpVOs;
		}
	}

	public DpcsSiSplitBkgCntrCompareResultVO getDpcsSiSplitBkgCntrCompareResultVO(){
		return dpcsSiSplitBkgCntrCompareResultVO;
	}

	public DpcsSiSplitBkgCntrCompareResultVO[] getDpcsSiSplitBkgCntrCompareResultVOS(){
		DpcsSiSplitBkgCntrCompareResultVO[] rtnVOs = null;
		if (this.dpcsSiSplitBkgCntrCompareResultVOs != null) {
			rtnVOs = Arrays.copyOf(dpcsSiSplitBkgCntrCompareResultVOs, dpcsSiSplitBkgCntrCompareResultVOs.length);
		}
		return rtnVOs;
	}

}