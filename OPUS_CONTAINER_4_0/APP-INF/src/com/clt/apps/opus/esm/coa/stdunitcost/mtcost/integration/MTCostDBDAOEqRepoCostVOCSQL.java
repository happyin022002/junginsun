/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MTCostDBDAOEqRepoCostVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MTCostDBDAOEqRepoCostVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * @20140923.SJH : COA_MTY_REPO_UT_COST 테이블의 데이터 삽입
	  * </pre>
	  */
	public MTCostDBDAOEqRepoCostVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_io_vol_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_fm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_cost_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_mty_amt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_mty_amt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_src_to_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_src_fm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_ib_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_imbal_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_ob_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_mty_amt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ib_mty_amt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_to_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_loc_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.mtcost.integration").append("\n"); 
		query.append("FileName : MTCostDBDAOEqRepoCostVOCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_MTY_REPO_UT_COST B1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT '1' FROM DUAL " ).append("\n"); 
		query.append("	  ) B2	" ).append("\n"); 
		query.append("ON (     B1.COST_LOC_GRP_CD     = @[cost_loc_grp_cd]   " ).append("\n"); 
		query.append("     AND B1.CNTR_TPSZ_CD        = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("     AND B1.TRD_CD 			    = @[trd_cd]		" ).append("\n"); 
		query.append("	 AND B1.SCC_CD              = @[scc_cd]" ).append("\n"); 
		query.append("     AND B1.EFF_FM_YRMON        = @[eff_fm_yrmon]) " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("      UPDATE " ).append("\n"); 
		query.append("         SET EFF_TO_YRMON       = @[eff_to_yrmon]" ).append("\n"); 
		query.append("			,IB_MTY_AMT1		= @[ib_mty_amt1]" ).append("\n"); 
		query.append("			,OB_MTY_AMT1		= @[ob_mty_amt1]" ).append("\n"); 
		query.append("			,IB_MTY_AMT2		= @[ib_mty_amt2]" ).append("\n"); 
		query.append("			,OB_MTY_AMT2		= @[ob_mty_amt2]" ).append("\n"); 
		query.append("			,CNTR_IO_VOL_STS_CD	= @[cntr_io_vol_sts_cd]" ).append("\n"); 
		query.append("			,CNTR_IMBAL_RTO		= @[cntr_imbal_rto]" ).append("\n"); 
		query.append("			,CNTR_IB_QTY		= @[cntr_ib_qty]" ).append("\n"); 
		query.append("			,CNTR_OB_QTY		= @[cntr_ob_qty]" ).append("\n"); 
		query.append("			,MTY_COST_TP_NM		= @[mty_cost_tp_nm]" ).append("\n"); 
		query.append("			,COST_SRC_FM_YRMON	= @[cost_src_fm_yrmon]" ).append("\n"); 
		query.append("			,COST_SRC_TO_YRMON	= @[cost_src_to_yrmon]" ).append("\n"); 
		query.append("            ,BAT_FLG            = DECODE(@[cost_loc_grp_cd],'E','Y',NULL)	--SJH.20141127.MOD" ).append("\n"); 
		query.append("            ,UPD_USR_ID         = @[upd_usr_id]" ).append("\n"); 
		query.append("            ,UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("      INSERT (COST_LOC_GRP_CD" ).append("\n"); 
		query.append("             ,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             ,TRD_CD" ).append("\n"); 
		query.append("             ,SCC_CD" ).append("\n"); 
		query.append("             ,EFF_FM_YRMON" ).append("\n"); 
		query.append("             ,EFF_TO_YRMON" ).append("\n"); 
		query.append("			 ,IB_MTY_AMT1" ).append("\n"); 
		query.append("			 ,OB_MTY_AMT1	" ).append("\n"); 
		query.append("			 ,IB_MTY_AMT2" ).append("\n"); 
		query.append("			 ,OB_MTY_AMT2" ).append("\n"); 
		query.append("			 ,CNTR_IO_VOL_STS_CD" ).append("\n"); 
		query.append("			 ,CNTR_IMBAL_RTO" ).append("\n"); 
		query.append("			 ,CNTR_IB_QTY" ).append("\n"); 
		query.append("			 ,CNTR_OB_QTY" ).append("\n"); 
		query.append("			 ,MTY_COST_TP_NM" ).append("\n"); 
		query.append("			 ,COST_SRC_FM_YRMON" ).append("\n"); 
		query.append("			 ,COST_SRC_TO_YRMON" ).append("\n"); 
		query.append("             ,BAT_FLG" ).append("\n"); 
		query.append("             ,CRE_USR_ID" ).append("\n"); 
		query.append("             ,CRE_DT" ).append("\n"); 
		query.append("             ,UPD_USR_ID" ).append("\n"); 
		query.append("             ,UPD_DT" ).append("\n"); 
		query.append("             ) " ).append("\n"); 
		query.append("      VALUES (@[cost_loc_grp_cd]" ).append("\n"); 
		query.append("             ,@[cntr_tpsz_cd]" ).append("\n"); 
		query.append("             ,@[trd_cd]             " ).append("\n"); 
		query.append("             ,@[scc_cd]" ).append("\n"); 
		query.append("             ,@[eff_fm_yrmon]" ).append("\n"); 
		query.append("             ,@[eff_to_yrmon]" ).append("\n"); 
		query.append("             ,@[ib_mty_amt1]" ).append("\n"); 
		query.append("             ,@[ob_mty_amt1]" ).append("\n"); 
		query.append("             ,@[ib_mty_amt2]" ).append("\n"); 
		query.append("             ,@[ob_mty_amt2]" ).append("\n"); 
		query.append("             ,@[cntr_io_vol_sts_cd]" ).append("\n"); 
		query.append("             ,@[cntr_imbal_rto]" ).append("\n"); 
		query.append("             ,@[cntr_ib_qty]" ).append("\n"); 
		query.append("             ,@[cntr_ob_qty]" ).append("\n"); 
		query.append("             ,@[mty_cost_tp_nm]" ).append("\n"); 
		query.append("             ,@[cost_src_fm_yrmon]" ).append("\n"); 
		query.append("             ,@[cost_src_to_yrmon]" ).append("\n"); 
		query.append("             ,DECODE(@[cost_loc_grp_cd],'E','Y',NULL)	--SJH.20141127.MOD" ).append("\n"); 
		query.append("             ,@[cre_usr_id]" ).append("\n"); 
		query.append("             ,SYSDATE" ).append("\n"); 
		query.append("             ,@[upd_usr_id]" ).append("\n"); 
		query.append("             ,SYSDATE)" ).append("\n"); 

	}
}