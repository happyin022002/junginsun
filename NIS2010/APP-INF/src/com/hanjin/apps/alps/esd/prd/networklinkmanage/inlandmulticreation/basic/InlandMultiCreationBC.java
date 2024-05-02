/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : InlandRouteManageBC.java
 *@FileTitle : Inland Route 정보관리화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-02-10
 *@LastModifier : noh seung bae
 *@LastVersion : 1.0
 * 2010-02-10 noh seung bae
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandmulticreation.basic;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandmulticreation.vo.SearchInlandRouteVO;
import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * alps-PRD Business Logic Command Interface<br>
 * - alps-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author noh seung bae
 * @see SearchInlandRouteVO
 * @since J2EE 1.5
 */
public interface InlandMultiCreationBC{

	/**
	 *
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List searchInlandMultiList(SearchInlandRouteVO vo) throws EventException;

	/**
	 *
	 * @param vo
	 * @return
	 * @throws EventException
	 * @throws DAOException
	 */
	public String multiInlandMulti(SearchInlandRouteVO vo) throws EventException, DAOException;
}
