/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmCoa0039Event.java
*@FileTitle : EsmCoa0039Event
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.14 김기대
* 1.0 Creation
 *=========================================================
 * History
 * 2011.03.02 김상수 [CHM-201109144-01] Lane Transit time 메뉴 개선
 *                                      - Lane Transit time 화면내의 Sheet에 OPR2(Operation) 칼럼추가
 *                                      - 잘못 구현되어 있거나 불필요한 Program 로직
 *                                        (VO, HTMLAction, mapping.xml, SQL) 제거 및 수정보완
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.networkcost.event;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.CoaMonVvdPortOpDysVO;

/**
 * ESM_COA_0039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_COA_0039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Ki Dae
 * @see ESM_COA_0039HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmCoa0039Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Multi Data 처리 - Create/Update/Delete */
	private CoaMonVvdPortOpDysVO[] mCoaMonVvdPortOpDysVOs = null;	

	/** 조회조건 처리 */
	private SearchConditionVO mSearchConditionVO = null;	


	/** Constructor */
	public EsmCoa0039Event(){}	
	
	/** return Name of Event*/
	public String getEventName(){
		return "EsmCoa0039Event";
	}

	
	/** ValueObject Array Setter - Create/Update/Delete */
	public void setCoaMonVvdPortOpDysVOs(CoaMonVvdPortOpDysVO[] coaMonVvdPortOpDysVOs){
		mCoaMonVvdPortOpDysVOs = coaMonVvdPortOpDysVOs;
	}
	/** ValueObject Array Getter - Create/Update/Delete */
	public CoaMonVvdPortOpDysVO[] getCoaMonVvdPortOpDysVOs(){
		return mCoaMonVvdPortOpDysVOs;
	}	

	/** ValueObject Setter */
	public void setSearchConditionVO(SearchConditionVO searchConditionVO){
		this.mSearchConditionVO = searchConditionVO;
	}
	/** ValueObject Getter */
	public SearchConditionVO getSearchConditionVO(){
		return mSearchConditionVO;
	}		

}
