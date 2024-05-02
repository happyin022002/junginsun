/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOsearchStockCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.30
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CNTRInventoryReportDBDAOsearchStockCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 구주지역내 SCC 또는 Yard별 MT 재고를 컨테이너별로 조회한다.(팝업)
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOsearchStockCntrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd22",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd21",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd20",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd26",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd25",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd24",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd23",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_type_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd29",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd28",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd27",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd30",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lvl",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd17",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd16",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd19",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd18",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration").append("\n"); 
		query.append("FileName : CNTRInventoryReportDBDAOsearchStockCntrListRSQL").append("\n"); 
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
		query.append("         A.LOC_CD" ).append("\n"); 
		query.append("        ,A.CNTR_NO" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.DMG_FLG" ).append("\n"); 
		query.append("		,A.DMG_FLG_DT" ).append("\n"); 
		query.append("		,A.DMG_UNFLG_DT" ).append("\n"); 
		query.append("        ,A.LSTM_CD" ).append("\n"); 
		query.append("        ,A.BKG_NO" ).append("\n"); 
		query.append("        ,A.VVD" ).append("\n"); 
		query.append("        ,A.CNMV_DT" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        A.CRNT_YD_CD  LOC_CD" ).append("\n"); 
		query.append("        ,A.CNTR_NO" ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,A.DMG_FLG" ).append("\n"); 
		query.append("		,MST_COMMON_PKG.MST_DMG_DT_GET_FNC(A.CNTR_NO, 'FLG' ) AS DMG_FLG_DT" ).append("\n"); 
		query.append("		,MST_COMMON_PKG.MST_DMG_DT_GET_FNC(A.CNTR_NO, 'UNFLG' ) AS DMG_UNFLG_DT" ).append("\n"); 
		query.append("        ,A.LSTM_CD" ).append("\n"); 
		query.append("        ,A.BKG_NO" ).append("\n"); 
		query.append("        ,B.TRNK_VSL_CD||B.TRNK_SKD_VOY_NO||B.TRNK_SKD_DIR_CD VVD" ).append("\n"); 
		query.append("        ,TO_CHAR(A.CNMV_DT,'YYYY-MM-DD') CNMV_DT" ).append("\n"); 
		query.append("    FROM MST_CONTAINER A" ).append("\n"); 
		query.append("        ,CTM_MOVEMENT B" ).append("\n"); 
		query.append("	WHERE A.CNTR_NO =B.CNTR_NO" ).append("\n"); 
		query.append("	AND  A.CNMV_YR=B.CNMV_YR" ).append("\n"); 
		query.append("	AND A.CNMV_ID_NO=B.CNMV_ID_NO" ).append("\n"); 
		query.append("	AND DECODE(@[lvl],'10',  DECODE(@[loc_type_code],1,A.RCC_CD,2,A.LCC_CD,3,A.ECC_CD,4,A.SCC_CD),  DECODE(@[yard_cd],NULL,A.LOC_CD,A.CRNT_YD_CD)) = DECODE(@[yard_cd],NULL,@[loc_cd],@[yard_cd])" ).append("\n"); 
		query.append("    #if (${yard_cd} != '')" ).append("\n"); 
		query.append("        AND DECODE(@[loc_type_code],'4',A.CRNT_YD_CD,A.SCC_CD) = @[yard_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("    AND A.CNMV_STS_CD = 'MT'" ).append("\n"); 
		query.append("    #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    	AND A.CNTR_TPSZ_CD  =@[cntr_tpsz_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("		''" ).append("\n"); 
		query.append("     	,      SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd1] ,1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd2] ,1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd3] ,1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd4] ,1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd5] ,1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd6] ,1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd7] ,1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd8] ,1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd9] ,1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd10],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd11],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd12],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd13],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd14],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd15],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd16],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd17],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd18],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd19],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd20],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd21],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd22],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd23],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd24],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd25],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd26],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd27],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd28],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd29],1)) " ).append("\n"); 
		query.append("        ||'|'||SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd30],1)) " ).append("\n"); 
		query.append("        ,''" ).append("\n"); 
		query.append("		,''" ).append("\n"); 
		query.append("		,''" ).append("\n"); 
		query.append("        ,''" ).append("\n"); 
		query.append("        ,''" ).append("\n"); 
		query.append("        ,''" ).append("\n"); 
		query.append("        ,''" ).append("\n"); 
		query.append("        ,''" ).append("\n"); 
		query.append("    FROM MST_CONTAINER A" ).append("\n"); 
		query.append("	WHERE DECODE(@[lvl],'10',  DECODE(@[loc_type_code],1,A.RCC_CD,2,A.LCC_CD,3,A.ECC_CD,4,A.SCC_CD),  DECODE(@[yard_cd],NULL,A.LOC_CD,A.CRNT_YD_CD)) = DECODE(@[yard_cd],NULL,@[loc_cd],@[yard_cd])" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${yard_cd} != '')" ).append("\n"); 
		query.append("        AND DECODE(@[loc_type_code],'4',A.CRNT_YD_CD,A.SCC_CD) = @[yard_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("    AND A.CNMV_STS_CD = 'MT'" ).append("\n"); 
		query.append("    #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    	AND A.CNTR_TPSZ_CD  =@[cntr_tpsz_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    GROUP BY DECODE(@[loc_type_code],1,A.RCC_CD,2,A.LCC_CD,3,A.ECC_CD,4,A.SCC_CD)" ).append("\n"); 
		query.append(") A    " ).append("\n"); 
		query.append("ORDER BY A.LOC_CD ,A.CNTR_NO,A.CNTR_TPSZ_CD,A.DMG_FLG" ).append("\n"); 

	}
}