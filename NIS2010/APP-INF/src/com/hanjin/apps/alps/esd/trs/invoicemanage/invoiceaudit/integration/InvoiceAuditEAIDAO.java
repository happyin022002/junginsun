/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : invoiceauditEAIDAO.java
*@FileTitle : Currency Change Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-06
*@LastModifier : Lee_SangWoo
*@LastVersion : 1.0
* 2006-12-06 Lee_SangWoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceaudit.basic.InvoiceAuditBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.EAIDAOSupport;


/**
 * ESD-invoicemanage에 대한 EAI 처리를 담당<br>
 * - ESD-invoicemanage Business Logic을 처리하기 위한 EAI 작업수행.<br>
 * 
 * @author Lee_SangWoo
 * @see InvoiceAuditBCImpl 참조
 * @since J2EE 1.4
 */
public class InvoiceAuditEAIDAO extends EAIDAOSupport {
	
}