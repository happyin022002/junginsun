/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NetworkCostDBDAOMultiPortTariffCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.07.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOMultiPortTariffCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public NetworkCostDBDAOMultiPortTariffCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_cnl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_port_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("cy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
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
		params.put("upload_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_clss_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",Y";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_usd_amt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOMultiPortTariffCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_PORT_TRF B1 USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SELECT @[cost_yrmon]           COST_YRMON" ).append("\n"); 
		query.append("      , @[slan_cd]              SLAN_CD" ).append("\n"); 
		query.append("      , @[skd_dir_cd]           SKD_DIR_CD" ).append("\n"); 
		query.append("      , NVL(@[tml_cd], @[port]||@[cy]) TML_CD" ).append("\n"); 
		query.append("      , @[locl_curr_cd]         LOCL_CURR_CD" ).append("\n"); 
		query.append("      , @[locl_port_amt]        LOCL_PORT_AMT" ).append("\n"); 
		query.append("      , @[locl_cnl_amt]         LOCL_CNL_AMT" ).append("\n"); 
		query.append("      , DECODE(@[upload_flg], 'Y', MAX(ROUND(@[locl_port_amt]/USD_LOCL_XCH_RT,3)) KEEP(DENSE_RANK FIRST ORDER BY ACCT_XCH_RT_YRMON DESC)" ).append("\n"); 
		query.append("                            , @[port_usd_amt]) PORT_USD_AMT" ).append("\n"); 
		query.append("      , DECODE(@[upload_flg], 'Y', MAX(ROUND(@[locl_cnl_amt]/USD_LOCL_XCH_RT,3)) KEEP(DENSE_RANK FIRST ORDER BY ACCT_XCH_RT_YRMON DESC)" ).append("\n"); 
		query.append("                            , @[cnl_usd_amt]) CNL_USD_AMT" ).append("\n"); 
		query.append("      , @[cre_usr_id]           CRE_USR_ID" ).append("\n"); 
		query.append("      , @[upd_usr_id]           UPD_USR_ID" ).append("\n"); 
		query.append("      , @[vsl_clss_capa]        VSL_CLSS_CAPA  " ).append("\n"); 
		query.append("   FROM DUAL A" ).append("\n"); 
		query.append("      , GL_MON_XCH_RT B" ).append("\n"); 
		query.append("  WHERE B.ACCT_XCH_RT_YRMON BETWEEN TO_CHAR(ADD_MONTHS(TO_DATE(@[cost_yrmon],'YYYYMM'),-1),'YYYYMM') AND @[cost_yrmon]	" ).append("\n"); 
		query.append("    AND B.ACCT_XCH_RT_LVL   = '1' 		" ).append("\n"); 
		query.append("    AND B.CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("B2 ON (     B1.COST_YRMON       = B2.COST_YRMON " ).append("\n"); 
		query.append("        AND B1.SLAN_CD          = B2.SLAN_CD " ).append("\n"); 
		query.append("        AND B1.SKD_DIR_CD       = B2.SKD_DIR_CD " ).append("\n"); 
		query.append("        AND B1.VSL_CLSS_CAPA    = B2.VSL_CLSS_CAPA" ).append("\n"); 
		query.append("        AND B1.TML_CD           = B2.TML_CD" ).append("\n"); 
		query.append("        AND B1.LOCL_CURR_CD     = B2.LOCL_CURR_CD )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("         UPDATE" ).append("\n"); 
		query.append("            SET B1.LOCL_PORT_AMT= B2.LOCL_PORT_AMT" ).append("\n"); 
		query.append("              , B1.LOCL_CNL_AMT = B2.LOCL_CNL_AMT" ).append("\n"); 
		query.append("              , B1.PORT_USD_AMT = B2.PORT_USD_AMT" ).append("\n"); 
		query.append("              , B1.CNL_USD_AMT  = B2.CNL_USD_AMT" ).append("\n"); 
		query.append("              , B1.UPD_USR_ID   = B2.UPD_USR_ID" ).append("\n"); 
		query.append("              , B1.UPD_DT       = SYSDATE " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("         INSERT (" ).append("\n"); 
		query.append("                B1.COST_YRMON" ).append("\n"); 
		query.append("              , B1.SLAN_CD" ).append("\n"); 
		query.append("              , B1.SKD_DIR_CD" ).append("\n"); 
		query.append("              , B1.TML_CD" ).append("\n"); 
		query.append("              , B1.LOCL_CURR_CD" ).append("\n"); 
		query.append("              , B1.LOCL_PORT_AMT" ).append("\n"); 
		query.append("              , B1.LOCL_CNL_AMT" ).append("\n"); 
		query.append("              , B1.PORT_USD_AMT" ).append("\n"); 
		query.append("              , B1.CNL_USD_AMT" ).append("\n"); 
		query.append("              , B1.CRE_USR_ID" ).append("\n"); 
		query.append("              , B1.CRE_DT" ).append("\n"); 
		query.append("              , B1.UPD_USR_ID" ).append("\n"); 
		query.append("              , B1.UPD_DT" ).append("\n"); 
		query.append("              , B1.VSL_CLSS_CAPA )" ).append("\n"); 
		query.append("         VALUES (" ).append("\n"); 
		query.append("                B2.COST_YRMON" ).append("\n"); 
		query.append("              , B2.SLAN_CD" ).append("\n"); 
		query.append("              , B2.SKD_DIR_CD" ).append("\n"); 
		query.append("              , B2.TML_CD" ).append("\n"); 
		query.append("              , B2.LOCL_CURR_CD" ).append("\n"); 
		query.append("              , B2.LOCL_PORT_AMT" ).append("\n"); 
		query.append("              , B2.LOCL_CNL_AMT" ).append("\n"); 
		query.append("              , B2.PORT_USD_AMT" ).append("\n"); 
		query.append("              , B2.CNL_USD_AMT" ).append("\n"); 
		query.append("              , B2.CRE_USR_ID" ).append("\n"); 
		query.append("              , SYSDATE" ).append("\n"); 
		query.append("              , B2.UPD_USR_ID" ).append("\n"); 
		query.append("              , SYSDATE" ).append("\n"); 
		query.append("              , B2.VSL_CLSS_CAPA )" ).append("\n"); 

	}
}