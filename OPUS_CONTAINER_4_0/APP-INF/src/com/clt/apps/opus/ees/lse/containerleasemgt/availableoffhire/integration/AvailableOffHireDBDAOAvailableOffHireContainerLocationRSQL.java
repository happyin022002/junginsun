/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AvailableOffHireDBDAOAvailableOffHireContainerLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvailableOffHireDBDAOAvailableOffHireContainerLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.05.15 / Jiyeon Jeon - Target Off-Hire Location 조회
	  * </pre>
	  */
	public AvailableOffHireDBDAOAvailableOffHireContainerLocationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_loc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.integration").append("\n"); 
		query.append("FileName : AvailableOffHireDBDAOAvailableOffHireContainerLocationRSQL").append("\n"); 
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
		query.append("SELECT SUB.CONTI_CD AS LOC_CD, SUB.CONTI_NM AS LOC_NM" ).append("\n"); 
		query.append("  FROM MDM_CONTINENT SUB" ).append("\n"); 
		query.append(" WHERE SUB.DELT_FLG  = 'N'" ).append("\n"); 
		query.append("   AND 'CT' = @[eq_loc_tp_cd]" ).append("\n"); 
		query.append("#if (${loc_cd} != '' )" ).append("\n"); 
		query.append("   AND SUB.CONTI_CD LIKE '%'||@[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT SUB.SCONTI_CD AS LOC_CD, SUB.SCONTI_NM AS LOC_NM" ).append("\n"); 
		query.append("  FROM MDM_SUBCONTINENT SUB" ).append("\n"); 
		query.append(" WHERE SUB.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("   AND 'ST' = @[eq_loc_tp_cd]" ).append("\n"); 
		query.append("#if (${loc_cd} != '' )" ).append("\n"); 
		query.append("   AND SUB.SCONTI_CD LIKE '%'||@[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT SUB.CNT_CD AS LOC_CD, SUB.CNT_NM AS LOC_NM" ).append("\n"); 
		query.append("  FROM MDM_COUNTRY SUB" ).append("\n"); 
		query.append(" WHERE SUB.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("   AND 'CN' = @[eq_loc_tp_cd]" ).append("\n"); 
		query.append("#if (${loc_cd} != '' )" ).append("\n"); 
		query.append("   AND SUB.CNT_CD LIKE '%'||@[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT SUB.RCC_CD AS LOC_CD, SUB.RCC_CD AS LOC_NM" ).append("\n"); 
		query.append("  FROM MDM_EQ_ORZ_CHT SUB" ).append("\n"); 
		query.append(" WHERE SUB.DELT_FLG    = 'N' " ).append("\n"); 
		query.append("   AND 'RC' = @[eq_loc_tp_cd]" ).append("\n"); 
		query.append("#if (${loc_cd} != '' )" ).append("\n"); 
		query.append("   AND SUB.RCC_CD LIKE '%'||@[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT SUB.ECC_CD AS LOC_CD, SUB.ECC_CD AS LOC_NM" ).append("\n"); 
		query.append("  FROM MDM_EQ_ORZ_CHT SUB" ).append("\n"); 
		query.append(" WHERE SUB.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("   AND 'EC' = @[eq_loc_tp_cd]" ).append("\n"); 
		query.append("#if (${loc_cd} != '' )" ).append("\n"); 
		query.append("   AND SUB.ECC_CD LIKE '%'||@[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT SUB.SCC_CD AS LOC_CD, SUB.SCC_CD AS LOC_NM" ).append("\n"); 
		query.append("  FROM MDM_EQ_ORZ_CHT SUB" ).append("\n"); 
		query.append(" WHERE SUB.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("   AND 'SC' = @[eq_loc_tp_cd]" ).append("\n"); 
		query.append("#if (${loc_cd} != '' )" ).append("\n"); 
		query.append("   AND SUB.SCC_CD LIKE '%'||@[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT SUB.LOC_CD AS LOC_CD, SUB.LOC_CD AS LOC_NM" ).append("\n"); 
		query.append("  FROM MDM_LOCATION SUB" ).append("\n"); 
		query.append(" WHERE SUB.DELT_FLG   = 'N'" ).append("\n"); 
		query.append("   AND 'LO' = @[eq_loc_tp_cd]" ).append("\n"); 
		query.append("#if (${loc_cd} != '' )" ).append("\n"); 
		query.append("   AND SUB.LOC_CD LIKE '%'||@[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT SUB.LCC_CD AS LOC_CD, SUB.LCC_CD AS LOC_NM" ).append("\n"); 
		query.append("  FROM MDM_EQ_ORZ_CHT SUB" ).append("\n"); 
		query.append(" WHERE SUB.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("   AND 'LC' = @[eq_loc_tp_cd]" ).append("\n"); 
		query.append("#if (${loc_cd} != '' )" ).append("\n"); 
		query.append("   AND SUB.LCC_CD LIKE '%'||@[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}