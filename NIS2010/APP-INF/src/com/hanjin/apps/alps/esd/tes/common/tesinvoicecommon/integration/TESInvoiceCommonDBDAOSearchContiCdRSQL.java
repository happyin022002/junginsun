/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TESInvoiceCommonDBDAOSearchContiCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESInvoiceCommonDBDAOSearchContiCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM Conti_Cd by Session Office
	  * </pre>
	  */
	public TESInvoiceCommonDBDAOSearchContiCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.integration").append("\n"); 
		query.append("FileName : TESInvoiceCommonDBDAOSearchContiCdRSQL").append("\n"); 
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
		query.append("SELECT C.CONTI_CD" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION B," ).append("\n"); 
		query.append("    (SELECT C.* " ).append("\n"); 
		query.append("    FROM MDM_LOCATION C " ).append("\n"); 
		query.append("    WHERE NVL(C.DELT_FLG,'N') <> 'Y') C" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND B.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND NVL(B.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND B.LOC_CD = C.LOC_CD" ).append("\n"); 

	}
}