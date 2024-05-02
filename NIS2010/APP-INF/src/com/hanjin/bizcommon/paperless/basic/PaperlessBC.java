/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PaperlessBC.java
*@FileTitle : Paperless
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.01
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2014.09.01 차상영
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.paperless.basic;

import java.util.List;

import com.hanjin.bizcommon.paperless.vo.SearchPaperlessListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * NIS2010-Bizcommon Business Logic Command Interface<br>
 * - NIS2010-Bizcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author cha sangyoung
 * @since J2EE 1.4
 */

public interface PaperlessBC {

	/**
	 * 조회 이벤트 처리<br>
	 *  Paperless화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param searchPaperlessListVO   SearchPaperlessListVO
	 * @return List<SearchPaperlessListVO>
	 * @exception EventException
	 */
	public List<SearchPaperlessListVO> searchPaperlessList(SearchPaperlessListVO searchPaperlessListVO) throws EventException;
}