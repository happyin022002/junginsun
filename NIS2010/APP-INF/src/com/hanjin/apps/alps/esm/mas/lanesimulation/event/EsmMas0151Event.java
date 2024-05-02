/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : ESM_MAS_151Event.java
*@FileTitle      : 항로 Simulation 의 Consumption Matrix by Class 정보 입력PopUp
*Open Issues     : Step5의 Bunker Cost 에서 콜
*Change history  :
*@LastModifyDate : 2008.02.14
*@LastModifier   : eunju park
*@LastVersion    : 1.0
* 2008.02.14 eunju park
* 1.0 최초 생성
* 2009.03.31 박은주 S2K-09U-002(Lane Simulation System 개선)
* 2010.02.18 serialVersionUID 선언
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.event;

import com.hanjin.apps.alps.esm.mas.common.event.MASEvent;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.syscommon.common.table.MasBnkCsmVO;


/**
 *  1. 기능 : ESM_MAS_0151 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 *  2. 처리개요 : <p>
 *    - ESM_MAS_0151HTMLAction에서 작성 <p>
 *    - ServiceCommand Layer로 전달하는 PDTO로 사용 <p>
 * 3. 주의사항 : <p>
 * ===================================<br>
 * 4. 작성자/작성일 : Park Eun Ju/2006.08.28<br>
 * ===================================<br>
 * 5. 수정사항<p>
 * 5.1 요구사항 ID :<p>
 * - 수정자/수정일 :<p>
 * - 수정사유/내역 :<p>
 * ===================================<br>
 * <p/>
 *
 * @author Park Eun Ju
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmMas0151Event extends MASEvent {
		private static final long serialVersionUID = 1L;
		private MasBnkCsmVO masBnkCsmVO = null;
		private MasBnkCsmVO[] masBnkCsmVOS = null;
		private SearchSimLaneListConditionVO searchSimLaneListConditionVO = null;

		public SearchSimLaneListConditionVO getSearchSimLaneListConditionVO() {
			return searchSimLaneListConditionVO;
		}

		public void setSearchSimLaneListConditionVO(
				SearchSimLaneListConditionVO searchSimLaneListConditionVO) {
			this.searchSimLaneListConditionVO = searchSimLaneListConditionVO;
		}
		
	    public MasBnkCsmVO[] getMasBnkCsmVOS() {
			return masBnkCsmVOS;
		}

		public void setMasBnkCsmVOS(MasBnkCsmVO[] masBnkCsmVOS) {
			this.masBnkCsmVOS = masBnkCsmVOS;
		}

		public MasBnkCsmVO getMasBnkCsmVO() {
			return masBnkCsmVO;
		}

		public void setMasBnkCsmVO(MasBnkCsmVO masBnkCsmVO) {
			this.masBnkCsmVO = masBnkCsmVO;
		}

		/**
	     * EsmMas0151Event 생성자함수
	     */
	    public EsmMas0151Event(){
	    	//
	    }
	    
		/**
		 * Event 명을 반환한다.
		 */
		public String getEventName() {
	        return "EsmMas0151Event";
	    }

		/**
		 * Event 명을 반환한다.
		 */
	    public String toString() {
	        return "EsmMas0151Event";
	    }

}
