/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOsearchSeaInvtListInvtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CNTRInventoryReportDBDAOsearchSeaInvtListInvtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sea Inventory (by VVD)
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOsearchSeaInvtListInvtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("route_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rf_tp_cd_m",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rf_tp_cd_h",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rf_tp_cd_c",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdt_ext_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_use_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd18",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("plst_flr_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stay_days",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd7",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rf_cntr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration").append("\n"); 
		query.append("FileName : CNTRInventoryReportDBDAOsearchSeaInvtListInvtRSQL").append("\n"); 
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
		query.append("SELECT  A.LVL" ).append("\n"); 
		query.append("       ,DECODE(SUBSTR(A.LVL,1,1),'0',UPPER(A.VVD),'Total') VVD" ).append("\n"); 
		query.append("       ,DECODE(SUBSTR(A.LVL,2,1),'0',DECODE(A.FULL_FLG,'Y','FULL','N','MTY'),'Total') DIVISION" ).append("\n"); 
		query.append("       ,DECODE(SUBSTR(A.LVL,3,1),'0',A.LSTM_CD,'Total')  LSTM_CD" ).append("\n"); 
		query.append("       ,A.TOTAL_CNT" ).append("\n"); 
		query.append("       ,A.QTY1" ).append("\n"); 
		query.append("       ,A.QTY2" ).append("\n"); 
		query.append("       ,A.QTY3" ).append("\n"); 
		query.append("       ,A.QTY4" ).append("\n"); 
		query.append("       ,A.QTY5" ).append("\n"); 
		query.append("       ,A.QTY6" ).append("\n"); 
		query.append("       ,A.QTY7" ).append("\n"); 
		query.append("       ,A.QTY8" ).append("\n"); 
		query.append("       ,A.QTY9" ).append("\n"); 
		query.append("       ,A.QTY10" ).append("\n"); 
		query.append("       ,A.QTY11" ).append("\n"); 
		query.append("       ,A.QTY12" ).append("\n"); 
		query.append("       ,A.QTY13" ).append("\n"); 
		query.append("       ,A.QTY14" ).append("\n"); 
		query.append("       ,A.QTY15" ).append("\n"); 
		query.append("       ,A.QTY16" ).append("\n"); 
		query.append("       ,A.QTY17" ).append("\n"); 
		query.append("       ,A.QTY18" ).append("\n"); 
		query.append("       ,A.QTY19" ).append("\n"); 
		query.append("       ,A.QTY20" ).append("\n"); 
		query.append("       ,A.QTY21" ).append("\n"); 
		query.append("       ,A.QTY22" ).append("\n"); 
		query.append("       ,A.QTY23" ).append("\n"); 
		query.append("       ,A.QTY24" ).append("\n"); 
		query.append("       ,A.QTY25" ).append("\n"); 
		query.append("       ,A.QTY26" ).append("\n"); 
		query.append("       ,A.QTY27" ).append("\n"); 
		query.append("       ,A.QTY28" ).append("\n"); 
		query.append("       ,A.QTY29" ).append("\n"); 
		query.append("       ,A.QTY30" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  /*+ LEADING(A)  */" ).append("\n"); 
		query.append("        GROUPING(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD)||GROUPING(A.FULL_FLG)||GROUPING(A.LSTM_CD) LVL" ).append("\n"); 
		query.append("        ,A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD,A.FULL_FLG,A.LSTM_CD                               " ).append("\n"); 
		query.append("        ,COUNT(*)   TOTAL_CNT" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd1]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd1]  ,1)),0)) QTY1 " ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd2]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd2]  ,1)),0)) QTY2 " ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd3]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd3]  ,1)),0)) QTY3 " ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd4]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd4]  ,1)),0)) QTY4 " ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd5]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd5]  ,1)),0)) QTY5 " ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd6]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd6]  ,1)),0)) QTY6 " ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd7]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd7]  ,1)),0)) QTY7 " ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd8]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd8]  ,1)),0)) QTY8 " ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd9]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd9]  ,1)),0)) QTY9 " ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd10] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd10] ,1)),0)) QTY10" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd11] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd11] ,1)),0)) QTY11" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd12] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd12] ,1)),0)) QTY12" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd13] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd13] ,1)),0)) QTY13" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd14] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd14] ,1)),0)) QTY14" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd15] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd15] ,1)),0)) QTY15" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd16] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd16] ,1)),0)) QTY16" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd17] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd17] ,1)),0)) QTY17" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd18] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd18] ,1)),0)) QTY18" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd19] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd19] ,1)),0)) QTY19" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd20] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd20] ,1)),0)) QTY20" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd21] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd21] ,1)),0)) QTY21" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd22] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd22] ,1)),0)) QTY22" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd23] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd23] ,1)),0)) QTY23" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd24] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd24] ,1)),0)) QTY24" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd25] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd25] ,1)),0)) QTY25" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd26] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd26] ,1)),0)) QTY26" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd27] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd27] ,1)),0)) QTY27" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd28] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd28] ,1)),0)) QTY28" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd29] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd29] ,1)),0)) QTY29" ).append("\n"); 
		query.append("        ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd30] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd30] ,1)),0)) QTY30" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	    SELECT   " ).append("\n"); 
		query.append("	             NVL(A.VSL_CD,'xxxx') VSL_CD" ).append("\n"); 
		query.append("	            ,NVL(A.SKD_VOY_NO,'0000') SKD_VOY_NO" ).append("\n"); 
		query.append("	            ,A.SKD_DIR_CD SKD_DIR_CD" ).append("\n"); 
		query.append("	            ,A.FULL_FLG" ).append("\n"); 
		query.append("	            ,A.LSTM_CD" ).append("\n"); 
		query.append("	            ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				,A.BKG_NO" ).append("\n"); 
		query.append("				,A.CRNT_YD_CD" ).append("\n"); 
		query.append("	    FROM MST_CONTAINER A" ).append("\n"); 
		query.append("	    WHERE A.ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("	    AND   A.CNMV_STS_CD='VL'" ).append("\n"); 
		query.append("		#if(${off_hire_flg} != '')" ).append("\n"); 
		query.append(" 		AND (" ).append("\n"); 
		query.append("                 ( A.LSTM_CD = 'LT' AND NVL(A.min_onh_dys,0) > 0" ).append("\n"); 
		query.append("                     AND  TRUNC(SYSDATE) > TRUNC(A.ONH_DT) + (NVL(A.MIN_ONH_DYS,0) - 1)" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("                 OR" ).append("\n"); 
		query.append("                 ( A.LSTM_CD = 'LT' AND NVL(A.min_onh_dys,0) = 0" ).append("\n"); 
		query.append("                     AND  TRUNC(SYSDATE) - ( SELECT /*+ INDEX_DESC (S XPKLSE_AGMT_VER) */ TRUNC(EXP_DT)" ).append("\n"); 
		query.append("                                                                  FROM   LSE_AGMT_VER S" ).append("\n"); 
		query.append("                                                                  WHERE  S.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                                                  AND    S.AGMT_SEQ    = A.AGMT_SEQ" ).append("\n"); 
		query.append("                                                                  AND    ROWNUM = 1" ).append("\n"); 
		query.append("                               ) > 0" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("                OR" ).append("\n"); 
		query.append("                 ( A.LSTM_CD IN ('ST', 'SI', 'OF', 'MI')" ).append("\n"); 
		query.append("                     AND TRUNC(SYSDATE)  > TRUNC(A.ONH_DT) + (NVL(A.MIN_ONH_DYS,0) - 1)" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	    #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("	    	AND A.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("	    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("	        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("	            	             FROM dual )" ).append("\n"); 
		query.append("	    				        )" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	    #if (${imdt_ext_flg} != '')" ).append("\n"); 
		query.append("	        AND A.IMDT_EXT_FLG =@[imdt_ext_flg]" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	    #if (${plst_flr_flg} != '')" ).append("\n"); 
		query.append("	        AND A.PLST_FLR_FLG =@[plst_flr_flg]" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	    #if (${lstm_cd} != '')" ).append("\n"); 
		query.append("	    	AND A.LSTM_CD IN ( " ).append("\n"); 
		query.append("	    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("	        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[lstm_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("	            	             FROM dual )" ).append("\n"); 
		query.append("	    				        )" ).append("\n"); 
		query.append("	    #end  " ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	    #if (${cntr_no} != '')" ).append("\n"); 
		query.append("	    	AND SUBSTR(A.CNTR_NO,0,4) = @[cntr_no]" ).append("\n"); 
		query.append("	    #end  " ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("		#if (${stay_days} != '')" ).append("\n"); 
		query.append("			AND TRUNC(SYSDATE) - TRUNC(CNMV_DT) + 1 > = @[stay_days]" ).append("\n"); 
		query.append("	    #end  " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	    #if (${cntr_use_co_cd} != '')" ).append("\n"); 
		query.append("	    	AND A.CNTR_USE_CO_CD = @[cntr_use_co_cd]" ).append("\n"); 
		query.append("	    #end  " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	    #if ( ${slan_cd} =='XXX' ) --vvd정보가 없을시 " ).append("\n"); 
		query.append("	        AND UPPER(nvl(A.VSL_CD,'xxxx')||nvl(A.SKD_VOY_NO,'0000')||nvl(A.SKD_DIR_CD,'x')) ='XXXX0000X'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	    #if (${vvd1} != '' || ${vvd2} != '' || ${vvd3} != '' ) " ).append("\n"); 
		query.append("	        #if (${vvd1} == 'XXXX0000' || ${vvd2} != 'XXXX0000' || ${vvd3} != 'XXXX0000' ) " ).append("\n"); 
		query.append("	            AND UPPER(nvl(A.VSL_CD,'xxxx')||nvl(A.SKD_VOY_NO,'0000')||A.SKD_DIR_CD) IN ( @[vvd1],@[vvd2],@[vvd3])" ).append("\n"); 
		query.append("	        #else" ).append("\n"); 
		query.append("	            AND (A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD) IN ( (SUBSTR(@[vvd1],1,4),SUBSTR(@[vvd1],5,4),SUBSTR(@[vvd1],9,1)), (SUBSTR(@[vvd2],1,4),SUBSTR(@[vvd2],5,4),SUBSTR(@[vvd2],9,1)), (SUBSTR(@[vvd3],1,4),SUBSTR(@[vvd3],5,4),SUBSTR(@[vvd3],9,1)) )" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("	    #end " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	    #if (${pol_cd} != '')" ).append("\n"); 
		query.append("	        #if (${route_tp_cd} != 'B')" ).append("\n"); 
		query.append("	            AND SUBSTR(A.CRNT_YD_CD,1,5) = @[pol_cd]" ).append("\n"); 
		query.append("	        #end" ).append("\n"); 
		query.append("	    #end  " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	    #if (${full_flg} != '')" ).append("\n"); 
		query.append("	    	AND A.FULL_FLG = @[full_flg]" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	    #if (${dmg_flg} != '')" ).append("\n"); 
		query.append("	    	AND A.DMG_FLG = @[dmg_flg]" ).append("\n"); 
		query.append("	    #end  " ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	    #if (${rf_tp_cd_c} != '' || ${rf_tp_cd_h} != '' || ${rf_cntr} != '' || ${rd_cgo_flg} != '')" ).append("\n"); 
		query.append("	        AND A.CNTR_TPSZ_CD LIKE 'R%'" ).append("\n"); 
		query.append("	    #end  " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	    #if (${rf_tp_cd_c} != '' || ${rf_tp_cd_h} != '' || ${rf_tp_cd_m} != '')" ).append("\n"); 
		query.append("	        AND A.RF_TP_CD IN(@[rf_tp_cd_c],@[rf_tp_cd_h],@[rf_tp_cd_m])" ).append("\n"); 
		query.append("	    #end  " ).append("\n"); 
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
		query.append("	    #if (${soc_cd} != '')" ).append("\n"); 
		query.append("	    	#if (${soc_cd} == '1')" ).append("\n"); 
		query.append("	    		AND A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("	    	#else" ).append("\n"); 
		query.append("	    		AND A.LSTM_CD = 'SH'" ).append("\n"); 
		query.append("	    	#end" ).append("\n"); 
		query.append("	    #end    " ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("	) A    " ).append("\n"); 
		query.append("    #if (${slan_cd} != '' || ${vvd1} != '' || ${vvd2} != '' || ${vvd3} != '' || ${pol_cd} != '' || ${pod_cd} != '' || ${del_cd} != '' || ${rd_cgo_flg} != '' || ${rf_cntr} != '')" ).append("\n"); 
		query.append("        ,BKG_BOOKING B" ).append("\n"); 
		query.append("        ,BKG_VVD C" ).append("\n"); 
		query.append("        WHERE A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("        AND A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("        AND A.VSL_CD = C.VSL_CD(+)" ).append("\n"); 
		query.append("        AND A.SKD_VOY_NO = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("        AND A.SKD_DIR_CD = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("        #if (${slan_cd} != '' && ${slan_cd} != 'XXX')" ).append("\n"); 
		query.append("            AND C.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${pol_cd} != '')" ).append("\n"); 
		query.append("            #if (${route_tp_cd} == 'B')" ).append("\n"); 
		query.append("                AND B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        #end  " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${pod_cd} != '')" ).append("\n"); 
		query.append("       		AND NVL(DECODE(@[route_tp_cd],'B',SUBSTR(B.POD_NOD_CD,1,5),SUBSTR(C.POD_YD_CD,1,5)),'XXXXX') = @[pod_cd]" ).append("\n"); 
		query.append("        #end  " ).append("\n"); 
		query.append("        #if (${del_cd} != '')" ).append("\n"); 
		query.append("            AND B.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("        #end  " ).append("\n"); 
		query.append("    	#if (${rd_cgo_flg} != '' || ${rf_cntr} != '')" ).append("\n"); 
		query.append("            AND B.RD_CGO_FLG IN(@[rf_cntr],@[rd_cgo_flg])" ).append("\n"); 
		query.append("        #end  " ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    GROUP BY CUBE(A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD,A.FULL_FLG,A.LSTM_CD)" ).append("\n"); 
		query.append("    ORDER BY      A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD,A.FULL_FLG,A.LSTM_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(", MST_LSE_TERM B" ).append("\n"); 
		query.append("WHERE A.LSTM_CD = B.LSTM_CD(+)" ).append("\n"); 
		query.append("ORDER BY A.VVD,DECODE(A.FULL_FLG,'Y','FULL','N','MTY'),B.DP_SEQ,A.LSTM_CD" ).append("\n"); 

	}
}