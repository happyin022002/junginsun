/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PerformanceReportDBDAOVesselUtilizationStatusReportOutVO2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2010.01.13 강동윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOVesselUtilizationStatusReportOutVO2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public PerformanceReportDBDAOVesselUtilizationStatusReportOutVO2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOVesselUtilizationStatusReportOutVO2RSQL").append("\n"); 
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
		query.append("WITH TMP AS" ).append("\n"); 
		query.append("(   SELECT VVD.VSL_CD" ).append("\n"); 
		query.append(",VVD.SKD_VOY_NO" ).append("\n"); 
		query.append(",VVD.SKD_DIR_CD" ).append("\n"); 
		query.append(",VVD.POL_CD" ).append("\n"); 
		query.append(",VVD.POD_CD" ).append("\n"); 
		query.append(",BKG.BKG_CGO_TP_CD" ).append("\n"); 
		query.append(",ORG.CONTI_CD    ORG_CONTI_CD" ).append("\n"); 
		query.append(",DES.CONTI_CD    DES_CONTI_CD" ).append("\n"); 
		query.append(",QUA.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",QUA.OP_CNTR_QTY" ).append("\n"); 
		query.append(",DECODE(VVD.POL_CD,'KRPUS',DECODE(VVD.POL_YD_CD,'KRPUSHN',VVD.POL_YD_CD,' '),' ') POL_YD_CD" ).append("\n"); 
		query.append(",DECODE(VVD.POD_CD,'KRPUS',DECODE(VVD.POD_YD_CD,'KRPUSHN',VVD.POD_YD_CD,' '),' ') POD_YD_CD" ).append("\n"); 
		query.append(",DECODE(BKG_CGO_TP_CD,'F',-- FULL CARGO" ).append("\n"); 
		query.append("DECODE(ORG.CONTI_CD, DES.CONTI_CD, -- INTER" ).append("\n"); 
		query.append("DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'2',OP_CNTR_QTY,OP_CNTR_QTY * 2),0))  IPC" ).append("\n"); 
		query.append(",DECODE(BKG_CGO_TP_CD,'F',-- FULL CARGO" ).append("\n"); 
		query.append("DECODE(ORG.CONTI_CD, DES.CONTI_CD, 0, -- OCEAN" ).append("\n"); 
		query.append("DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'2',OP_CNTR_QTY,OP_CNTR_QTY * 2)))    OCN" ).append("\n"); 
		query.append(",DECODE(BKG_CGO_TP_CD,'P',-- EMPTY CARGO" ).append("\n"); 
		query.append("DECODE(SUBSTR(CNTR_TPSZ_CD,-1),'2',OP_CNTR_QTY,OP_CNTR_QTY * 2))         MTY" ).append("\n"); 
		query.append("FROM BKG_BOOKING      BKG" ).append("\n"); 
		query.append(",BKG_VVD          VVD" ).append("\n"); 
		query.append(",BKG_QUANTITY     QUA" ).append("\n"); 
		query.append(",MDM_LOCATION     ORG" ).append("\n"); 
		query.append(",MDM_LOCATION     DES" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND BKG.BKG_NO = QUA.BKG_NO" ).append("\n"); 
		query.append("AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("AND BKG.POL_CD = ORG.LOC_CD" ).append("\n"); 
		query.append("AND BKG.POD_CD = DES.LOC_CD" ).append("\n"); 
		query.append("AND VVD.VSL_CD = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT DECODE(SKD.VPS_PORT_CD,'KRPUS',DECODE(SKD.YD_CD,'KRPUSHN',SKD.YD_CD,'KRPUS'),SKD.VPS_PORT_CD) AS VPS_PORT_CD" ).append("\n"); 
		query.append(",SKD.SLAN_CD" ).append("\n"); 
		query.append(",SKD.VSL_CD" ).append("\n"); 
		query.append(",SKD.SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD.SKD_DIR_CD" ).append("\n"); 
		query.append(",LOD.POL_YD_CD" ).append("\n"); 
		query.append(",TO_CHAR(SKD.VPS_ETA_DT,'MM-DD')  AS ETA_DT" ).append("\n"); 
		query.append(",TO_CHAR(SKD.VPS_ETD_DT,'MM-DD')  AS ETD_DT" ).append("\n"); 
		query.append(",NVL(SUM(LOD.LOD_IPC),0)          AS LOAD_IPC" ).append("\n"); 
		query.append(",NVL(SUM(LOD.LOD_OCN),0)          AS LOAD_OCN" ).append("\n"); 
		query.append(",NVL(SUM(LOD.LOD_MTY),0)          AS LOAD_MTY" ).append("\n"); 
		query.append(",NVL(SUM(DIS.DIS_IPC),0)          AS DIS_IPC" ).append("\n"); 
		query.append(",NVL(SUM(DIS.DIS_OCN),0)          AS DIS_OCN" ).append("\n"); 
		query.append(",NVL(SUM(DIS.DIS_MTY),0)          AS DIS_MTY" ).append("\n"); 
		query.append("FROM  VSK_VSL_PORT_SKD SKD," ).append("\n"); 
		query.append("( SELECT VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",POL_CD" ).append("\n"); 
		query.append(",POL_YD_CD" ).append("\n"); 
		query.append(",SUM(IPC)   LOD_IPC" ).append("\n"); 
		query.append(",SUM(OCN)   LOD_OCN" ).append("\n"); 
		query.append(",SUM(MTY)   LOD_MTY" ).append("\n"); 
		query.append("FROM TMP" ).append("\n"); 
		query.append("GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, POL_CD, POL_YD_CD" ).append("\n"); 
		query.append(") LOD," ).append("\n"); 
		query.append("( SELECT VSL_CD" ).append("\n"); 
		query.append(",SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",POD_CD" ).append("\n"); 
		query.append(",POD_YD_CD" ).append("\n"); 
		query.append(",SUM(IPC)   DIS_IPC" ).append("\n"); 
		query.append(",SUM(OCN)   DIS_OCN" ).append("\n"); 
		query.append(",SUM(MTY)   DIS_MTY" ).append("\n"); 
		query.append("FROM TMP" ).append("\n"); 
		query.append("GROUP BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD, POD_CD, POD_YD_CD" ).append("\n"); 
		query.append(") DIS" ).append("\n"); 
		query.append("WHERE SKD.VSL_CD = LOD.VSL_CD(+)" ).append("\n"); 
		query.append("AND SKD.SKD_VOY_NO = LOD.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND SKD.SKD_DIR_CD = LOD.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND SKD.VPS_PORT_CD = LOD.POL_CD(+)" ).append("\n"); 
		query.append("AND DECODE(SKD.VPS_PORT_CD,'KRPUS',DECODE(SKD.YD_CD,'KRPUSHN',SKD.YD_CD,' '),' ')  = LOD.POL_YD_CD(+)" ).append("\n"); 
		query.append("AND SKD.VSL_CD = DIS.VSL_CD(+)" ).append("\n"); 
		query.append("AND SKD.SKD_VOY_NO = DIS.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND SKD.SKD_DIR_CD = DIS.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND SKD.VPS_PORT_CD = DIS.POD_CD(+)" ).append("\n"); 
		query.append("AND SKD.VSL_CD = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("AND SKD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND SKD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("GROUP BY SKD.SLAN_CD" ).append("\n"); 
		query.append(",SKD.VSL_CD" ).append("\n"); 
		query.append(",SKD.SKD_VOY_NO" ).append("\n"); 
		query.append(",SKD.SKD_DIR_CD" ).append("\n"); 
		query.append(",DECODE(SKD.VPS_PORT_CD,'KRPUS',DECODE(SKD.YD_CD,'KRPUSHN',SKD.YD_CD,'KRPUS'),SKD.VPS_PORT_CD)" ).append("\n"); 
		query.append(",SKD.VPS_ETA_DT" ).append("\n"); 
		query.append(",SKD.VPS_ETD_DT" ).append("\n"); 
		query.append(",LOD.POL_YD_CD" ).append("\n"); 
		query.append("ORDER BY SKD.VSL_CD, SKD.SKD_VOY_NO, SKD.SKD_DIR_CD, SKD.VPS_ETA_DT" ).append("\n"); 

	}
}