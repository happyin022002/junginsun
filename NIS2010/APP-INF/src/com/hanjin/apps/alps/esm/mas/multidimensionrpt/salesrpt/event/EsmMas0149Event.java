/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmMas0149Event.java
*@FileTitle : Cost Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.11
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.11 송호진
* 1.0 Creation
===========================================================
 ' History :
 ' 2008.08.29 박상희 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 디렉토리 변경
 ' 2009.09.15 송호진 ALPS F/W 적용   
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.vo.RouteDetail0147VO;


/**
 * ESM_MAS_0149 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_MAS_0149HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Song Ho Jin
 * @see ESM_MAS_0149HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmMas0149Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RouteDetail0147VO routeDetail0147VO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RouteDetail0147VO[] routeDetail0147VOs = null;

	private SearchConditionVO searchConditionVO = null;

	public EsmMas0149Event(){}
	
	public void setRouteDetail0147VO(RouteDetail0147VO routeDetail0147VO){
		this. routeDetail0147VO = routeDetail0147VO;
	}

	public void setRouteDetail0147VOS(RouteDetail0147VO[] routeDetail0147VOs){
		this. routeDetail0147VOs = routeDetail0147VOs;
	}

	public RouteDetail0147VO getRouteDetail0147VO(){
		return routeDetail0147VO;
	}

	public RouteDetail0147VO[] getRouteDetail0147VOS(){
		return routeDetail0147VOs;
	}

	public SearchConditionVO getSearchConditionVO() {
		return searchConditionVO;
	}

	public void setSearchConditionVO(SearchConditionVO searchConditionVO) {
		this.searchConditionVO = searchConditionVO;
	}

}