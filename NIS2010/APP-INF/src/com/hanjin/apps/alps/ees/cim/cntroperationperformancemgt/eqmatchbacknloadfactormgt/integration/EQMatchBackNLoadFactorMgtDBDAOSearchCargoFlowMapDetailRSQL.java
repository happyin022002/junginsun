/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapDetailRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.01
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2014.12.01 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapDetailRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCargoFlowMapDetail
	  * </pre>
	  */
	public EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapDetailRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("toz",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_sz_loc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.integration").append("\n"); 
		query.append("FileName : EQMatchBackNLoadFactorMgtDBDAOSearchCargoFlowMapDetailRSQL").append("\n"); 
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
		query.append("      B.CNTR_NO" ).append("\n"); 
		query.append("	 ,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("     ,C.LSTM_CD" ).append("\n"); 
		query.append("     ,B.MVMT_STS_CD" ).append("\n"); 
		query.append("     ,TO_CHAR(B.CNMV_EVNT_DT2,'YYYY-MM-DD HH24:MI:SS') AS CNMV_EVNT_DT" ).append("\n"); 
		query.append("     ,B.ORG_YD_CD" ).append("\n"); 
		query.append("     ,B.BKG_NO" ).append("\n"); 
		query.append("     ,B.POR_CD" ).append("\n"); 
		query.append("     ,B.POL_CD" ).append("\n"); 
		query.append("     ,B.POD_CD" ).append("\n"); 
		query.append("     ,B.DEL_CD" ).append("\n"); 
		query.append("     ,TO_CHAR(B.POD_ETA_DT,'YYYY-MM-DD HH24:MI:SS') AS ETA_DT" ).append("\n"); 
		query.append("     ,B.CRNT_VSL_CD||B.CRNT_SKD_VOY_NO||B.CRNT_SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	    SELECT " ).append("\n"); 
		query.append("	     A.CNTR_NO" ).append("\n"); 
		query.append("	    ,A.TGT_MVMT_DT" ).append("\n"); 
		query.append("	    FROM CIM_BKG_MTCH_BAK A" ).append("\n"); 
		query.append("	    ,(    " ).append("\n"); 
		query.append("		    SELECT L1.LOC_CD" ).append("\n"); 
		query.append("		    FROM MDM_LOCATION    L1" ).append("\n"); 
		query.append("			    ,MDM_EQ_ORZ_CHT  O1" ).append("\n"); 
		query.append("		    WHERE 1=1" ).append("\n"); 
		query.append("		    AND L1.SCC_CD = O1.SCC_CD" ).append("\n"); 
		query.append("/* FROM LOC */" ).append("\n"); 
		query.append("#if (${inquiryWise1} == 'R')" ).append("\n"); 
		query.append("			AND O1.RCC_CD = @[from_loc]" ).append("\n"); 
		query.append("#elseif (${inquiryWise1} == 'L')" ).append("\n"); 
		query.append("			AND O1.LCC_CD = @[from_loc]" ).append("\n"); 
		query.append("#elseif (${inquiryWise1} == 'E')" ).append("\n"); 
		query.append("			AND O1.ECC_CD = @[from_loc]" ).append("\n"); 
		query.append("#elseif (${inquiryWise1} == 'S')" ).append("\n"); 
		query.append("			AND O1.SCC_CD = @[from_loc]" ).append("\n"); 
		query.append("#elseif (${inquiryWise1} == 'C')" ).append("\n"); 
		query.append("			AND SUBSTR(O1.SCC_CD,1,2) = @[from_loc]" ).append("\n"); 
		query.append("#elseif (${inquiryWise1} == 'P')" ).append("\n"); 
		query.append("			AND L1.LOC_CD = @[from_loc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	    ) O1," ).append("\n"); 
		query.append("	    (" ).append("\n"); 
		query.append("    	    SELECT L2.LOC_CD" ).append("\n"); 
		query.append("	        FROM MDM_LOCATION   L2" ).append("\n"); 
		query.append("	    	    ,MDM_EQ_ORZ_CHT O2" ).append("\n"); 
		query.append("	        WHERE 1=1" ).append("\n"); 
		query.append("	        AND L2.SCC_CD = O2.SCC_CD" ).append("\n"); 
		query.append("/* TO LOC */" ).append("\n"); 
		query.append("#if (${inquiryWise2} == 'R')" ).append("\n"); 
		query.append("			AND O2.RCC_CD = @[to_loc]" ).append("\n"); 
		query.append("#elseif (${inquiryWise2} == 'L')" ).append("\n"); 
		query.append("			AND O2.LCC_CD = @[to_loc]" ).append("\n"); 
		query.append("#elseif (${inquiryWise2} == 'E')" ).append("\n"); 
		query.append("			AND O2.ECC_CD = @[to_loc]" ).append("\n"); 
		query.append("#elseif (${inquiryWise2} == 'S')" ).append("\n"); 
		query.append("			AND O2.SCC_CD = @[to_loc]" ).append("\n"); 
		query.append("#elseif (${inquiryWise2} == 'C')" ).append("\n"); 
		query.append("			AND SUBSTR(O2.SCC_CD,1,2) = @[to_loc]" ).append("\n"); 
		query.append("#elseif (${inquiryWise2} == 'P')" ).append("\n"); 
		query.append("			AND L2.LOC_CD = @[to_loc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	    ) O2" ).append("\n"); 
		query.append("	    WHERE 1=1" ).append("\n"); 
		query.append("#if (${period} == 'W')" ).append("\n"); 
		query.append("	    AND A.TGT_YRWK BETWEEN @[fromz] AND @[toz]   " ).append("\n"); 
		query.append("#elseif (${period} == 'M')" ).append("\n"); 
		query.append("        AND A.TGT_MVMT_DT BETWEEN @[fromz] AND @[toz]	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${inquiryWise1} == 'P')" ).append("\n"); 
		query.append("	  	AND A.CNTR_PERF_LOC_DIV_CD = 'POL'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("      	AND A.CNTR_PERF_LOC_DIV_CD = 'POR'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("/* TYPE SIZE */" ).append("\n"); 
		query.append("      	AND A.CNTR_TPSZ_CD = @[tp_sz_loc]" ).append("\n"); 
		query.append("/* soc */" ).append("\n"); 
		query.append("#if (${soc} == 'E')" ).append("\n"); 
		query.append("	  	AND  A.SOC_FLG  = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${soc} == 'O')" ).append("\n"); 
		query.append("	  	AND  A.SOC_FLG  = 'Y'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("    	AND A.LOC_CD = O1.LOC_CD" ).append("\n"); 
		query.append("	    AND A.TO_LOC_CD = O2.LOC_CD" ).append("\n"); 
		query.append("	) A" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("         SELECT " ).append("\n"); 
		query.append("              B.CNTR_NO" ).append("\n"); 
		query.append("             ,B.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("             ,B.MVMT_STS_CD" ).append("\n"); 
		query.append("             ,B.CNMV_EVNT_DT CNMV_EVNT_DT2" ).append("\n"); 
		query.append("             ,B.ORG_YD_CD" ).append("\n"); 
		query.append("             ,B.BKG_NO" ).append("\n"); 
		query.append("             ,D.POR_CD" ).append("\n"); 
		query.append("             ,D.POL_CD" ).append("\n"); 
		query.append("             ,D.POD_CD" ).append("\n"); 
		query.append("             ,D.DEL_CD" ).append("\n"); 
		query.append("             ,D.POD_ETA_DT " ).append("\n"); 
		query.append("             ,B.CRNT_VSL_CD" ).append("\n"); 
		query.append("             ,B.CRNT_SKD_VOY_NO" ).append("\n"); 
		query.append("             ,B.CRNT_SKD_DIR_CD" ).append("\n"); 
		query.append("             ,TO_CHAR(B.CNMV_EVNT_DT, 'YYYYMMDD') AS CNMV_EVNT_DT" ).append("\n"); 
		query.append("         FROM" ).append("\n"); 
		query.append("             CTM_MOVEMENT     B" ).append("\n"); 
		query.append("            ,BKG_BOOKING      D            " ).append("\n"); 
		query.append("         WHERE 1=1" ).append("\n"); 
		query.append("         AND B.MVMT_STS_CD = 'VL'" ).append("\n"); 
		query.append("         AND B.BKG_NO = D.BKG_NO         " ).append("\n"); 
		query.append("     ) B   " ).append("\n"); 
		query.append("    ,MST_CONTAINER    C     " ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("AND A.CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("AND A.TGT_MVMT_DT = B.CNMV_EVNT_DT" ).append("\n"); 

	}
}