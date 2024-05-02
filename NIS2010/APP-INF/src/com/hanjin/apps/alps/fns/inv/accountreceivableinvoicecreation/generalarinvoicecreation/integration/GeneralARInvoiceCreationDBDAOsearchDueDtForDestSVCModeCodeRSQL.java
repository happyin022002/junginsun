/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralARInvoiceCreationDBDAOsearchDueDtForDestSVCModeCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.10.15 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralARInvoiceCreationDBDAOsearchDueDtForDestSVCModeCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralARInvoiceCreationDBDAOsearchDueDtForDestSVCModeCodeRSQL
	  * </pre>
	  */
	public GeneralARInvoiceCreationDBDAOsearchDueDtForDestSVCModeCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("due_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_trns_svc_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration ").append("\n"); 
		query.append("FileName : GeneralARInvoiceCreationDBDAOsearchDueDtForDestSVCModeCodeRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[dest_trns_svc_mod_cd] , 'CIP', TO_CHAR(TO_DATE(@[due_dt],'YYYYMMDD')+8, 'YYYYMMDD')" ).append("\n"); 
		query.append(", 'CML', TO_CHAR(TO_DATE(@[due_dt],'YYYYMMDD')+8, 'YYYYMMDD')" ).append("\n"); 
		query.append(", 'NIP', TO_CHAR(TO_DATE(@[due_dt],'YYYYMMDD')+8, 'YYYYMMDD')" ).append("\n"); 
		query.append(", 'MLB', TO_CHAR(TO_DATE(@[due_dt],'YYYYMMDD')+8, 'YYYYMMDD')" ).append("\n"); 
		query.append(", 'IPI', TO_CHAR(TO_DATE(@[due_dt],'YYYYMMDD')+8, 'YYYYMMDD')" ).append("\n"); 
		query.append(", TO_CHAR(TO_DATE(@[due_dt],'YYYYMMDD'), 'YYYYMMDD')) DUE_DT" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}