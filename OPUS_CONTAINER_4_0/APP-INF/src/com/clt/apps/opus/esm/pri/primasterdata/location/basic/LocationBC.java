/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LocationBC.java
*@FileTitle : Location Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.location.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltCntListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltGrpLocDtlListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltGrpLocListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltLocListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltRgnListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltSteListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Primasterdata Business Logic Command Interface<br>
 * - Handling a biz logic about Primasterdata<br>
 *
 * @author 
 * @see Esm_pri_4026EventResponse 
 * @since J2EE 1.4
 */

public interface LocationBC {
	/**
	 * Retrieving COUNTRY CODE.<br>
	 * 
	 * @param RsltCntListVO rsltCntListVO
	 * @return List<RsltCntListVO>
	 * @exception EventException
	 */
	public List<RsltCntListVO> searchCountryList(RsltCntListVO rsltCntListVO) throws EventException;
	/**
	 * Retrieving LOCATION CODE.<br>
	 * 
	 * @param RsltLocListVO rsltLocListVO
	 * @return List<RsltLocListVO>
	 * @exception EventException
	 */
	public List<RsltLocListVO> searchLocationList(RsltLocListVO rsltLocListVO) throws EventException;

	/**
	 * SRetrieving TATE CODE.<br>
	 * 
	 * @param RsltSteListVO rsltSteListVO
	 * @return List<RsltSteListVO>
	 * @exception EventException
	 */
	public List<RsltSteListVO> searchStateList(RsltSteListVO rsltSteListVO) throws EventException;
	
	/**
	 * Retrieving SERVICE SCOPE GROUP LOCATION CODE.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchSpScpGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException;
	/**
	 * Retrieving S/C GUIDELINE GROUP LOCATION CODE.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchSgGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException;
	/**
	 * Retrieving RFA GUIDELINE GROUP LOCATION CODE.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchRgGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException;
	/**
	 * Retrieving RFA PROPOSAL GROUP LOCATION CODE.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchRpScpGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException;
	/**
	 * Retrieving SURCHARGE GROUP LOCATION CODE.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchScgGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException;
	
	
	/**
	 * Retrieving REGION CODE.<br>
	 * 
	 * @param RsltRgnListVO rsltRgnListVO
	 * @return List<RsltRgnListVO>
	 * @exception EventException
	 */
	public List<RsltRgnListVO> searchRegionList(RsltRgnListVO rsltRgnListVO) throws EventException;
	
	/**
	 * Retrieving COUNTRY CODE to COMBO.<br>
	 * 
	 * @param RsltCdListVO rsltCobCntListVO
	 * @return List<RsltCdListVO>
	 * @throws EventException 
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchComboCountryList(RsltCdListVO rsltCobCntListVO) throws EventException;
		
	/**
	 * Retrieving RFA GUIDELINE GROUP LOCATION CODE DETAIL information.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchRgGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException;
	/**
	 * Retrieving S/C GUIDELINE GROUP LOCATION CODE DETAIL information.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchSgGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException;
	/**
	 * Retrieving SURCHARGE GROUP LOCATION CODE DETAIL information.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchScgGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException;
	/**
	 * Retrieving RFA PROPOSAL GROUP LOCATION CODE DETAIL information.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchRpScpGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException;
	/**
	 * Retrieving S/C PROPOSAL GROUP LOCATION CODE DETAIL information.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchSpScpGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException;


 
  
}