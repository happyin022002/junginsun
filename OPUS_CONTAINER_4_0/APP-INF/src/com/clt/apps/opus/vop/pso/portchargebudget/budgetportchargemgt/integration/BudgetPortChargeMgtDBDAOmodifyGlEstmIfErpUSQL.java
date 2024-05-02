/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BudgetPortChargeMgtDBDAOmodifyGlEstmIfErpUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.09.07 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BudgetPortChargeMgtDBDAOmodifyGlEstmIfErpUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 실행월 전의 Max 월에 수작업으로 입력한 Estimate Amount를 그대로 사용하기 위해 Update 한다.
	  * </pre>
	  */
	public BudgetPortChargeMgtDBDAOmodifyGlEstmIfErpUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration").append("\n"); 
		query.append("FileName : BudgetPortChargeMgtDBDAOmodifyGlEstmIfErpUSQL").append("\n"); 
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
		query.append("MERGE INTO GL_ESTM_IF_ERP GL" ).append("\n"); 
		query.append("USING ( SELECT GE.ESTM_AMT" ).append("\n"); 
		query.append("             , GL.EXE_YRMON" ).append("\n"); 
		query.append("             , GL.SYS_SRC_ID" ).append("\n"); 
		query.append("             , GL.REV_YRMON" ).append("\n"); 
		query.append("             , GL.ACCT_CD" ).append("\n"); 
		query.append("             , GL.ESTM_SEQ_NO" ).append("\n"); 
		query.append("             , GL.ACT_AMT" ).append("\n"); 
		query.append("             , (GE.ESTM_AMT - GL.ACT_AMT) AS ACCL_AMT" ).append("\n"); 
		query.append("             , 'Y|Updated from last accrual. calculated amount ['||NVL(GL.ESTM_AMT,0)||']. updated by batch.' AS SRC_UPD_RMK" ).append("\n"); 
		query.append("             , GE.SRC_UPD_USR_ID" ).append("\n"); 
		query.append("             , GE.SRC_UPD_DT" ).append("\n"); 
		query.append("             , GL.SLAN_CD" ).append("\n"); 
		query.append("          FROM (SELECT GE.*" ).append("\n"); 
		query.append("                  FROM (" ).append("\n"); 
		query.append("                        SELECT GE.EXE_YRMON" ).append("\n"); 
		query.append("                             , GE.REV_YRMON" ).append("\n"); 
		query.append("                             , GE.ACCT_CD" ).append("\n"); 
		query.append("                             , GE.VSL_CD" ).append("\n"); 
		query.append("                             , GE.SKD_VOY_NO" ).append("\n"); 
		query.append("                             , GE.SKD_DIR_CD" ).append("\n"); 
		query.append("                             , GE.REV_DIR_CD" ).append("\n"); 
		query.append("                             , GE.ACCT_DTL_CD" ).append("\n"); 
		query.append("                             , GE.LOCL_CURR_CD" ).append("\n"); 
		query.append("                             , GE.COST_ACT_PLC_CD" ).append("\n"); 
		query.append("                             , GE.VVD_DUR_NO" ).append("\n"); 
		query.append("                             , GE.UPD_RMK" ).append("\n"); 
		query.append("                             , GE.ESTM_AMT" ).append("\n"); 
		query.append("                             , GE.SLAN_CD" ).append("\n"); 
		query.append("                             , GE.UPD_USR_ID AS SRC_UPD_USR_ID" ).append("\n"); 
		query.append("                             , TO_CHAR(GE.UPD_DT,'YYYYMMDDHH24MISS') AS SRC_UPD_DT" ).append("\n"); 
		query.append("                             , ROW_NUMBER() OVER (PARTITION BY GE.REV_YRMON, GE.ACCT_CD, GE.VSL_CD, GE.SKD_VOY_NO, GE.SKD_DIR_CD, GE.REV_DIR_CD, GE.ACCT_DTL_CD, GE.LOCL_CURR_CD, GE.COST_ACT_PLC_CD, GE.VVD_DUR_NO  ORDER BY GE.EXE_YRMON DESC, GE.UPD_DT DESC) AS GL_RANK" ).append("\n"); 
		query.append("                          FROM GL_ESTM_IF_ERP GE" ).append("\n"); 
		query.append("                         WHERE GE.SYS_SRC_ID        = 'PS2'" ).append("\n"); 
		query.append("                       ) GE" ).append("\n"); 
		query.append("                 WHERE GE.GL_RANK = 1 /*최종 데이타를 구하는 부분.*/" ).append("\n"); 
		query.append("               ) GE" ).append("\n"); 
		query.append("             , GL_ESTM_IF_ERP GL" ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("           AND GL.EXE_YRMON         = REPLACE( @[exe_yrmon] , '-', '') /*실행 월*/" ).append("\n"); 
		query.append("           AND GL.SYS_SRC_ID        = 'PSO'" ).append("\n"); 
		query.append("           AND GE.REV_YRMON         = GL.REV_YRMON" ).append("\n"); 
		query.append("           AND GE.ACCT_CD           = GL.ACCT_CD" ).append("\n"); 
		query.append("           AND GE.VSL_CD            = GL.VSL_CD" ).append("\n"); 
		query.append("           AND GE.SKD_VOY_NO        = GL.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND GE.SKD_DIR_CD        = GL.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND GE.REV_DIR_CD        = GL.REV_DIR_CD" ).append("\n"); 
		query.append("           AND GE.ACCT_DTL_CD       = GL.ACCT_DTL_CD" ).append("\n"); 
		query.append("           AND GE.LOCL_CURR_CD      = GL.LOCL_CURR_CD" ).append("\n"); 
		query.append("           AND GE.COST_ACT_PLC_CD   = GL.COST_ACT_PLC_CD" ).append("\n"); 
		query.append("           AND GE.VVD_DUR_NO        = GL.VVD_DUR_NO" ).append("\n"); 
		query.append("           AND GE.SLAN_CD           = GL.SLAN_CD" ).append("\n"); 
		query.append("           AND GL.VSL_CD            = @[vsl_cd]" ).append("\n"); 
		query.append("           AND GL.SKD_VOY_NO        = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND GL.SKD_DIR_CD        = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND GL.COST_ACT_PLC_CD   = @[yd_cd]" ).append("\n"); 
		query.append("           AND GL.VVD_DUR_NO        = @[clpt_ind_seq]" ).append("\n"); 
		query.append("       ) GE" ).append("\n"); 
		query.append("   ON (     GL.EXE_YRMON    = GE.EXE_YRMON" ).append("\n"); 
		query.append("        AND GL.SYS_SRC_ID   = GE.SYS_SRC_ID" ).append("\n"); 
		query.append("        AND GL.REV_YRMON    = GE.REV_YRMON" ).append("\n"); 
		query.append("        AND GL.ACCT_CD      = GE.ACCT_CD" ).append("\n"); 
		query.append("        AND GL.ESTM_SEQ_NO  = GE.ESTM_SEQ_NO" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("   SET GL.ESTM_AMT      = GE.ESTM_AMT" ).append("\n"); 
		query.append("     , GL.ACCL_AMT      = GE.ACCL_AMT" ).append("\n"); 
		query.append("     , GL.UPD_RMK       = GE.SRC_UPD_RMK" ).append("\n"); 
		query.append("     , GL.UPD_USR_ID    = GE.SRC_UPD_USR_ID" ).append("\n"); 
		query.append("     , GL.UPD_DT        = TO_DATE(GE.SRC_UPD_DT,'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("     , GL.ACCL_FLG      = DECODE(SIGN(GE.ACCL_AMT), -1, 'N', NULL) /*2016.09.07 minus amount N flag*/" ).append("\n"); 

	}
}