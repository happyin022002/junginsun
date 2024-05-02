/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SalesRPTDBDAOSearchMonthlyAvgUC0057List2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRPTDBDAOSearchMonthlyAvgUC0057List2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Monthly Average U/C
	  * </pre>
	  */
	public SalesRPTDBDAOSearchMonthlyAvgUC0057List2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_tpsz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pro_vw",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_de_term",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rcv_term",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.integration").append("\n"); 
		query.append("FileName : SalesRPTDBDAOSearchMonthlyAvgUC0057List2RSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("   BKG_POR_CD " ).append("\n"); 
		query.append("  ,BKG_DEL_CD " ).append("\n"); 
		query.append("  ,N1ST_RLANE_CD " ).append("\n"); 
		query.append("  ,N1ST_POL_CD " ).append("\n"); 
		query.append("  ,N1ST_POD_CD " ).append("\n"); 
		query.append("  ,N2ND_RLANE_CD " ).append("\n"); 
		query.append("  ,N2ND_POL_CD " ).append("\n"); 
		query.append("  ,N2ND_POD_CD " ).append("\n"); 
		query.append("  ,N3RD_RLANE_CD " ).append("\n"); 
		query.append("  ,N3RD_POL_CD " ).append("\n"); 
		query.append("  ,N3RD_POD_CD " ).append("\n"); 
		query.append("  ,N4TH_RLANE_CD " ).append("\n"); 
		query.append("  ,N4TH_POL_CD " ).append("\n"); 
		query.append("  ,N4TH_POD_CD " ).append("\n"); 
		query.append("  ,TPSZ_CODE " ).append("\n"); 
		query.append("  ,LOAD " ).append("\n"); 
		query.append("  ,BKG_REV                           AS REV /* REV(BKG_REV+BKG_OFT_REV)*/" ).append("\n"); 
		query.append("  ,CM_COST                 AS CM_COST" ).append("\n"); 
		query.append("  ,BKG_REV+MISC_REV-CM_COST-DEM_DET          AS CM  /* REV(BKG_REV+BKG_OFT_REV+BKG_MISC_REV+SCR_CHG_REV)-CM_COST*/" ).append("\n"); 
		query.append("  ,OP_COST                           AS OP_COST" ).append("\n"); 
		query.append("  ,BKG_REV+MISC_REV-CM_COST-DEM_DET-OP_COST  AS OP" ).append("\n"); 
		query.append("FROM ( " ).append("\n"); 
		query.append("    SELECT 			" ).append("\n"); 
		query.append("         H.BKG_POR_CD " ).append("\n"); 
		query.append("        ,H.BKG_DEL_CD " ).append("\n"); 
		query.append("        ,H.N1ST_RLANE_CD " ).append("\n"); 
		query.append("        ,H.N1ST_POL_CD " ).append("\n"); 
		query.append("        ,H.N1ST_POD_CD " ).append("\n"); 
		query.append("        ,H.N2ND_RLANE_CD " ).append("\n"); 
		query.append("        ,H.N2ND_POL_CD " ).append("\n"); 
		query.append("        ,H.N2ND_POD_CD " ).append("\n"); 
		query.append("        ,H.N3RD_RLANE_CD " ).append("\n"); 
		query.append("        ,H.N3RD_POL_CD " ).append("\n"); 
		query.append("        ,H.N3RD_POD_CD " ).append("\n"); 
		query.append("        ,H.N4TH_RLANE_CD " ).append("\n"); 
		query.append("        ,H.N4TH_POL_CD " ).append("\n"); 
		query.append("        ,H.N4TH_POD_CD " ).append("\n"); 
		query.append("        ,H.SPCL_CNTR_TPSZ_CD TPSZ_CODE " ).append("\n"); 
		query.append("        ,SUM(NVL(H.BKG_QTY,0)) LOAD " ).append("\n"); 
		query.append("        ,SUM(NVL(H.BKG_REV,0)+NVL(H.BKG_OFT_REV,0)) BKG_REV  /* REV(BKG_REV+BKG_OFT_REV) */" ).append("\n"); 
		query.append("        ,SUM(NVL(H.BKG_MISC_REV,0)+NVL(H.SCR_CHG_REV,0)) MISC_REV" ).append("\n"); 
		query.append("        ,SUM(NVL(H.DMDT_COM_AMT,0)) DEM_DET" ).append("\n"); 
		query.append("        ,SUM(DECODE(@[f_pro_vw], 'P', NVL(H.PA_CM_COST_TTL_AMT, 0), 'R', NVL(H.RA_CM_COST_TTL_AMT, 0))) CM_COST " ).append("\n"); 
		query.append("        ,SUM(DECODE(@[f_pro_vw], 'P', NVL(A6.PA_OP_COST_TTL_AMT, 0) , 'R', 0)) OP_COST " ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("    	 MAS_BKG_EXPN_DTL H" ).append("\n"); 
		query.append("        ,MAS_BKG_OP_EXPN_DTL A6" ).append("\n"); 
		query.append("    WHERE  1=1       " ).append("\n"); 
		query.append("      AND H.COST_YRMON      = REPLACE(@[f_cost_yrmon], '-','')  " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      /* 이 쿼리문은 Kind 가 1일경우만 들어오기 때문에 이부분을 하지 않아도 된다.*/" ).append("\n"); 
		query.append("      #if (${f_kind} == '1')  /* from:pol, to:pod */" ).append("\n"); 
		query.append("        AND H.REV_POL_CD         = @[f_pol] " ).append("\n"); 
		query.append("        AND H.REV_POD_CD         = @[f_pod] " ).append("\n"); 
		query.append("        AND H.RLANE_CD           = @[f_rlane] " ).append("\n"); 
		query.append("        AND H.SPCL_CNTR_TPSZ_CD  = @[f_tpsz] " ).append("\n"); 
		query.append("      #else   /* from:Origin, to:Dest   from:por, to:del */" ).append("\n"); 
		query.append("        AND H.BKG_POR_CD         = @[f_from] " ).append("\n"); 
		query.append("        AND H.BKG_DEL_CD         = @[f_to] " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("        #if(${f_cntr_tpsz_cd}!='')  " ).append("\n"); 
		query.append("          AND H.SPCL_CNTR_TPSZ_CD  = @[f_cntr_tpsz_cd]  " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("      #if(${f_rcv_term}!='')   " ).append("\n"); 
		query.append("        AND H.BKG_RCV_TERM_CD = @[f_rcv_term] " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      #if(${f_de_term}!='')  " ).append("\n"); 
		query.append("        AND H.BKG_DE_TERM_CD  = @[f_de_term] " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("				          " ).append("\n"); 
		query.append("      AND H.DELT_FLG        <> 'Y' " ).append("\n"); 
		query.append("      AND H.BL_NO_TP        IN ('M','0') " ).append("\n"); 
		query.append("      AND H.BKG_STS_CD      IN ('F','S') " ).append("\n"); 
		query.append("      AND H.BKG_CGO_TP_CD   <> 'P' " ).append("\n"); 
		query.append("      AND H.BKG_NO         = A6.BKG_NO(+)" ).append("\n"); 
		query.append("      AND H.CNTR_TPSZ_CD   = A6.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("      AND H.COST_ROUT_NO   = A6.COST_ROUT_NO(+)" ).append("\n"); 
		query.append("    GROUP BY H.REV_POL_CD" ).append("\n"); 
		query.append("        ,H.BKG_POR_CD " ).append("\n"); 
		query.append("        ,H.BKG_DEL_CD " ).append("\n"); 
		query.append("        ,H.N1ST_RLANE_CD " ).append("\n"); 
		query.append("        ,H.N1ST_POL_CD " ).append("\n"); 
		query.append("        ,H.N1ST_POD_CD " ).append("\n"); 
		query.append("        ,H.N2ND_RLANE_CD " ).append("\n"); 
		query.append("        ,H.N2ND_POL_CD " ).append("\n"); 
		query.append("        ,H.N2ND_POD_CD " ).append("\n"); 
		query.append("        ,H.N3RD_RLANE_CD " ).append("\n"); 
		query.append("        ,H.N3RD_POL_CD " ).append("\n"); 
		query.append("        ,H.N3RD_POD_CD " ).append("\n"); 
		query.append("        ,H.N4TH_RLANE_CD " ).append("\n"); 
		query.append("        ,H.N4TH_POL_CD " ).append("\n"); 
		query.append("        ,H.N4TH_POD_CD " ).append("\n"); 
		query.append("        ,H.SPCL_CNTR_TPSZ_CD " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY BKG_POR_CD " ).append("\n"); 
		query.append("  ,BKG_DEL_CD " ).append("\n"); 
		query.append("  ,N1ST_RLANE_CD " ).append("\n"); 
		query.append("  ,N1ST_POL_CD " ).append("\n"); 
		query.append("  ,N1ST_POD_CD " ).append("\n"); 
		query.append("  ,N2ND_RLANE_CD " ).append("\n"); 
		query.append("  ,N2ND_POL_CD " ).append("\n"); 
		query.append("  ,N2ND_POD_CD " ).append("\n"); 
		query.append("  ,N3RD_RLANE_CD " ).append("\n"); 
		query.append("  ,N3RD_POL_CD " ).append("\n"); 
		query.append("  ,N3RD_POD_CD " ).append("\n"); 
		query.append("  ,N4TH_RLANE_CD " ).append("\n"); 
		query.append("  ,N4TH_POL_CD " ).append("\n"); 
		query.append("  ,N4TH_POD_CD " ).append("\n"); 
		query.append("  ,TPSZ_CODE" ).append("\n"); 

	}
}