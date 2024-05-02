/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Invoice210EdiManageBC.java
*@FileTitle : Invoice 210 EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009-05-08
*@LastModifier : eunju son
*@LastVersion : 1.0
* 2009-05-08 eunju son
* 1.0 최초생성
============================================================= */
package com.hanjin.apps.alps.esd.trs.servicesio.invoice210edi.basic;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.TrsTrspInvEdiVO;

/**
 * Invoice210EdiManageBC<br>
 * - Invoice210EdiManageBC
 * 
 * @author sunghwan cho
 * @see SppTrsI10EventResponse,Invoice210EdiManageBC 참조
 * @since J2EE 1.4
 */
public interface Invoice210EdiManageBC {
	
	/**
	 * Receving Data From MNR <br>
	 * Receive JMS Queue 방식 사용(JMS Inbound)
	 * @param str - JMS Queue로 부터 받은 메세지
	 * @return
	 * @throws EventException
	 */
	public TrsTrspInvEdiVO receive210EDIData(String str) throws EventException;
	
	/**
	 * Creating Data Received From MNR<br>
	 * @param model
	 * @return
	 * @throws EventException
	 */
	public boolean add210EDIManage(TrsTrspInvEdiVO model) throws EventException;

}
