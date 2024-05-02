/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateBackEndJob
*@FileTitle : ProductCatalogCreateBackEndJob Job
*Open Issues :
*Change history :
*@LastModifyDate :  
*@LastModifier : jsy
*@LastVersion : 1.0
* 2013.12.04 jsy
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic;

import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Product Catalog Back End Job Business Logic Basic Command implementation<br>
 * @author JSY
 * @see EsdPrd0080Event 참조
 * @date 2013.12.09
 * @since J2EE 1.6
 */
public class ProductCatalogCreateBackEndJob extends BackEndCommandSupport { 
	/**
	 * 
	 */
	private static final long serialVersionUID = -3848484619137590218L;
	private EsdPrd0080Event event0080 ;
	private SignOnUserAccount account;

	/**
	 * pc생성을 위한 setting
	 * @param event
	 */
	public void setEvent(EsdPrd0080Event event) {
		this.event0080 = event;
	}
	/**
	 * account setting
	 * @param account
	 */
	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.account = account;
	}	
	
	/**
	 * pc 생성을  수행할 Thread 기동시 동작한다.<br>
	 * @return DBRowSet
	 * @exception Exception
	 */
	public DBRowSet doStart() throws Exception {
		DBRowSet rowSet = null;
		ProductCatalogCreateBC command = new ProductCatalogCreateBCImpl();
//		rowSet =command.createPrdCtlgFullRoutForCOA(event0080);
		rowSet =command.createPrdCtlgFullRoutForCOAMAS(event0080);
		return rowSet;
	}

}
