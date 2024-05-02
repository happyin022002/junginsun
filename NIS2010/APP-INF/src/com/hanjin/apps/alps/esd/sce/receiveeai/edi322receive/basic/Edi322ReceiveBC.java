/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : Edi322ReceiveBC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-01
*@LastModifier :
*@LastVersion : 1.0
* 2009-11-01 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.vo.SearchEdi322ActDatRcvDtVO;
import com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.vo.SearchEdi322BkgNoVO;
import com.hanjin.apps.alps.esd.sce.receiveeai.edi322receive.vo.SearchEdi322CntrNoVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
/**
 * ENIS-SCEM EDI 322 Message
 * - ENIS-SCEM EDI 322 Message에 대한 비지니스 로직에 대한 인터페이스
 *
 * @author 
 * @see 
 * @since J2EE 1.4
 */
public interface Edi322ReceiveBC{
	
	/** 
	 * 322 MSG를 FF에서 분리
	 * 
	 * @param String inv
	 * @return ArrayList<HashMap<String, String>>
	 * @exception EventException
	 */
	public ArrayList<HashMap<String, String>> getEDI322DataFormat(String inv)throws EventException;
	
	/**
	 * 322 MSG 임시 데이터를 생성한다
	 * 
	 * @param ArrayList totalParamArrLst
	 * @exception EventException
	 */
	public void createEDI322TmpData(ArrayList totalParamArrLst)throws EventException;
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchEdi322CntrNoVO searchEdi322CntrNoVO
	 * @return List<SearchEdi322CntrNoVO>
	 * @exception DAOException
	 */
	public List<SearchEdi322CntrNoVO> searchEdi322CntrNoVO(SearchEdi322CntrNoVO searchEdi322CntrNoVO) throws EventException;

	/**
	 * INSERT INTO EDI322MSG 
	 * @param Map param
	 * @exception EventException
	 */	
	public void createEDI322TmpData(Map param) throws EventException;	
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchEdi322BkgNoVO searchEdi322BkgNoVO
	 * @return List<SearchEdi322BkgNoVO>
	 * @exception DAOException
	 */
	public List<SearchEdi322BkgNoVO> searchEdi322BkgNo(SearchEdi322BkgNoVO searchEdi322BkgNoVO) throws EventException;	
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchEdi322ActDatRcvDtVO searchEdi322ActDatRcvDtVO
	 * @return List<SearchEdi322ActDatRcvDtVO>
	 * @exception EventException
	 */
	public List<SearchEdi322ActDatRcvDtVO> searchEdi322ActDatRcvDt(SearchEdi322ActDatRcvDtVO searchEdi322ActDatRcvDtVO) throws EventException;
	
	/**
	 * create EDI322Msg If
	 * 
	 * @param Map param
	 * @exception EventException
	 */
	public void createEDI322MsgIf(Map param) throws EventException;	
}