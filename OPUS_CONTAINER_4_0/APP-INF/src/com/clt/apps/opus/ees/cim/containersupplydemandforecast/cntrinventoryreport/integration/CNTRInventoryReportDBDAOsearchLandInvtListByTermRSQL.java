/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOsearchLandInvtListByTermRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.26
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.26 
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

public class CNTRInventoryReportDBDAOsearchLandInvtListByTermRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Total Inventory (By Lease Term) By Lease Term 조회
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOsearchLandInvtListByTermRSQL(){
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
		params.put("d2_payld_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd27",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : CNTRInventoryReportDBDAOsearchLandInvtListByTermRSQL").append("\n"); 
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
		query.append("    A.LOC_CD," ).append("\n"); 
		query.append("	#if (${view_flg} == 'MVMT')" ).append("\n"); 
		query.append("		A.CNMV_STS_CD " ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		A.LSTM_CD " ).append("\n"); 
		query.append("	#end DIVISION," ).append("\n"); 
		query.append("    (NVL(QTY1,0)" ).append("\n"); 
		query.append("    +NVL(QTY2,0)" ).append("\n"); 
		query.append("    +NVL(QTY3,0)" ).append("\n"); 
		query.append("    +NVL(QTY4,0)" ).append("\n"); 
		query.append("    +NVL(QTY5,0)" ).append("\n"); 
		query.append("    +NVL(QTY6,0)" ).append("\n"); 
		query.append("    +NVL(QTY7,0)" ).append("\n"); 
		query.append("    +NVL(QTY8,0)" ).append("\n"); 
		query.append("    +NVL(QTY9,0)" ).append("\n"); 
		query.append("    +NVL(QTY10,0)" ).append("\n"); 
		query.append("    +NVL(QTY11,0)" ).append("\n"); 
		query.append("    +NVL(QTY12,0)" ).append("\n"); 
		query.append("    +NVL(QTY13,0)" ).append("\n"); 
		query.append("    +NVL(QTY14,0)" ).append("\n"); 
		query.append("    +NVL(QTY15,0)" ).append("\n"); 
		query.append("    +NVL(QTY16,0)" ).append("\n"); 
		query.append("    +NVL(QTY17,0)" ).append("\n"); 
		query.append("    +NVL(QTY18,0)" ).append("\n"); 
		query.append("    +NVL(QTY19,0)" ).append("\n"); 
		query.append("    +NVL(QTY20,0)" ).append("\n"); 
		query.append("    +NVL(QTY21,0)" ).append("\n"); 
		query.append("    +NVL(QTY22,0)" ).append("\n"); 
		query.append("    +NVL(QTY23,0)" ).append("\n"); 
		query.append("    +NVL(QTY24,0)" ).append("\n"); 
		query.append("    +NVL(QTY25,0)" ).append("\n"); 
		query.append("    +NVL(QTY26,0)" ).append("\n"); 
		query.append("    +NVL(QTY27,0)" ).append("\n"); 
		query.append("    +NVL(QTY28,0)" ).append("\n"); 
		query.append("    +NVL(QTY29,0)" ).append("\n"); 
		query.append("    +NVL(QTY30,0)) TOTAL_CNT,                              " ).append("\n"); 
		query.append("    A.QTY1," ).append("\n"); 
		query.append("    A.QTY2," ).append("\n"); 
		query.append("    A.QTY3, " ).append("\n"); 
		query.append("    A.QTY4, " ).append("\n"); 
		query.append("    A.QTY5, " ).append("\n"); 
		query.append("    A.QTY6, " ).append("\n"); 
		query.append("    A.QTY7, " ).append("\n"); 
		query.append("    A.QTY8, " ).append("\n"); 
		query.append("    A.QTY9, " ).append("\n"); 
		query.append("    A.QTY10," ).append("\n"); 
		query.append("    A.QTY11," ).append("\n"); 
		query.append("    A.QTY12," ).append("\n"); 
		query.append("    A.QTY13," ).append("\n"); 
		query.append("    A.QTY14," ).append("\n"); 
		query.append("    A.QTY15," ).append("\n"); 
		query.append("    A.QTY16," ).append("\n"); 
		query.append("    A.QTY17," ).append("\n"); 
		query.append("    A.QTY18," ).append("\n"); 
		query.append("    A.QTY19," ).append("\n"); 
		query.append("    A.QTY20," ).append("\n"); 
		query.append("    A.QTY21," ).append("\n"); 
		query.append("    A.QTY22," ).append("\n"); 
		query.append("    A.QTY23," ).append("\n"); 
		query.append("    A.QTY24," ).append("\n"); 
		query.append("    A.QTY25," ).append("\n"); 
		query.append("    A.QTY26," ).append("\n"); 
		query.append("    A.QTY27," ).append("\n"); 
		query.append("    A.QTY28," ).append("\n"); 
		query.append("    A.QTY29," ).append("\n"); 
		query.append("    A.QTY30          " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        A.LOC_CD" ).append("\n"); 
		query.append("        #if (${view_flg} == 'MVMT')" ).append("\n"); 
		query.append("        	,A.CNMV_STS_CD " ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("        	,A.LSTM_CD " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd1]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd1]  ,A.VOL,0))) QTY1" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd2]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd2]  ,A.VOL,0))) QTY2" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd3]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd3]  ,A.VOL,0))) QTY3" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd4]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd4]  ,A.VOL,0))) QTY4" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd5]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd5]  ,A.VOL,0))) QTY5" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd6]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd6]  ,A.VOL,0))) QTY6" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd7]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd7]  ,A.VOL,0))) QTY7" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd8]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd8]  ,A.VOL,0))) QTY8" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd9]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd9]  ,A.VOL,0))) QTY9" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd10] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd10] ,A.VOL,0))) QTY10" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd11] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd11] ,A.VOL,0))) QTY11" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd12] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd12] ,A.VOL,0))) QTY12" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd13] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd13] ,A.VOL,0))) QTY13" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd14] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd14] ,A.VOL,0))) QTY14" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd15] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd15] ,A.VOL,0))) QTY15" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd16] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd16] ,A.VOL,0))) QTY16" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd17] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd17] ,A.VOL,0))) QTY17" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd18] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd18] ,A.VOL,0))) QTY18" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd19] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd19] ,A.VOL,0))) QTY19" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd20] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd20] ,A.VOL,0))) QTY20" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd21] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd21] ,A.VOL,0))) QTY21" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd22] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd22] ,A.VOL,0))) QTY22" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd23] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd23] ,A.VOL,0))) QTY23" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd24] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd24] ,A.VOL,0))) QTY24" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd25] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd25] ,A.VOL,0))) QTY25" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd26] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd26] ,A.VOL,0))) QTY26" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd27] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd27] ,A.VOL,0))) QTY27" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd28] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd28] ,A.VOL,0))) QTY28" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd29] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd29] ,A.VOL,0))) QTY29" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd30] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd30] ,A.VOL,0))) QTY30" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	    SELECT " ).append("\n"); 
		query.append("	    	#if (${loc_type_code} == '1')" ).append("\n"); 
		query.append("	    		A.RCC_CD" ).append("\n"); 
		query.append("	    	#elseif (${loc_type_code} == '2')" ).append("\n"); 
		query.append("	    		SUBSTR(A.CRNT_YD_CD,1,2)" ).append("\n"); 
		query.append("	    	#elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("	    		A.LCC_CD" ).append("\n"); 
		query.append("	    	#elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("	    		A.ECC_CD" ).append("\n"); 
		query.append("	    	#elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("	    		A.SCC_CD" ).append("\n"); 
		query.append("	    	#elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("	    		A.SCC_CD" ).append("\n"); 
		query.append("	    	#elseif (${loc_type_code} == '7')" ).append("\n"); 
		query.append("	    		A.CRNT_YD_CD" ).append("\n"); 
		query.append("            #elseif (${loc_type_code} == '8')" ).append("\n"); 
		query.append("	    		A.ECC_CD" ).append("\n"); 
		query.append("	    	#end LOC_CD" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("			#if (${view_flg} == 'MVMT')" ).append("\n"); 
		query.append("				,A.CNMV_STS_CD " ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				,A.LSTM_CD " ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("	        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	        ,COUNT(1) VOL" ).append("\n"); 
		query.append("	    FROM MST_CONTAINER A" ).append("\n"); 
		query.append("	    WHERE A.ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("	    AND A.CNMV_STS_CD IN(" ).append("\n"); 
		query.append("	                        'CD'," ).append("\n"); 
		query.append("	                        'CE'," ).append("\n"); 
		query.append("	                        'CI'," ).append("\n"); 
		query.append("	                        'CM'," ).append("\n"); 
		query.append("	                        'CO'," ).append("\n"); 
		query.append("	                        'CP'," ).append("\n"); 
		query.append("	                        'CT'," ).append("\n"); 
		query.append("	                        'CX'," ).append("\n"); 
		query.append("	                        'EN'," ).append("\n"); 
		query.append("	                        'IC'," ).append("\n"); 
		query.append("	                        'ID'," ).append("\n"); 
		query.append("	                        'MT'," ).append("\n"); 
		query.append("	                        'OC'," ).append("\n"); 
		query.append("	                        'OP'," ).append("\n"); 
		query.append("	                        'TN'," ).append("\n"); 
		query.append("	                        'TS')" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("		#if (${loc_type_code} == '3')" ).append("\n"); 
		query.append("			AND A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("			AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("			AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("			AND A.ECC_CD =@[loc_cd]" ).append("\n"); 
		query.append("		#elseif (${loc_type_code} == '7')" ).append("\n"); 
		query.append("			AND A.SCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '8')" ).append("\n"); 
		query.append("	    	AND A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	   #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("	    	AND A.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("	    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("	        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("	            	             FROM dual )" ).append("\n"); 
		query.append("	    				        )" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    #if (${full_flg} != '')" ).append("\n"); 
		query.append("	    	AND A.FULL_FLG = @[full_flg]" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    #if (${cntr_hngr_rck_cd} != '')" ).append("\n"); 
		query.append("	    	AND (A.CNTR_HNGR_RCK_CD IS NOT NULL OR  A.CNTR_HNGR_BAR_ATCH_KNT > 0)" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    #if (${disp_flg} != '')" ).append("\n"); 
		query.append("	    	AND A.DISP_FLG = @[disp_flg]" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    #if (${d2_payld_flg} != '')" ).append("\n"); 
		query.append("			AND A.CNTR_TPSZ_CD ='D2'" ).append("\n"); 
		query.append("	    	AND A.D2_PAYLD_FLG = @[d2_payld_flg]" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    #if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("	    	AND A.CNMV_STS_CD IN ( " ).append("\n"); 
		query.append("	    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("	        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cnmv_sts_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("	            	             FROM dual )" ).append("\n"); 
		query.append("	    				        )" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    #if (${dmg_flg} != '')" ).append("\n"); 
		query.append("	    	AND A.DMG_FLG = @[dmg_flg]" ).append("\n"); 
		query.append("	    #end  " ).append("\n"); 
		query.append("	    #if (${cntr_no} != '')" ).append("\n"); 
		query.append("	    	AND SUBSTR(A.CNTR_NO,0,4) = @[cntr_no]" ).append("\n"); 
		query.append("	    #end  " ).append("\n"); 
		query.append("	    #if (${lstm_cd} != '')" ).append("\n"); 
		query.append("	    	AND A.LSTM_CD IN ( " ).append("\n"); 
		query.append("	    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("	        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[lstm_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("	            	             FROM dual )" ).append("\n"); 
		query.append("	    				        )" ).append("\n"); 
		query.append("	    #end  " ).append("\n"); 
		query.append("	    #if (${soc_cd} != '')" ).append("\n"); 
		query.append("	    	#if (${soc_cd} == '1')" ).append("\n"); 
		query.append("	    		AND A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("	    	#else" ).append("\n"); 
		query.append("	    		AND A.LSTM_CD = 'SH'" ).append("\n"); 
		query.append("	    	#end" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("		GROUP BY " ).append("\n"); 
		query.append("	    	#if (${loc_type_code} == '1')" ).append("\n"); 
		query.append("	    		A.RCC_CD," ).append("\n"); 
		query.append("	    	#elseif (${loc_type_code} == '2')" ).append("\n"); 
		query.append("	    		SUBSTR(A.CRNT_YD_CD,1,2)," ).append("\n"); 
		query.append("	    	#elseif (${loc_type_code} == '3')" ).append("\n"); 
		query.append("	    		A.LCC_CD," ).append("\n"); 
		query.append("	    	#elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("	    		A.ECC_CD," ).append("\n"); 
		query.append("	    	#elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("	    		A.SCC_CD," ).append("\n"); 
		query.append("	    	#elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("	    		A.SCC_CD," ).append("\n"); 
		query.append("	    	#elseif (${loc_type_code} == '7')" ).append("\n"); 
		query.append("	    		A.CRNT_YD_CD," ).append("\n"); 
		query.append("            #elseif (${loc_type_code} == '8')" ).append("\n"); 
		query.append("	    		A.ECC_CD," ).append("\n"); 
		query.append("	    	#end" ).append("\n"); 
		query.append("		#if (${view_flg} == 'MVMT')" ).append("\n"); 
		query.append("			A.CNMV_STS_CD" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("			A.LSTM_CD" ).append("\n"); 
		query.append("		#end    " ).append("\n"); 
		query.append("		,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	) a" ).append("\n"); 
		query.append("	GROUP BY CUBE(A.LOC_CD," ).append("\n"); 
		query.append("	#if (${view_flg} == 'MVMT')" ).append("\n"); 
		query.append("		A.CNMV_STS_CD )" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		A.LSTM_CD )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("#if (${view_flg} == 'MVMT')" ).append("\n"); 
		query.append("	 COM_INTG_CD_DTL B" ).append("\n"); 
		query.append("	WHERE A.CNMV_STS_CD = B.INTG_CD_VAL_CTNT(+)" ).append("\n"); 
		query.append("	AND B.INTG_CD_ID(+)='CD02086'" ).append("\n"); 
		query.append("	ORDER BY A.LOC_CD,B.INTG_CD_VAL_DP_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	 MST_LSE_TERM B" ).append("\n"); 
		query.append("	WHERE A.LSTM_CD = B.LSTM_CD(+)" ).append("\n"); 
		query.append("	ORDER BY A.LOC_CD,B.DP_SEQ,A.LSTM_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}