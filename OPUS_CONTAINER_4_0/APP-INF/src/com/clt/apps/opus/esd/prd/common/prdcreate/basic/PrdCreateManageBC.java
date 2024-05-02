/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PrdCommonManageBC.java
 *@FileTitle : PRD Common Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcreate.basic;

import com.clt.apps.opus.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.syscommon.common.table.PrdBkgCopMapVO;

/**
 * PRD Business Logic Command Interface<br>
 * 
 * @author jungsunyoung
 * @see EventResponse
 * @since J2EE 1.4
 */
public interface PrdCreateManageBC {

	/**
	 * PrdCreateManageBC's createPrdCtlNoGen
	 * 
	 * @param pctlNoTpCd
	 * @return
	 * @throws EventException
	 */
	public String createPrdCtlNoGen(String pctlNoTpCd) throws EventException;

	/**
	 * PrdCreateManageBC's createActivityGroup
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void createActivityGroup(Event e) throws EventException;

	/**
	 * PrdCreateManageBC's dataArrangement
	 * 
	 * @param e
	 * @throws EventException void
	 */
	public void dataArrangement(Event e) throws EventException;

	/**
	 * PrdCreateManageBC's updateActivityGroup
	 * 
	 * @param hdPctlNo
	 * @throws EventException void
	 */
	public void updateActivityGroup(String hdPctlNo) throws EventException;

	/**
	 * PrdCreateManageBC's delByFullcyVal
	 * 
	 * @param e
	 * @throws EventException void
	 */
	public void createContainerQty(Event e) throws EventException;

	/**
	 * PrdCreateManageBC's checkMixedRterm
	 * 
	 * @param bkgNo
	 * @param por
	 * @param rTerm
	 * @return
	 * @throws EventException String
	 */
	public String checkMixedRterm(String bkgNo, String por, String rTerm) throws EventException;

	/**
	 * PrdCreateManageBC's checkMixedDterm
	 * 
	 * @param bkgNo
	 * @param del
	 * @param dTerm
	 * @return
	 * @throws EventException String
	 */
	public String checkMixedDterm(String bkgNo, String del, String dTerm) throws EventException;

	/**
	 * PrdCreateManageBC's getSkdType
	 * 
	 * @param vvd
	 * @param ldDt
	 * @param pol1
	 * @return
	 * @throws EventException
	 */
	public String getSkdType(String vvd, String ldDt, String pol1) throws EventException;

	/**
	 * PrdCreateManageBC's setPrdCreateParam
	 * 
	 * @param prdParameterVO
	 * @return
	 * @throws EventException
	 */
	public Event setPrdCreateParam(PrdParameterVO prdParameterVO) throws EventException;

	/**
	 * createActivityGroupIncludePattern
	 * 
	 * @param prdPcCreateVo
	 * @param prdPatternVO
	 * @param usr_id
	 * @throws EventException
	 */
	public void createActivityGroupIncludePattern(PrdPcCreateVO prdPcCreateVo, PrdPatternVO prdPatternVO, String usr_id) throws EventException;

	/**
	 * PrdCreateManageBC's checkMixedTermYard
	 * 
	 * @param term
	 * @param node
	 * @return
	 * @throws EventException String
	 */
	public String checkMixedTermYard(String term, String node) throws EventException;

	/**
	 * PrdCreateManageBCImpl.java's updateActivityGroupIncludePattern
	 * 
	 * @param prdBkgCopMapVO
	 * @param hdPctlNo
	 * @param mapSeq
	 * @param usr_id
	 * @throws EventException
	 */
	public void updateActivityGroupIncludePattern(PrdBkgCopMapVO prdBkgCopMapVO, String hdPctlNo, String[] mapSeq, String usr_id) throws EventException;

	/**
	 * 
	 * @param hdPctlNo
	 * @param bkgNo
	 * @param copNo
	 * @param usr_id
	 * @throws EventException
	 */
	public void updateActivityGroupIncludePatternSceReplan(String hdPctlNo, String bkgNo, String copNo, String usr_id) throws EventException;

}
