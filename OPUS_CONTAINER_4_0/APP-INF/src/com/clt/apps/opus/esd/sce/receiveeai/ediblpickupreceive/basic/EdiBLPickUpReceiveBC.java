/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EdiBLPickUpReceiveBC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014-11-04
*@LastModifier :
*@LastVersion : 1.0
* 2009-11-01 
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.receiveeai.ediblpickupreceive.vo.SearchEdiBLPickUpCntrNoVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
/**
 * SCEM EDI BLPickUp Message
 * - SCEM EDI BLPickUp Message에 대한 비지니스 로직에 대한 인터페이스
 *
 * @author 
 * @see 
 * @since J2EE 1.4
 */
public interface EdiBLPickUpReceiveBC{
	
	/** 
	 * BLPickUp MSG를 FF에서 분리
	 * 
	 * @param String inv
	 * @return ArrayList<HashMap<String, String>>
	 * @exception EventException
	 */
	public ArrayList<HashMap<String, String>> getEDIBLPickUpDataFormat(String inv)throws EventException;
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchEdiBLPickUpCntrNoVO searchEdiBLPickUpCntrNoVO
	 * @return List<SearchEdiBLPickUpCntrNoVO>
	 * @exception DAOException
	 */
	public List<SearchEdiBLPickUpCntrNoVO> searchEdiBLPickUpCntrNoVO(SearchEdiBLPickUpCntrNoVO searchEdiBLPickUpCntrNoVO) throws EventException;

	/**
	 * INSERT INTO EDIBLPickUpMSG 
	 * @param Map<String, String> param
	 * @exception EventException
	 */	
	public void createEDIBLPickUpTmpData(Map<String, String> param) throws EventException;	

	/**
	 * create EDIBLPickUpMsg If
	 * 
	 * @param Map<String, String> param
	 * @exception EventException
	 */
	public void createEDIBLPickUpMsgIf(Map<String, String> param) throws EventException;	
}