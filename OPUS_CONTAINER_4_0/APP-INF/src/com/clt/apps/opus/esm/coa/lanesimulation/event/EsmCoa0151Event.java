/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : ESM_COA_151Event.java
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
package com.clt.apps.opus.esm.coa.lanesimulation.event;

import com.clt.apps.opus.esm.coa.common.event.COAEvent;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.syscommon.common.table.CoaBnkCsmVO;
import java.util.Arrays;									//SJH.20150507.소스품질

/**
 *  1. 기능 : ESM_COA_0151 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 *  2. 처리개요 : <p>
 *    - ESM_COA_0151HTMLAction에서 작성 <p>
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
public class EsmCoa0151Event extends COAEvent {
		private static final long serialVersionUID = 1L;
		private CoaBnkCsmVO coaBnkCsmVO = null;
		private CoaBnkCsmVO[] coaBnkCsmVOS = null;
		private SearchSimLaneListConditionVO searchSimLaneListConditionVO = null;

		public SearchSimLaneListConditionVO getSearchSimLaneListConditionVO() {
			return searchSimLaneListConditionVO;
		}

		public void setSearchSimLaneListConditionVO(
				SearchSimLaneListConditionVO searchSimLaneListConditionVO) {
			this.searchSimLaneListConditionVO = searchSimLaneListConditionVO;
		}
		
		//SJH.20150507.소스품질
	    public CoaBnkCsmVO[] getCoaBnkCsmVOS() {
			CoaBnkCsmVO[] rtnVOs = null;
			if (this.coaBnkCsmVOS != null) {
				rtnVOs = Arrays.copyOf(coaBnkCsmVOS, coaBnkCsmVOS.length);
			}
			return rtnVOs;
		}
	  //SJH.20150507.소스품질
		public void setCoaBnkCsmVOS(CoaBnkCsmVO[] coaBnkCsmVOS){
			if(coaBnkCsmVOS != null){
				CoaBnkCsmVO[] tmpVOs = Arrays.copyOf(coaBnkCsmVOS, coaBnkCsmVOS.length);
				this.coaBnkCsmVOS = tmpVOs;
			}
		}

		public CoaBnkCsmVO getCoaBnkCsmVO() {
			return coaBnkCsmVO;
		}

		public void setCoaBnkCsmVO(CoaBnkCsmVO coaBnkCsmVO) {
			this.coaBnkCsmVO = coaBnkCsmVO;
		}

		/**
	     * EsmCoa0151Event 생성자함수
	     */
	    public EsmCoa0151Event(){
	    	//
	    }
	    
		/**
		 * Event 명을 반환한다.
		 */
		public String getEventName() {
	        return "EsmCoa0151Event";
	    }

		/**
		 * Event 명을 반환한다.
		 */
	    public String toString() {
	        return "EsmCoa0151Event";
	    }

}
