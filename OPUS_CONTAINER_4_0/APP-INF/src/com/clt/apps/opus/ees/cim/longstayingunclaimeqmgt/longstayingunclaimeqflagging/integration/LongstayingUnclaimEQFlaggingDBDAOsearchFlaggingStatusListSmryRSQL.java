/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingDBDAOsearchFlaggingStatusListSmryRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.28
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LongstayingUnclaimEQFlaggingDBDAOsearchFlaggingStatusListSmryRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * L/S & U/C Creation화면에서 Flag된 L/S 및 U/C 장비의 현황을 조회한다.
	  * </pre>
	  */
	public LongstayingUnclaimEQFlaggingDBDAOsearchFlaggingStatusListSmryRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("over_stay_days",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd5",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd7",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration").append("\n"); 
		query.append("FileName : LongstayingUnclaimEQFlaggingDBDAOsearchFlaggingStatusListSmryRSQL").append("\n"); 
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
		query.append("     A.LVL" ).append("\n"); 
		query.append("    ,DECODE(A.LVL,'010','Total','011','G.Total',A.LOC_CD) LOC_CD" ).append("\n"); 
		query.append("    ,DECODE(A.LVL,'001','Total','010',A.CNMV_STS_CD,'011','G.Total',A.CNMV_STS_CD) CNMV_STS_CD" ).append("\n"); 
		query.append("    ,DECODE(A.SEQ,1,'Completed',2,'ALL','Flag Ratio') flag_status" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,DECODE(A.SEQ,1,TOTAL||'',2,TOTAL||'',(TO_CHAR(TOTAL,'990.0')||'%') ) TOTAL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd1]   ),0,NULL,DECODE(A.SEQ,1,A.QTY1  ||'',2,A.QTY1  ||'',(TO_CHAR(A.QTY1  ,'990.0')||'%') )) QTY1  " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd2]   ),0,NULL,DECODE(A.SEQ,1,A.QTY2  ||'',2,A.QTY2  ||'',(TO_CHAR(A.QTY2  ,'990.0')||'%') )) QTY2  " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd3]   ),0,NULL,DECODE(A.SEQ,1,A.QTY3  ||'',2,A.QTY3  ||'',(TO_CHAR(A.QTY3  ,'990.0')||'%') )) QTY3  " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd4]   ),0,NULL,DECODE(A.SEQ,1,A.QTY4  ||'',2,A.QTY4  ||'',(TO_CHAR(A.QTY4  ,'990.0')||'%') )) QTY4  " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd5]   ),0,NULL,DECODE(A.SEQ,1,A.QTY5  ||'',2,A.QTY5  ||'',(TO_CHAR(A.QTY5  ,'990.0')||'%') )) QTY5  " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd6]   ),0,NULL,DECODE(A.SEQ,1,A.QTY6  ||'',2,A.QTY6  ||'',(TO_CHAR(A.QTY6  ,'990.0')||'%') )) QTY6  " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd7]   ),0,NULL,DECODE(A.SEQ,1,A.QTY7  ||'',2,A.QTY7  ||'',(TO_CHAR(A.QTY7  ,'990.0')||'%') )) QTY7  " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd8]   ),0,NULL,DECODE(A.SEQ,1,A.QTY8  ||'',2,A.QTY8  ||'',(TO_CHAR(A.QTY8  ,'990.0')||'%') )) QTY8  " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd9]   ),0,NULL,DECODE(A.SEQ,1,A.QTY9  ||'',2,A.QTY9  ||'',(TO_CHAR(A.QTY9  ,'990.0')||'%') )) QTY9  " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd10]  ),0,NULL,DECODE(A.SEQ,1,A.QTY10 ||'',2,A.QTY10 ||'',(TO_CHAR(A.QTY10 ,'990.0')||'%') )) QTY10 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd11]  ),0,NULL,DECODE(A.SEQ,1,A.QTY11 ||'',2,A.QTY11 ||'',(TO_CHAR(A.QTY11 ,'990.0')||'%') )) QTY11 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd12]  ),0,NULL,DECODE(A.SEQ,1,A.QTY12 ||'',2,A.QTY12 ||'',(TO_CHAR(A.QTY12 ,'990.0')||'%') )) QTY12 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd13]  ),0,NULL,DECODE(A.SEQ,1,A.QTY13 ||'',2,A.QTY13 ||'',(TO_CHAR(A.QTY13 ,'990.0')||'%') )) QTY13 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd14]  ),0,NULL,DECODE(A.SEQ,1,A.QTY14 ||'',2,A.QTY14 ||'',(TO_CHAR(A.QTY14 ,'990.0')||'%') )) QTY14 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd15]  ),0,NULL,DECODE(A.SEQ,1,A.QTY15 ||'',2,A.QTY15 ||'',(TO_CHAR(A.QTY15 ,'990.0')||'%') )) QTY15 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd16]  ),0,NULL,DECODE(A.SEQ,1,A.QTY16 ||'',2,A.QTY16 ||'',(TO_CHAR(A.QTY16 ,'990.0')||'%') )) QTY16 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd17]  ),0,NULL,DECODE(A.SEQ,1,A.QTY17 ||'',2,A.QTY17 ||'',(TO_CHAR(A.QTY17 ,'990.0')||'%') )) QTY17 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd18]  ),0,NULL,DECODE(A.SEQ,1,A.QTY18 ||'',2,A.QTY18 ||'',(TO_CHAR(A.QTY18 ,'990.0')||'%') )) QTY18 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd19]  ),0,NULL,DECODE(A.SEQ,1,A.QTY19 ||'',2,A.QTY19 ||'',(TO_CHAR(A.QTY19 ,'990.0')||'%') )) QTY19 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd20]  ),0,NULL,DECODE(A.SEQ,1,A.QTY20 ||'',2,A.QTY20 ||'',(TO_CHAR(A.QTY20 ,'990.0')||'%') )) QTY20 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd21]  ),0,NULL,DECODE(A.SEQ,1,A.QTY21 ||'',2,A.QTY21 ||'',(TO_CHAR(A.QTY21 ,'990.0')||'%') )) QTY21 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd22]  ),0,NULL,DECODE(A.SEQ,1,A.QTY22 ||'',2,A.QTY22 ||'',(TO_CHAR(A.QTY22 ,'990.0')||'%') )) QTY22 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd23]  ),0,NULL,DECODE(A.SEQ,1,A.QTY23 ||'',2,A.QTY23 ||'',(TO_CHAR(A.QTY23 ,'990.0')||'%') )) QTY23 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd24]  ),0,NULL,DECODE(A.SEQ,1,A.QTY24 ||'',2,A.QTY24 ||'',(TO_CHAR(A.QTY24 ,'990.0')||'%') )) QTY24 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd25]  ),0,NULL,DECODE(A.SEQ,1,A.QTY25 ||'',2,A.QTY25 ||'',(TO_CHAR(A.QTY25 ,'990.0')||'%') )) QTY25 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd26]  ),0,NULL,DECODE(A.SEQ,1,A.QTY26 ||'',2,A.QTY26 ||'',(TO_CHAR(A.QTY26 ,'990.0')||'%') )) QTY26 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd27]  ),0,NULL,DECODE(A.SEQ,1,A.QTY27 ||'',2,A.QTY27 ||'',(TO_CHAR(A.QTY27 ,'990.0')||'%') )) QTY27 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd28]  ),0,NULL,DECODE(A.SEQ,1,A.QTY28 ||'',2,A.QTY28 ||'',(TO_CHAR(A.QTY28 ,'990.0')||'%') )) QTY28 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd29]  ),0,NULL,DECODE(A.SEQ,1,A.QTY29 ||'',2,A.QTY29 ||'',(TO_CHAR(A.QTY29 ,'990.0')||'%') )) QTY29 " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd30]  ),0,NULL,DECODE(A.SEQ,1,A.QTY30 ||'',2,A.QTY30 ||'',(TO_CHAR(A.QTY30 ,'990.0')||'%') )) QTY30 " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("         C.SEQ" ).append("\n"); 
		query.append("		#if (${loc_type_code} == '1')   --LCC" ).append("\n"); 
		query.append("	        ,RANK() OVER (ORDER BY A.ECC_CD) RANK" ).append("\n"); 
		query.append("		    ,GROUPING(C.SEQ)||GROUPING(A.ECC_CD)||GROUPING(A.CNMV_STS_CD) LVL" ).append("\n"); 
		query.append("			,A.ECC_CD LOC_CD" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '2')   --RCC" ).append("\n"); 
		query.append("	        ,RANK() OVER (ORDER BY A.LCC_CD) RANK" ).append("\n"); 
		query.append("		    ,GROUPING(C.SEQ)||GROUPING(A.LCC_CD)||GROUPING(A.CNMV_STS_CD) LVL" ).append("\n"); 
		query.append("			,A.LCC_CD LOC_CD" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '3')   --ECC" ).append("\n"); 
		query.append("	        ,RANK() OVER (ORDER BY A.SCC_CD) RANK" ).append("\n"); 
		query.append("		    ,GROUPING(C.SEQ)||GROUPING(A.SCC_CD)||GROUPING(A.CNMV_STS_CD) LVL" ).append("\n"); 
		query.append("			,A.SCC_CD LOC_CD" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '4')   --SCC" ).append("\n"); 
		query.append("	        ,RANK() OVER (ORDER BY A.CRNT_YD_CD) RANK" ).append("\n"); 
		query.append("		    ,GROUPING(C.SEQ)||GROUPING(A.CRNT_YD_CD)||GROUPING(A.CNMV_STS_CD) LVL" ).append("\n"); 
		query.append("			,A.CRNT_YD_CD LOC_CD" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '5')   --YARD" ).append("\n"); 
		query.append("	        ,RANK() OVER (ORDER BY A.CRNT_YD_CD) RANK" ).append("\n"); 
		query.append("		    ,GROUPING(C.SEQ)||GROUPING(A.CRNT_YD_CD)||GROUPING(A.CNMV_STS_CD) LVL" ).append("\n"); 
		query.append("			,A.CRNT_YD_CD LOC_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		,A.CNMV_STS_CD" ).append("\n"); 
		query.append("        ,NVL(COUNT(A.CNTR_NO),0) TOTAL_QTY" ).append("\n"); 
		query.append("        ,NVL(SUM(DECODE(A.UCLM_LS_DIV_CD,'L',1)),0) COMP_QYT" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(DECODE(A.UCLM_LS_DIV_CD,'L',1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(COUNT(A.CNTR_NO),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     ROUND(NVL(SUM(DECODE(A.UCLM_LS_DIV_CD,'L',1)),0)/NVL(COUNT(A.CNTR_NO),0)*100,1)" ).append("\n"); 
		query.append("    	 END TOTAL   " ).append("\n"); 
		query.append("    	       " ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd1] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd1] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd1] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd1] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd1] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY1         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd2] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd2] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd2] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd2] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd2] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY2         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd3] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd3] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd3] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd3] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd3] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY3         " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd4] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd4] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd4] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd4] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd4] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY4        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd5] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd5] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd5] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd5] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd5] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY5        " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd6] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd6] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd6] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd6] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd6] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY6" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd7] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd7] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd7] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd7] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd7] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY7" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd8] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd8] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd8] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd8] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd8] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY8    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd9] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd9] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd9] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd9] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd9] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY9   " ).append("\n"); 
		query.append("    	 " ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd10] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd10] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd10] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd10] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd10] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY10    " ).append("\n"); 
		query.append("    	 " ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd11] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd11] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd11] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd11] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd11] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY11      	  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd12] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd12] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd12] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd12] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd12] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY12       	 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd13] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd13] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd13] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd13] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd13] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY13       	 	    " ).append("\n"); 
		query.append("    	 " ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd14] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd14] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd14] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd14] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd14] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY14   " ).append("\n"); 
		query.append("    	 " ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd15] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd15] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd15] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd15] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd15] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY15" ).append("\n"); 
		query.append("    	      	" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd16] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd16] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd16] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd16] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd16] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY16    	     " ).append("\n"); 
		query.append("    	 " ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd17] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd17] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd17] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd17] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd17] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY17     	 " ).append("\n"); 
		query.append("    	 " ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd18] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd18] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd18] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd18] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd18] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY18       " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd19] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd19] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd19] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd19] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd19] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY19    	 	 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd20] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd20] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd20] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd20] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd20] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY20      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd21] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd21] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd21] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd21] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd21] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY21    " ).append("\n"); 
		query.append("    	 " ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd22] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd22] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd22] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd22] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd22] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY22     	    	 	  	   	 	 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd23] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd23] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd23] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd23] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd23] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY23    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd24] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd24] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd24] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd24] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd24] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY24         	" ).append("\n"); 
		query.append("    	 " ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd25] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd25] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd25] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd25] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd25] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY25        	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd26] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd26] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd26] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd26] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd26] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY26        	" ).append("\n"); 
		query.append("    	 " ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd27] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd27] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd27] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd27] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd27] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY27       	    	    	 	  	   	 	 " ).append("\n"); 
		query.append("    	 " ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd28] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd28] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd28] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd28] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd28] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY28    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd29] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd29] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd29] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd29] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd29] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY29 " ).append("\n"); 
		query.append("    	 " ).append("\n"); 
		query.append("    	,CASE WHEN C.SEQ=1  THEN" ).append("\n"); 
		query.append("    	     NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd30] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=2  THEN" ).append("\n"); 
		query.append("    		 NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd30] ,1)),0)" ).append("\n"); 
		query.append("    	 WHEN C.SEQ=3  THEN" ).append("\n"); 
		query.append("    	     DECODE(NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd30] ,1)),0), 0, 0, ROUND( NVL(SUM(CASE WHEN A.CNTR_TPSZ_CD = @[cntr_tpsz_cd30] AND A.UCLM_LS_DIV_CD ='L' THEN 1 ELSE 0 END),0) /NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd30] ,1)),0)*100,1))" ).append("\n"); 
		query.append("    	 END QTY30  	     	    	    	    	 	  	   	 	 " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM MST_CONTAINER A,MDM_EQ_ORZ_CHT B, (SELECT LEVEL SEQ   FROM DUAL CONNECT BY LEVEL <=3) C" ).append("\n"); 
		query.append("    WHERE   A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("    AND   A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("	AND LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("	AND NVL(A.UCLM_LS_DIV_CD,'Z') <>'U'" ).append("\n"); 
		query.append("    AND A.CNMV_STS_CD IN (" ).append("\n"); 
		query.append("         'CD'" ).append("\n"); 
		query.append("        ,'CE'" ).append("\n"); 
		query.append("        ,'CI'" ).append("\n"); 
		query.append("        ,'CM'" ).append("\n"); 
		query.append("        ,'CO'" ).append("\n"); 
		query.append("        ,'CP'" ).append("\n"); 
		query.append("        ,'CT'" ).append("\n"); 
		query.append("        ,'CX'" ).append("\n"); 
		query.append("        ,'EN'" ).append("\n"); 
		query.append("        ,'IC'" ).append("\n"); 
		query.append("        ,'ID'" ).append("\n"); 
		query.append("        ,'MT'" ).append("\n"); 
		query.append("        ,'OC'" ).append("\n"); 
		query.append("        ,'OP'" ).append("\n"); 
		query.append("        ,'TN'" ).append("\n"); 
		query.append("        ,'TS'" ).append("\n"); 
		query.append("        ,'VD'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("	#if (${loc_type_code} == '1' )" ).append("\n"); 
		query.append("		AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_type_code} == '2')" ).append("\n"); 
		query.append("		AND A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("		AND A.ECC_CD =@[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("		AND A.SCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("	#elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("		AND A.CRNT_YD_CD =@[loc_cd]" ).append("\n"); 
		query.append("	#end     " ).append("\n"); 
		query.append("    #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("    	AND A.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${lstm_cd} != '')" ).append("\n"); 
		query.append("    	AND A.LSTM_CD IN ( " ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[lstm_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    #if (${full_flg} != '')" ).append("\n"); 
		query.append("    	AND A.FULL_FLG = @[full_flg]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND   CEIL(GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR(@[loc_cd],1,5)) - A.CNMV_DT) >= @[over_stay_days]" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("    	AND A.CNMV_STS_CD IN ( " ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cnmv_sts_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("        AND A.CNMV_STS_CD NOT IN('VL','XX')" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("    	AND A.CNMV_STS_CD IN(SELECT MVMT_STS_CD FROM MDM_MVMT_STS WHERE MVMT_STS_CD NOT IN('VL','XX'))" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("	#if (${loc_type_code} == '1')   --LCC" ).append("\n"); 
		query.append("	    GROUP BY CUBE(C.SEQ,A.ECC_CD,A.CNMV_STS_CD)" ).append("\n"); 
		query.append("	#elseif (${loc_type_code} == '2')   --RCC" ).append("\n"); 
		query.append("	    GROUP BY CUBE(C.SEQ,A.LCC_CD,A.CNMV_STS_CD)" ).append("\n"); 
		query.append("	#elseif (${loc_type_code} == '3')   --ECC" ).append("\n"); 
		query.append("	    GROUP BY CUBE(C.SEQ,A.SCC_CD,A.CNMV_STS_CD)" ).append("\n"); 
		query.append("	#elseif (${loc_type_code} == '4')   --SCC" ).append("\n"); 
		query.append("	    GROUP BY CUBE(C.SEQ,A.CRNT_YD_CD,A.CNMV_STS_CD)" ).append("\n"); 
		query.append("	#elseif (${loc_type_code} == '5')   --YARD" ).append("\n"); 
		query.append("	    GROUP BY CUBE(C.SEQ,A.CRNT_YD_CD,A.CNMV_STS_CD)" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append(") A, COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("WHERE A.CNMV_STS_CD = B.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("AND B.INTG_CD_ID(+)='CD02086'" ).append("\n"); 
		query.append("AND A.LVL NOT IN ('100','101','110','111')" ).append("\n"); 
		query.append("ORDER BY RANK,B.INTG_CD_VAL_DP_SEQ,A.SEQ" ).append("\n"); 

	}
}