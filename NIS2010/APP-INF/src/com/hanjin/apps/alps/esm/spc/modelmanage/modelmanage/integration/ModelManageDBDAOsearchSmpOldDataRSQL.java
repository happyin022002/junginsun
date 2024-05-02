/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ModelManageDBDAOsearchSmpOldDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ModelManageDBDAOsearchSmpOldDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SMP History를 위해 old 값을 조회합니다.
	  * [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
	  * 2014.02.04 [CHM-201428383-01] RFA 로직 추가
	  * 2014.05.16 [CHM-201430353] SMP / AES 보완요청 - SC 입력 기능 추가
	  * 2015.06.17 BKG 연동하는 부분에서 물량 비교시 Null이 들어와서 오류가 발생 따라서 NVL 처리를 해줌
	  * </pre>
	  */
	public ModelManageDBDAOsearchSmpOldDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g2_cng_usr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("strd_adj_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrwk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g3_cng_usr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_adj_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("unit",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_adj_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("g1_cng_usr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spc_ctrl_mdl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_ctrl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.integration").append("\n"); 
		query.append("FileName : ModelManageDBDAOsearchSmpOldDataRSQL").append("\n"); 
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
		query.append("--Null값비교" ).append("\n"); 
		query.append("SELECT A.TRD_CD" ).append("\n"); 
		query.append("      ,A.COST_YRWK" ).append("\n"); 
		query.append("      ,A.VER_SEQ" ).append("\n"); 
		query.append("      ,A.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,A.CUST_SEQ" ).append("\n"); 
		query.append("      ,A.CTRT_OFC_CD" ).append("\n"); 
		query.append("      ,A.SC_NO" ).append("\n"); 
		query.append("      ,A.RFA_NO" ).append("\n"); 
		query.append("      ,A.CUST_CTRL_CD" ).append("\n"); 
		query.append("      ,A.SUB_TRD_CD" ).append("\n"); 
		query.append("      ,A.SLS_RHQ_CD" ).append("\n"); 
		query.append("#if (${flg} == '1')" ).append("\n"); 
		query.append("      ,A.G1_CNG_USR" ).append("\n"); 
		query.append("      ,A.CUST_ADJ_QTY" ).append("\n"); 
		query.append("      ,B.OLD_CUST_ADJ_QTY" ).append("\n"); 
		query.append("#elseif (${flg} == '2') " ).append("\n"); 
		query.append("      ,A.G2_CNG_USR" ).append("\n"); 
		query.append("      ,A.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("      ,NVL(NVL(A.SUB_TRD_ADJ_QTY, B.OLD_SUB_TRD_ADJ_QTY),0) AS SUB_TRD_ADJ_QTY --RHQ SAVE시" ).append("\n"); 
		query.append("      ,NVL(B.OLD_SUB_TRD_ADJ_QTY,0) AS OLD_SUB_TRD_ADJ_QTY" ).append("\n"); 
		query.append("#elseif (${flg} == '3')" ).append("\n"); 
		query.append("      ,A.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A.G3_CNG_USR" ).append("\n"); 
		query.append("      ,A.RLANE_CD" ).append("\n"); 
		query.append("      ,A.RLANE_ADJ_QTY" ).append("\n"); 
		query.append("      ,B.OLD_RLANE_ADJ_QTY" ).append("\n"); 
		query.append("#elseif (${flg} == '4')" ).append("\n"); 
		query.append("      ,A.SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("      ,A.G3_CNG_USR" ).append("\n"); 
		query.append("      ,A.RLANE_CD" ).append("\n"); 
		query.append("      ,A.SPC_CTRL_MDL_RMK" ).append("\n"); 
		query.append("      ,B.OLD_SPC_CTRL_MDL_RMK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ,A.USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("  FROM (SELECT @[trd_cd]         AS TRD_CD" ).append("\n"); 
		query.append("              ,@[cost_yrwk]      AS COST_YRWK" ).append("\n"); 
		query.append("              ,@[ver_seq]        AS VER_SEQ" ).append("\n"); 
		query.append("              ,@[cust_cnt_cd]    AS CUST_CNT_CD" ).append("\n"); 
		query.append("              ,@[cust_seq]       AS CUST_SEQ" ).append("\n"); 
		query.append("              ,@[ctrt_ofc_cd]    AS CTRT_OFC_CD" ).append("\n"); 
		query.append("              ,@[sc_no]          AS SC_NO" ).append("\n"); 
		query.append("              ,@[rfa_no]         AS RFA_NO" ).append("\n"); 
		query.append("              ,@[cust_ctrl_cd]   AS CUST_CTRL_CD" ).append("\n"); 
		query.append("              ,@[sub_trd_cd]     AS SUB_TRD_CD" ).append("\n"); 
		query.append("              ,@[sls_rhq_cd]     AS SLS_RHQ_CD" ).append("\n"); 
		query.append("#if (${flg} != '1')" ).append("\n"); 
		query.append("              ,@[sls_rgn_ofc_cd] AS SLS_RGN_OFC_CD" ).append("\n"); 
		query.append("    #if (${flg} != '2')" ).append("\n"); 
		query.append("              ,@[rlane_cd]       AS RLANE_CD" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${flg} == '1')" ).append("\n"); 
		query.append("              ,@[g1_cng_usr] AS G1_CNG_USR" ).append("\n"); 
		query.append("              ,@[cust_adj_qty] * DECODE(@[unit], 'T', 1, 2) AS CUST_ADJ_QTY" ).append("\n"); 
		query.append("#elseif (${flg} == '2')" ).append("\n"); 
		query.append("              ,@[g2_cng_usr] AS G2_CNG_USR" ).append("\n"); 
		query.append("              ,@[strd_adj_qty] * DECODE(@[unit], 'T', 1, 2) AS SUB_TRD_ADJ_QTY" ).append("\n"); 
		query.append("#elseif (${flg} == '3')" ).append("\n"); 
		query.append("              ,@[g3_cng_usr] AS G3_CNG_USR" ).append("\n"); 
		query.append("              ,@[rlane_adj_qty] * DECODE(@[unit], 'T', 1, 2) AS RLANE_ADJ_QTY" ).append("\n"); 
		query.append("#elseif (${flg} == '4')" ).append("\n"); 
		query.append("              ,@[g3_cng_usr]       AS G3_CNG_USR" ).append("\n"); 
		query.append("              ,@[spc_ctrl_mdl_rmk] AS SPC_CTRL_MDL_RMK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ,@[usr_id]           AS USR_ID" ).append("\n"); 
		query.append("          FROM DUAL" ).append("\n"); 
		query.append("       ) A," ).append("\n"); 
		query.append("       (SELECT " ).append("\n"); 
		query.append("#if (${flg} == '1')" ).append("\n"); 
		query.append("               MAX(CUST_ADJ_QTY) AS OLD_CUST_ADJ_QTY" ).append("\n"); 
		query.append("#elseif (${flg} == '2')" ).append("\n"); 
		query.append("               MAX(SUB_TRD_ADJ_QTY) AS OLD_SUB_TRD_ADJ_QTY" ).append("\n"); 
		query.append("#elseif (${flg} == '3')" ).append("\n"); 
		query.append("               MAX(RLANE_ADJ_QTY) AS OLD_RLANE_ADJ_QTY" ).append("\n"); 
		query.append("#elseif (${flg} == '4')" ).append("\n"); 
		query.append("               MAX(SPC_CTRL_MDL_RMK) AS OLD_SPC_CTRL_MDL_RMK" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("          FROM SPC_MDL_CUST_REV_LANE" ).append("\n"); 
		query.append("         WHERE TRD_CD           = @[trd_cd]" ).append("\n"); 
		query.append("           AND COST_YRWK        = @[cost_yrwk]" ).append("\n"); 
		query.append("           AND VER_SEQ          = @[ver_seq]" ).append("\n"); 
		query.append("           AND CUST_CNT_CD      = @[cust_cnt_cd]" ).append("\n"); 
		query.append("           AND CUST_SEQ         = @[cust_seq]" ).append("\n"); 
		query.append("           AND NVL(SC_NO , ' ') = NVL(@[sc_no] , NVL(SC_NO, ' '))" ).append("\n"); 
		query.append("           AND NVL(RFA_NO, ' ') = NVL(@[rfa_no], ' ')" ).append("\n"); 
		query.append("           AND SUB_TRD_CD       = @[sub_trd_cd]" ).append("\n"); 
		query.append("           AND SLS_RHQ_CD       = @[sls_rhq_cd]" ).append("\n"); 
		query.append("     	   AND CTRT_OFC_CD      = @[ctrt_ofc_cd]" ).append("\n"); 
		query.append("#if (${flg} != '1') " ).append("\n"); 
		query.append("           AND SLS_RGN_OFC_CD   = @[sls_rgn_ofc_cd]" ).append("\n"); 
		query.append("    #if (${flg} != '2')" ).append("\n"); 
		query.append("           AND RLANE_CD         = @[rlane_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       ) B" ).append("\n"); 

	}
}