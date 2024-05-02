/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EqInterchangeRequestDBDAOSearchEMUCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EqInterchangeRequestDBDAOSearchEMUCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 각각 ECC/LCC/RCC level에 대해서 EMU Cost을 조회를 해온다.
	  * </pre>
	  */
	public EqInterchangeRequestDBDAOSearchEMUCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.eqinterchangemgt.integration").append("\n"); 
		query.append("FileName : EqInterchangeRequestDBDAOSearchEMUCostRSQL").append("\n"); 
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
		query.append("SELECT A1.COST_YRMON" ).append("\n"); 
		query.append("      , A1.ECC_CD" ).append("\n"); 
		query.append("      ,A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,A1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("      ,DECODE(A1.CNTR_ORG_DEST_CD, 'O', 'Origin(from)', 'Dest(to)') ORI_DEST" ).append("\n"); 
		query.append("      , NVL((A1.MTY_STVG_UC_AMT + A1.MTY_TRSP_UC_AMT),0) CALCU_TTL ------------------EMU Cost TTL" ).append("\n"); 
		query.append("    FROM MAS_MTY_ECC_UT_COST A1" ).append("\n"); 
		query.append("      , MAS_MTY_CNTR_ROUT_PERF A2" ).append("\n"); 
		query.append("  WHERE 1                   = 1" ).append("\n"); 
		query.append("    AND A1.COST_LOC_GRP_CD  = DECODE (@[loc_tp],'RCC','R','LCC','L','E') " ).append("\n"); 
		query.append("    AND A1.COST_YRMON       = TO_CHAR(SYSDATE,'YYYYMM') " ).append("\n"); 
		query.append("    AND A1.COST_YRMON       = A2.COST_YRMON" ).append("\n"); 
		query.append("    AND A1.ECC_CD           = DECODE(A1.CNTR_ORG_DEST_CD, 'O', A2.ROUT_N1ST_ECC_CD, A2.ROUT_LST_ECC_CD)" ).append("\n"); 
		query.append("    AND A1.CNTR_ORG_DEST_CD = @[org_dest_cd] -- 'O' 'Origin(from)' , 'D' Dest(to)" ).append("\n"); 
		query.append("    AND A1.CNTR_TPSZ_CD     = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("    AND A1.CNTR_ORG_DEST_CD = A2.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("    AND A1.ECC_CD           = @[loc_cd]" ).append("\n"); 
		query.append("GROUP BY A1.COST_YRMON" ).append("\n"); 
		query.append("      , A1.ECC_CD" ).append("\n"); 
		query.append("      , A1.CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append("      , A1.IMBAL_RTO" ).append("\n"); 
		query.append("      , A1.CNTR_ORG_DEST_CD" ).append("\n"); 
		query.append("      , A1.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      , A1.MCNTR_QTY" ).append("\n"); 
		query.append("      , A1.MTY_STVG_UC_AMT" ).append("\n"); 
		query.append("      , A1.MTY_TRSP_UC_AMT" ).append("\n"); 
		query.append("      , ROUND(A1.MTY_TZ_DYS, 2)" ).append("\n"); 
		query.append("ORDER BY A1.ECC_CD" ).append("\n"); 
		query.append("      , A1.CNTR_IO_VOL_STS_CD DESC" ).append("\n"); 
		query.append("      , A1.CNTR_TPSZ_CD" ).append("\n"); 

	}
}