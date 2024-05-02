/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CostStructureDBDAOMultiCostStructure0137CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostStructureDBDAOMultiCostStructure0137CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * NODE, LINK 단가 INSERT/UPDATE   
	  * </pre>
	  */
	public CostStructureDBDAOMultiCostStructure0137CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_vol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_cost_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_act_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_fx_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("nod_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("coa_cost_src_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_mty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lnk_to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.coststructure.integration").append("\n"); 
		query.append("FileName : CostStructureDBDAOMultiCostStructure0137CSQL").append("\n"); 
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
		query.append("#if (${f_table_name} != 'COA_NOD_AVG_STND_COST') " ).append("\n"); 
		query.append("MERGE INTO COA_LNK_AVG_STND_COST B1						" ).append("\n"); 
		query.append("USING ( SELECT @[cost_yrmon]  COST_YRMON" ).append("\n"); 
		query.append("              ,@[lnk_fm_nod_cd]  LNK_FM_NOD_CD" ).append("\n"); 
		query.append("              ,@[lnk_to_nod_cd]  LNK_TO_NOD_CD" ).append("\n"); 
		query.append("              ,'N'  CO_CD" ).append("\n"); 
		query.append("              ,@[cntr_tpsz_cd]  CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,@[full_mty_cd]  FULL_MTY_CD" ).append("\n"); 
		query.append("              ,@[coa_cost_src_cd]  COA_COST_SRC_CD" ).append("\n"); 
		query.append("              ,@[cost_loc_grp_cd]  COST_LOC_GRP_CD" ).append("\n"); 
		query.append("              ,@[locl_curr_cd]  LOCL_CURR_CD" ).append("\n"); 
		query.append("              ,@[stnd_cost_usd_amt]  STND_COST_USD_AMT" ).append("\n"); 
		query.append("              ,@[lnk_ttl_qty]  LNK_TTL_QTY" ).append("\n"); 
		query.append("              ,@[lnk_ttl_amt]  LNK_TTL_AMT" ).append("\n"); 
		query.append("              ,@[cost_vol_cd]  COST_VOL_CD" ).append("\n"); 
		query.append("              ,@[upd_usr_id]  UPD_USR_ID" ).append("\n"); 
		query.append("              ,DECODE(@[cost_fx_flg], '1', 'Y', 'Y', 'Y', 'N')  COST_FX_FLG		--SJH.20150205.MOD" ).append("\n"); 
		query.append("          FROM DUAL  ) B2							" ).append("\n"); 
		query.append("ON ( B1.COST_YRMON            = B2.COST_YRMON" ).append("\n"); 
		query.append("  AND  B1.LNK_FM_NOD_CD       = B2.LNK_FM_NOD_CD" ).append("\n"); 
		query.append("  AND  B1.LNK_TO_NOD_CD       = B2.LNK_TO_NOD_CD" ).append("\n"); 
		query.append("  AND  B1.CO_CD               = B2.CO_CD" ).append("\n"); 
		query.append("  AND  B1.CNTR_TPSZ_CD        = B2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("  AND  B1.FULL_MTY_CD         = B2.FULL_MTY_CD" ).append("\n"); 
		query.append("  AND  B1.COA_COST_SRC_CD     = B2.COA_COST_SRC_CD" ).append("\n"); 
		query.append("  AND  B1.COST_LOC_GRP_CD     = B2.COST_LOC_GRP_CD)						" ).append("\n"); 
		query.append("WHEN MATCHED THEN											" ).append("\n"); 
		query.append("    UPDATE SET   B1.LOCL_CURR_CD       = B2.LOCL_CURR_CD" ).append("\n"); 
		query.append("                ,B1.STND_COST_USD_AMT  = B2.STND_COST_USD_AMT" ).append("\n"); 
		query.append("                ,B1.LNK_TTL_QTY        = B2.LNK_TTL_QTY" ).append("\n"); 
		query.append("                ,B1.LNK_TTL_AMT        = B2.LNK_TTL_AMT" ).append("\n"); 
		query.append("                ,B1.COST_VOL_CD        = B2.COST_VOL_CD" ).append("\n"); 
		query.append("                ,B1.UPD_USR_ID         = B2.UPD_USR_ID" ).append("\n"); 
		query.append("                ,B1.UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("                ,B1.COST_FX_FLG        = B2.COST_FX_FLG" ).append("\n"); 
		query.append("                ,B1.COST_CALC_RMK      = B1.COST_CALC_RMK||'>amt:'||B2.STND_COST_USD_AMT||',FX:'||B2.COST_FX_FLG" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN										" ).append("\n"); 
		query.append("    INSERT													" ).append("\n"); 
		query.append("    (COST_YRMON    , LNK_FM_NOD_CD, LNK_TO_NOD_CD    , CO_CD      , CNTR_TPSZ_CD, FULL_MTY_CD, COA_COST_SRC_CD,	" ).append("\n"); 
		query.append("    COST_LOC_GRP_CD, LOCL_CURR_CD , STND_COST_USD_AMT, LNK_TTL_QTY, LNK_TTL_AMT , COST_VOL_CD,						" ).append("\n"); 
		query.append("    CRE_USR_ID     , CRE_DT       , UPD_USR_ID       , UPD_DT	 , COST_FX_FLG , B1.COST_CALC_RMK)" ).append("\n"); 
		query.append("    VALUES																											" ).append("\n"); 
		query.append("    (B2.COST_YRMON    , B2.LNK_FM_NOD_CD, B2.LNK_TO_NOD_CD    , B2.CO_CD      , B2.CNTR_TPSZ_CD, B2.FULL_MTY_CD, B2.COA_COST_SRC_CD,	" ).append("\n"); 
		query.append("    B2.COST_LOC_GRP_CD, B2.LOCL_CURR_CD , B2.STND_COST_USD_AMT, B2.LNK_TTL_QTY, B2.LNK_TTL_AMT , B2.COST_VOL_CD,						" ).append("\n"); 
		query.append("    B2.UPD_USR_ID     , SYSDATE         , B2.UPD_USR_ID       , SYSDATE       , B2.COST_FX_FLG , " ).append("\n"); 
		query.append("    '>AMT'||B2.STND_COST_USD_AMT||',FX'||B2.COST_FX_FLG) " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("MERGE INTO COA_NOD_AVG_STND_COST B1							" ).append("\n"); 
		query.append("USING ( SELECT @[cost_yrmon]  COST_YRMON" ).append("\n"); 
		query.append("              ,@[full_mty_cd]  FULL_MTY_CD" ).append("\n"); 
		query.append("              ,@[cntr_tpsz_cd]  CNTR_TPSZ_CD" ).append("\n"); 
		query.append("              ,@[cost_loc_grp_cd]  COST_LOC_GRP_CD" ).append("\n"); 
		query.append("              ,@[nod_cd]  NOD_CD" ).append("\n"); 
		query.append("              ,@[trd_cd]  TRD_CD" ).append("\n"); 
		query.append("              ,@[cost_act_grp_cd]  COST_ACT_GRP_CD" ).append("\n"); 
		query.append("              ,@[coa_cost_src_cd]  COA_COST_SRC_CD " ).append("\n"); 
		query.append("              ,@[locl_curr_cd]  LOCL_CURR_CD" ).append("\n"); 
		query.append("              ,@[stnd_cost_usd_amt]  STND_COST_USD_AMT" ).append("\n"); 
		query.append("              ,@[nod_ttl_qty]  NOD_TTL_QTY" ).append("\n"); 
		query.append("              ,@[nod_ttl_amt]  NOD_TTL_AMT" ).append("\n"); 
		query.append("              ,@[cost_vol_cd]  COST_VOL_CD" ).append("\n"); 
		query.append("              ,@[upd_usr_id]  UPD_USR_ID" ).append("\n"); 
		query.append("              ,DECODE(@[cost_fx_flg], '1', 'Y', 'Y', 'Y', 'N')  COST_FX_FLG 	--SJH.20150205.MOD" ).append("\n"); 
		query.append("          FROM DUAL ) B2" ).append("\n"); 
		query.append("ON (    B1.COST_YRMON       = B2.COST_YRMON" ).append("\n"); 
		query.append("    AND B1.FULL_MTY_CD      = B2.FULL_MTY_CD" ).append("\n"); 
		query.append("    AND B1.CNTR_TPSZ_CD     = B2.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    AND B1.COST_LOC_GRP_CD  = B2.COST_LOC_GRP_CD" ).append("\n"); 
		query.append("    AND B1.NOD_CD           = B2.NOD_CD" ).append("\n"); 
		query.append("    AND B1.TRD_CD           = B2.TRD_CD" ).append("\n"); 
		query.append("    AND B1.COST_ACT_GRP_CD  = B2.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("    AND B1.COA_COST_SRC_CD  = B2.COA_COST_SRC_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET   B1.LOCL_CURR_CD         = B2.LOCL_CURR_CD" ).append("\n"); 
		query.append("                ,B1.STND_COST_USD_AMT    = B2.STND_COST_USD_AMT" ).append("\n"); 
		query.append("                ,B1.NOD_TTL_QTY          = B2.NOD_TTL_QTY" ).append("\n"); 
		query.append("                ,B1.NOD_TTL_AMT          = B2.NOD_TTL_AMT" ).append("\n"); 
		query.append("                ,B1.COST_VOL_CD          = B2.COST_VOL_CD" ).append("\n"); 
		query.append("                ,B1.UPD_USR_ID           = B2.UPD_USR_ID" ).append("\n"); 
		query.append("                ,B1.UPD_DT               = SYSDATE" ).append("\n"); 
		query.append("                ,B1.COST_FX_FLG          = B2.COST_FX_FLG" ).append("\n"); 
		query.append("                ,B1.COST_CALC_RMK        = B1.COST_CALC_RMK||'>amt:'||B2.STND_COST_USD_AMT||',FX:'||B2.COST_FX_FLG" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT" ).append("\n"); 
		query.append("    (B1.COST_YRMON       , B1.FULL_MTY_CD, B1.CNTR_TPSZ_CD, B1.COST_LOC_GRP_CD, B1.NOD_CD    , B1.COA_COST_SRC_CD, B1.LOCL_CURR_CD," ).append("\n"); 
		query.append("     B1.STND_COST_USD_AMT, B1.NOD_TTL_QTY, B1.NOD_TTL_AMT , B1.COST_VOL_CD    , B1.CRE_USR_ID, B1.CRE_DT         , B1.UPD_USR_ID  , B1.UPD_DT," ).append("\n"); 
		query.append("	   B1.COST_FX_FLG      , B1.COST_CALC_RMK, B1.TRD_CD, B1.COST_ACT_GRP_CD)" ).append("\n"); 
		query.append("    VALUES" ).append("\n"); 
		query.append("    (B2.COST_YRMON       , B2.FULL_MTY_CD, B2.CNTR_TPSZ_CD, B2.COST_LOC_GRP_CD, B2.NOD_CD    , B2.COA_COST_SRC_CD, B2.LOCL_CURR_CD," ).append("\n"); 
		query.append("     B2.STND_COST_USD_AMT, B2.NOD_TTL_QTY, B2.NOD_TTL_AMT , B2.COST_VOL_CD    , B2.UPD_USR_ID, SYSDATE           , B2.UPD_USR_ID  , SYSDATE," ).append("\n"); 
		query.append("	   B2.COST_FX_FLG      , '>amt'||B2.STND_COST_USD_AMT||',fx'||B2.COST_FX_FLG, B2.TRD_CD, B2.COST_ACT_GRP_CD)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}