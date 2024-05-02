/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : EsmMas0338Event.java
*@FileTitle : Agreed Network Cost Ratio Table
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.19
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.07.19 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.MasAgrdNtwkCostRtoVO;


/**
 * ESM_MAS_0338 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0338HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG, Min Seok
 * @see ESM_MAS_0338HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0338Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MasAgrdNtwkCostRtoVO masAgrdNtwkCostRtoVO = null;
    private MasAgrdNtwkCostRtoVO[] masAgrdNtwkCostRtoVOs = null;

	private SearchConditionVO searchConditionVO = null;	
	
	public EsmMas0338Event(){}
	
	   /** ValueObject Array Setter - Create/Update/Delete */
    public void setMasAgrdNtwkCostRtoVOs(MasAgrdNtwkCostRtoVO[] masAgrdNtwkCostRtoVOs){
        this.masAgrdNtwkCostRtoVOs = masAgrdNtwkCostRtoVOs;
    }
    /** ValueObject Array Getter - Create/Update/Delete */
    public MasAgrdNtwkCostRtoVO[] getMasAgrdNtwkCostRtoVOs(){
        return masAgrdNtwkCostRtoVOs;
    }   
	public void setMasAgrdNtwkCostRtoVO(MasAgrdNtwkCostRtoVO masAgrdNtwkCostRtoVO){
		this. masAgrdNtwkCostRtoVO = masAgrdNtwkCostRtoVO;
	}

	public MasAgrdNtwkCostRtoVO getMasAgrdNtwkCostRtoVO(){
		return masAgrdNtwkCostRtoVO;
	}
	
	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.searchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
}