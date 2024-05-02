/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffCodeBC.java
*@FileTitle : Tariff Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.14
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.10.14 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.PriRcvDeTermMapgVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltPercentBaseChargeGroupingVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltPercentBaseChargeVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltServiceScopePropertyMappingVO;
import com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo.RsltServiceScopePropertyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriScgPctBseChgVO;
import com.clt.syscommon.common.table.PriScgPctBseVO;
import com.clt.syscommon.common.table.PriSvcScpPptMapgVO;
import com.clt.syscommon.common.table.PriSvcScpPptVO;

/**
 * PRICommonData Business Logic Command Interface<br>
 * - Handling a biz logic about PRICommonData<br>
 *
 * @author SHKIM
 * @see EsmPri5001EventResponse
 * @since J2EE 1.6
 */
public interface PRICommonDataBC { 
	
	/**
	 * ESM_PRI_5004 : Retrieve <br>
	 * 조회
	 * 
	 * @param PriSvcScpPptVO priSvcScpPptVO
	 * @return List<RsltServiceScopePropertyVO>
	 * @exception EventException
	 */
	public List<RsltServiceScopePropertyVO> searchServiceScopeProperty(PriSvcScpPptVO priSvcScpPptVO) throws EventException;
	

	/**
	 * ESM_PRI_5004 : SAVE <br>
	 * Tariff Scope duplicate check
	 * 
	 * @param PriSvcScpPptVO[] priSvcScpPptVOs
	 * @param SignOnUserAccount account
	 * @return List<RsltServiceScopePropertyVO>
	 * @exception EventException
	 */
	public List<RsltServiceScopePropertyVO> manageServiceScopeProperty(PriSvcScpPptVO[] priSvcScpPptVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_PRI_5005 : Retrieve <br>
	 * 조회
	 * 
	 * @param PriSvcScpPptMapgVO priSvcScpPptMapgVO
	 * @return List<RsltServiceScopePropertyMappingVO>
	 * @exception EventException
	 */
	public List<RsltServiceScopePropertyMappingVO> searchServiceScopePropertyMapping(PriSvcScpPptMapgVO priSvcScpPptMapgVO) throws EventException;
	

	/**
	 * ESM_PRI_5005 : SAVE <br>
	 * Tariff Scope duplicate check
	 * 
	 * @param PriSvcScpPptMapgVO[] priSvcScpPptMapgVOs
	 * @param SignOnUserAccount account
	 * @return List<RsltServiceScopePropertyMappingVO>
	 * @exception EventException
	 */
	public List<RsltServiceScopePropertyMappingVO> manageServiceScopePropertyMapping(PriSvcScpPptMapgVO[] priSvcScpPptMapgVOs, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_PRI_5002 : Retrieve <br>
	 * 
	 * @return List<RsltPercentBaseChargeVO>
	 * @exception EventException
	 */
	public List<RsltPercentBaseChargeVO> searchPercentBaseCharge() throws EventException;
	
	/**
	 * ESM_PRI_5002 : sheet1 on select cell <br>
	 * 
	 * @param PriScgPctBseVO priScgPctBseVO
	 * @return List<RsltPercentBaseChargeGroupingVO>
	 * @exception EventException
	 */
	public List<RsltPercentBaseChargeGroupingVO> searchPercentBaseChargeGrouping(PriScgPctBseVO priScgPctBseVO) throws EventException;

	
	/**
	 * ESM_PRI_5002 : sheet1 SAVE <br>
	 * 
	 * @param PriScgPctBseVO[] priScgPctBseVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void managePercentBaseCharge(PriScgPctBseVO[] priScgPctBseVOs , SignOnUserAccount account) throws EventException;
	
	
	/**
	 * ESM_PRI_5002 : sheet2 SAVE <br>
	 * 
	 * @param PriScgPctBseChgVO[] priScgPctBseChgVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void managePercentBaseChargeGrouping(PriScgPctBseChgVO[] priScgPctBseChgVOs , SignOnUserAccount account) throws EventException;

	/**
	 * ESM_PRI_5001
	 * BKG Term Mapping Creation retrieve<br>
	 * 
	 * @return List<PriRcvDeTermMapgVO>
	 * @exception EventException
	 */
	public List<PriRcvDeTermMapgVO> searchBookingTermMappingList() throws EventException;
	
	
	/**
	 * ESM_PRI_5001
	 * BKG Term Mapping Creation add/remove<br>
	 * 
	 * @param  PriRcvDeTermMapgVO[] priRcvDeTermMapgVOs
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBookingTermMapping(PriRcvDeTermMapgVO[] priRcvDeTermMapgVOs, SignOnUserAccount account) throws EventException;

}