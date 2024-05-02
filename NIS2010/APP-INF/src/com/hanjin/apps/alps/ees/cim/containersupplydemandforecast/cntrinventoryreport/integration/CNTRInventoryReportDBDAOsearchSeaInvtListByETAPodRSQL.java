/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CNTRInventoryReportDBDAOsearchSeaInvtListByETAPodRSQL.java
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

public class CNTRInventoryReportDBDAOsearchSeaInvtListByETAPodRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sea Inventory (POL-POD Pair)
	  * 2011.10.12 신자영 [CHM-201113678-01] [CIM] SEA-INVENTORY POL-POD 검색 관련 보완
	  * </pre>
	  */
	public CNTRInventoryReportDBDAOsearchSeaInvtListByETAPodRSQL(){
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
		params.put("rd_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_tpsz_cd12",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("disp_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : CNTRInventoryReportDBDAOsearchSeaInvtListByETAPodRSQL").append("\n"); 
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
		query.append("SELECT LVL" ).append("\n"); 
		query.append("	,DECODE(LVL, 111, 'Total', VVD)  VVD" ).append("\n"); 
		query.append("	#if (${pol_pod_wise} == 'ETD_POL_A')" ).append("\n"); 
		query.append("    ,POL ,DECODE(LVL, 111, '', DECODE(NVL(POD, 'N'), 'N', 'Total', POD)) POD " ).append("\n"); 
		query.append("	#elseif (${pol_pod_wise} == 'ETD_POL_D')" ).append("\n"); 
		query.append("    ,POL ,DECODE(LVL, 111, '', DECODE(NVL(POD, 'N'), 'N', 'Total', POD)) POD " ).append("\n"); 
		query.append("	#elseif (${pol_pod_wise} == 'ETA_POD_A')" ).append("\n"); 
		query.append("	,POD ,DECODE(NVL(POL, 'N'), 'N', 'Total', POL) POL" ).append("\n"); 
		query.append("	#elseif (${pol_pod_wise} == 'ETA_POD_D')" ).append("\n"); 
		query.append("	,POD ,DECODE(NVL(POL, 'N'), 'N', 'Total', POL) POL" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	,DECODE(LVL, 111, '', ETD_DT)  ETD_DT" ).append("\n"); 
		query.append("	,ETA_DT" ).append("\n"); 
		query.append("	,TOTAL_CNT" ).append("\n"); 
		query.append("	,QTY1" ).append("\n"); 
		query.append("	,QTY2" ).append("\n"); 
		query.append("	,QTY3" ).append("\n"); 
		query.append("	,QTY4" ).append("\n"); 
		query.append("	,QTY5" ).append("\n"); 
		query.append("	,QTY6" ).append("\n"); 
		query.append("	,QTY7" ).append("\n"); 
		query.append("	,QTY8" ).append("\n"); 
		query.append("	,QTY9" ).append("\n"); 
		query.append("	,QTY10" ).append("\n"); 
		query.append("	,QTY11" ).append("\n"); 
		query.append("	,QTY12" ).append("\n"); 
		query.append("	,QTY13" ).append("\n"); 
		query.append("	,QTY14" ).append("\n"); 
		query.append("	,QTY15" ).append("\n"); 
		query.append("	,QTY16" ).append("\n"); 
		query.append("	,QTY17" ).append("\n"); 
		query.append("	,QTY18" ).append("\n"); 
		query.append("	,QTY19" ).append("\n"); 
		query.append("	,QTY20" ).append("\n"); 
		query.append("	,QTY21" ).append("\n"); 
		query.append("	,QTY22" ).append("\n"); 
		query.append("	,QTY23" ).append("\n"); 
		query.append("	,QTY24" ).append("\n"); 
		query.append("	,QTY25" ).append("\n"); 
		query.append("	,QTY26" ).append("\n"); 
		query.append("	,QTY27" ).append("\n"); 
		query.append("	,QTY28" ).append("\n"); 
		query.append("	,QTY29" ).append("\n"); 
		query.append("	,QTY30" ).append("\n"); 
		query.append("FROM(" ).append("\n"); 
		query.append("	SELECT LVL" ).append("\n"); 
		query.append("		,VVD" ).append("\n"); 
		query.append("		,POL" ).append("\n"); 
		query.append("        , NVL(ETD_DT, LAG(ETD_DT) OVER (PARTITION BY LVL, VVD, POL ORDER BY LVL, VVD, POL)) AS ETD_DT" ).append("\n"); 
		query.append("		#if (${pol_pod_wise} == 'ETD_POL_A')" ).append("\n"); 
		query.append("        , ROW_NUMBER() OVER (PARTITION BY LVL, ETA_DT, VVD, POL ORDER BY LVL, ETA_DT, VVD, POL) AS NO" ).append("\n"); 
		query.append("		#elseif (${pol_pod_wise} == 'ETD_POL_D')" ).append("\n"); 
		query.append("		, ROW_NUMBER() OVER (PARTITION BY LVL, ETA_DT, VVD, POL ORDER BY LVL, ETA_DT, VVD, POL) AS NO" ).append("\n"); 
		query.append("		#elseif (${pol_pod_wise} == 'ETA_POD_A')" ).append("\n"); 
		query.append("		, ROW_NUMBER() OVER (PARTITION BY LVL, ETD_DT, VVD, POD ORDER BY LVL, ETD_DT, VVD, POD) AS NO" ).append("\n"); 
		query.append("		#elseif (${pol_pod_wise} == 'ETA_POD_D')" ).append("\n"); 
		query.append("		, ROW_NUMBER() OVER (PARTITION BY LVL, ETD_DT, VVD, POD ORDER BY LVL, ETD_DT, VVD, POD) AS NO" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        ,POD " ).append("\n"); 
		query.append("		,ETA_DT" ).append("\n"); 
		query.append("		,TOTAL_CNT" ).append("\n"); 
		query.append("		,QTY1" ).append("\n"); 
		query.append("		,QTY2" ).append("\n"); 
		query.append("		,QTY3" ).append("\n"); 
		query.append("		,QTY4" ).append("\n"); 
		query.append("		,QTY5" ).append("\n"); 
		query.append("		,QTY6" ).append("\n"); 
		query.append("		,QTY7" ).append("\n"); 
		query.append("		,QTY8" ).append("\n"); 
		query.append("		,QTY9" ).append("\n"); 
		query.append("		,QTY10" ).append("\n"); 
		query.append("		,QTY11" ).append("\n"); 
		query.append("		,QTY12" ).append("\n"); 
		query.append("		,QTY13" ).append("\n"); 
		query.append("		,QTY14" ).append("\n"); 
		query.append("		,QTY15" ).append("\n"); 
		query.append("		,QTY16" ).append("\n"); 
		query.append("		,QTY17" ).append("\n"); 
		query.append("		,QTY18" ).append("\n"); 
		query.append("		,QTY19" ).append("\n"); 
		query.append("		,QTY20" ).append("\n"); 
		query.append("		,QTY21" ).append("\n"); 
		query.append("		,QTY22" ).append("\n"); 
		query.append("		,QTY23" ).append("\n"); 
		query.append("		,QTY24" ).append("\n"); 
		query.append("		,QTY25" ).append("\n"); 
		query.append("		,QTY26" ).append("\n"); 
		query.append("		,QTY27" ).append("\n"); 
		query.append("		,QTY28" ).append("\n"); 
		query.append("		,QTY29" ).append("\n"); 
		query.append("		,QTY30  " ).append("\n"); 
		query.append("	FROM(" ).append("\n"); 
		query.append("		SELECT  LVL, VVD,POL, ETD_DT, POD, ETA_DT, " ).append("\n"); 
		query.append("			SUM(TOTAL_CNT) TOTAL_CNT," ).append("\n"); 
		query.append("			SUM(QTY1)  AS QTY1," ).append("\n"); 
		query.append("			SUM(QTY2)  AS QTY2," ).append("\n"); 
		query.append("			SUM(QTY3)  AS QTY3," ).append("\n"); 
		query.append("			SUM(QTY4)  AS QTY4," ).append("\n"); 
		query.append("			SUM(QTY5)  AS QTY5," ).append("\n"); 
		query.append("			SUM(QTY6)  AS QTY6," ).append("\n"); 
		query.append("			SUM(QTY7)  AS QTY7," ).append("\n"); 
		query.append("			SUM(QTY8)  AS QTY8," ).append("\n"); 
		query.append("			SUM(QTY9)  AS QTY9," ).append("\n"); 
		query.append("			SUM(QTY10)  AS QTY10," ).append("\n"); 
		query.append("			SUM(QTY11)  AS QTY11," ).append("\n"); 
		query.append("			SUM(QTY12)  AS QTY12," ).append("\n"); 
		query.append("			SUM(QTY13)  AS QTY13," ).append("\n"); 
		query.append("			SUM(QTY14)  AS QTY14," ).append("\n"); 
		query.append("			SUM(QTY15)  AS QTY15," ).append("\n"); 
		query.append("			SUM(QTY16)  AS QTY16," ).append("\n"); 
		query.append("			SUM(QTY17)  AS QTY17," ).append("\n"); 
		query.append("			SUM(QTY18)  AS QTY18," ).append("\n"); 
		query.append("			SUM(QTY19)  AS QTY19," ).append("\n"); 
		query.append("			SUM(QTY20)  AS QTY20," ).append("\n"); 
		query.append("			SUM(QTY21)  AS QTY21," ).append("\n"); 
		query.append("			SUM(QTY22)  AS QTY22," ).append("\n"); 
		query.append("			SUM(QTY23)  AS QTY23," ).append("\n"); 
		query.append("			SUM(QTY24)  AS QTY24," ).append("\n"); 
		query.append("			SUM(QTY25)  AS QTY25," ).append("\n"); 
		query.append("			SUM(QTY26)  AS QTY26," ).append("\n"); 
		query.append("			SUM(QTY27)  AS QTY27," ).append("\n"); 
		query.append("			SUM(QTY28)  AS QTY28," ).append("\n"); 
		query.append("			SUM(QTY29)  AS QTY29," ).append("\n"); 
		query.append("			SUM(QTY30)  AS QTY30" ).append("\n"); 
		query.append("		FROM (" ).append("\n"); 
		query.append("			SELECT  A.LVL" ).append("\n"); 
		query.append("				,A.VVD VVD" ).append("\n"); 
		query.append("				,POL_CD  POL" ).append("\n"); 
		query.append("				,NVL(" ).append("\n"); 
		query.append("				(	SELECT TO_CHAR(MAX(B.VPS_ETD_DT),'YYYYMMDD')" ).append("\n"); 
		query.append("					FROM  VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("					WHERE SUBSTR(A.VVD,1,4) = B.VSL_CD" ).append("\n"); 
		query.append("					AND   SUBSTR(A.VVD,5,4) = B.SKD_VOY_NO" ).append("\n"); 
		query.append("					AND   SUBSTR(A.VVD,9,1) = B.SKD_DIR_CD" ).append("\n"); 
		query.append("					AND   A.POL_CD = B.VPS_PORT_CD" ).append("\n"); 
		query.append("					AND   A.LVL=000), '99991231') ETD_DT" ).append("\n"); 
		query.append("				,A.POD_CD  POD" ).append("\n"); 
		query.append("				,NVL(" ).append("\n"); 
		query.append("				(	SELECT TO_CHAR(MIN(B.VPS_ETA_DT),'YYYYMMDD')" ).append("\n"); 
		query.append("					FROM  VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("					WHERE SUBSTR(A.VVD,1,4) = B.VSL_CD" ).append("\n"); 
		query.append("					AND   SUBSTR(A.VVD,5,4) = B.SKD_VOY_NO" ).append("\n"); 
		query.append("					AND   SUBSTR(A.VVD,9,1) = B.SKD_DIR_CD" ).append("\n"); 
		query.append("					AND   A.POD_CD = B.VPS_PORT_CD" ).append("\n"); 
		query.append("					AND   A.LVL=000), '99991231') ETA_DT" ).append("\n"); 
		query.append("				,A.TOTAL_CNT" ).append("\n"); 
		query.append("				,A.QTY1" ).append("\n"); 
		query.append("				,A.QTY2" ).append("\n"); 
		query.append("				,A.QTY3" ).append("\n"); 
		query.append("				,A.QTY4" ).append("\n"); 
		query.append("				,A.QTY5" ).append("\n"); 
		query.append("				,A.QTY6" ).append("\n"); 
		query.append("				,A.QTY7" ).append("\n"); 
		query.append("				,A.QTY8" ).append("\n"); 
		query.append("				,A.QTY9" ).append("\n"); 
		query.append("				,A.QTY10" ).append("\n"); 
		query.append("				,A.QTY11" ).append("\n"); 
		query.append("				,A.QTY12" ).append("\n"); 
		query.append("				,A.QTY13" ).append("\n"); 
		query.append("				,A.QTY14" ).append("\n"); 
		query.append("				,A.QTY15" ).append("\n"); 
		query.append("				,A.QTY16" ).append("\n"); 
		query.append("				,A.QTY17" ).append("\n"); 
		query.append("				,A.QTY18" ).append("\n"); 
		query.append("				,A.QTY19" ).append("\n"); 
		query.append("				,A.QTY20" ).append("\n"); 
		query.append("				,A.QTY21" ).append("\n"); 
		query.append("				,A.QTY22" ).append("\n"); 
		query.append("				,A.QTY23" ).append("\n"); 
		query.append("				,A.QTY24" ).append("\n"); 
		query.append("				,A.QTY25" ).append("\n"); 
		query.append("				,A.QTY26" ).append("\n"); 
		query.append("				,A.QTY27" ).append("\n"); 
		query.append("				,A.QTY28" ).append("\n"); 
		query.append("				,A.QTY29" ).append("\n"); 
		query.append("				,A.QTY30" ).append("\n"); 
		query.append("			FROM (" ).append("\n"); 
		query.append("				SELECT " ).append("\n"); 
		query.append("                /* LEADING(A)   */ " ).append("\n"); 
		query.append("		#if (${pol_pod_wise} == 'ETD_POL_A'||${pol_pod_wise} == 'ETD_POL_D')" ).append("\n"); 
		query.append("	        GROUPING(nvl(A.VSL_CD,'xxxx')||nvl(A.SKD_VOY_NO,'0000')||nvl(A.SKD_DIR_CD,'x'))||GROUPING(nvl(DECODE('${route_tp_cd}','B',B.POL_CD,SUBSTR(A.CRNT_YD_CD,1,5)),'XXXXX'))||GROUPING(nvl(DECODE('${route_tp_cd}','B',SUBSTR(B.POD_NOD_CD,1,5),SUBSTR(C.POD_YD_CD,1,5)),'XXXXX')) LVL" ).append("\n"); 
		query.append("	        ,nvl(A.VSL_CD,'xxxx')||nvl(A.SKD_VOY_NO,'0000')||nvl(A.SKD_DIR_CD,'x') VVD" ).append("\n"); 
		query.append("			,nvl(DECODE('${route_tp_cd}','B',B.POL_CD,SUBSTR(A.CRNT_YD_CD,1,5)),'XXXXX')  POL_CD " ).append("\n"); 
		query.append("			,nvl(DECODE('${route_tp_cd}','B',SUBSTR(B.POD_NOD_CD,1,5),SUBSTR(C.POD_YD_CD,1,5)),'XXXXX')  POD_CD" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("	        GROUPING(nvl(A.VSL_CD,'xxxx')||nvl(A.SKD_VOY_NO,'0000')||nvl(A.SKD_DIR_CD,'x'))||GROUPING(nvl(DECODE('${route_tp_cd}','B',SUBSTR(B.POD_NOD_CD,1,5),SUBSTR(C.POD_YD_CD,1,5)),'XXXXX'))||GROUPING(nvl(DECODE('${route_tp_cd}','B',B.POL_CD,SUBSTR(A.CRNT_YD_CD,1,5)),'XXXXX')) LVL" ).append("\n"); 
		query.append("	        ,nvl(A.VSL_CD,'xxxx')||nvl(A.SKD_VOY_NO,'0000')||nvl(A.SKD_DIR_CD,'x') VVD" ).append("\n"); 
		query.append("			,nvl(DECODE('${route_tp_cd}','B',SUBSTR(B.POD_NOD_CD,1,5),SUBSTR(C.POD_YD_CD,1,5)),'XXXXX')  POD_CD" ).append("\n"); 
		query.append("			,nvl(DECODE('${route_tp_cd}','B',B.POL_CD,SUBSTR(A.CRNT_YD_CD,1,5)),'XXXXX')  POL_CD" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("        			--GROUPING(NVL(A.VSL_CD,'xxxx')||NVL(A.SKD_VOY_NO,'0000')||NVL(A.SKD_DIR_CD,'x'))||GROUPING(NVL(DECODE('V','B',B.POL_CD,SUBSTR(A.CRNT_YD_CD,1,5)),'XXXXX'))||GROUPING(nvl(DECODE('V','B',SUBSTR(B.POD_NOD_CD,1,5),SUBSTR(C.POD_YD_CD,1,5)),'XXXXX')) LVL" ).append("\n"); 
		query.append("        	        --,NVL(A.VSL_CD,'xxxx')||nvl(A.SKD_VOY_NO,'0000')||nvl(A.SKD_DIR_CD,'x') VVD" ).append("\n"); 
		query.append("        			--,NVL(DECODE('V','B',B.POL_CD,SUBSTR(A.CRNT_YD_CD,1,5)),'XXXXX')  POL_CD " ).append("\n"); 
		query.append("        			--,NVL(DECODE('V','B',SUBSTR(B.POD_NOD_CD,1,5),SUBSTR(C.POD_YD_CD,1,5)),'XXXXX')  POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        		    ,COUNT(*)   TOTAL_CNT" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd1]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd1]  ,1)),0)) QTY1 " ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd2]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd2]  ,1)),0)) QTY2 " ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd3]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd3]  ,1)),0)) QTY3 " ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd4]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd4]  ,1)),0)) QTY4 " ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd5]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd5]  ,1)),0)) QTY5 " ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd6]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd6]  ,1)),0)) QTY6 " ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd7]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd7]  ,1)),0)) QTY7 " ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd8]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd8]  ,1)),0)) QTY8 " ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd9]  ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd9]  ,1)),0)) QTY9 " ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd10] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd10] ,1)),0)) QTY10" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd11] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd11] ,1)),0)) QTY11" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd12] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd12] ,1)),0)) QTY12" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd13] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd13] ,1)),0)) QTY13" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd14] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd14] ,1)),0)) QTY14" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd15] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd15] ,1)),0)) QTY15" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd16] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd16] ,1)),0)) QTY16" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd17] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd17] ,1)),0)) QTY17" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd18] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd18] ,1)),0)) QTY18" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd19] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd19] ,1)),0)) QTY19" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd20] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd20] ,1)),0)) QTY20" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd21] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd21] ,1)),0)) QTY21" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd22] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd22] ,1)),0)) QTY22" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd23] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd23] ,1)),0)) QTY23" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd24] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd24] ,1)),0)) QTY24" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd25] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd25] ,1)),0)) QTY25" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd26] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd26] ,1)),0)) QTY26" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd27] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd27] ,1)),0)) QTY27" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd28] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd28] ,1)),0)) QTY28" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd29] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd29] ,1)),0)) QTY29" ).append("\n"); 
		query.append("					,DECODE(INSTR(@[cntr_tpsz_cd],@[cntr_tpsz_cd30] ),0,NULL,NVL(SUM(DECODE(A.CNTR_TPSZ_CD,@[cntr_tpsz_cd30] ,1)),0)) QTY30" ).append("\n"); 
		query.append("				FROM MST_CONTAINER A" ).append("\n"); 
		query.append("					,BKG_BOOKING B" ).append("\n"); 
		query.append("					,BKG_VVD C" ).append("\n"); 
		query.append("				WHERE A.ACIAC_DIV_CD='A'" ).append("\n"); 
		query.append("				AND   A.CNMV_STS_CD='VL'" ).append("\n"); 
		query.append("				AND A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("				AND A.BKG_NO = C.BKG_NO(+)" ).append("\n"); 
		query.append("				AND A.VSL_CD = C.VSL_CD(+)" ).append("\n"); 
		query.append("				AND A.SKD_VOY_NO = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("				AND A.SKD_DIR_CD = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if(${off_hire_flg} != '')" ).append("\n"); 
		query.append("				AND (" ).append("\n"); 
		query.append("                      ( A.LSTM_CD = 'LT' AND NVL(A.min_onh_dys,0) > 0" ).append("\n"); 
		query.append("                          AND  TRUNC(SYSDATE) > TRUNC(A.ONH_DT) + (NVL(A.MIN_ONH_DYS,0) - 1)" ).append("\n"); 
		query.append("                      )" ).append("\n"); 
		query.append("                      OR" ).append("\n"); 
		query.append("	                  ( A.LSTM_CD = 'LT' AND NVL(A.min_onh_dys,0) = 0" ).append("\n"); 
		query.append("   	                    AND  TRUNC(SYSDATE) - ( SELECT /*+ INDEX_DESC (S XPKLSE_AGMT_VER) */ TRUNC(EXP_DT)" ).append("\n"); 
		query.append("                                                  FROM   LSE_AGMT_VER S" ).append("\n"); 
		query.append("                                                 WHERE  S.AGMT_CTY_CD = A.AGMT_CTY_CD" ).append("\n"); 
		query.append("                                                   AND    S.AGMT_SEQ    = A.AGMT_SEQ" ).append("\n"); 
		query.append("                                                   AND    ROWNUM = 1" ).append("\n"); 
		query.append("                       ) > 0" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                OR" ).append("\n"); 
		query.append("                 ( A.LSTM_CD IN ('ST', 'SI', 'OF', 'MI')" ).append("\n"); 
		query.append("                     AND TRUNC(SYSDATE)  > TRUNC(A.ONH_DT) + (NVL(A.MIN_ONH_DYS,0) - 1)" ).append("\n"); 
		query.append("                 )" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				#if (${slan_cd} != '' && ${slan_cd} != 'XXX')" ).append("\n"); 
		query.append("				AND C.SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("				AND A.CNTR_TPSZ_CD IN ( " ).append("\n"); 
		query.append("    		  		SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	        FROM TABLE (SELECT cast( CIM_IN_LIST_FNC( @[cntr_tpsz_cd]  ) AS listItemType ) " ).append("\n"); 
		query.append("            	        FROM dual )" ).append("\n"); 
		query.append("    			)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				#if (${imdt_ext_flg} != '')" ).append("\n"); 
		query.append("				AND A.IMDT_EXT_FLG =@[imdt_ext_flg]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${plst_flr_flg} != '')" ).append("\n"); 
		query.append("				AND A.PLST_FLR_FLG =@[plst_flr_flg]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("				#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("				AND A.LSTM_CD IN ( " ).append("\n"); 
		query.append("    		  				 SELECT COLUMN_VALUE" ).append("\n"); 
		query.append("        	                 FROM TABLE ( SELECT cast( CIM_IN_LIST_FNC( @[lstm_cd] ) AS listItemType ) " ).append("\n"); 
		query.append("            	             FROM dual )" ).append("\n"); 
		query.append("    				        )" ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("				#if (${cntr_no} != '')" ).append("\n"); 
		query.append("				AND SUBSTR(A.CNTR_NO,0,4) = @[cntr_no]" ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if ( ${slan_cd} =='XXX' ) --vvd정보가 없을시 " ).append("\n"); 
		query.append("				AND UPPER(nvl(A.VSL_CD,'xxxx')||nvl(A.SKD_VOY_NO,'0000')||nvl(A.SKD_DIR_CD,'x')) ='XXXX0000X'" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${vvd1} != '' || ${vvd2} != '' || ${vvd3} != '') " ).append("\n"); 
		query.append("					#if (${vvd1} == 'XXXX0000' || ${vvd2} != 'XXXX0000' || ${vvd3} != 'XXXX0000') " ).append("\n"); 
		query.append("					AND UPPER(nvl(A.VSL_CD,'xxxx')||nvl(A.SKD_VOY_NO,'0000')||A.SKD_DIR_CD) IN ( @[vvd1],@[vvd2],@[vvd3])" ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("					AND (A.VSL_CD,A.SKD_VOY_NO,A.SKD_DIR_CD) IN ( (SUBSTR(@[vvd1],1,4),SUBSTR(@[vvd1],5,4),SUBSTR(@[vvd1],9,1)), (SUBSTR(@[vvd2],1,4),SUBSTR(@[vvd2],5,4),SUBSTR(@[vvd2],9,1)), (SUBSTR(@[vvd3],1,4),SUBSTR(@[vvd3],5,4),SUBSTR(@[vvd3],9,1)) )" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end    " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("				#if (${pol_cd} != '')" ).append("\n"); 
		query.append("				AND DECODE('${route_tp_cd}','B',B.POL_CD,SUBSTR(A.CRNT_YD_CD,1,5)) = @[pol_cd]" ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				#if (${pod_cd} != '')" ).append("\n"); 
		query.append("				AND NVL(DECODE('${route_tp_cd}','B',SUBSTR(B.POD_NOD_CD,1,5),SUBSTR(C.POD_YD_CD,1,5)),'XXXXX') = @[pod_cd]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				#if (${del_cd} != '')" ).append("\n"); 
		query.append("				AND B.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("				#if (${stay_days} != '')" ).append("\n"); 
		query.append("				AND TRUNC(SYSDATE) - TRUNC(CNMV_DT) + 1 > = @[stay_days]" ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${full_flg} != '')" ).append("\n"); 
		query.append("				AND A.FULL_FLG = @[full_flg]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${dmg_flg} != '')" ).append("\n"); 
		query.append("				AND A.DMG_FLG = @[dmg_flg]" ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("				#if (${rf_tp_cd_c} != '' || ${rf_tp_cd_h} != '' || ${rf_cntr} != '' || ${rd_cgo_flg} != '')" ).append("\n"); 
		query.append("				AND A.CNTR_TPSZ_CD LIKE 'R%'" ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${rf_tp_cd_c} != '' || ${rf_tp_cd_h} != '')" ).append("\n"); 
		query.append("				AND A.RF_TP_CD IN(@[rf_tp_cd_c],@[rf_tp_cd_h])" ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("				#if (${rd_cgo_flg} != '' || ${rf_cntr} != '')" ).append("\n"); 
		query.append("				AND B.RD_CGO_FLG IN(@[rf_cntr],@[rd_cgo_flg])" ).append("\n"); 
		query.append("				#end  " ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("				#if (${cntr_hngr_rck_cd} != '')" ).append("\n"); 
		query.append("				AND (A.CNTR_HNGR_RCK_CD IS NOT NULL  OR  A.CNTR_HNGR_BAR_ATCH_KNT > 0)" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("				#if (${disp_flg} != '')" ).append("\n"); 
		query.append("				AND A.DISP_FLG = @[disp_flg]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				#if (${d2_payld_flg} != '')" ).append("\n"); 
		query.append("				  AND A.CNTR_TPSZ_CD ='D2'" ).append("\n"); 
		query.append("				  AND A.D2_PAYLD_FLG = @[d2_payld_flg]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				" ).append("\n"); 
		query.append("				#if (${soc_cd} != '')" ).append("\n"); 
		query.append("					#if (${soc_cd} == '1')" ).append("\n"); 
		query.append("					AND A.LSTM_CD <> 'SH'" ).append("\n"); 
		query.append("					#else" ).append("\n"); 
		query.append("					AND A.LSTM_CD = 'SH'" ).append("\n"); 
		query.append("					#end" ).append("\n"); 
		query.append("				#end	" ).append("\n"); 
		query.append("				#if (${pol_pod_wise} == 'ETD_POL_A'||${pol_pod_wise} == 'ETD_POL_D')" ).append("\n"); 
		query.append("        			GROUP BY CUBE(nvl(A.VSL_CD,'xxxx')||nvl(A.SKD_VOY_NO,'0000')||nvl(A.SKD_DIR_CD,'x'),nvl(DECODE('${route_tp_cd}','B',B.POL_CD,SUBSTR(A.CRNT_YD_CD,1,5)),'XXXXX'),nvl(DECODE('${route_tp_cd}','B',SUBSTR(B.POD_NOD_CD,1,5),SUBSTR(C.POD_YD_CD,1,5)),'XXXXX'))" ).append("\n"); 
		query.append("        			ORDER BY      nvl(A.VSL_CD,'xxxx')||nvl(A.SKD_VOY_NO,'0000')||nvl(A.SKD_DIR_CD,'x'),nvl(DECODE('${route_tp_cd}','B',B.POL_CD,SUBSTR(A.CRNT_YD_CD,1,5)),'XXXXX'),nvl(DECODE('${route_tp_cd}','B',SUBSTR(B.POD_NOD_CD,1,5),SUBSTR(C.POD_YD_CD,1,5)),'XXXXX')" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("        			GROUP BY CUBE(nvl(A.VSL_CD,'xxxx')||nvl(A.SKD_VOY_NO,'0000')||nvl(A.SKD_DIR_CD,'x'),nvl(DECODE('${route_tp_cd}','B',SUBSTR(B.POD_NOD_CD,1,5),SUBSTR(C.POD_YD_CD,1,5)),'XXXXX'),nvl(DECODE('${route_tp_cd}','B',B.POL_CD,SUBSTR(A.CRNT_YD_CD,1,5)),'XXXXX'))" ).append("\n"); 
		query.append("        			ORDER BY      nvl(A.VSL_CD,'xxxx')||nvl(A.SKD_VOY_NO,'0000')||nvl(A.SKD_DIR_CD,'x'),nvl(DECODE('${route_tp_cd}','B',SUBSTR(B.POD_NOD_CD,1,5),SUBSTR(C.POD_YD_CD,1,5)),'XXXXX'),nvl(DECODE('${route_tp_cd}','B',B.POL_CD,SUBSTR(A.CRNT_YD_CD,1,5)),'XXXXX')" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("				) A" ).append("\n"); 
		query.append("			WHERE 1=1" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("		#if (${pol_pod_wise} == 'ETD_POL_A')" ).append("\n"); 
		query.append("		GROUP BY GROUPING SETS ( (LVL, ETD_DT, VVD, POL), (LVL,VVD,POL,ETD_DT,POD,ETA_DT) )" ).append("\n"); 
		query.append("		#elseif (${pol_pod_wise} == 'ETD_POL_D')" ).append("\n"); 
		query.append("		GROUP BY GROUPING SETS ( (LVL, ETD_DT, VVD, POL), (LVL,VVD,POL,ETD_DT,POD,ETA_DT) )" ).append("\n"); 
		query.append("		#elseif (${pol_pod_wise} == 'ETA_POD_A')" ).append("\n"); 
		query.append("        GROUP BY GROUPING SETS ( (LVL, ETA_DT, VVD, POD), (LVL,VVD,POL,ETD_DT,POD,ETA_DT) )" ).append("\n"); 
		query.append("		#elseif (${pol_pod_wise} == 'ETA_POD_D')" ).append("\n"); 
		query.append("        GROUP BY GROUPING SETS ( (LVL, ETA_DT, VVD, POD), (LVL,VVD,POL,ETD_DT,POD,ETA_DT) )" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("WHERE LVL  IN (000,111)    -- 추가" ).append("\n"); 
		query.append("#if (${pol_pod_wise} == 'ETD_POL_A')" ).append("\n"); 
		query.append("ORDER BY LVL ASC,  ETD_DT  ,VVD, POL,  ETA_DT" ).append("\n"); 
		query.append("#elseif (${pol_pod_wise} == 'ETD_POL_D')" ).append("\n"); 
		query.append("ORDER BY LVL ASC,  ETD_DT DESC, VVD DESC, POL DESC, ETA_DT ASC" ).append("\n"); 
		query.append("#elseif (${pol_pod_wise} == 'ETA_POD_A')" ).append("\n"); 
		query.append("ORDER BY LVL ASC, ETA_DT  ,VVD, POD,  ETD_DT" ).append("\n"); 
		query.append("#elseif (${pol_pod_wise} == 'ETA_POD_D')" ).append("\n"); 
		query.append("ORDER BY LVL ASC, ETA_DT DESC, VVD DESC, POD DESC, ETD_DT ASC" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}