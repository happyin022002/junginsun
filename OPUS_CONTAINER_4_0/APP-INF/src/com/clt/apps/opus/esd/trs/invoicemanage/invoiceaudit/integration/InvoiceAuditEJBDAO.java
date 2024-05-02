/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : invoiceauditEJBDAO.java
*@FileTitle : Currency Change Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-06
*@LastModifier : Lee_SangWoo
*@LastVersion : 1.0
* 2006-12-06 Lee_SangWoo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.basic.InvoiceAuditBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.support.layer.integration.EJBDAOSupport;


/**
 * ESD-invoicemanage에 대한 EJB 처리를 담당<br>
 * - ESD-invoicemanage Business Logic을 처리하기 위한 EJB 작업수행.<br>
 * 
 * @author Lee_SangWoo
 * @see InvoiceAuditBCImpl 참조
 * @since J2EE 1.4
 */
public class InvoiceAuditEJBDAO extends EJBDAOSupport {
	
}