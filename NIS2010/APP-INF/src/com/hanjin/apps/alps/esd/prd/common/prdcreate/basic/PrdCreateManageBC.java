/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PrdCommonManageBC.java
*@FileTitle : PRD 공통관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-16
*@LastModifier : jungsunyoung
*@LastVersion : 1.0
* 2006-10-16 jungsunyoung
* 1.0 최초 생성
* history
* csr : N200903190040 20090320 mixed term , tro i/o TERM 일때 TERM CHANGE처리 
* 2010.09.27 채창호 [CHM-201006116] : Mixed Term Logic 변경 요청
* 2012.05.31 박만건 [CHM-201217633] 구주 Hinterland
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcreate.basic;

import com.hanjin.apps.alps.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * alps-PRD Business Logic Command Interface<br>
 * - alps-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author jungsunyoung
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface PrdCreateManageBC  {

	/**
	 * PrdCreateManageBC's createPrdCtlNoGen
	 * @param pctlNoTpCd
	 * @return
	 * @throws EventException
	 */
	public String createPrdCtlNoGen(String pctlNoTpCd)throws EventException;

	/**
	 * PrdCreateManageBC's createActivityGroup
	 * @param e
	 * @throws EventException
	 */
	public void createActivityGroup(Event e) throws EventException;

	/**
	 * PrdCreateManageBC's dataArrangement
	 * @param e
	 * @throws EventException void
	 */
	public void  dataArrangement(Event e) throws EventException;

	/**
	 * PrdCreateManageBC's updateActivityGroup
	 * @param hdPctlNo
	 * @throws EventException void
	 */
	public void updateActivityGroup(String hdPctlNo) throws EventException;

	/**
	 * PrdCreateManageBC's delByFullcyVal
	 * @param e
	 * @throws EventException void
	 */
	public void createContainerQty(Event e)throws EventException;

 	/**
	 * PrdCreateManageBC's checkMixedRterm
	 * @param bkgNo
	 * @param por
	 * @param rTerm
	 * @return
	 * @throws EventException String
	 */
	public String checkMixedRterm(String bkgNo ,String por, String rTerm) throws EventException;
 
	/**
	 * PrdCreateManageBC's checkMixedDterm
	 * @param bkgNo
	 * @param del
	 * @param dTerm
	 * @return
	 * @throws EventException String
	 */
	public String checkMixedDterm(String bkgNo, String  del,String dTerm) throws EventException;

	/**
	 * PrdCreateManageBC's getSkdType
	 * @param vvd
	 * @param ldDt
	 * @param pol1
	 * @return
	 * @throws EventException
	 */
	public String getSkdType(String vvd, String ldDt, String pol1) throws EventException;

	/**
	 * PrdCreateManageBC's setPrdCreateParam
	 * @param prdParameterVO
	 * @return
	 * @throws EventException
	 */
	public Event setPrdCreateParam(PrdParameterVO prdParameterVO) throws EventException;

	/**
	 * createActivityGroupIncludePattern
	 * @param prdPcCreateVo
	 * @param prdPatternVO
	 * @param usr_id
	 * @throws EventException
	 */
	public void createActivityGroupIncludePattern(PrdPcCreateVO prdPcCreateVo,
			PrdPatternVO prdPatternVO, String usr_id)throws EventException;
	
	/**
     * Auto IRG가 생성되어야 하는지 검사하고 필요시 생성함<br>
     * @author Park Mangeon
	 * @param String pctlNo Product Catalogue 번호
	 * @param String usrId 작업을 진행하는 사용자 ID
	 * @param String ofcCd 작업을 진행하는 사용자 Office
	 * @throws EventException
	 */
	public void manageAutoIRG(String pctlNo, String usrId, String ofcCd) throws EventException;
	
	/**
	 * PrdCreateManageBC's checkMixedTermYard
	 * @param term
	 * @param node
	 * @return
	 * @throws EventException String
	 */
	public String checkMixedTermYard(String term, String node) throws EventException;
	
	/**
	 * PrdCreateManageBC's selectPcNoMinMax
	 * @param String hdPctlNo
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet selectPcNoMinMax(String hdPctlNo) throws EventException;
}
