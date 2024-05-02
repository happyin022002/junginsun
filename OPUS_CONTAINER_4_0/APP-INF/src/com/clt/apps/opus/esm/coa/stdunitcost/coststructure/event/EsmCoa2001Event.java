/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmCoa2001Event.java
*@FileTitle : Register Main Group Cost Code
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.05
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.04.05 문동선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.MainGrpCostCodeVO;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_2001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_2001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dongsun Moon
 * @see ESM_COA_2001HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa2001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MainGrpCostCodeVO mainGrpCostCodeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private MainGrpCostCodeVO[] mainGrpCostCodeVOs = null;
	
	private String stndCostTpCd = null;

	public EsmCoa2001Event(){}
	
	public void setMainGrpCostCodeVO(MainGrpCostCodeVO mainGrpCostCodeVO){
		this. mainGrpCostCodeVO = mainGrpCostCodeVO;
	}
	//SJH.20150508.소스품질
	public void setMainGrpCostCodeVOS(MainGrpCostCodeVO[] mainGrpCostCodeVOs){
		if(mainGrpCostCodeVOs != null){
			MainGrpCostCodeVO[] tmpVOs = Arrays.copyOf(mainGrpCostCodeVOs, mainGrpCostCodeVOs.length);
			this.mainGrpCostCodeVOs = tmpVOs;
		}
	}
	
	public void setStndCostTpCd(String sntdCostTpCd){
		this. stndCostTpCd = sntdCostTpCd;
	}

	public String getStndCostTpCd(){
		return stndCostTpCd;
	}

	public MainGrpCostCodeVO getMainGrpCostCodeVO(){
		return mainGrpCostCodeVO;
	}
	//SJH.20150508.소스품질
	public MainGrpCostCodeVO[] getMainGrpCostCodeVOS(){
		MainGrpCostCodeVO[] rtnVOs = null;
		if (this.mainGrpCostCodeVOs != null) {
			rtnVOs = Arrays.copyOf(mainGrpCostCodeVOs, mainGrpCostCodeVOs.length);
		}
		return rtnVOs;
	}

}