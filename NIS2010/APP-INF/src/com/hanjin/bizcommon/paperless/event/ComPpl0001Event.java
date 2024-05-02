/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COM_PPL_0001Event.java
*@FileTitle : Paperless
*Open Issues :
*Change history :
*@LastModifyDate : 2014-09-01
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014-09-01 차상영
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.paperless.event;

import com.hanjin.bizcommon.paperless.vo.SearchPaperlessListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * COM_PPL_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_PPL_0001_HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author cha sangyoung
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */public class ComPpl0001Event extends EventSupport {
		/** Table Value Object 조회 조건 및 단건 처리  */
		private SearchPaperlessListVO searchPaperlessListVO = null;
		
		/** Table Value Object Multi Data 처리 */
		private SearchPaperlessListVO[] searchPaperlessListVOs = null;

		public ComPpl0001Event(){}

		public SearchPaperlessListVO getSearchPaperlessListVO() {
			return searchPaperlessListVO;
		}

		public void setSearchPaperlessListVO(SearchPaperlessListVO searchPaperlessListVO) {
			this.searchPaperlessListVO = searchPaperlessListVO;
		}

		public SearchPaperlessListVO[] getSearchPaperlessListVOs() {
			return searchPaperlessListVOs;
		}

		public void setSearchPaperlessListVOs(
				SearchPaperlessListVO[] searchPaperlessListVOs) {
			this.searchPaperlessListVOs = searchPaperlessListVOs;
		}


}
