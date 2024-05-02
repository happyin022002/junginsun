/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LocationBC.java
*@FileTitle : Location Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.04.28 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.location.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltCntListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltGrpLocDtlListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltGrpLocListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltLocListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltRgnListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltSteListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * NIS2010-Primasterdata Business Logic Command Interface<br>
 * - NIS2010-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI SUNG MIN
 * @see Esm_pri_4026EventResponse 참조
 * @since J2EE 1.4
 */

public interface LocationBC {
	/**
	 * COUNTRY CODE를 조회한다.<br>
	 * 
	 * @param RsltCntListVO rsltCntListVO
	 * @return List<RsltCntListVO>
	 * @exception EventException
	 */
	public List<RsltCntListVO> searchCountryList(RsltCntListVO rsltCntListVO) throws EventException;
	/**
	 * LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltLocListVO rsltLocListVO
	 * @return List<RsltLocListVO>
	 * @exception EventException
	 */
	public List<RsltLocListVO> searchLocationList(RsltLocListVO rsltLocListVO) throws EventException;

	/**
	 * STATE CODE를 조회한다.<br>
	 * 
	 * @param RsltSteListVO rsltSteListVO
	 * @return List<RsltSteListVO>
	 * @exception EventException
	 */
	public List<RsltSteListVO> searchStateList(RsltSteListVO rsltSteListVO) throws EventException;
	
	/**
	 * SERVICE SCOPE GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchSpScpGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException;
	/**
	 * S/C GUIDELINE GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchSgGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException;
	/**
	 * RFA GUIDELINE GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchRgGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException;
	/**
	 * RFA PROPOSAL GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchRpScpGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException;
	/**
	 * SURCHARGE GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchScgGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException;
	
	
	/**
	 * REGION CODE를 조회한다.<br>
	 * 
	 * @param RsltRgnListVO rsltRgnListVO
	 * @return List<RsltRgnListVO>
	 * @exception EventException
	 */
	public List<RsltRgnListVO> searchRegionList(RsltRgnListVO rsltRgnListVO) throws EventException;
	
	/**
	 * COUNTRY CODE를 COMBO로 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCobCntListVO
	 * @return List<RsltCdListVO>
	 * @throws EventException 
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchComboCountryList(RsltCdListVO rsltCobCntListVO) throws EventException;
		
	/**
	 * RFA GUIDELINE GROUP LOCATION CODE DETAIL 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchRgGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException;
	/**
	 * S/C GUIDELINE GROUP LOCATION CODE DETAIL 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchSgGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException;
	/**
	 * SURCHARGE GROUP LOCATION CODE DETAIL 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchScgGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException;
	/**
	 * RFA PROPOSAL GROUP LOCATION CODE DETAIL 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchRpScpGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException;
	/**
	 * S/C PROPOSAL GROUP LOCATION CODE DETAIL 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchSpScpGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException;
	/**
	 * CMPB GROUP LOCATION CODE 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO  
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchCMPBGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException;
	/**
	 * CMPB GROUP LOCATION CODE DETAIL 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */	
	public List<RsltGrpLocDtlListVO> searchCMPBGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException;
	
	/**
	 * SQ GROUP LOCATION CODE 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO  
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchSQGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException;
	/**
	 * SQ GROUP LOCATION CODE DETAIL 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */	
	public List<RsltGrpLocDtlListVO> searchSQGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException;
	
	/**
	 * RQ GROUP LOCATION CODE 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO  
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchRQGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException;
	/**
	 * RQ GROUP LOCATION CODE DETAIL 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO  
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */	
	public List<RsltGrpLocDtlListVO> searchRQGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException;

}