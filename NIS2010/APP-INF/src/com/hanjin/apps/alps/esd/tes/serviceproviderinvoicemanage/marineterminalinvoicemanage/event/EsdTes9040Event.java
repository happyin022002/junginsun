/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_904Event.java
*@FileTitle : Total Amount PopUp 화면 - Marine Terminal 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-16
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-16 parkyeonjin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import java.util.Collection;

import com.hanjin.framework.support.layer.event.EventSupport;



/**
 * ESD_TES_9040 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TES_9040HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author parkyeonjin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTes9040Event extends EventSupport {

	public EsdTes9040Event(){}

	public String getEventName() {
		return "EsdTes9040Event";
	}

	public String toString() {
		return "EsdTes9040Event";
	}

}
