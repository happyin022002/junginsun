/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageDBDAOSearchCntrTypeSizeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.14 박재흥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OndockRailChargeInvoiceManageDBDAOSearchCntrTypeSizeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCntrTypeSizeList
	  * </pre>
	  */
	public OndockRailChargeInvoiceManageDBDAOSearchCntrTypeSizeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.integration ").append("\n"); 
		query.append("FileName : OndockRailChargeInvoiceManageDBDAOSearchCntrTypeSizeListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT cntr_tpsz_cd FROM mdm_cntr_tp_sz ORDER BY  cntr_tpsz_cd" ).append("\n"); 

	}
}