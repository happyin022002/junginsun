/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : ESM_MAS_167Event.java
*@FileTitle      : 
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.02
*@LastModifier   : eunju park
*@LastVersion    : 1.0
* 2009.02 eunju park
* 1.0 최초 생성
* 2009.03.31 박은주 S2K-09U-002(Lane Simulation System 개선)
* 2010.02.18 serialVersionUID 선언
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.event;

import com.hanjin.apps.alps.esm.mas.common.event.MASEvent;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchTocHireListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.syscommon.common.table.MasTmChtrOutHirVO;


/**
 *  1. 기능 : ESM_MAS_0167 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 *  2. 처리개요 : <p>
 *    - ESM_MAS_0167HTMLAction에서 작성 <p>
 *    - ServiceCommand Layer로 전달하는 PDTO로 사용 <p>
 * 3. 주의사항 : <p>
 * ===================================<br>
 * 4. 작성자/작성일 : Yoon jin young/2009.08.28<br>
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
public class EsmMas0167Event extends MASEvent {
		private static final long serialVersionUID = 1L;
		private MasTmChtrOutHirVO tmChtrOutHirVo = null;
		private MasTmChtrOutHirVO[] tmChtrOutHirVos = null;
		private SearchTocHireListVO searchTocHireListVO = null;
		private SearchTocHireListVO[] searchTocHireListVOs = null;
		
	    public SearchTocHireListVO[] getSearchTocHireListVOs() {
			return searchTocHireListVOs;
		}

		public void setSearchTocHireListVOs(SearchTocHireListVO[] searchTocHireListVOs) {
			this.searchTocHireListVOs = searchTocHireListVOs;
		}

		public SearchTocHireListVO getSearchTocHireListVO() {
			return searchTocHireListVO;
		}

		public void setSearchTocHireListVO(SearchTocHireListVO searchTocHireListVO) {
			this.searchTocHireListVO = searchTocHireListVO;
		}

		public MasTmChtrOutHirVO[] getTmChtrOutHirVos() {
			return tmChtrOutHirVos;
		}

		public void setTmChtrOutHirVos(MasTmChtrOutHirVO[] tmChtrOutHirVos) {
			this.tmChtrOutHirVos = tmChtrOutHirVos;
		}

		public MasTmChtrOutHirVO getTmChtrOutHirVo() {
			return tmChtrOutHirVo;
		}

		public void setTmChtrOutHirVo(MasTmChtrOutHirVO tmChtrOutHirVo) {
			this.tmChtrOutHirVo = tmChtrOutHirVo;
		}

		/**
	     * ESM_MAS_167Event 생성자함수
	     */
	    public EsmMas0167Event(){
	    	//
	    }
	    
		/**
		 * Event 명을 반환한다.
		 */
		public String getEventName() {
	        return "EsmMas0167Event";
	    }

		/**
		 * Event 명을 반환한다.
		 */
	    public String toString() {
	        return "EsmMas0167Event";
	    }

}
