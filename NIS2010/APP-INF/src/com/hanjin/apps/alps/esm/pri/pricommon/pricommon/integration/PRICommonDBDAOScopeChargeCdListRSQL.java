/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : PRICommonDBDAOScopeChargeCdListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.28
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.09.28 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PRICommonDBDAOScopeChargeCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * scope 별 surcharge 리스트 조회
	  * </pre>
	  */
	public PRICommonDBDAOScopeChargeCdListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etc1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.pricommon.pricommon.integration").append("\n"); 
		query.append("FileName : PRICommonDBDAOScopeChargeCdListRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A1.CHG_CD AS CD" ).append("\n"); 
		query.append("      ,B1.CHG_NM AS NM" ).append("\n"); 
		query.append("  FROM PRI_SCG_PRF A1" ).append("\n"); 
		query.append("      ,MDM_CHARGE B1" ).append("\n"); 
		query.append(" WHERE A1.CHG_CD = B1.CHG_CD" ).append("\n"); 
		query.append("#if (${etc1} != '')  " ).append("\n"); 
		query.append("   AND A1.SVC_SCP_CD = @[etc1]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND A1.SVC_SCP_CD IN (" ).append("\n"); 
		query.append("	   SELECT SVC_SCP_CD FROM MDM_SVC_SCP" ).append("\n"); 
		query.append("        WHERE TRF_PFX_CD = @[etc2]" ).append("\n"); 
		query.append("          AND TRF_NO = @[etc3]" ).append("\n"); 
		query.append("          AND DELT_FLG = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND B1.DELT_FLG = 'N'" ).append("\n"); 
		query.append(" ORDER BY A1.CHG_CD" ).append("\n"); 

	}
}