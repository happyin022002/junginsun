/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : WeeklyCMDBDAOAddUCbyCustomerListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.16
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WeeklyCMDBDAOAddUCbyCustomerListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Unit Cost by Customer (Door. CY Exception) - Add New
	  * </pre>
	  */
	public WeeklyCMDBDAOAddUCbyCustomerListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stnd_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rcv_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.integration").append("\n"); 
		query.append("FileName : WeeklyCMDBDAOAddUCbyCustomerListCSQL").append("\n"); 
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
		query.append("MERGE INTO MAS_CHSS_EXPT_CUST_LIST A" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT @[cost_yrmon] AS COST_YRMON, @[ctrt_no] AS CTRT_NO, @[scc_cd] AS SCC_CD" ).append("\n"); 
		query.append("            , (" ).append("\n"); 
		query.append("               SELECT NVL(MAX(CTRT_SEQ), 0) + 1 AS NEXT_CTRT_SEQ" ).append("\n"); 
		query.append("                 FROM MAS_CHSS_EXPT_CUST_LIST" ).append("\n"); 
		query.append("                WHERE COST_YRMON = @[cost_yrmon]" ).append("\n"); 
		query.append("                  AND CTRT_NO    = @[ctrt_no]" ).append("\n"); 
		query.append("                  AND SCC_CD     = @[scc_cd]" ).append("\n"); 
		query.append("              ) AS CTRT_SEQ" ).append("\n"); 
		query.append("            , TRIM(@[usa_io_bnd_cd]) AS USA_IO_BND_CD, TRIM(@[bkg_rcv_de_term_cd]) AS BKG_RCV_DE_TERM_CD" ).append("\n"); 
		query.append("            , @[stnd_uc_amt] AS STND_UC_AMT" ).append("\n"); 
		query.append("            , 'N' AS DELT_FLG" ).append("\n"); 
		query.append("            , @[upd_usr_id] AS CRE_USR_ID, SYSDATE AS CRE_DT" ).append("\n"); 
		query.append("            , @[upd_usr_id] AS UPD_USR_ID, SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("         FROM DUAL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("   ON (" ).append("\n"); 
		query.append("           A.COST_YRMON         = B.COST_YRMON        " ).append("\n"); 
		query.append("       AND A.CTRT_NO            = B.CTRT_NO             " ).append("\n"); 
		query.append("       AND A.SCC_CD             = B.SCC_CD            " ).append("\n"); 
		query.append("       AND A.USA_IO_BND_CD      = B.USA_IO_BND_CD     " ).append("\n"); 
		query.append("       AND A.BKG_RCV_DE_TERM_CD = B.BKG_RCV_DE_TERM_CD" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET" ).append("\n"); 
		query.append("		  A.STND_UC_AMT = B.STND_UC_AMT" ).append("\n"); 
		query.append("        , A.DELT_FLG    = 'N'" ).append("\n"); 
		query.append("		, A.UPD_USR_ID  = B.UPD_USR_ID" ).append("\n"); 
		query.append("        , A.UPD_DT      = B.UPD_DT" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT ( A.COST_YRMON, A.CTRT_NO, A.SCC_CD, A.CTRT_SEQ" ).append("\n"); 
		query.append("           , A.USA_IO_BND_CD, A.BKG_RCV_DE_TERM_CD, A.STND_UC_AMT" ).append("\n"); 
		query.append("           , A.DELT_FLG, A.CRE_USR_ID, A.CRE_DT, A.UPD_USR_ID, A.UPD_DT )" ).append("\n"); 
		query.append("    VALUES ( B.COST_YRMON, B.CTRT_NO, B.SCC_CD, B.CTRT_SEQ" ).append("\n"); 
		query.append("           , B.USA_IO_BND_CD, B.BKG_RCV_DE_TERM_CD, B.STND_UC_AMT" ).append("\n"); 
		query.append("           , B.DELT_FLG, B.CRE_USR_ID, B.CRE_DT, B.UPD_USR_ID, B.UPD_DT )" ).append("\n"); 

	}
}