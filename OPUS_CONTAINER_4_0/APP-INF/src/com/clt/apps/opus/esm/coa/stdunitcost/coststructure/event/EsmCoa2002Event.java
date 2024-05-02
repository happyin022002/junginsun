/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmCoa2002Event.java
*@FileTitle : Register Sub Group Cost Code
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2012.04.05 문동선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.esm.coa.stdunitcost.coststructure.vo.SubGrpCostCodeVO;
import java.util.Arrays;									//SJH.20150508.소스품질

/**
 * ESM_COA_2002 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_2002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Dongsun Moon
 * @see ESM_COA_2002HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmCoa2002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SubGrpCostCodeVO subGrpCostCodeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SubGrpCostCodeVO[] subGrpCostCodeVOs = null;
	
	private String stndCostTpCd = null;
	private String mainGroupCostCd = null;

	public EsmCoa2002Event(){}
	
	public void setSubGrpCostCodeVO(SubGrpCostCodeVO subGrpCostCodeVO){
		this. subGrpCostCodeVO = subGrpCostCodeVO;
	}
	//SJH.20150508.소스품질
	public void setSubGrpCostCodeVOS(SubGrpCostCodeVO[] subGrpCostCodeVOs){
		if(subGrpCostCodeVOs != null){
			SubGrpCostCodeVO[] tmpVOs = Arrays.copyOf(subGrpCostCodeVOs, subGrpCostCodeVOs.length);
			this.subGrpCostCodeVOs = tmpVOs;
		}
	}
	
	public void setStndCostTpCd(String sntdCostTpCd){
		this. stndCostTpCd = sntdCostTpCd;
	}

	public String getStndCostTpCd(){
		return stndCostTpCd;
	}
	
	public void setMainGroupCostCd(String mainGroupCostCd){
		this. mainGroupCostCd = mainGroupCostCd;
	}

	public String getMainGroupCostCd(){
		return mainGroupCostCd;
	}

	public SubGrpCostCodeVO getSubGrpCostCodeVO(){
		return subGrpCostCodeVO;
	}
	//SJH.20150508.소스품질
	public SubGrpCostCodeVO[] getSubGrpCostCodeVOS(){
		SubGrpCostCodeVO[] rtnVOs = null;
		if (this.subGrpCostCodeVOs != null) {
			rtnVOs = Arrays.copyOf(subGrpCostCodeVOs, subGrpCostCodeVOs.length);
		}
		return rtnVOs;
	}

}