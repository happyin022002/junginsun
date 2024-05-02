/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DODInvoiceMgtDBDAOSearchARInterfaceContainerListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.16
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2013.09.16 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DODInvoiceMgtDBDAOSearchARInterfaceContainerListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchARInterfaceContainerList
	  * </pre>
	  */
	public DODInvoiceMgtDBDAOSearchARInterfaceContainerListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dod_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.dodinvoicemgt.integration").append("\n"); 
		query.append("FileName : DODInvoiceMgtDBDAOSearchARInterfaceContainerListRSQL").append("\n"); 
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
		query.append("SELECT  ROWNUM AS CNTR_SEQ, " ).append("\n"); 
		query.append("        CNTR_NO," ).append("\n"); 
		query.append("        CNTR_TPSZ_CD," ).append("\n"); 
		query.append("        CRE_USR_ID ," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        @[cre_usr_id]  AS UPD_USR_ID," ).append("\n"); 
		query.append("        NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd]),SYSDATE) AS UPD_DT" ).append("\n"); 
		query.append("FROM EAS_DOD_INV_DTL" ).append("\n"); 
		query.append("WHERE DOD_INV_NO = @[dod_inv_no]" ).append("\n"); 
		query.append("ORDER BY CNTR_NO" ).append("\n"); 

	}
}