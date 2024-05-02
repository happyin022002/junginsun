/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortSOMasterDataMgtDAOsearchOfficeYardsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortSOMasterDataMgtDAOsearchOfficeYardsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchOfficeYards
	  * </pre>
	  */
	public PortSOMasterDataMgtDAOsearchOfficeYardsRSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.integration").append("\n"); 
		query.append("FileName : PortSOMasterDataMgtDAOsearchOfficeYardsRSQL").append("\n"); 
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
		query.append("/* PsoInvOfcYd VO*/" ).append("\n"); 
		query.append("SELECT T1.YD_CD YD_CD1" ).append("\n"); 
		query.append("     ,T2.YD_NM YD_CD2" ).append("\n"); 
		query.append("     ,T4.AP_OFC_CD OFC_CD" ).append("\n"); 
		query.append("     ,T4.AR_CURR_CD CURR_CD" ).append("\n"); 
		query.append("     ,T1.CRE_USR_ID" ).append("\n"); 
		query.append("     ,DECODE(T5.PORT_CD,NULL,'N','Y') AS CANAL_FLAG" ).append("\n"); 
		query.append("  FROM PSO_INV_OFC_YD T1" ).append("\n"); 
		query.append("     , MDM_YARD T2" ).append("\n"); 
		query.append("     , MDM_ORGANIZATION T4" ).append("\n"); 
		query.append("     ,(SELECT INTG_CD_VAL_CTNT PORT_CD" ).append("\n"); 
		query.append("          FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("         WHERE INTG_CD_ID='CD20074') T5" ).append("\n"); 
		query.append(" WHERE T1.OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("   AND T1.YD_CD = T2.YD_CD" ).append("\n"); 
		query.append("   AND T2.OFC_CD = T4.OFC_CD" ).append("\n"); 
		query.append("   AND T4.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND T2.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND SUBSTR(T1.YD_CD, 1,5) = T5.PORT_CD(+)" ).append("\n"); 

	}
}