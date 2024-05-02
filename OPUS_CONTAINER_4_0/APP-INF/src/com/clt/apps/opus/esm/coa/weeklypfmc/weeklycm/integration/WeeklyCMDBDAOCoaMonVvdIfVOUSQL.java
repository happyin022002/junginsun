/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WeeklyCMDBDAOCoaMonVvdIfVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.08
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.03.08 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHOISUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOCoaMonVvdIfVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * coa_mon_vvd_if insert& update
	  * </pre>
	  */
	public WeeklyCMDBDAOCoaMonVvdIfVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_fm_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOCoaMonVvdIfVOUSQL").append("\n"); 
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
		query.append("MERGE INTO COA_MON_VVD_IF A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("		SELECT DISTINCT" ).append("\n"); 
		query.append("			   DECODE(SUBSTR(ESTM_IOC_DIV_CD, 1, 1) ,SUBSTR(ESTM_IOC_DIV_CD, -1)" ).append("\n"); 
		query.append("			 , SUBSTR(RLANE_CD, -2)||'S' ,ESTM_IOC_DIV_CD||'S') TRD_CD" ).append("\n"); 
		query.append("  			 , RLANE_CD" ).append("\n"); 
		query.append("  			 , DECODE(SUBSTR(ESTM_IOC_DIV_CD, 1, 1), SUBSTR(ESTM_IOC_DIV_CD, -1), 'O', 'I') IOC_CD" ).append("\n"); 
		query.append("  			 , VSL_CD" ).append("\n"); 
		query.append("  			 , SKD_VOY_NO" ).append("\n"); 
		query.append("  			 , SKD_DIR_CD DIR_CD" ).append("\n"); 
		query.append("  			 , NULL VVD_SEQ" ).append("\n"); 
		query.append("  			 , REV_YRMON COST_YRMON" ).append("\n"); 
		query.append("  			 , NULL COST_WK" ).append("\n"); 
		query.append("  			 , SUBSTR(RLANE_CD, 1, 3) SLAN_CD" ).append("\n"); 
		query.append("  			 , NULL LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("  			 , NULL N1ST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("  			 , NULL LST_LODG_PORT_CD" ).append("\n"); 
		query.append("  			 , 'GL IF' CRE_USR_ID" ).append("\n"); 
		query.append("  			 , SYSDATE CRE_DT" ).append("\n"); 
		query.append("  			 , 'GL IF' UPD_USR_ID" ).append("\n"); 
		query.append("  			 , SYSDATE UPD_DT" ).append("\n"); 
		query.append("  		  FROM GL_ESTM_REV_VVD" ).append("\n"); 
		query.append("		 WHERE REV_YRMON      = @[f_cost_yr] || @[f_cost_fm_mon]" ).append("\n"); 
		query.append("		   AND ESTM_BC_DIV_CD = 'C' ) B" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   ON ( 	A.TRD_CD 		= B.TRD_CD " ).append("\n"); 
		query.append("		AND A.RLANE_CD 		= B.RLANE_CD" ).append("\n"); 
		query.append("		AND A.IOC_CD 		= B.IOC_CD" ).append("\n"); 
		query.append("		AND A.VSL_CD 		= B.VSL_CD" ).append("\n"); 
		query.append("		AND A.SKD_VOY_NO 	= B.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND A.DIR_CD 		= B.DIR_CD )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("	   UPDATE  " ).append("\n"); 
		query.append("          SET A.VVD_SEQ 		= B.VVD_SEQ" ).append("\n"); 
		query.append("		    , A.COST_YRMON 		= B.COST_YRMON " ).append("\n"); 
		query.append("            , A.COST_WK 		= B.COST_WK " ).append("\n"); 
		query.append("            , A.SLAN_CD 		= B.SLAN_CD " ).append("\n"); 
		query.append("            , A.LST_LODG_PORT_ETD_DT = B.LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("			, A.N1ST_LODG_PORT_ETD_DT = B.N1ST_LODG_PORT_ETD_DT " ).append("\n"); 
		query.append("            , A.LST_LODG_PORT_CD = B.LST_LODG_PORT_CD" ).append("\n"); 
		query.append("			, A.UPD_USR_ID 		= B.UPD_USR_ID " ).append("\n"); 
		query.append("            , A.UPD_DT 			= B.UPD_DT" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("   INSERT (   TRD_CD" ).append("\n"); 
		query.append("			, RLANE_CD" ).append("\n"); 
		query.append("			, IOC_CD" ).append("\n"); 
		query.append("			, VSL_CD" ).append("\n"); 
		query.append("			, SKD_VOY_NO" ).append("\n"); 
		query.append("			, DIR_CD    " ).append("\n"); 
		query.append("			, VVD_SEQ" ).append("\n"); 
		query.append("            , COST_YRMON" ).append("\n"); 
		query.append("            , COST_WK" ).append("\n"); 
		query.append("            , SLAN_CD" ).append("\n"); 
		query.append("            , LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("            , N1ST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("            , LST_LODG_PORT_CD" ).append("\n"); 
		query.append("            , CRE_USR_ID" ).append("\n"); 
		query.append("            , CRE_DT" ).append("\n"); 
		query.append("            , UPD_USR_ID" ).append("\n"); 
		query.append("            , UPD_DT )" ).append("\n"); 
		query.append("   VALUES (   B.TRD_CD" ).append("\n"); 
		query.append("            , B.RLANE_CD" ).append("\n"); 
		query.append("            , B.IOC_CD" ).append("\n"); 
		query.append("            , B.VSL_CD" ).append("\n"); 
		query.append("            , B.SKD_VOY_NO" ).append("\n"); 
		query.append("            , B.DIR_CD    " ).append("\n"); 
		query.append("            , B.VVD_SEQ" ).append("\n"); 
		query.append("            , B.COST_YRMON" ).append("\n"); 
		query.append("            , B.COST_WK" ).append("\n"); 
		query.append("            , B.SLAN_CD" ).append("\n"); 
		query.append("            , B.LST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("            , B.N1ST_LODG_PORT_ETD_DT" ).append("\n"); 
		query.append("            , B.LST_LODG_PORT_CD" ).append("\n"); 
		query.append("            , B.CRE_USR_ID" ).append("\n"); 
		query.append("            , B.CRE_DT" ).append("\n"); 
		query.append("            , B.UPD_USR_ID" ).append("\n"); 
		query.append("            , B.UPD_DT )" ).append("\n"); 

	}
}