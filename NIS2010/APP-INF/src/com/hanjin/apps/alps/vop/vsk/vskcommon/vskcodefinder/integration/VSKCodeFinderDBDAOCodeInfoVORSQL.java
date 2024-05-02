/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VSKCodeFinderDBDAOCodeInfoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2010.03.26 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VSKCodeFinderDBDAOCodeInfoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public VSKCodeFinderDBDAOCodeInfoVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grd_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("name",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.integration").append("\n"); 
		query.append("FileName : VSKCodeFinderDBDAOCodeInfoVORSQL").append("\n"); 
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
		query.append("#if (${grd_nm} == 'CD0XXXX') " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	@[grd_nm]	GRD_NM" ).append("\n"); 
		query.append("	,A.CRR_CD CODE" ).append("\n"); 
		query.append("	,A.CRR_NM NAME" ).append("\n"); 
		query.append("FROM   MDM_CARRIER A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${code} != '') " ).append("\n"); 
		query.append("AND     UPPER(A.CRR_CD) LIKE @[code] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${name} != '') " ).append("\n"); 
		query.append("AND     UPPER(A.CRR_NM) LIKE '%' || UPPER(@[name]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.CRR_CD" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	@[grd_nm]	GRD_NM" ).append("\n"); 
		query.append("	,A.INTG_CD_VAL_CTNT CODE" ).append("\n"); 
		query.append("	,A.INTG_CD_VAL_DESC NAME" ).append("\n"); 
		query.append("FROM   COM_INTG_CD_DTL A" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.INTG_CD_ID = @[grd_nm]" ).append("\n"); 
		query.append("#if (${code} != '') " ).append("\n"); 
		query.append("AND     A.INTG_CD_VAL_CTNT LIKE @[code] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${name} != '') " ).append("\n"); 
		query.append("AND     UPPER(A.INTG_CD_VAL_DESC) LIKE '%' || UPPER(@[name]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}