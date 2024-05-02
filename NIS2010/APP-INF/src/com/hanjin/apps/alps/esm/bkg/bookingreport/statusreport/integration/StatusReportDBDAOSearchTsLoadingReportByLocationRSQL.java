/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : StatusReportDBDAOSearchTsLoadingReportByLocationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.01.26 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOSearchTsLoadingReportByLocationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * StatusReportDBDAOSearchTsLoadingReportByLocationRSQL
	  * </pre>
	  */
	public StatusReportDBDAOSearchTsLoadingReportByLocationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dura_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_tmnl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("out_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trade_zone",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dura_to_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shipper_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("location_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("order_by",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOSearchTsLoadingReportByLocationRSQL").append("\n"); 
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
		query.append("/* For Select */" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("ROWNUM SEQ_NO" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(SUM(TEU) OVER(),'99990.99')) TOTAL_40T" ).append("\n"); 
		query.append(", TRIM(TO_CHAR(SUM(FEU) OVER(),'99990.99')) TOTAL_20T" ).append("\n"); 
		query.append(", ${order_by_title} AS ORDER_BY_TITLE" ).append("\n"); 
		query.append(", Y.*" ).append("\n"); 
		query.append("FROM ( SELECT   /*+ ORDERED */" ).append("\n"); 
		query.append("SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',CNTR_VOL_QTY,0)) AS TEU," ).append("\n"); 
		query.append("SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),'2',0,CNTR_VOL_QTY)) AS FEU," ).append("\n"); 
		query.append("BKG_NO,       SHIPPER_CD,  POL_CD,  POD_CD,   IN_VVD,  OUT_VVD," ).append("\n"); 
		query.append("BL_NO,        SHIPPER_NM,  IN_LANE, OUT_LANE, IN_TMNL, OUT_TMNL, IN_ZONE, OUT_ZONE" ).append("\n"); 
		query.append("FROM (  SELECT" ).append("\n"); 
		query.append("BK.BKG_NO," ).append("\n"); 
		query.append("CUST.CUST_CNT_CD||CUST.CUST_SEQ AS SHIPPER_CD," ).append("\n"); 
		query.append("VVD.POL_CD," ).append("\n"); 
		query.append("VVD.POD_CD," ).append("\n"); 
		query.append("IN_VVD.VSL_CD||IN_VVD.SKD_VOY_NO||IN_VVD.SKD_DIR_CD           AS IN_VVD," ).append("\n"); 
		query.append("OUT_VVD.VSL_CD||OUT_VVD.SKD_VOY_NO||OUT_VVD.SKD_DIR_CD        AS OUT_VVD," ).append("\n"); 
		query.append("CNTR.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNTR_VOL_QTY," ).append("\n"); 
		query.append("BK.BL_NO," ).append("\n"); 
		query.append("REPLACE(CUST.CUST_NM,CHR(13)||CHR(10),' ') AS SHIPPER_NM," ).append("\n"); 
		query.append("IN_VVD.SLAN_CD     AS IN_LANE," ).append("\n"); 
		query.append("OUT_VVD.SLAN_CD    AS OUT_LANE," ).append("\n"); 
		query.append("IN_VVD.POL_YD_CD   AS IN_TMNL," ).append("\n"); 
		query.append("OUT_VVD.POL_YD_CD  AS OUT_TMNL," ).append("\n"); 
		query.append("DECODE(SUBSTR(IN_VVD.POL_CD,1,2), 'JP','JPN',DECODE(IN_POL.CONTI_CD,'M','USA','E','EUR',DECODE(SUBSTR(IN_POL.SCONTI_CD,1,1),SUBSTR(IN_POL.SCONTI_CD,1,1),'IPC','PRC'))) IN_ZONE," ).append("\n"); 
		query.append("DECODE(SUBSTR(OUT_VVD.POD_CD,1,2),'JP','JPN',DECODE(OUT_POD.CONTI_CD,'M','USA','E','EUR',DECODE(SUBSTR(OUT_POL.SCONTI_CD,1,1),SUBSTR(OUT_POD.SCONTI_CD,1,1),'IPC','PRC')))  OUT_ZONE" ).append("\n"); 
		query.append("FROM   (SELECT" ).append("\n"); 
		query.append("S.VSL_CD, S.SKD_VOY_NO, S.SKD_DIR_CD, S.VPS_PORT_CD, S.VPS_ETD_DT ,CLPT_SEQ ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD S  ,VSK_VSL_SKD V" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    S.VPS_ETD_DT >= TO_DATE(@[dura_from_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("AND    S.VPS_ETD_DT <= TO_DATE(@[dura_to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND    NVL(SKD_CNG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("AND    S.VSL_CD  = V.VSL_CD" ).append("\n"); 
		query.append("AND    S.SKD_VOY_NO = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    S.SKD_DIR_CD  = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    S.SLAN_CD  = V.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND    V.SKD_STS_CD <> 'RDY'" ).append("\n"); 
		query.append("AND    S.VPS_PORT_CD = @[location_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* location_yd_cd */" ).append("\n"); 
		query.append("#if (${location_yd_cd} != '')" ).append("\n"); 
		query.append("AND    S.YD_CD = @[location_cd]||@[location_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") VSP," ).append("\n"); 
		query.append("BKG_VVD VVD, BKG_BOOKING BK," ).append("\n"); 
		query.append("BKG_CONTAINER CNTR, BKG_CUSTOMER CUST," ).append("\n"); 
		query.append("BKG_VVD IN_VVD, BKG_VVD OUT_VVD," ).append("\n"); 
		query.append("MDM_LOCATION IN_POL,MDM_LOCATION IN_POD," ).append("\n"); 
		query.append("MDM_LOCATION OUT_POL,MDM_LOCATION OUT_POD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VSP.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("AND VSP.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VSP.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VSP.CLPT_IND_SEQ  = VVD.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND VPS_PORT_CD = VVD.POD_CD" ).append("\n"); 
		query.append("AND VVD.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND VVD.BKG_NO = IN_VVD.BKG_NO(+)" ).append("\n"); 
		query.append("AND VVD.POL_CD = IN_VVD.POD_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND VVD.BKG_NO = OUT_VVD.BKG_NO(+)" ).append("\n"); 
		query.append("AND VVD.POD_CD = OUT_VVD.POL_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND VVD.BKG_NO = CUST.BKG_NO" ).append("\n"); 
		query.append("AND CUST.BKG_CUST_TP_CD ='S'" ).append("\n"); 
		query.append("AND BK.BKG_NO = CNTR.BKG_NO" ).append("\n"); 
		query.append("AND  IN_VVD.POL_CD = IN_POL.LOC_CD(+)" ).append("\n"); 
		query.append("AND  IN_VVD.POD_CD = IN_POD.LOC_CD(+)" ).append("\n"); 
		query.append("AND  OUT_VVD.POL_CD = OUT_POL.LOC_CD(+)" ).append("\n"); 
		query.append("AND  OUT_VVD.POD_CD = OUT_POD.LOC_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* bl_type_ob */" ).append("\n"); 
		query.append("#if (${bl_type_ob} != '')" ).append("\n"); 
		query.append("AND    BK.POL_CD = @[location_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* bl_type_ts */" ).append("\n"); 
		query.append("#if (${bl_type_ts} != '')" ).append("\n"); 
		query.append("AND    VVD.POL_CD = @[location_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* POL */" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND    VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* POD */" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND    VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* OUT LANE */" ).append("\n"); 
		query.append("#if (${out_lane} != '')" ).append("\n"); 
		query.append("AND    OUT_VVD.SLAN_CD = @[out_lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* OUT LANE */" ).append("\n"); 
		query.append("#if (${out_lane} != '')" ).append("\n"); 
		query.append("AND    OUT_VVD.SLAN_CD = @[out_lane]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* OUT TMNL */" ).append("\n"); 
		query.append("#if (${out_tmnl} != '')" ).append("\n"); 
		query.append("AND    OUT_VVD.POL_YD_CD = @[out_tmnl]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("/* TRADE ZONE */" ).append("\n"); 
		query.append("#if (${trade_zone} != '')" ).append("\n"); 
		query.append("AND    OUT_ZONE = @[trade_zone]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("/* SHIPPER CD*/" ).append("\n"); 
		query.append("#if (${shipper_cd} != '')" ).append("\n"); 
		query.append("AND    SHIPPER_CD = @[shipper_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY BKG_NO,       SHIPPER_CD,  POL_CD,  POD_CD,   IN_VVD,  OUT_VVD," ).append("\n"); 
		query.append("BL_NO,        SHIPPER_NM,  IN_LANE, OUT_LANE, IN_TMNL, OUT_TMNL, IN_ZONE, OUT_ZONE" ).append("\n"); 
		query.append("ORDER BY @[order_by]" ).append("\n"); 
		query.append(") Y" ).append("\n"); 

	}
}