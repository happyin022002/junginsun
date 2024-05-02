/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOsearchLandInvtListByLocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.21 
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

public class CNTRInventoryReportDBDAOsearchLandInvtListByLocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Land Inventory (By Location)
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOsearchLandInvtListByLocRSQL(){
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
		query.append("FileName : CNTRInventoryReportDBDAOsearchLandInvtListByLocRSQL").append("\n"); 
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
		query.append("WITH LV_QTY AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("          A.RCC_CD," ).append("\n"); 
		query.append("          A.LCC_CD," ).append("\n"); 
		query.append("          A.ECC_CD," ).append("\n"); 
		query.append("          A.SCC_CD," ).append("\n"); 
		query.append("          A.CRNT_YD_CD," ).append("\n"); 
		query.append("          DECODE(LVL,'9','Total','1',RCC_CD,'2',LCC_CD,'3',ECC_CD,'4',SCC_CD,'5',CRNT_YD_CD)||DECODE(LVL,'1','(R)','2','(L)','3','(E)','4','(S)') LOC_CD," ).append("\n"); 
		query.append("          A.LVL LVL," ).append("\n"); 
		query.append("          DECODE(A.LVL,'9',NULL,DECODE(@[loc_type_code],'1',A.LVL," ).append("\n"); 
		query.append("                                            	'3',A.LVL-1," ).append("\n"); 
		query.append("                                            	'4',A.LVL-2," ).append("\n"); 
		query.append("                                            	'5',A.LVL-3," ).append("\n"); 
		query.append("                                            	'6',A.LVL-3," ).append("\n"); 
		query.append("                                            	'7',A.LVL-4," ).append("\n"); 
		query.append("												'8',A.LVL-2)) LVL0," ).append("\n"); 
		query.append("         (NVL(QTY1 ,0) " ).append("\n"); 
		query.append("         +NVL(QTY2 ,0)" ).append("\n"); 
		query.append("         +NVL(QTY3 ,0)" ).append("\n"); 
		query.append("         +NVL(QTY4 ,0)" ).append("\n"); 
		query.append("         +NVL(QTY5 ,0)" ).append("\n"); 
		query.append("         +NVL(QTY6 ,0)" ).append("\n"); 
		query.append("         +NVL(QTY7 ,0)" ).append("\n"); 
		query.append("         +NVL(QTY8 ,0)" ).append("\n"); 
		query.append("         +NVL(QTY9 ,0)" ).append("\n"); 
		query.append("         +NVL(QTY10,0)" ).append("\n"); 
		query.append("         +NVL(QTY11,0)" ).append("\n"); 
		query.append("         +NVL(QTY12,0)" ).append("\n"); 
		query.append("         +NVL(QTY13,0)" ).append("\n"); 
		query.append("         +NVL(QTY14,0)" ).append("\n"); 
		query.append("         +NVL(QTY15,0)" ).append("\n"); 
		query.append("         +NVL(QTY16,0)" ).append("\n"); 
		query.append("         +NVL(QTY17,0)" ).append("\n"); 
		query.append("         +NVL(QTY18,0)" ).append("\n"); 
		query.append("         +NVL(QTY19,0)" ).append("\n"); 
		query.append("         +NVL(QTY20,0)" ).append("\n"); 
		query.append("         +NVL(QTY21,0)" ).append("\n"); 
		query.append("         +NVL(QTY22,0)" ).append("\n"); 
		query.append("         +NVL(QTY23,0)" ).append("\n"); 
		query.append("         +NVL(QTY24,0)" ).append("\n"); 
		query.append("         +NVL(QTY25,0)" ).append("\n"); 
		query.append("         +NVL(QTY26,0)" ).append("\n"); 
		query.append("         +NVL(QTY27,0)" ).append("\n"); 
		query.append("         +NVL(QTY28,0)" ).append("\n"); 
		query.append("         +NVL(QTY29,0)" ).append("\n"); 
		query.append("         +NVL(QTY30,0)) TOTAL_CNT,   " ).append("\n"); 
		query.append("          A.QTY1," ).append("\n"); 
		query.append("          A.QTY2," ).append("\n"); 
		query.append("          A.QTY3, " ).append("\n"); 
		query.append("          A.QTY4, " ).append("\n"); 
		query.append("          A.QTY5, " ).append("\n"); 
		query.append("          A.QTY6, " ).append("\n"); 
		query.append("          A.QTY7, " ).append("\n"); 
		query.append("          A.QTY8, " ).append("\n"); 
		query.append("          A.QTY9, " ).append("\n"); 
		query.append("          A.QTY10," ).append("\n"); 
		query.append("          A.QTY11," ).append("\n"); 
		query.append("          A.QTY12," ).append("\n"); 
		query.append("          A.QTY13," ).append("\n"); 
		query.append("          A.QTY14," ).append("\n"); 
		query.append("          A.QTY15," ).append("\n"); 
		query.append("          A.QTY16," ).append("\n"); 
		query.append("          A.QTY17," ).append("\n"); 
		query.append("          A.QTY18," ).append("\n"); 
		query.append("          A.QTY19," ).append("\n"); 
		query.append("          A.QTY20," ).append("\n"); 
		query.append("          A.QTY21," ).append("\n"); 
		query.append("          A.QTY22," ).append("\n"); 
		query.append("          A.QTY23," ).append("\n"); 
		query.append("          A.QTY24," ).append("\n"); 
		query.append("          A.QTY25," ).append("\n"); 
		query.append("          A.QTY26," ).append("\n"); 
		query.append("          A.QTY27," ).append("\n"); 
		query.append("          A.QTY28," ).append("\n"); 
		query.append("          A.QTY29," ).append("\n"); 
		query.append("          A.QTY30          " ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("     A.RCC_CD" ).append("\n"); 
		query.append("    ,A.LCC_CD" ).append("\n"); 
		query.append("    ,A.ECC_CD" ).append("\n"); 
		query.append("    ,A.SCC_CD" ).append("\n"); 
		query.append("    ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("	,DECODE(GROUPING(RCC_CD)||GROUPING(LCC_CD)||GROUPING(ECC_CD)||GROUPING(SCC_CD)||GROUPING(CRNT_YD_CD)," ).append("\n"); 
		query.append("    	   '01111','1','00111','2','00011','3','00001','4','00000','5','11111','9') LVL     " ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd1]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd1]  ,A.VOL,0))) QTY1" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd2]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd2]  ,A.VOL,0))) QTY2" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd3]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd3]  ,A.VOL,0))) QTY3" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd4]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd4]  ,A.VOL,0))) QTY4" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd5]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd5]  ,A.VOL,0))) QTY5" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd6]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd6]  ,A.VOL,0))) QTY6" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd7]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd7]  ,A.VOL,0))) QTY7" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd8]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd8]  ,A.VOL,0))) QTY8" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd9]  ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd9]  ,A.VOL,0))) QTY9" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd10] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd10] ,A.VOL,0))) QTY10" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd11] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd11] ,A.VOL,0))) QTY11" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd12] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd12] ,A.VOL,0))) QTY12" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd13] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd13] ,A.VOL,0))) QTY13" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd14] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd14] ,A.VOL,0))) QTY14" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd15] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd15] ,A.VOL,0))) QTY15" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd16] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd16] ,A.VOL,0))) QTY16" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd17] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd17] ,A.VOL,0))) QTY17" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd18] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd18] ,A.VOL,0))) QTY18" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd19] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd19] ,A.VOL,0))) QTY19" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd20] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd20] ,A.VOL,0))) QTY20" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd21] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd21] ,A.VOL,0))) QTY21" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd22] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd22] ,A.VOL,0))) QTY22" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd23] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd23] ,A.VOL,0))) QTY23" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd24] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd24] ,A.VOL,0))) QTY24" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd25] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd25] ,A.VOL,0))) QTY25" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd26] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd26] ,A.VOL,0))) QTY26" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd27] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd27] ,A.VOL,0))) QTY27" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd28] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd28] ,A.VOL,0))) QTY28" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd29] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd29] ,A.VOL,0))) QTY29" ).append("\n"); 
		query.append("    ,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd30] ),0,NULL,SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd30] ,A.VOL,0))) QTY30" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("         A.RCC_CD" ).append("\n"); 
		query.append("        ,A.LCC_CD" ).append("\n"); 
		query.append("        ,A.ECC_CD" ).append("\n"); 
		query.append("        ,A.SCC_CD" ).append("\n"); 
		query.append("        ,A.CRNT_YD_CD    " ).append("\n"); 
		query.append("        ,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ,COUNT(1) VOL" ).append("\n"); 
		query.append("    FROM MST_CONTAINER A" ).append("\n"); 
		query.append("    WHERE A.ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("    AND A.CNMV_STS_CD IN(" ).append("\n"); 
		query.append("                        'CD'," ).append("\n"); 
		query.append("                        'CE'," ).append("\n"); 
		query.append("                        'CI'," ).append("\n"); 
		query.append("                        'CM'," ).append("\n"); 
		query.append("                        'CO'," ).append("\n"); 
		query.append("                        'CP'," ).append("\n"); 
		query.append("                        'CT'," ).append("\n"); 
		query.append("                        'CX'," ).append("\n"); 
		query.append("                        'EN'," ).append("\n"); 
		query.append("                        'IC'," ).append("\n"); 
		query.append("                        'ID'," ).append("\n"); 
		query.append("                        'MT'," ).append("\n"); 
		query.append("                        'OC'," ).append("\n"); 
		query.append("                        'OP'," ).append("\n"); 
		query.append("                        'TN'," ).append("\n"); 
		query.append("                        'TS')" ).append("\n"); 
		query.append("    	#if (${loc_type_code} == '3')" ).append("\n"); 
		query.append("    		AND A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    	#elseif (${loc_type_code} == '4')" ).append("\n"); 
		query.append("    		AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    	#elseif (${loc_type_code} == '5')" ).append("\n"); 
		query.append("    		AND A.LCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    	#elseif (${loc_type_code} == '6')" ).append("\n"); 
		query.append("    		AND A.ECC_CD =@[loc_cd]" ).append("\n"); 
		query.append("    	#elseif (${loc_type_code} == '7')" ).append("\n"); 
		query.append("    		AND A.SCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("        #elseif (${loc_type_code} == '8')" ).append("\n"); 
		query.append("			AND A.RCC_CD =@[loc_cd]" ).append("\n"); 
		query.append("      	#end " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("       #if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("        	AND A.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("        		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("            	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("                	             FROM dual )" ).append("\n"); 
		query.append("        				        )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${full_flg} != '')" ).append("\n"); 
		query.append("        	AND A.FULL_FLG = @[full_flg]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	    #if (${cntr_hngr_rck_cd} != '')" ).append("\n"); 
		query.append("	    	AND (A.CNTR_HNGR_RCK_CD IS NOT NULL OR  A.CNTR_HNGR_BAR_ATCH_KNT > 0)" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${disp_flg} != '')" ).append("\n"); 
		query.append("        	AND A.DISP_FLG = @[disp_flg]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${d2_payld_flg} != '')" ).append("\n"); 
		query.append("    		AND A.CNTR_TPSZ_CD ='D2'" ).append("\n"); 
		query.append("        	AND A.D2_PAYLD_FLG = @[d2_payld_flg]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${cnmv_sts_cd} != '')" ).append("\n"); 
		query.append("        	AND A.CNMV_STS_CD IN ( " ).append("\n"); 
		query.append("        		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("            	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[cnmv_sts_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("                	             FROM dual )" ).append("\n"); 
		query.append("        				        )" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${dmg_flg} != '')" ).append("\n"); 
		query.append("        	AND A.DMG_FLG = @[dmg_flg]" ).append("\n"); 
		query.append("        #end  " ).append("\n"); 
		query.append("        #if (${cntr_no} != '')" ).append("\n"); 
		query.append("        	AND SUBSTR(A.CNTR_NO,0,4) = @[cntr_no]" ).append("\n"); 
		query.append("        #end  " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${lstm_cd} != '')" ).append("\n"); 
		query.append("        	AND A.LSTM_CD IN ( " ).append("\n"); 
		query.append("        		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("            	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[lstm_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("                	             FROM dual )" ).append("\n"); 
		query.append("        				        )" ).append("\n"); 
		query.append("        #end  " ).append("\n"); 
		query.append("        #if (${soc_cd} != '')" ).append("\n"); 
		query.append("        	#if (${soc_cd} == '1')" ).append("\n"); 
		query.append("        		AND A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("        	#else" ).append("\n"); 
		query.append("        		AND A.LSTM_CD = 'SH'" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        GROUP BY A.RCC_CD,A.LCC_CD,A.ECC_CD,A.SCC_CD,A.CRNT_YD_CD,A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        ORDER BY A.RCC_CD DESC ,A.LCC_CD DESC ,A.ECC_CD DESC ,A.SCC_CD DESC ,A.CRNT_YD_CD     " ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("GROUP BY ROLLUP(A.RCC_CD,A.LCC_CD,A.ECC_CD,A.SCC_CD,A.CRNT_YD_CD)" ).append("\n"); 
		query.append("ORDER BY A.RCC_CD DESC ,A.LCC_CD DESC ,A.ECC_CD DESC ,A.SCC_CD DESC ,A.CRNT_YD_CD " ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE DECODE(@[loc_type_code],'1','1'," ).append("\n"); 
		query.append("                         	'2','5',  " ).append("\n"); 
		query.append("                         	'3','2',  " ).append("\n"); 
		query.append("                         	'4','3',  " ).append("\n"); 
		query.append("                         	'5','4',  " ).append("\n"); 
		query.append("                         	'6','4'," ).append("\n"); 
		query.append("                         	'7','5'," ).append("\n"); 
		query.append("							'8','3') <= A.LVL" ).append("\n"); 
		query.append("ORDER BY  A.RCC_CD," ).append("\n"); 
		query.append("          DECODE(A.LCC_CD,NULL,'1',A.LCC_CD), " ).append("\n"); 
		query.append("          DECODE(A.ECC_CD,NULL,'1',A.ECC_CD)," ).append("\n"); 
		query.append("          DECODE(A.SCC_CD,NULL,'1',A.SCC_CD)," ).append("\n"); 
		query.append("          DECODE(A.CRNT_YD_CD,NULL,'1',CRNT_YD_CD)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#if (${loc_type_code} == '2')" ).append("\n"); 
		query.append("SELECT NULL RCC_CD" ).append("\n"); 
		query.append("       ,NULL LCC_CD" ).append("\n"); 
		query.append("       ,NULL ECC_CD" ).append("\n"); 
		query.append("       ,NULL SCC_CD" ).append("\n"); 
		query.append("       ,NVL(SUBSTR(A.LOC_CD,1,2),'Total') LOC_CD" ).append("\n"); 
		query.append("       ,NULL CRNT_YD_CD" ).append("\n"); 
		query.append("       , '0' LVL0" ).append("\n"); 
		query.append("       , '0' LVL" ).append("\n"); 
		query.append("       ,SUM(TOTAL_CNT) TOTAL_CNT" ).append("\n"); 
		query.append("       ,SUM(A.QTY1 ) QTY1 " ).append("\n"); 
		query.append("       ,SUM(A.QTY2 ) QTY2 " ).append("\n"); 
		query.append("       ,SUM(A.QTY3 ) QTY3 " ).append("\n"); 
		query.append("       ,SUM(A.QTY4 ) QTY4 " ).append("\n"); 
		query.append("       ,SUM(A.QTY5 ) QTY5 " ).append("\n"); 
		query.append("       ,SUM(A.QTY6 ) QTY6 " ).append("\n"); 
		query.append("       ,SUM(A.QTY7 ) QTY7 " ).append("\n"); 
		query.append("       ,SUM(A.QTY8 ) QTY8 " ).append("\n"); 
		query.append("       ,SUM(A.QTY9 ) QTY9 " ).append("\n"); 
		query.append("       ,SUM(A.QTY10) QTY10" ).append("\n"); 
		query.append("       ,SUM(A.QTY11) QTY11" ).append("\n"); 
		query.append("       ,SUM(A.QTY12) QTY12" ).append("\n"); 
		query.append("       ,SUM(A.QTY13) QTY13" ).append("\n"); 
		query.append("       ,SUM(A.QTY14) QTY14" ).append("\n"); 
		query.append("       ,SUM(A.QTY15) QTY15" ).append("\n"); 
		query.append("       ,SUM(A.QTY16) QTY16" ).append("\n"); 
		query.append("       ,SUM(A.QTY17) QTY17" ).append("\n"); 
		query.append("       ,SUM(A.QTY18) QTY18" ).append("\n"); 
		query.append("       ,SUM(A.QTY19) QTY19" ).append("\n"); 
		query.append("       ,SUM(A.QTY20) QTY20" ).append("\n"); 
		query.append("       ,SUM(A.QTY21) QTY21" ).append("\n"); 
		query.append("       ,SUM(A.QTY22) QTY22" ).append("\n"); 
		query.append("       ,SUM(A.QTY23) QTY23" ).append("\n"); 
		query.append("       ,SUM(A.QTY24) QTY24" ).append("\n"); 
		query.append("       ,SUM(A.QTY25) QTY25" ).append("\n"); 
		query.append("       ,SUM(A.QTY26) QTY26" ).append("\n"); 
		query.append("       ,SUM(A.QTY27) QTY27" ).append("\n"); 
		query.append("       ,SUM(A.QTY28) QTY28" ).append("\n"); 
		query.append("       ,SUM(A.QTY29) QTY29" ).append("\n"); 
		query.append("       ,SUM(A.QTY30) QTY30" ).append("\n"); 
		query.append("FROM LV_QTY A" ).append("\n"); 
		query.append("WHERE @[loc_type_code] = '2'" ).append("\n"); 
		query.append("AND LVL ='5'" ).append("\n"); 
		query.append("GROUP BY ROLLUP(SUBSTR(A.LOC_CD,1,2))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("     A.RCC_CD" ).append("\n"); 
		query.append("    ,A.LCC_CD" ).append("\n"); 
		query.append("    ,A.ECC_CD" ).append("\n"); 
		query.append("    ,A.SCC_CD" ).append("\n"); 
		query.append("	,A.LOC_CD" ).append("\n"); 
		query.append("    ,A.CRNT_YD_CD" ).append("\n"); 
		query.append("    ,A.LVL" ).append("\n"); 
		query.append("    ,DECODE(A.LVL, '9', '1',A.LVL0) LVL0" ).append("\n"); 
		query.append("    ,A.TOTAL_CNT" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY1 ) QTY1 " ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY2 ) QTY2 " ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY3 ) QTY3 " ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY4 ) QTY4 " ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY5 ) QTY5 " ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY6 ) QTY6 " ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY7 ) QTY7 " ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY8 ) QTY8 " ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY9 ) QTY9 " ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY10) QTY10" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY11) QTY11" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY12) QTY12" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY13) QTY13" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY14) QTY14" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY15) QTY15" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY16) QTY16" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY17) QTY17" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY18) QTY18" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY19) QTY19" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY20) QTY20" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY21) QTY21" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY22) QTY22" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY23) QTY23" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY24) QTY24" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY25) QTY25" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY26) QTY26" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY27) QTY27" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY28) QTY28" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY29) QTY29" ).append("\n"); 
		query.append("    ,TO_NUMBER(A.QTY30) QTY30" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM LV_QTY A" ).append("\n"); 
		query.append("WHERE @[loc_type_code] <> '2' " ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}