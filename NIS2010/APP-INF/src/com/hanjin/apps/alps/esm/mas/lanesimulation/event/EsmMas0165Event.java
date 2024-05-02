/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : ESM_MAS_165Event.java
*@FileTitle      : 
*Open Issues     :
*Change history  :
*@LastModifyDate : 2007-12-18
*@LastModifier   : eunju park
*@LastVersion    : 1.0
* 2007-11-12 eunju4 park
* 1.0 최초 생성
* 2009.03.31 박은주,임옥영,박상희 S2K-09U-002(Lane Simulation System 개선)
* 2010.02.18 serialVersionUID 선언
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.event;

import com.hanjin.apps.alps.esm.mas.common.event.MASEvent;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchFileMgmtListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;


/**
 *  1. 기능 : ESM_MAS_0165 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 *  2. 처리개요 : <p>
 *    - ESM_MAS_0165HTMLAction에서 작성 <p>
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
public class EsmMas0165Event extends MASEvent {
	private static final long serialVersionUID = 1L;
	private SearchFileMgmtListVO searchFileMgmtListVO =null;
	private SearchFileMgmtListVO[] searchFileMgmtListVOS =null;
	public SearchFileMgmtListVO[] getSearchFileMgmtListVOS() {
		return searchFileMgmtListVOS;
	}

	public void setSearchFileMgmtListVOS(
			SearchFileMgmtListVO[] searchFileMgmtListVOS) {
		this.searchFileMgmtListVOS = searchFileMgmtListVOS;
	}

	public SearchFileMgmtListVO getSearchFileMgmtListVO() {
		return searchFileMgmtListVO;
	}

	public void setSearchFileMgmtListVO(SearchFileMgmtListVO searchFileMgmtListVO) {
		
		this.searchFileMgmtListVO = searchFileMgmtListVO;
	}

		/**
	     * EsmMas0165Event 생성자함수
	     */
	    public EsmMas0165Event(){
	    	//
	    }
	    
		/**
		 * Event 명을 반환한다.
		 */
		public String getEventName() {
	        return "EsmMas0165Event";
	    }

		/**
		 * Event 명을 반환한다.
		 */
	    public String toString() {
	        return "EsmMas0165Event";
	    }

}
