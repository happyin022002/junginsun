/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EQAvailabilityFinderDBDAOsearchAvailRepoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.15
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2015.07.15 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQAvailabilityFinderDBDAOsearchAvailRepoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MTY Reposition for EQ Availability
	  * </pre>
	  */
	public EQAvailabilityFinderDBDAOsearchAvailRepoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd5",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fcast_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_type_code",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.containersupplydemandforecast.eqavailabilityfinder.integration").append("\n"); 
		query.append("FileName : EQAvailabilityFinderDBDAOsearchAvailRepoListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	A.LVL   " ).append("\n"); 
		query.append("    ,A.IO_BND_CD" ).append("\n"); 
		query.append("    ,A.EQ_TRSP_MOD_CD" ).append("\n"); 
		query.append("    ,A.VVD" ).append("\n"); 
		query.append("    ,A.FM_YD_CD" ).append("\n"); 
		query.append("    ,A.ETD_DT" ).append("\n"); 
		query.append("    ,A.TO_YD_CD" ).append("\n"); 
		query.append("    ,A.ETB_DT" ).append("\n"); 
		query.append("    ,A.TOTAL" ).append("\n"); 
		query.append("    ,A.FCAST_QTY1" ).append("\n"); 
		query.append("    ,A.FCAST_QTY2" ).append("\n"); 
		query.append("    ,A.FCAST_QTY3" ).append("\n"); 
		query.append("    ,A.FCAST_QTY4" ).append("\n"); 
		query.append("    ,A.FCAST_QTY5" ).append("\n"); 
		query.append("    ,A.FCAST_QTY6" ).append("\n"); 
		query.append("    ,A.FCAST_QTY7" ).append("\n"); 
		query.append("    ,A.FCAST_QTY8" ).append("\n"); 
		query.append("    ,A.FCAST_QTY9" ).append("\n"); 
		query.append("    ,A.FCAST_QTY10" ).append("\n"); 
		query.append("    ,A.FCAST_QTY11" ).append("\n"); 
		query.append("    ,A.FCAST_QTY12" ).append("\n"); 
		query.append("    ,A.FCAST_QTY13" ).append("\n"); 
		query.append("    ,A.FCAST_QTY14" ).append("\n"); 
		query.append("    ,A.FCAST_QTY15" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT   A.LVL   " ).append("\n"); 
		query.append("	        ,A.IO_BND_CD" ).append("\n"); 
		query.append("	        ,DECODE(A.EQ_TRSP_MOD_CD,'V','T/D VVD','R','Rail','W','Water','T','Truck') EQ_TRSP_MOD_CD" ).append("\n"); 
		query.append("	        ,A.VVD" ).append("\n"); 
		query.append("	        ,A.FM_YD_CD" ).append("\n"); 
		query.append("	        ,A.ETD_DT" ).append("\n"); 
		query.append("	        ,A.TO_YD_CD" ).append("\n"); 
		query.append("	        ,A.ETB_DT" ).append("\n"); 
		query.append("	        ,A.FCAST_QTY1+A.FCAST_QTY2+A.FCAST_QTY3+A.FCAST_QTY4+A.FCAST_QTY5+A.FCAST_QTY6+A.FCAST_QTY7+A.FCAST_QTY8+A.FCAST_QTY9+A.FCAST_QTY10+A.FCAST_QTY11+A.FCAST_QTY12+A.FCAST_QTY13+A.FCAST_QTY14+A.FCAST_QTY15 TOTAL" ).append("\n"); 
		query.append("	        ,A.FCAST_QTY1" ).append("\n"); 
		query.append("	        ,A.FCAST_QTY2" ).append("\n"); 
		query.append("	        ,A.FCAST_QTY3" ).append("\n"); 
		query.append("	        ,A.FCAST_QTY4" ).append("\n"); 
		query.append("	        ,A.FCAST_QTY5" ).append("\n"); 
		query.append("	        ,A.FCAST_QTY6" ).append("\n"); 
		query.append("	        ,A.FCAST_QTY7" ).append("\n"); 
		query.append("	        ,A.FCAST_QTY8" ).append("\n"); 
		query.append("	        ,A.FCAST_QTY9" ).append("\n"); 
		query.append("	        ,A.FCAST_QTY10" ).append("\n"); 
		query.append("	        ,A.FCAST_QTY11" ).append("\n"); 
		query.append("	        ,A.FCAST_QTY12" ).append("\n"); 
		query.append("	        ,A.FCAST_QTY13" ).append("\n"); 
		query.append("	        ,A.FCAST_QTY14" ).append("\n"); 
		query.append("	        ,A.FCAST_QTY15" ).append("\n"); 
		query.append("	FROM(" ).append("\n"); 
		query.append("	    SELECT" ).append("\n"); 
		query.append("	             GROUPING(A.IO_BND_CD)||GROUPING(A.EQ_TRSP_MOD_CD)||GROUPING(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD)||GROUPING(A.FM_YD_CD)||GROUPING(TO_CHAR(A.ETD_DT,'YYYYMMDD'))||GROUPING(A.TO_YD_CD)||GROUPING(TO_CHAR(A.ETB_DT,'YYYYMMDD')) LVL" ).append("\n"); 
		query.append("	            ,A.IO_BND_CD" ).append("\n"); 
		query.append("	            ,A.EQ_TRSP_MOD_CD" ).append("\n"); 
		query.append("	            ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD" ).append("\n"); 
		query.append("	            ,A.FM_YD_CD" ).append("\n"); 
		query.append("	            ,TO_CHAR(A.ETD_DT,'YYYYMMDD') ETD_DT" ).append("\n"); 
		query.append("	            ,A.TO_YD_CD" ).append("\n"); 
		query.append("	            ,TO_CHAR(A.ETB_DT,'YYYYMMDD') ETB_DT" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd1]  ,A.FCAST_QTY,0))  FCAST_QTY1" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd2]  ,A.FCAST_QTY,0))  FCAST_QTY2" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd3]  ,A.FCAST_QTY,0))  FCAST_QTY3" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd4]  ,A.FCAST_QTY,0))  FCAST_QTY4" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd5]  ,A.FCAST_QTY,0))  FCAST_QTY5" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd6]  ,A.FCAST_QTY,0))  FCAST_QTY6" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd7]  ,A.FCAST_QTY,0))  FCAST_QTY7" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd8]  ,A.FCAST_QTY,0))  FCAST_QTY8" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd9]  ,A.FCAST_QTY,0))  FCAST_QTY9" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd10], A.FCAST_QTY,0))  FCAST_QTY10" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd11], A.FCAST_QTY,0))  FCAST_QTY11" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd12], A.FCAST_QTY,0))  FCAST_QTY12" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd13], A.FCAST_QTY,0))  FCAST_QTY13" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd14], A.FCAST_QTY,0))  FCAST_QTY14" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd15], A.FCAST_QTY,0))  FCAST_QTY15" ).append("\n"); 
		query.append("	    FROM  CIM_AVAL_REPO A,MDM_LOCATION B, MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("	    WHERE DECODE(A.IO_BND_CD,'I',SUBSTR(A.TO_YD_CD,1,5),SUBSTR(A.FM_YD_CD,1,5))=B.LOC_CD" ).append("\n"); 
		query.append("        AND B.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("#if (${loc_type_code} == 'S')" ).append("\n"); 
		query.append("    	AND D.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'E')" ).append("\n"); 
		query.append("	    AND D.ECC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'L')" ).append("\n"); 
		query.append("	    AND D.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'R')" ).append("\n"); 
		query.append("	    AND D.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'Y')" ).append("\n"); 
		query.append("        AND  DECODE(@[io_bnd_cd],'I',A.TO_YD_CD,A.FM_YD_CD)=@[loc_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	    AND D.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("        AND NVL(@[loc_type_code], 'X') = NVL(@[loc_type_code], 'X')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		#if (${io_bnd_cd} !='' )" ).append("\n"); 
		query.append("			AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${fcast_dt} !='' )" ).append("\n"); 
		query.append("			AND DECODE(@[io_bnd_cd],'I',TO_CHAR(A.ETB_DT,'YYYYMMDD'),TO_CHAR(A.ETD_DT,'YYYYMMDD')) = @[fcast_dt]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	    GROUP BY GROUPING SETS((A.IO_BND_CD,A.EQ_TRSP_MOD_CD,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD,A.FM_YD_CD,TO_CHAR(A.ETD_DT,'YYYYMMDD'),A.TO_YD_CD,TO_CHAR(A.ETB_DT,'YYYYMMDD'))," ).append("\n"); 
		query.append("	                           (A.IO_BND_CD))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    UNION ALL" ).append("\n"); 
		query.append("	    SELECT" ).append("\n"); 
		query.append("	             '1111111' LVL" ).append("\n"); 
		query.append("	            ,''IO_BND_CD" ).append("\n"); 
		query.append("	            ,'' EQ_TRSP_MOD_CD" ).append("\n"); 
		query.append("	            ,'' VVD" ).append("\n"); 
		query.append("	            ,'' FM_YD_CD" ).append("\n"); 
		query.append("	            ,'' ETD_DT" ).append("\n"); 
		query.append("	            ,'' TO_YD_CD" ).append("\n"); 
		query.append("	            ,'' ETB_DT" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.IO_BND_CD,'I',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd1]  ,A.FCAST_QTY,0),0)) - SUM(DECODE(A.IO_BND_CD,'O',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd1]  ,A.FCAST_QTY,0),0)) FCAST_QTY1 " ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.IO_BND_CD,'I',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd2]  ,A.FCAST_QTY,0),0)) - SUM(DECODE(A.IO_BND_CD,'O',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd2]  ,A.FCAST_QTY,0),0)) FCAST_QTY2 " ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.IO_BND_CD,'I',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd3]  ,A.FCAST_QTY,0),0)) - SUM(DECODE(A.IO_BND_CD,'O',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd3]  ,A.FCAST_QTY,0),0)) FCAST_QTY3 " ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.IO_BND_CD,'I',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd4]  ,A.FCAST_QTY,0),0)) - SUM(DECODE(A.IO_BND_CD,'O',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd4]  ,A.FCAST_QTY,0),0)) FCAST_QTY4 " ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.IO_BND_CD,'I',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd5]  ,A.FCAST_QTY,0),0)) - SUM(DECODE(A.IO_BND_CD,'O',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd5]  ,A.FCAST_QTY,0),0)) FCAST_QTY5 " ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.IO_BND_CD,'I',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd6]  ,A.FCAST_QTY,0),0)) - SUM(DECODE(A.IO_BND_CD,'O',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd6]  ,A.FCAST_QTY,0),0)) FCAST_QTY6 " ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.IO_BND_CD,'I',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd7]  ,A.FCAST_QTY,0),0)) - SUM(DECODE(A.IO_BND_CD,'O',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd7]  ,A.FCAST_QTY,0),0)) FCAST_QTY7 " ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.IO_BND_CD,'I',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd8]  ,A.FCAST_QTY,0),0)) - SUM(DECODE(A.IO_BND_CD,'O',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd8]  ,A.FCAST_QTY,0),0)) FCAST_QTY8 " ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.IO_BND_CD,'I',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd9]  ,A.FCAST_QTY,0),0)) - SUM(DECODE(A.IO_BND_CD,'O',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd9]  ,A.FCAST_QTY,0),0)) FCAST_QTY9 " ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.IO_BND_CD,'I',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd10] ,A.FCAST_QTY,0),0)) - SUM(DECODE(A.IO_BND_CD,'O',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd10] ,A.FCAST_QTY,0),0)) FCAST_QTY10" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.IO_BND_CD,'I',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd11] ,A.FCAST_QTY,0),0)) - SUM(DECODE(A.IO_BND_CD,'O',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd11] ,A.FCAST_QTY,0),0)) FCAST_QTY11" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.IO_BND_CD,'I',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd12] ,A.FCAST_QTY,0),0)) - SUM(DECODE(A.IO_BND_CD,'O',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd12] ,A.FCAST_QTY,0),0)) FCAST_QTY12" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.IO_BND_CD,'I',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd13] ,A.FCAST_QTY,0),0)) - SUM(DECODE(A.IO_BND_CD,'O',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd13] ,A.FCAST_QTY,0),0)) FCAST_QTY13" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.IO_BND_CD,'I',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd14] ,A.FCAST_QTY,0),0)) - SUM(DECODE(A.IO_BND_CD,'O',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd14] ,A.FCAST_QTY,0),0)) FCAST_QTY14" ).append("\n"); 
		query.append("	            ,SUM(DECODE(A.IO_BND_CD,'I',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd15] ,A.FCAST_QTY,0),0)) - SUM(DECODE(A.IO_BND_CD,'O',DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd15] ,A.FCAST_QTY,0),0)) FCAST_QTY15" ).append("\n"); 
		query.append("	    FROM  CIM_AVAL_REPO A,MDM_LOCATION B, MDM_EQ_ORZ_CHT D" ).append("\n"); 
		query.append("	    WHERE DECODE(A.IO_BND_CD,'I',SUBSTR(A.TO_YD_CD,1,5),SUBSTR(A.FM_YD_CD,1,5))=B.LOC_CD" ).append("\n"); 
		query.append("        AND  B.SCC_CD = D.SCC_CD" ).append("\n"); 
		query.append("#if (${loc_type_code} == 'S')" ).append("\n"); 
		query.append("    	AND D.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'E')" ).append("\n"); 
		query.append("	    AND D.ECC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'L')" ).append("\n"); 
		query.append("	    AND D.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'R')" ).append("\n"); 
		query.append("	    AND D.RCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#elseif (${loc_type_code} == 'Y')" ).append("\n"); 
		query.append("        AND  DECODE(A.IO_BND_CD,'I',A.TO_YD_CD,A.FM_YD_CD)=@[loc_cd] --YARD " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	    AND D.SCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("        AND NVL(@[loc_type_code], 'X') = NVL(@[loc_type_code], 'X')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		AND A.IO_BND_CD = 'X'" ).append("\n"); 
		query.append("	    ) A" ).append("\n"); 
		query.append("	ORDER BY A.IO_BND_CD,DECODE(A.EQ_TRSP_MOD_CD,'V',1,'T',2,'R',3,'W',4),  DECODE(A.IO_BND_CD,'I',A.ETB_DT,'O',A.ETD_DT)" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE A.TOTAL <> 0" ).append("\n"); 

	}
}