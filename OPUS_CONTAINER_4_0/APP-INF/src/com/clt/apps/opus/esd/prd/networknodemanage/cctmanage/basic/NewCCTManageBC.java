/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NewCCTManageBC.JAVA
 *@FileTitle : New CCT Management
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.event.EsdPrd0039Event;
import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.vo.NewCCTManageVO;
import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.vo.PrdCstSkdByPortVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PrdTmlVgmCctHisVO;

/**
 * PRD Business Logic Command Interface<br>
 * 
 * @author Jeongseon An
 * @see ESD_PRD_0036EventResponse
 * @since J2EE 1.4
 */
public interface NewCCTManageBC {

	/**
	 * retrieving - CCTmanage
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public DBRowSet searchCCTManage(NewCCTManageVO vo) throws EventException;

	/**
	 * multi event - ESD_PRD_036
	 * 
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiCCTManage(NewCCTManageVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieving Costal Schedule
	 * 
	 * @param prdCstSkdByPortVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet searchCstSkdByPort(PrdCstSkdByPortVO prdCstSkdByPortVO) throws EventException;

	/**
	 * multi event - ESD_PRD_0036
	 * 
	 * @param prdCstSkdByPortVOs
	 * @param account
	 * @throws EventException
	 */
	public void multiVslCgoClzDate(PrdCstSkdByPortVO[] prdCstSkdByPortVOs, SignOnUserAccount account) throws EventException;

	/**
	 * @param event
	 * @return
	 * @throws EventException
	 */
	public List<PrdTmlVgmCctHisVO> searchPrdTmlVgmCctHis(EsdPrd0039Event event) throws EventException;
}
