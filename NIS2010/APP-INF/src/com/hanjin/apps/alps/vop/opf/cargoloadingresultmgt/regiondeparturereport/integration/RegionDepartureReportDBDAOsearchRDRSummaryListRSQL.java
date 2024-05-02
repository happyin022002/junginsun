/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : RegionDepartureReportDBDAOsearchRDRSummaryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RegionDepartureReportDBDAOsearchRDRSummaryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RDR Summary 조회
	  * </pre>
	  */
	public RegionDepartureReportDBDAOsearchRDRSummaryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("region",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_week_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fr_week_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.integration").append("\n"); 
		query.append("FileName : RegionDepartureReportDBDAOsearchRDRSummaryListRSQL").append("\n"); 
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
		query.append(" VSL_CD" ).append("\n"); 
		query.append(",VOY_NO" ).append("\n"); 
		query.append(",DIR_CD" ).append("\n"); 
		query.append(",VVD" ).append("\n"); 
		query.append(",REGION" ).append("\n"); 
		query.append(",LANE" ).append("\n"); 
		query.append(",OPR_CD" ).append("\n"); 
		query.append(",TOT_ALLOC" ).append("\n"); 
		query.append(",TOT_WGT" ).append("\n"); 
		query.append(",TYPE" ).append("\n"); 
		query.append(",HC20_QTY" ).append("\n"); 
		query.append(",ADD_20" ).append("\n"); 
		query.append(",HC40_QTY" ).append("\n"); 
		query.append(",ADD_40" ).append("\n"); 
		query.append(",BSA_45" ).append("\n"); 
		query.append(",ADD_45" ).append("\n"); 
		query.append(",ADD_AKBB" ).append("\n"); 
		query.append(",POL" ).append("\n"); 
		query.append(",POD" ).append("\n"); 
		query.append(",VPS_DT" ).append("\n"); 
		query.append(",(SELECT PLN_YR||'-'||PLN_WK FROM EQR_WK_PRD WHERE VPS_DT_ORG BETWEEN TO_DATE(WK_ST_DT,'YYYYMMDD') AND TO_DATE(WK_END_DT,'YYYYMMDD')) WEEK_NO" ).append("\n"); 
		query.append(",F_20" ).append("\n"); 
		query.append(",F_2H" ).append("\n"); 
		query.append(",F_40" ).append("\n"); 
		query.append(",F_4H" ).append("\n"); 
		query.append(",F_45" ).append("\n"); 
		query.append(",F_20+F_2H+F_40+F_4H+F_45 F_QTY" ).append("\n"); 
		query.append(",F_20_W+F_2H_W+F_40_W+F_4H_W+F_45_W F_WEIGHT" ).append("\n"); 
		query.append(",E_20" ).append("\n"); 
		query.append(",E_2H" ).append("\n"); 
		query.append(",E_40" ).append("\n"); 
		query.append(",E_4H" ).append("\n"); 
		query.append(",E_45" ).append("\n"); 
		query.append(",E_20+E_2H+E_40+E_4H+E_45 E_QTY" ).append("\n"); 
		query.append(",E_20_W+E_2H_W+E_40_W+E_4H_W+E_45_W E_WEIGHT" ).append("\n"); 
		query.append(",F_20+F_2H+(F_40+F_4H+F_45)*2 F_TOTAL_TEU" ).append("\n"); 
		query.append(",E_20+E_2H+(E_40+E_4H+E_45)*2 E_TOTAL_TEU" ).append("\n"); 
		query.append(",ADD_20+ADD_40+ADD_45+ADD_AKBB DEAD_SLOT  --ADD SLOT" ).append("\n"); 
		query.append(",F_20+F_2H+(F_40+F_4H+F_45)*2 + E_20+E_2H+(E_40+E_4H+E_45)*2 + ADD_20+ADD_40+ADD_45+ADD_AKBB GRAND_TOTAL" ).append("\n"); 
		query.append(",F_20_W+F_2H_W+F_40_W+F_4H_W+F_45_W + E_20_W+E_2H_W+E_40_W+E_4H_W+E_45_W T_WEIGHT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("         A.VSL_CD,A.VOY_NO,A.DIR_CD" ).append("\n"); 
		query.append("		,A.VSL_CD||A.VOY_NO||A.DIR_CD VVD" ).append("\n"); 
		query.append("        ,A.REGION" ).append("\n"); 
		query.append("        ,F.SLAN_CD LANE" ).append("\n"); 
		query.append("        ,B.OPR_CD" ).append("\n"); 
		query.append("        ,MAX(NVL(B.BSA_SLOT,0)+NVL(B.RELEASE_SLOT,0)+NVL(B.SWAP_SLOT,0)) TOT_ALLOC" ).append("\n"); 
		query.append("        ,MAX(NVL(B.BSA_WGT,0)+NVL(B.RELEASE_WGT,0)+NVL(B.SWAP_WGT,0)) TOT_WGT" ).append("\n"); 
		query.append("        ,MAX(D.TYPE) TYPE" ).append("\n"); 
		query.append("        ,MAX(NVL(C.HC20_QTY, 0)) HC20_QTY  --(BSA)" ).append("\n"); 
		query.append("        ,MAX(DECODE(D.TYPE, '3', NVL(D.SLOT_QTY, 0), 0)) ADD_20   -- (ADD SLOT)" ).append("\n"); 
		query.append("        ,MAX(NVL(C.HC_QTY, 0)) HC40_QTY" ).append("\n"); 
		query.append("        ,MAX(DECODE(D.TYPE, 'H', NVL(D.SLOT_QTY, 0), 0)) ADD_40" ).append("\n"); 
		query.append("        ,MAX(NVL(C.QTY_45, 0)) BSA_45" ).append("\n"); 
		query.append("        ,MAX(DECODE(D.TYPE, 'L', NVL(D.SLOT_QTY, 0), 0)) ADD_45" ).append("\n"); 
		query.append("		,MAX(DECODE(D.TYPE, 'A', NVL(D.SLOT_QTY, 0), 0)) ADD_AKBB" ).append("\n"); 
		query.append("        ,E.POL" ).append("\n"); 
		query.append("        ,E.POD_ISO as POD" ).append("\n"); 
		query.append("        ,MAX(F.PF_ETD_DT) VPS_DT  --hidden" ).append("\n"); 
		query.append("		,MAX(G.PF_ETD_DT) VPS_DT_ORG" ).append("\n"); 
		query.append("--        ,E.CNTR_TYPE  --F/E" ).append("\n"); 
		query.append("--        ,E.CNTR_SIZE" ).append("\n"); 
		query.append("--        ,DECODE(E.CNTR_SIZE,'2','20','3','2H','4','40','H','4H','L','45') CNTR_SIZE" ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'F', DECODE(E.CNTR_SIZE,'2', NVL(E.QTY, 0), 0), 0)) F_20        " ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'F', DECODE(E.CNTR_SIZE,'3', NVL(E.QTY, 0), 0), 0)) F_2H" ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'F', DECODE(E.CNTR_SIZE,'4', NVL(E.QTY, 0), 0), 0)) F_40" ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'F', DECODE(E.CNTR_SIZE,'H', NVL(E.QTY, 0), 0), 0)) F_4H" ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'F', DECODE(E.CNTR_SIZE,'L', NVL(E.QTY, 0), 0), 0)) F_45        " ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'F', DECODE(E.CNTR_SIZE,'2', NVL(E.WEIGHT, 0), 0), 0)) F_20_W        " ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'F', DECODE(E.CNTR_SIZE,'3', NVL(E.WEIGHT, 0), 0), 0)) F_2H_W" ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'F', DECODE(E.CNTR_SIZE,'4', NVL(E.WEIGHT, 0), 0), 0)) F_40_W" ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'F', DECODE(E.CNTR_SIZE,'H', NVL(E.WEIGHT, 0), 0), 0)) F_4H_W" ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'F', DECODE(E.CNTR_SIZE,'L', NVL(E.WEIGHT, 0), 0), 0)) F_45_W        " ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'E', DECODE(E.CNTR_SIZE,'2', NVL(E.QTY, 0), 0), 0)) E_20        " ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'E', DECODE(E.CNTR_SIZE,'3', NVL(E.QTY, 0), 0), 0)) E_2H" ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'E', DECODE(E.CNTR_SIZE,'4', NVL(E.QTY, 0), 0), 0)) E_40" ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'E', DECODE(E.CNTR_SIZE,'H', NVL(E.QTY, 0), 0), 0)) E_4H" ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'E', DECODE(E.CNTR_SIZE,'L', NVL(E.QTY, 0), 0), 0)) E_45        " ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'E', DECODE(E.CNTR_SIZE,'2', NVL(E.WEIGHT, 0), 0), 0)) E_20_W        " ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'E', DECODE(E.CNTR_SIZE,'3', NVL(E.WEIGHT, 0), 0), 0)) E_2H_W" ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'E', DECODE(E.CNTR_SIZE,'4', NVL(E.WEIGHT, 0), 0), 0)) E_40_W" ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'E', DECODE(E.CNTR_SIZE,'H', NVL(E.WEIGHT, 0), 0), 0)) E_4H_W" ).append("\n"); 
		query.append("        ,MAX(DECODE(E.CNTR_TYPE,'E', DECODE(E.CNTR_SIZE,'L', NVL(E.WEIGHT, 0), 0), 0)) E_45_W      " ).append("\n"); 
		query.append("        FROM" ).append("\n"); 
		query.append("         RDR_HEADER A" ).append("\n"); 
		query.append("        ,RDR_ALLOCATION B" ).append("\n"); 
		query.append("        ,RDR_BSA C" ).append("\n"); 
		query.append("        ,RDR_UTILIZE D" ).append("\n"); 
		query.append("        ,RDR_SUMMARY E" ).append("\n"); 
		query.append("        ,VSK_VSL_PORT_SKD F " ).append("\n"); 
		query.append("	    ,(SELECT H.VSL_CD, H.VOY_NO, H.DIR_CD, H.REGION          -- Region의 마직 포트 PF ETD 가 VVD 선택의 기준" ).append("\n"); 
		query.append("					,F.PF_ETD_DT   " ).append("\n"); 
		query.append("            FROM RDR_HEADER H, " ).append("\n"); 
		query.append("           	     VSK_VSL_PORT_SKD F" ).append("\n"); 
		query.append("        	#if (${fr_week_no} != '' && ${to_week_no} != '')" ).append("\n"); 
		query.append("	        	 ,( " ).append("\n"); 
		query.append("	            	SELECT MIN(WK_ST_DT) WK_ST_DT, MAX(WK_END_DT) WK_END_DT" ).append("\n"); 
		query.append("		          	  FROM EQR_WK_PRD " ).append("\n"); 
		query.append("		             WHERE PLN_YR||PLN_WK >= @[fr_week_no]  --'201323'  " ).append("\n"); 
		query.append("		               AND PLN_YR||PLN_WK <= @[to_week_no]    --'201338'     " ).append("\n"); 
		query.append("	    	     ) G" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("   	   WHERE  1=1" ).append("\n"); 
		query.append("--	     AND H.VSL_CD  = 'HJUK'" ).append("\n"); 
		query.append("--	     AND H.VOY_NO  = '0010'" ).append("\n"); 
		query.append("--	     AND H.DIR_CD  = 'W'" ).append("\n"); 
		query.append("--	     AND H.REGION  = 'A'" ).append("\n"); 
		query.append("	     AND F.VSL_CD  = H.VSL_CD   " ).append("\n"); 
		query.append(" 	     AND F.SKD_VOY_NO = H.VOY_NO   " ).append("\n"); 
		query.append("	     AND F.SKD_DIR_CD = H.DIR_CD" ).append("\n"); 
		query.append("	     AND H.PORT_CD    = F.VPS_PORT_CD" ).append("\n"); 
		query.append("     #if (${vsl_cd} != '' && ${voy_no} != '' && ${dir_cd} != '')" ).append("\n"); 
		query.append("	     AND H.VSL_CD  = @[vsl_cd]  --'HNGE'  --'HJNL'" ).append("\n"); 
		query.append("   	     AND H.VOY_NO  = @[voy_no]  --'0014'" ).append("\n"); 
		query.append("         AND H.DIR_CD  = @[dir_cd]  -- 'W'" ).append("\n"); 
		query.append("	 #end " ).append("\n"); 
		query.append("	 #if (${vsl_cd} != '' && ${voy_no} == '' && ${dir_cd} == '')" ).append("\n"); 
		query.append("	     AND H.VSL_CD  = @[vsl_cd] " ).append("\n"); 
		query.append("	 #end " ).append("\n"); 
		query.append("	 #if (${region} != '')" ).append("\n"); 
		query.append("    	 AND H.REGION  = @[region]  --'M'" ).append("\n"); 
		query.append("	 #end        " ).append("\n"); 
		query.append("	 #if (${slan_cd} != '')" ).append("\n"); 
		query.append("         AND F.SLAN_CD = @[slan_cd]    --'PSX' " ).append("\n"); 
		query.append("	 #end" ).append("\n"); 
		query.append("	 #if (${fr_week_no} != '' && ${to_week_no} != '') " ).append("\n"); 
		query.append("	     AND F.PF_ETD_DT BETWEEN  TO_DATE(G.WK_ST_DT,'YYYY-MM-DD') AND TO_DATE(G.WK_END_DT,'YYYY-MM-DD')+1 " ).append("\n"); 
		query.append("  	 #elseif (${fr_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("   	     AND F.PF_ETD_DT BETWEEN  TO_DATE(@[fr_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD')+1" ).append("\n"); 
		query.append("         #end " ).append("\n"); 
		query.append("       ) G     " ).append("\n"); 
		query.append("        WHERE" ).append("\n"); 
		query.append("            A.VSL_CD    =   B.VSL_CD" ).append("\n"); 
		query.append("        AND A.VOY_NO    =   B.VOY_NO" ).append("\n"); 
		query.append("        AND A.DIR_CD    =   B.DIR_CD" ).append("\n"); 
		query.append("        AND A.REGION    =   B.REGION" ).append("\n"); 
		query.append("        AND B.VSL_CD    =   C.VSL_CD(+)" ).append("\n"); 
		query.append("        AND B.VOY_NO    =   C.VOY_NO(+)" ).append("\n"); 
		query.append("        AND B.DIR_CD    =   C.DIR_CD(+)" ).append("\n"); 
		query.append("        AND B.REGION    =   C.REGION(+)" ).append("\n"); 
		query.append("        AND B.OPR_CD    =   C.OPR_CD(+)" ).append("\n"); 
		query.append("        AND A.VSL_CD    =   D.VSL_CD(+)" ).append("\n"); 
		query.append("        AND A.VOY_NO    =   D.VOY_NO(+)" ).append("\n"); 
		query.append("        AND A.DIR_CD    =   D.DIR_CD(+)" ).append("\n"); 
		query.append("        AND A.REGION    =   D.REGION(+)" ).append("\n"); 
		query.append("        AND DECODE(D.OPR_CD, NULL, 'N', C.OPR_CD) = NVL(D.OPR_CD, 'N')    " ).append("\n"); 
		query.append("        AND A.VSL_CD    =   E.VSL_CD" ).append("\n"); 
		query.append("        AND A.VOY_NO    =   E.VOY_NO" ).append("\n"); 
		query.append("        AND A.DIR_CD    =   E.DIR_CD" ).append("\n"); 
		query.append("        AND A.REGION    =   E.REGION" ).append("\n"); 
		query.append("        AND A.VSL_CD    =   G.VSL_CD" ).append("\n"); 
		query.append("        AND A.VOY_NO    =   G.VOY_NO" ).append("\n"); 
		query.append("        AND A.DIR_CD    =   G.DIR_CD" ).append("\n"); 
		query.append("        AND A.REGION    =   G.REGION        " ).append("\n"); 
		query.append("        AND F.VSL_CD       = A.VSL_CD   " ).append("\n"); 
		query.append("        AND F.SKD_VOY_NO   = A.VOY_NO   " ).append("\n"); 
		query.append("        AND F.SKD_DIR_CD   = A.DIR_CD   " ).append("\n"); 
		query.append("        AND F.VPS_PORT_CD  = E.POD_ISO " ).append("\n"); 
		query.append("        AND B.OPR_CD    =   E.OPR_CD               " ).append("\n"); 
		query.append("--        AND D.TYPE      IN  ('3','H','L')   -- HC20, HC40, 45" ).append("\n"); 
		query.append("        #if (${vsl_cd} != '' && ${voy_no} != '' && ${dir_cd} != '')" ).append("\n"); 
		query.append("	        AND A.VSL_CD  = @[vsl_cd]  --'HNGE'  --'HJNL'" ).append("\n"); 
		query.append("    	    	AND A.VOY_NO  = @[voy_no]  --'0014'" ).append("\n"); 
		query.append("        	AND A.DIR_CD  = @[dir_cd]  -- 'W'" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("        #if (${vsl_cd} != '' && ${voy_no} == '' && ${dir_cd} == '')" ).append("\n"); 
		query.append("        	AND A.VSL_CD  = @[vsl_cd] " ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("        #if (${region} != '')" ).append("\n"); 
		query.append("    	    AND A.REGION  = @[region]  --'M'" ).append("\n"); 
		query.append("        #end " ).append("\n"); 
		query.append("        -- AND B.OPR_CD  =     " ).append("\n"); 
		query.append("        #if (${slan_cd} != '')" ).append("\n"); 
		query.append("	        AND F.SLAN_CD = @[slan_cd]    --'PSX' " ).append("\n"); 
		query.append("        #end       " ).append("\n"); 
		query.append("        GROUP BY A.VSL_CD,A.VOY_NO,A.DIR_CD,A.REGION,F.SLAN_CD,B.OPR_CD,E.POL,E.POD_ISO,F.CLPT_SEQ" ).append("\n"); 
		query.append("        ORDER BY A.VSL_CD,A.VOY_NO,A.DIR_CD,A.REGION,F.SLAN_CD,B.OPR_CD,E.POL,F.CLPT_SEQ" ).append("\n"); 
		query.append(") AA" ).append("\n"); 
		query.append("ORDER BY WEEK_NO,VSL_CD,VOY_NO,DIR_CD,REGION,LANE, OPR_CD,POL" ).append("\n"); 

	}
}