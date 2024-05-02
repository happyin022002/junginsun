/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Edi324SendBC.java
*@FileTitle :Edi324SendBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.13
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2012.02.13 채창호 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi324send.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.edi324send.Edi324SendSC;
import com.hanjin.apps.alps.esd.sce.edi324send.vo.Edi324SendVO;
import com.hanjin.apps.alps.esd.sce.edi324send.vo.SearchEdi324SendVO;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * ENIS-SCE Business Logic ServiceCommand<br>
 * - ENIS-SCE에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author YJLEE
 * @see Edi324SendSC 참조
 * @since J2EE 1.4
 */
public interface Edi324SendBC {
    /*The Definition of the carriage return*/
	public final String CHR10 = "\n";	
	public final String SUCCESS = "Y";
	public final String FAIL    = "N";
	/**
	 * edi324Send
	 * 발송 대상의 정보에 대한 빠진부분을 정보를 채우고 flat file 생성 및 MQ로직 호출 Method.
	 * 
     * @param  List<Edi324SendVO> list1
	 * @throws EventException
	 */	        
     
    public void edi324Send(List<Edi324SendVO> list1) throws EventException;
	/**
	 * sendEDIMQ
	 * 생성된 Falt File을 OutBound MQ로 발송 하는 Method.
     * @param  String ediString
	 * @throws EventException
	 */
    public void sendEDIMQ(String ediString)throws EventException;

	/**
	 * edi324Send
	 * ESD_SCE_0056화면에서 선택된 정보에 대한 조건 기준으로 EID 발송 대상을 조회하는  Method.
	 * 
     * @param  List<SearchEdi324SendVO> searchEdi324SendVOs
     * @param  String usr_id
	 * @throws EventException
	 */	        
   
    public void edi324SendGetTarget(List<SearchEdi324SendVO> searchEdi324SendVOs ,String usr_id) throws EventException;

}
