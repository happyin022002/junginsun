/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : EsmMas0341Event.java
*@FileTitle : Allocation for Inter to Inter TS
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
import com.hanjin.apps.alps.esm.mas.weeklypfmc.networkdistribution.vo.SearchAgrdNtwkAllocByAgmtInterVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_MAS_0341 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0341HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SONG, Min Seok
 * @see ESM_MAS_0341HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0341Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAgrdNtwkAllocByAgmtInterVO searchAgrdNtwkAllocByAgmtInterVO = null;
    private SearchAgrdNtwkAllocByAgmtInterVO[] searchAgrdNtwkAllocByAgmtInterVOs = null;

	private SearchConditionVO searchConditionVO = null;	
	
	public EsmMas0341Event(){}
	
	   /** ValueObject Array Setter - Create/Update/Delete */
    public void setSearchAgrdNtwkAllocByAgmtInterVOs(SearchAgrdNtwkAllocByAgmtInterVO[] searchAgrdNtwkAllocByAgmtInterVOs){
        this.searchAgrdNtwkAllocByAgmtInterVOs = searchAgrdNtwkAllocByAgmtInterVOs;
    }
    /** ValueObject Array Getter - Create/Update/Delete */
    public SearchAgrdNtwkAllocByAgmtInterVO[] getSearchAgrdNtwkAllocByAgmtInterVOs(){
        return searchAgrdNtwkAllocByAgmtInterVOs;
    }   
	public void setSearchAgrdNtwkAllocByAgmtInterVO(SearchAgrdNtwkAllocByAgmtInterVO searchAgrdNtwkAllocByAgmtInterVO){
		this. searchAgrdNtwkAllocByAgmtInterVO = searchAgrdNtwkAllocByAgmtInterVO;
	}

	public SearchAgrdNtwkAllocByAgmtInterVO getSearchAgrdNtwkAllocByAgmtInterVO(){
		return searchAgrdNtwkAllocByAgmtInterVO;
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