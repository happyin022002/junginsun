/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_051Event.java
*@FileTitle : 항로 Simulation 마스터 및 W/F 생성/조회/변경
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-25
*@LastModifier : eunju park
*@LastVersion : 1.0
* 2006-08-25 eunju park
* 1.0 최초 생성
* 2009.03.31 박상희 S2K-09U-002(Lane Simulation System 개선)
* 2010.02.18 serialVersionUID 선언
=========================================================*/
package com.clt.apps.opus.esm.coa.lanesimulation.event;

import com.clt.apps.opus.esm.coa.common.event.COAEvent;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.LaneInfoListConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchLaneInfoListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimLaneListConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimLaneListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimVesselListConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchSimVesselListVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchVesselInfoConditionVO;
import com.clt.apps.opus.esm.coa.lanesimulation.vo.SearchVesselInfoVO;
import com.clt.framework.core.controller.html.HTMLAction;
import java.util.Arrays;									//SJH.20150507.소스품질

/**
 *  1. 기능 : ESM_COA_051 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 *  2. 처리개요 : <p>
 *    - ESM_COA_051HTMLAction에서 작성 <p>
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
public class EsmCoa0051Event extends COAEvent {
	private static final long serialVersionUID = 1L;
		private SearchLaneInfoListVO searchLaneInfoListVO =null;
		private LaneInfoListConditionVO laneInfoListConditionVO = null;
		private SearchSimLaneListVO searchSimLaneListVO = null;
		private SearchSimLaneListVO[] searchSimLaneListVOS = null;
		private SearchSimLaneListConditionVO searchSimLaneListConditionVO = null;
		private SearchSimLaneListConditionVO[] searchSimLaneListConditionVOS = null;
		private SearchVesselInfoVO searchVesselInfoVO = null;
		private SearchVesselInfoConditionVO searchVesselInfoConditionVO = null;

		public SearchVesselInfoConditionVO getSearchVesselInfoConditionVO() {
			return searchVesselInfoConditionVO;
		}

		public void setSearchVesselInfoConditionVO(
				SearchVesselInfoConditionVO searchVesselInfoConditionVO) {
			this.searchVesselInfoConditionVO = searchVesselInfoConditionVO;
		}

		public SearchVesselInfoVO getSearchVesselInfoVO() {
			return searchVesselInfoVO;
		}

		public void setSearchVesselInfoVO(SearchVesselInfoVO searchVesselInfoVO) {
			this.searchVesselInfoVO = searchVesselInfoVO;
		}
		
		//SJH.20150507.소스품질
		public SearchSimLaneListConditionVO[] getSearchSimLaneListConditionVOS() {
			SearchSimLaneListConditionVO[] rtnVOs = null;
			if (this.searchSimLaneListConditionVOS != null) {
				rtnVOs = Arrays.copyOf(searchSimLaneListConditionVOS, searchSimLaneListConditionVOS.length);
			}
			return rtnVOs;
		}
		//SJH.20150507.소스품질
		public void setSearchSimLaneListConditionVOS(SearchSimLaneListConditionVO[] searchSimLaneListConditionVOS){
			if(searchSimLaneListConditionVOS != null){
				SearchSimLaneListConditionVO[] tmpVOs = Arrays.copyOf(searchSimLaneListConditionVOS, searchSimLaneListConditionVOS.length);
				this.searchSimLaneListConditionVOS = tmpVOs;
			}
		}

		private SearchSimVesselListVO searchSimVesselListVO = null;
		private SearchSimVesselListVO[] searchSimVesselListVOS = null;				
		private SearchSimVesselListConditionVO searchSimVesselListConditionVO = null;

		//SJH.20150507.소스품질
		public SearchSimLaneListVO[] getSearchSimLaneListVOS() {
			SearchSimLaneListVO[] rtnVOs = null;
			if (this.searchSimLaneListVOS != null) {
				rtnVOs = Arrays.copyOf(searchSimLaneListVOS, searchSimLaneListVOS.length);
			}
			return rtnVOs;
		}
		//SJH.20150507.소스품질
		public void setSearchSimLaneListVOS(SearchSimLaneListVO[] searchSimLaneListVOS){
			if(searchSimLaneListVOS != null){
				SearchSimLaneListVO[] tmpVOs = Arrays.copyOf(searchSimLaneListVOS, searchSimLaneListVOS.length);
				this.searchSimLaneListVOS = tmpVOs;
			}
		}
		//SJH.20150507.소스품질
		public SearchSimVesselListVO[] getSearchSimVesselListVOS() {
			SearchSimVesselListVO[] rtnVOs = null;
			if (this.searchSimVesselListVOS != null) {
				rtnVOs = Arrays.copyOf(searchSimVesselListVOS, searchSimVesselListVOS.length);
			}
			return rtnVOs;
		}
		//SJH.20150507.소스품질
		public void setSearchSimVesselListVOS(SearchSimVesselListVO[] searchSimVesselListVOS){
			if(searchSimVesselListVOS != null){
				SearchSimVesselListVO[] tmpVOs = Arrays.copyOf(searchSimVesselListVOS, searchSimVesselListVOS.length);
				this.searchSimVesselListVOS = tmpVOs;
			}
		}
		
		public SearchSimVesselListVO getSearchSimVesselListVO() {
			return searchSimVesselListVO;
		}

		public void setSearchSimVesselListVO(SearchSimVesselListVO searchSimVesselListVO) {
			this.searchSimVesselListVO = searchSimVesselListVO;
		}

		public SearchSimVesselListConditionVO getSearchSimVesselListConditionVO() {
			return searchSimVesselListConditionVO;
		}

		public void setSearchSimVesselListConditionVO(
				SearchSimVesselListConditionVO searchSimVesselListConditionVO) {
			this.searchSimVesselListConditionVO = searchSimVesselListConditionVO;
		}

		public SearchSimLaneListVO getSearchSimLaneListVO() {
			return searchSimLaneListVO;
		}

		public void setSearchSimLaneListVO(SearchSimLaneListVO searchSimLaneListVO) {
			this.searchSimLaneListVO = searchSimLaneListVO;
		}

	    public SearchSimLaneListConditionVO getSearchSimLaneListConditionVO() {
			return searchSimLaneListConditionVO;
		}

		public void setSearchSimLaneListConditionVO(
				SearchSimLaneListConditionVO searchSimLaneListConditionVO) {
			this.searchSimLaneListConditionVO = searchSimLaneListConditionVO;
		}

		public LaneInfoListConditionVO getLaneInfoListConditionVO() {
			return laneInfoListConditionVO;
		}

		public void setLaneInfoListConditionVO(
				LaneInfoListConditionVO laneInfoListConditionVO) {
			this.laneInfoListConditionVO = laneInfoListConditionVO;
		}

		public SearchLaneInfoListVO getSearchLaneInfoListVO() {
			return searchLaneInfoListVO;
		}

		public void setSearchLaneInfoListVO(SearchLaneInfoListVO searchLaneInfoListVO) {
			this.searchLaneInfoListVO = searchLaneInfoListVO;
		}

		/**
	     * EsmCoa0051Event 생성자함수
	     */
	    public EsmCoa0051Event(){
	    	//
	    }
	    
		/**
		 * Event 명을 반환한다.
		 */
		public String getEventName() {
	        return "EsmCoa0051Event";
	    }

		/**
		 * Event 명을 반환한다.
		 */
	    public String toString() {
	        return "EsmCoa0051Event";
	    }
}
