/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : EdiHoldStatusReceiveBC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013-06-25
*@LastModifier :
*@LastVersion : 1.0
* 2013-06-25 
* 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.esd.sce.receiveeai.holdstatusreceive.basic;

import java.util.ArrayList;
import java.util.HashMap;

import com.hanjin.framework.core.layer.event.EventException;
/**
 * ALPS-SCEM EDI Hold Status Message
 * - ALPS-SCEM EDI Hold Status Message 에 대한 비지니스 로직에 대한 인터페이스
 *
 * @author Sang-Jun Kwon
 * @see 
 * @since J2EE 1.4
 */
public interface EdiHoldStatusReceiveBC {

	/** 
	 * Hold Status Header를 FF에서 분리
	 * 
	 * @param String inv
	 * @return ArrayList<HashMap<String, String>>
	 * @exception EventException
	 */
	public HashMap<String, String> getHoldStatusHeaderdData(String inv)throws EventException;
	
	/** 
	 * Hold Status Release를 FF에서 분리
	 * 
	 * @param String inv
	 * @return ArrayList<HashMap<String, String>>[]
	 * @exception EventException
	 */
	public HashMap<String, String>[] getHoldStatusReleaseData(String inv)throws EventException;
	
	/** 
	 * Hold Status Release를 FF에서 분리
	 * 
	 * @param HashMap<String, String> hdr
	 * * @param HashMap<String, String> rel
	 * @exception EventException
	 */
	public void updateHoldStatus(HashMap<String, String> hdr, HashMap<String, String> rel)throws EventException;
}
