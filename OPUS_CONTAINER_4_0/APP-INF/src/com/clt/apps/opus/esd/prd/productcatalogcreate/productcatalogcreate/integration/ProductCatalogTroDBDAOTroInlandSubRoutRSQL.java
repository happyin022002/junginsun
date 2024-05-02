/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ProductCatalogTroDBDAOTroInlandSubRoutRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogTroDBDAOTroInlandSubRoutRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TroInlandSubRout
	  * </pre>
	  */
	public ProductCatalogTroDBDAOTroInlandSubRoutRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogTroDBDAOTroInlandSubRoutRSQL").append("\n"); 
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
		query.append("WITH ROUT AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT RK,RK2,FM_NOD_CD,TO_NOD_CD,MODE_CD," ).append("\n"); 
		query.append("           COMB_MOD,COST_ACT_SEQ," ).append("\n"); 
		query.append("           LAG_NOD,LAG_COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("           (CASE WHEN RK2 = 1 AND LAG_NOD = FM_NOD_CD AND LAG_COST_ACT_GRP_SEQ IS NOT NULL  " ).append("\n"); 
		query.append("                  THEN -1" ).append("\n"); 
		query.append("                 ELSE 0" ).append("\n"); 
		query.append("           END) LAG_SEQ" ).append("\n"); 
		query.append("                        " ).append("\n"); 
		query.append("    FROM (       " ).append("\n"); 
		query.append("        SELECT DENSE_RANK() OVER (ORDER BY COST_ACT_GRP_SEQ,SEQ) RK," ).append("\n"); 
		query.append("               DENSE_RANK() OVER (PARTITION BY COST_ACT_GRP_SEQ ORDER BY SEQ) RK2," ).append("\n"); 
		query.append("               FM_NOD_CD,TO_NOD_CD,MODE_CD," ).append("\n"); 
		query.append("               COMB_MOD,COST_ACT_GRP_SEQ COST_ACT_SEQ," ).append("\n"); 
		query.append("               LAG(TO_NOD_CD,1) OVER( ORDER BY COST_ACT_GRP_SEQ, SEQ) LAG_NOD," ).append("\n"); 
		query.append("               LAG(COST_ACT_GRP_SEQ,1) OVER (ORDER BY COST_ACT_GRP_SEQ,SEQ) LAG_COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT SEQ,FM_NOD_CD,TO_NOD_CD,MODE_CD," ).append("\n"); 
		query.append("                  COMB_MOD,COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("            FROM (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                (                                                                                                " ).append("\n"); 
		query.append("                CASE F_N0                                                                                        " ).append("\n"); 
		query.append("                    WHEN 0 THEN '1'    WHEN 1 THEN '2'  " ).append("\n"); 
		query.append("                    ELSE 'N/A'                                                                                   " ).append("\n"); 
		query.append("                END                                                                                              " ).append("\n"); 
		query.append("                ) SEQ," ).append("\n"); 
		query.append("                (                                                                                                " ).append("\n"); 
		query.append("                CASE F_N0                                                                                        " ).append("\n"); 
		query.append("                    WHEN 0 THEN SUBSTR(ROUT,1,7)    WHEN 1 THEN SUBSTR(ROUT,16,7)  " ).append("\n"); 
		query.append("                    ELSE 'N/A'                                                                                   " ).append("\n"); 
		query.append("                END                                                                                              " ).append("\n"); 
		query.append("                ) FM_NOD_CD," ).append("\n"); 
		query.append("                (                                                                                                " ).append("\n"); 
		query.append("                CASE F_N0                                                                                        " ).append("\n"); 
		query.append("                    WHEN 0 THEN SUBSTR(ROUT,16,7)    WHEN 1 THEN SUBSTR(ROUT,31,7)  " ).append("\n"); 
		query.append("                    ELSE 'N/A'                                                                                   " ).append("\n"); 
		query.append("                END                                                                                              " ).append("\n"); 
		query.append("                ) TO_NOD_CD," ).append("\n"); 
		query.append("                (                                                                                                " ).append("\n"); 
		query.append("                CASE F_N0                                                                                        " ).append("\n"); 
		query.append("                    WHEN 0 THEN SUBSTR(ROUT,8,2)    WHEN 1 THEN SUBSTR(ROUT,23,2)  " ).append("\n"); 
		query.append("                    ELSE 'N/A'                                                                                   " ).append("\n"); 
		query.append("                END                                                                                              " ).append("\n"); 
		query.append("                ) MODE_CD," ).append("\n"); 
		query.append("                (                                                                                                " ).append("\n"); 
		query.append("                CASE WHEN LENGTH(ROUT) > 22  THEN 'Y' " ).append("\n"); 
		query.append("                    ELSE 'N'                                                                                  " ).append("\n"); 
		query.append("                END                                                                                              " ).append("\n"); 
		query.append("                ) COMB_MOD," ).append("\n"); 
		query.append("                TRSP_BND_CD," ).append("\n"); 
		query.append("                COST_ACT_GRP_SEQ  " ).append("\n"); 
		query.append("                FROM " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                SELECT " ).append("\n"); 
		query.append("                (CASE " ).append("\n"); 
		query.append("                    WHEN TRSP_BND_CD = 'O' AND TRIM(DOR_NOD_CD) IS NOT NULL" ).append("\n"); 
		query.append("                           THEN DECODE(TRSP_BND_CD,'O',TRIM(DOR_NOD_CD),TRIM(VIA_NOD_CD))||DECODE(DECODE(TRSP_BND_CD,'O',TRIM(DOR_NOD_CD),TRIM(VIA_NOD_CD)),NULL,NULL,DECODE(TRSP_BND_CD,'O',SUBSTR(TRSP_CRR_MOD_CD,1,1)||'D',DECODE(SUBSTR(TRSP_CRR_MOD_CD,2,1),'D',TRSP_CRR_MOD_CD,SUBSTR(TRSP_CRR_MOD_CD,2,1)||'D')))||" ).append("\n"); 
		query.append("                                  DECODE(DECODE(TRSP_BND_CD,'O',TRIM(DOR_NOD_CD),TRIM(VIA_NOD_CD)),NULL,NULL,LPAD(VNDR_SEQ,6,0))||" ).append("\n"); 
		query.append("                                DECODE(TRSP_BND_CD,'O',TRIM(VIA_NOD_CD),TRIM(DOR_NOD_CD))||DECODE(DECODE(TRSP_BND_CD,'O',TRIM(VIA_NOD_CD),TRIM(DOR_NOD_CD)),NULL,NULL,DECODE(SUBSTR(TRSP_CRR_MOD_CD,2,1),'D',TRSP_CRR_MOD_CD,SUBSTR(TRSP_CRR_MOD_CD,2,1)||'D'))||" ).append("\n"); 
		query.append("                                  DECODE(DECODE(TRSP_BND_CD,'O',TRIM(VIA_NOD_CD),TRIM(DOR_NOD_CD)),NULL,NULL,LPAD(VNDR_SEQ,6,0))||TO_NOD_CD" ).append("\n"); 
		query.append("                      WHEN TRSP_BND_CD = 'I' AND TRIM(DOR_NOD_CD) IS NOT NULL" ).append("\n"); 
		query.append("                           THEN FM_NOD_CD||SUBSTR(TRSP_CRR_MOD_CD,1,1)||'D'||LPAD(VNDR_SEQ,6,0)||" ).append("\n"); 
		query.append("                                DECODE(TRSP_BND_CD,'O',TRIM(DOR_NOD_CD),TRIM(VIA_NOD_CD))||DECODE(DECODE(TRSP_BND_CD,'O',TRIM(DOR_NOD_CD),TRIM(VIA_NOD_CD)),NULL,NULL,DECODE(TRSP_BND_CD,'O',SUBSTR(TRSP_CRR_MOD_CD,1,1)||'D',DECODE(SUBSTR(TRSP_CRR_MOD_CD,2,1),'D',TRSP_CRR_MOD_CD,SUBSTR(TRSP_CRR_MOD_CD,2,1)||'D')))||" ).append("\n"); 
		query.append("                                  DECODE(DECODE(TRSP_BND_CD,'O',TRIM(DOR_NOD_CD),TRIM(VIA_NOD_CD)),NULL,NULL,LPAD(VNDR_SEQ,6,0))||" ).append("\n"); 
		query.append("                                DECODE(TRSP_BND_CD,'O',TRIM(VIA_NOD_CD),TRIM(DOR_NOD_CD))" ).append("\n"); 
		query.append("                           ELSE  " ).append("\n"); 
		query.append("                                FM_NOD_CD||SUBSTR(TRSP_CRR_MOD_CD,1,1)||'D'||LPAD(VNDR_SEQ,6,0)||" ).append("\n"); 
		query.append("                                DECODE(TRSP_BND_CD,'O',TRIM(DOR_NOD_CD),TRIM(VIA_NOD_CD))||DECODE(DECODE(TRSP_BND_CD,'O',TRIM(DOR_NOD_CD),TRIM(VIA_NOD_CD)),NULL,NULL,DECODE(TRSP_BND_CD,'O',SUBSTR(TRSP_CRR_MOD_CD,1,1)||'D',DECODE(SUBSTR(TRSP_CRR_MOD_CD,2,1),'D',TRSP_CRR_MOD_CD,SUBSTR(TRSP_CRR_MOD_CD,2,1)||'D')))||" ).append("\n"); 
		query.append("                                  DECODE(DECODE(TRSP_BND_CD,'O',TRIM(DOR_NOD_CD),TRIM(VIA_NOD_CD)),NULL,NULL,LPAD(VNDR_SEQ,6,0))||" ).append("\n"); 
		query.append("                                DECODE(TRSP_BND_CD,'O',TRIM(VIA_NOD_CD),TRIM(DOR_NOD_CD))||DECODE(DECODE(TRSP_BND_CD,'O',TRIM(VIA_NOD_CD),TRIM(DOR_NOD_CD)),NULL,NULL,DECODE(SUBSTR(TRSP_CRR_MOD_CD,2,1),'D',TRSP_CRR_MOD_CD,SUBSTR(TRSP_CRR_MOD_CD,2,1)||'D'))||" ).append("\n"); 
		query.append("                                  DECODE(DECODE(TRSP_BND_CD,'O',TRIM(VIA_NOD_CD),TRIM(DOR_NOD_CD)),NULL,NULL,LPAD(VNDR_SEQ,6,0))||TO_NOD_CD " ).append("\n"); 
		query.append("                END) " ).append("\n"); 
		query.append("                ROUT ," ).append("\n"); 
		query.append("                TRSP_BND_CD," ).append("\n"); 
		query.append("                COST_ACT_GRP_SEQ                      " ).append("\n"); 
		query.append("                FROM TRS_TRSP_SVC_ORD                                                                                                         " ).append("\n"); 
		query.append("                WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("                AND TRSP_BND_CD = @[io_bnd_cd] " ).append("\n"); 
		query.append("                AND TRSP_SO_TP_CD <> 'S'" ).append("\n"); 
		query.append("                AND NVL(DELT_FLG,'N') <> 'Y' " ).append("\n"); 
		query.append("                 ) SVC_ORD,                                                                                               " ).append("\n"); 
		query.append("                (                                                                                                " ).append("\n"); 
		query.append("                    SELECT CPY_NO F_N0 FROM COM_CPY_NO WHERE CPY_NO <=1                                 " ).append("\n"); 
		query.append("                ) ORDER BY 1" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            WHERE TO_NOD_CD IS NOT NULL" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT /*+ RULE */ " ).append("\n"); 
		query.append("                TO_CHAR(B.SUB_RAIL_SEQ)," ).append("\n"); 
		query.append("                B.FM_NOD_CD," ).append("\n"); 
		query.append("                B.TO_NOD_CD," ).append("\n"); 
		query.append("                B.TRSP_MOD_CD," ).append("\n"); 
		query.append("                (CASE WHEN COUNT(B.SUB_RAIL_SEQ) OVER (PARTITION BY B.TRSP_SO_OFC_CTY_CD ,B.TRSP_SO_SEQ) > 1 --XXXXX" ).append("\n"); 
		query.append("                        THEN 'Y'" ).append("\n"); 
		query.append("                      ELSE  'N'" ).append("\n"); 
		query.append("                 END) COMB_MOD, " ).append("\n"); 
		query.append("                A.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append("            FROM TRS_TRSP_RAIL_BIL_ORD A , TRS_TRSP_RAIL_BIL_VNDR_SET B " ).append("\n"); 
		query.append("            WHERE A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD                                                                     " ).append("\n"); 
		query.append("            AND A.TRSP_SO_SEQ = B.TRSP_SO_SEQ                                                                               " ).append("\n"); 
		query.append("            AND A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("            AND A.TRSP_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("			AND NVL(A.TRSP_FRST_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("            AND NVL(A.DELT_FLG,'N') <> 'Y' " ).append("\n"); 
		query.append("            ORDER BY 6,1  " ).append("\n"); 
		query.append("        ) " ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT  " ).append("\n"); 
		query.append("REPLACE(  " ).append("\n"); 
		query.append("REPLACE(MAX(  " ).append("\n"); 
		query.append("               SYS_CONNECT_BY_PATH(  " ).append("\n"); 
		query.append("               DECODE(LAG_SEQ,-1,NULL,   " ).append("\n"); 
		query.append("                           DECODE(RK2,1,'%'||ROUT.FM_NOD_CD||DECODE(TO_NOD_CD,NULL,NULL,'@*'),NULL) " ).append("\n"); 
		query.append("                       	  )||  " ).append("\n"); 
		query.append("               ROUT.MODE_CD||DECODE(TO_NOD_CD,NULL,NULL,'@*')||  " ).append("\n"); 
		query.append("               ROUT.COMB_MOD||'@*'||LPAD(ROUT.COST_ACT_SEQ,3,'0')||DECODE(TO_NOD_CD,NULL,NULL,'@*')||" ).append("\n"); 
		query.append("               ROUT.TO_NOD_CD  " ).append("\n"); 
		query.append("               , '-')  " ).append("\n"); 
		query.append("               ),'@*','-')||'%'  " ).append("\n"); 
		query.append("        ,'-%','%') TS_STRING  " ).append("\n"); 
		query.append("FROM ROUT  " ).append("\n"); 
		query.append("START WITH ROUT.RK = 1  " ).append("\n"); 
		query.append("CONNECT BY PRIOR ROUT.RK   = ROUT.RK -1" ).append("\n"); 

	}
}