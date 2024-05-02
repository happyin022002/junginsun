/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315SendBC.java
*@FileTitle :Edi315SendBC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.11.17 전병석 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.basic;

import java.util.HashMap;

import com.clt.apps.opus.esd.sce.edi315send.Edi315SendSC;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315AmsDataVO;
import com.clt.apps.opus.esd.sce.edi315send.vo.Edi315SendVO;
import com.clt.framework.core.layer.event.EventException;


/**
 * SCE Business Logic ServiceCommand<br>
 * - SCE에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author YJLEE
 * @see Edi315SendSC 참조
 * @since J2EE 1.4
 */
public interface Edi315SendBC {
    /*The Definition of the carriage return*/
	public final String CHR10 = "\n";	
	public final String SUCCESS = "Y";
	public final String FAIL    = "N";
	/**
	 * edi315Send
	 * VIP 315 를 발송 하는 모든 로직이 들어 있는 Method.
	 * 이 안에 화주 별 Validation 과 Loging 로직과 Flat File 생성 / MQ 발송 로직이 다 있음.
	 * 
     * @param  Edi315SendVO sendVo
	 * @return String
	 * @throws EventException
	 */	        
    public String edi315Send(Edi315SendVO sendVo) throws EventException;
    /**
     * sysDate 
     * 오라클의 SYSDATE 와 같은 함수이고 Format 대로 Return 한다.
     * @param String dFormat
	 * @return String
	 */	     
	public String sysDate(String dFormat);
	/**
	 * sysDate
	 * 오라클의 SYSDATE 와 같은 함수.
	 * @return String
	 */		
	public String sysDate();
	/**
	 * addSceEdiAmsIf
	 * SCE_EDI_AMS_IF 배치 테이블에 데이타를 Insert 하는 Method.(CargoRelease에서 콜)
     * @param  Edi315AmsDataVO amsVo
	 * @return String
	 * @throws EventException
	 */
	public String addSceEdiAmsIf(Edi315AmsDataVO amsVo)throws EventException;
	/**
	 * sendEDIMQ
	 * 생성된 Falt File을 OutBound MQ로 발송 하는 Method.
     * @param  String ediString
	 * @return String
	 * @throws EventException
	 */
    public String sendEDIMQ(String ediString)throws EventException;
    
    /**
     * 
     * @param param
     * @return
     * @throws EventException
     */
    public int updateSceCopDtlActualDateByTrs(HashMap<String, Object> param) throws EventException;

}
