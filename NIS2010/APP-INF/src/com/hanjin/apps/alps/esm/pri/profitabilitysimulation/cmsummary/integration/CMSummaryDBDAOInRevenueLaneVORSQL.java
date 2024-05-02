/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CMSummaryDBDAOInRevenueLaneVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.16
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.03.16 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SONG MIN SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CMSummaryDBDAOInRevenueLaneVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CMSummaryDBDAOInRevenueLaneVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration").append("\n"); 
		query.append("FileName : CMSummaryDBDAOInRevenueLaneVORSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT" ).append("\n"); 
		query.append("		A1.RLANE_CD " ).append("\n"); 
		query.append(",       B1.RLANE_NM" ).append("\n"); 
		query.append("--,       A1.TRD_CD" ).append("\n"); 
		query.append("--,       A1.SUB_TRD_CD" ).append("\n"); 
		query.append("  FROM  MDM_DTL_REV_LANE A1" ).append("\n"); 
		query.append(",       MDM_REV_LANE B1" ).append("\n"); 
		query.append(" WHERE  A1.RLANE_CD = B1.RLANE_CD  " ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append(" AND    A1.RLANE_CD LIKE UPPER(@[rlane_cd]) || '%'" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${rlane_nm} != '')" ).append("\n"); 
		query.append(" AND    B1.RLANE_NM LIKE UPPER(@[rlane_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${trd_cd} != '')" ).append("\n"); 
		query.append(" AND    A1.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("#end    " ).append("\n"); 
		query.append("#if (${sub_trd_cd} != '')" ).append("\n"); 
		query.append(" AND    A1.SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" AND    B1.VSL_TP_CD = 'C' " ).append("\n"); 
		query.append(" AND    B1.DELT_FLG = 'N'" ).append("\n"); 
		query.append(" AND    A1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("--and		rownum < 10" ).append("\n"); 
		query.append("ORDER 	BY A1.RLANE_CD, B1.RLANE_NM" ).append("\n"); 

	}
}