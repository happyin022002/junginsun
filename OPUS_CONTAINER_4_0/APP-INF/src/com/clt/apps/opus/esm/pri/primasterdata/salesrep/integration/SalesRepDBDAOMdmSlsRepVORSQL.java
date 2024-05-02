/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SalesRepDBDAOMdmSlsRepVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2012.02.21 송민석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.salesrep.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG Min Seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRepDBDAOMdmSlsRepVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SalesRepDBDAOMdmSlsRepVORSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.primasterdata.salesrep.integration").append("\n"); 
		query.append("FileName : SalesRepDBDAOMdmSlsRepVORSQL").append("\n"); 
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
		query.append("SELECT SREP_CD" ).append("\n"); 
		query.append("     , OFC_CD" ).append("\n"); 
		query.append("     , SREP_NM" ).append("\n"); 
		query.append("  FROM MDM_SLS_REP" ).append("\n"); 
		query.append(" WHERE DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${srep_cd} != '') " ).append("\n"); 
		query.append("   AND SREP_CD LIKE '%' || @[srep_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("  AND OFC_CD LIKE @[ofc_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}