/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ConstraintManageDBDAOSearchContainerTypeSizeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintManageDBDAOSearchContainerTypeSizeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ConstraintManageDBDAOSearchContainerTypeSize
	  * </pre>
	  */
	public ConstraintManageDBDAOSearchContainerTypeSizeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_sz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.integration").append("\n"); 
		query.append("FileName : ConstraintManageDBDAOSearchContainerTypeSizeRSQL").append("\n"); 
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
		query.append("#if (${p_gubun} == 'TP')" ).append("\n"); 
		query.append("SELECT CNTR_TP_CD" ).append("\n"); 
		query.append("  FROM (SELECT O.CNTR_TP_CD" ).append("\n"); 
		query.append("              ,MIN(O.RPT_DP_SEQ) SEQ" ).append("\n"); 
		query.append("          FROM MDM_CNTR_TP_SZ O" ).append("\n"); 
		query.append("         WHERE O.CNTR_SZ_CD = NVL(@[cntr_sz_cd], O.CNTR_SZ_CD)" ).append("\n"); 
		query.append("           AND O.DELT_FLG = 'N'" ).append("\n"); 
		query.append("         GROUP BY CNTR_TP_CD)" ).append("\n"); 
		query.append(" ORDER BY SEQ" ).append("\n"); 
		query.append("#elseif (${p_gubun} == 'SZ')" ).append("\n"); 
		query.append("SELECT CNTR_SZ_CD" ).append("\n"); 
		query.append("  FROM (SELECT CNTR_SZ_CD" ).append("\n"); 
		query.append("              ,MIN(O.RPT_DP_SEQ) SEQ" ).append("\n"); 
		query.append("          FROM MDM_CNTR_TP_SZ O" ).append("\n"); 
		query.append("         WHERE O.CNTR_TP_CD = NVL(@[cntr_tp_cd], O.CNTR_TP_CD)" ).append("\n"); 
		query.append("         GROUP BY CNTR_SZ_CD)" ).append("\n"); 
		query.append(" ORDER BY SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("select *" ).append("\n"); 
		query.append("  from MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append(" where CNTR_TPSZ_CD = @[cntr_tp_cd] || @[cntr_sz_cd]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}