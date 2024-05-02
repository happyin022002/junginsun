/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchOldBunkerCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2010.01.26 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchOldBunkerCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchOldBunkerCost
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchOldBunkerCostRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slt_prc_wrk_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_svc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchOldBunkerCostRSQL").append("\n"); 
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
		query.append("SELECT ROUND((VSL_CSL1+VSL_CSL2+VSL_CSL3)/CLS_CNT,1) AS TTL_AVG, VSL_CSL1,VSL_CSL2,VSL_CSL3" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("'' AS TTL_AVG,MAX(COL1) AS VSL_CSL1, MAX(COL2) AS VSL_CSL2, MAX(COL3) AS VSL_CSL3,MAX(ROWRN) AS CLS_CNT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.ROWRN,B.RN," ).append("\n"); 
		query.append("DECODE(A.ROWRN, 1 ," ).append("\n"); 
		query.append("DECODE(B.RN, 2,  MTX_FOIL_SEA_TTL_QTY ," ).append("\n"); 
		query.append("3,  MTX_FOIL_MNVR_TTL_QTY," ).append("\n"); 
		query.append("4,  MTX_FOIL_PORT_TTL_QTY," ).append("\n"); 
		query.append("5,  MTX_FOIL_TTL_QTY," ).append("\n"); 
		query.append("6,  BNK_EXPN_AMT," ).append("\n"); 
		query.append("1,  DECODE(A.ROWRN, 1, DLY_BNK_CSM_QTY))) COL1," ).append("\n"); 
		query.append("DECODE(A.ROWRN, 2," ).append("\n"); 
		query.append("DECODE(B.RN, 2,  MTX_FOIL_SEA_TTL_QTY," ).append("\n"); 
		query.append("3,  MTX_FOIL_MNVR_TTL_QTY," ).append("\n"); 
		query.append("4,  MTX_FOIL_PORT_TTL_QTY," ).append("\n"); 
		query.append("5,  MTX_FOIL_TTL_QTY," ).append("\n"); 
		query.append("6,  BNK_EXPN_AMT," ).append("\n"); 
		query.append("1,  DECODE(A.ROWRN, 2, DLY_BNK_CSM_QTY))) COL2," ).append("\n"); 
		query.append("DECODE(A.ROWRN, 3," ).append("\n"); 
		query.append("DECODE(B.RN, 2,  MTX_FOIL_SEA_TTL_QTY," ).append("\n"); 
		query.append("3,  MTX_FOIL_MNVR_TTL_QTY," ).append("\n"); 
		query.append("4,  MTX_FOIL_PORT_TTL_QTY," ).append("\n"); 
		query.append("5,  MTX_FOIL_TTL_QTY," ).append("\n"); 
		query.append("6,  BNK_EXPN_AMT," ).append("\n"); 
		query.append("1,  DECODE(A.ROWRN, 3, DLY_BNK_CSM_QTY))) COL3" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(   SELECT  ROW_NUMBER() OVER (ORDER BY VSL_CLSS_CD) ROWRN" ).append("\n"); 
		query.append(",VSL_SLAN_CD" ).append("\n"); 
		query.append(",PF_SVC_TP_CD" ).append("\n"); 
		query.append(",SLT_PRC_WRK_YR" ).append("\n"); 
		query.append(",BSE_QTR_CD" ).append("\n"); 
		query.append(",VSL_CLSS_CD" ).append("\n"); 
		query.append(",PE_AMT" ).append("\n"); 
		query.append(",CNTR_DZN_CAPA" ).append("\n"); 
		query.append(",DLY_BNK_CSM_QTY" ).append("\n"); 
		query.append(",MTX_FOIL_SEA_DY_QTY" ).append("\n"); 
		query.append(",MTX_FOIL_SEA_TTL_QTY" ).append("\n"); 
		query.append(",MTX_FOIL_MNVR_DY_QTY" ).append("\n"); 
		query.append(",MTX_FOIL_MNVR_TTL_QTY" ).append("\n"); 
		query.append(",MTX_FOIL_PORT_DY_QTY" ).append("\n"); 
		query.append(",MTX_FOIL_PORT_TTL_QTY" ).append("\n"); 
		query.append(",MTX_FOIL_TTL_QTY" ).append("\n"); 
		query.append(",BNK_EXPN_AMT" ).append("\n"); 
		query.append(",VSL_OWNR_FLG" ).append("\n"); 
		query.append(",OWNR_HIR_TEU_AMT" ).append("\n"); 
		query.append(",OWNR_HIR_TTL_AMT" ).append("\n"); 
		query.append(",CHRG_HIR_TEU_AMT" ).append("\n"); 
		query.append(",CHRG_HIR_TTL_AMT" ).append("\n"); 
		query.append(",SLT_PRC_TTL_AMT" ).append("\n"); 
		query.append(",SLT_PRC_RND_AMT" ).append("\n"); 
		query.append(",SLT_PRC_ONE_WY_AMT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",'' AS TTL_MFO" ).append("\n"); 
		query.append("FROM   VSK_SLT_PRC_DTL" ).append("\n"); 
		query.append("WHERE  VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("AND    PF_SVC_TP_CD = @[pf_svc_tp_cd]" ).append("\n"); 
		query.append("AND    SLT_PRC_WRK_YR = @[slt_prc_wrk_yr]" ).append("\n"); 
		query.append("AND    BSE_QTR_CD = @[bse_qtr_cd]" ).append("\n"); 
		query.append(") A, ( SELECT ROWNUM RN FROM DICT WHERE ROWNUM<=6) B" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY RN" ).append("\n"); 
		query.append("ORDER BY RN" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}