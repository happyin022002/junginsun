/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AvgAgencyCommissionDBDAOMergeAvgAgencyCommissionCountryListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AvgAgencyCommissionDBDAOMergeAvgAgencyCommissionCountryListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * .
	  * </pre>
	  */
	public AvgAgencyCommissionDBDAOMergeAvgAgencyCommissionCountryListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_stnd_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("comm_ut_amt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("comm_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.avgagncommission.integration ").append("\n"); 
		query.append("FileName : AvgAgencyCommissionDBDAOMergeAvgAgencyCommissionCountryListCSQL").append("\n"); 
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
		query.append("MERGE INTO ACM_COMM_CNT_UT_COST A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT '1' FROM DUAL " ).append("\n"); 
		query.append("	  ) A2	" ).append("\n"); 
		query.append("ON (   A.COMM_YRMON         = @[comm_yrmon]" ).append("\n"); 
		query.append("   AND A.CNT_CD             = @[cnt_cd]" ).append("\n"); 
		query.append("   AND A.IO_BND_CD          = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND A.AC_TP_CD           = @[ac_tp_cd]" ).append("\n"); 
		query.append("   AND A.CNTR_TPSZ_CD       = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("   AND A.COMM_STND_COST_CD  = @[comm_stnd_cost_cd]" ).append("\n"); 
		query.append("   AND A.TRD_CD             = @[trd_cd]" ).append("\n"); 
		query.append("   AND A.SUB_TRD_CD         = @[sub_trd_cd])	" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("     UPDATE " ).append("\n"); 
		query.append("        SET A.BKG_QTY       = @[bkg_qty] " ).append("\n"); 
		query.append("          , A.COMM_TTL_AMT  = @[comm_ttl_amt] " ).append("\n"); 
		query.append("          , A.COMM_UT_AMT   = @[comm_ut_amt] " ).append("\n"); 
		query.append("          , A.UPD_USR_ID    = @[cre_usr_id] " ).append("\n"); 
		query.append("          , A.UPD_DT        = SYSDATE    " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("		   A.COMM_YRMON" ).append("\n"); 
		query.append("         , A.CNT_CD" ).append("\n"); 
		query.append("         , A.IO_BND_CD" ).append("\n"); 
		query.append("         , A.AC_TP_CD" ).append("\n"); 
		query.append("         , A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("         , A.COMM_STND_COST_CD" ).append("\n"); 
		query.append("         , A.TRD_CD" ).append("\n"); 
		query.append("         , A.SUB_TRD_CD" ).append("\n"); 
		query.append("         , A.BKG_QTY" ).append("\n"); 
		query.append("         , A.COMM_TTL_AMT" ).append("\n"); 
		query.append("         , A.COMM_UT_AMT" ).append("\n"); 
		query.append("         , A.CRE_USR_ID" ).append("\n"); 
		query.append("         , A.CRE_DT" ).append("\n"); 
		query.append("         , A.UPD_USR_ID" ).append("\n"); 
		query.append("         , A.UPD_DT" ).append("\n"); 
		query.append("	    ) VALUES (" ).append("\n"); 
		query.append("          @[comm_yrmon]" ).append("\n"); 
		query.append("        , @[cnt_cd]" ).append("\n"); 
		query.append("        , @[io_bnd_cd]" ).append("\n"); 
		query.append("        , @[ac_tp_cd]" ).append("\n"); 
		query.append("        , @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("        , @[comm_stnd_cost_cd]" ).append("\n"); 
		query.append("        , @[trd_cd]" ).append("\n"); 
		query.append("        , @[sub_trd_cd]" ).append("\n"); 
		query.append("        , @[bkg_qty]" ).append("\n"); 
		query.append("        , @[comm_ttl_amt]" ).append("\n"); 
		query.append("        , @[comm_ut_amt]" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , @[cre_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE )" ).append("\n"); 

	}
}