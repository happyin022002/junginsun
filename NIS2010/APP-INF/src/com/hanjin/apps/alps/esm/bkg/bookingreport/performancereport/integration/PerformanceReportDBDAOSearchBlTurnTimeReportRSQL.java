/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchBlTurnTimeReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchBlTurnTimeReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PerformanceReportDBDAOSearchBlTurnTimeReportRSQL
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchBlTurnTimeReportRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pfm_by_pic",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("period_from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pfm_by_queue_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchBlTurnTimeReportRSQL").append("\n"); 
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
		query.append("   TO_CHAR(FLOOR(GRP_TOTAL_ELAPSED_TIME/GRP_QUE_CNT/3600),'00')                AS AVG_ELAPSED_TIME_HH" ).append("\n"); 
		query.append(" , TO_CHAR(FLOOR(MOD(GRP_TOTAL_ELAPSED_TIME/GRP_QUE_CNT,3600)/60),'00')        AS AVG_ELAPSED_TIME_MI" ).append("\n"); 
		query.append(" , TO_CHAR(FLOOR(MOD(MOD(GRP_TOTAL_ELAPSED_TIME/GRP_QUE_CNT, 3600),60)),'00')  AS AVG_ELAPSED_TIME_SS" ).append("\n"); 
		query.append(" , Y.*" ).append("\n"); 
		query.append("FROM ( SELECT" ).append("\n"); 
		query.append("					   TO_CHAR(FLOOR(ELAPSED_TIME/3600),'00')         AS ELAPSED_TIME_HH" ).append("\n"); 
		query.append("					 , TO_CHAR(FLOOR(MOD(ELAPSED_TIME,3600)/60),'00') AS ELAPSED_TIME_MI" ).append("\n"); 
		query.append("					 , TO_CHAR(MOD(MOD(ELAPSED_TIME, 3600),60),'00')  AS ELAPSED_TIME_SS" ).append("\n"); 
		query.append("					 , (SELECT  INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("							 FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("							WHERE INTG_CD_ID = 'CD02100' AND INTG_CD_VAL_CTNT = X.DPCS_WRK_GRP_CD)  AS QUEUE" ).append("\n"); 
		query.append("					 , (SELECT  INTG_CD_VAL_DP_DESC " ).append("\n"); 
		query.append("							 FROM COM_INTG_CD_DTL " ).append("\n"); 
		query.append("							WHERE INTG_CD_ID = 'CD01577' AND INTG_CD_VAL_CTNT = X.SR_AMD_TP_CD)  AS SR_KIND    " ).append("\n"); 
		query.append("	  			     , COUNT(DPCS_WRK_GRP_CD) OVER( PARTITION BY DPCS_WRK_GRP_CD,PIC) GRP_QUE_CNT" ).append("\n"); 
		query.append("                     , SUM(ELAPSED_TIME) OVER     ( PARTITION BY DPCS_WRK_GRP_CD,PIC) GRP_TOTAL_ELAPSED_TIME" ).append("\n"); 
		query.append("                     , DENSE_RANK() OVER( ORDER BY  DPCS_WRK_GRP_CD,PIC) AS SEQ_NO" ).append("\n"); 
		query.append("					 , X.*" ).append("\n"); 
		query.append("					FROM (" ).append("\n"); 
		query.append("					SELECT /*+ ORDERED *//*+ USE_NL(BKG_SR_CRNT_RQST) */" ).append("\n"); 
		query.append("							DISTINCT G.DPCS_WRK_GRP_CD AS DPCS_WRK_GRP_CD," ).append("\n"); 
		query.append("							H.ATND_USR_ID              AS PIC," ).append("\n"); 
		query.append("							SR.SR_AMD_TP_CD            AS SR_AMD_TP_CD," ).append("\n"); 
		query.append("							H.BKG_NO," ).append("\n"); 
		query.append("							B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("							B.POL_CD," ).append("\n"); 
		query.append("							B.POD_cD," ).append("\n"); 
		query.append("							H.SR_NO SR_NO," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							#if(${pfm_by_queue_cd} == '%')" ).append("\n"); 
		query.append("								DECODE(G.DPCS_WRK_GRP_CD,'I',SR.INP_WRK_CTNT,'0') " ).append("\n"); 
		query.append("							+ DECODE(G.DPCS_WRK_GRP_CD,'R',SR.RT_WRK_CTNT,'0') " ).append("\n"); 
		query.append("							+ DECODE(G.DPCS_WRK_GRP_CD,'A',SR.AUD_WRK_CTNT,'0') AS ELAPSED_TIME" ).append("\n"); 
		query.append("							#else    " ).append("\n"); 
		query.append("							 TO_NUMBER(DECODE(@[pfm_by_queue_cd],'S', NVL((SELECT WRK_TM_NO FROM BKG_SR_FAX WHERE SR_NO = H.SR_NO AND SR_KND_CD = H.SR_KND_CD),'0')," ).append("\n"); 
		query.append("																 'I',SR.INP_WRK_CTNT," ).append("\n"); 
		query.append("																 'R',SR.RT_WRK_CTNT," ).append("\n"); 
		query.append("																 'A',SR.AUD_WRK_CTNT,'0'))  AS ELAPSED_TIME" ).append("\n"); 
		query.append("							#end   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							#if(${doc_part} !='Y')" ).append("\n"); 
		query.append("								,NVL((SELECT 'Y' FROM" ).append("\n"); 
		query.append("									  BKG_SR_FAX" ).append("\n"); 
		query.append("									  WHERE SR_NO = SR.SR_NO" ).append("\n"); 
		query.append("									  AND SR_KND_CD = SR.SR_KND_CD" ).append("\n"); 
		query.append("									  AND RCV_OFC_CD IN (" ).append("\n"); 
		query.append("							#if(${doc_part_eu} =='Y')" ).append("\n"); 
		query.append("							'ANRSO','BRESO','DUSSO','FRASO','FXTBO','HAMSC','LONBB','MANBS','MUCSO','RTMSC','FXTSC','HAMRUG'," ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if(${doc_part_jp} =='Y')" ).append("\n"); 
		query.append("							'KIJBA','OSASO','TYOSC'," ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if(${doc_part_sw} =='Y')" ).append("\n"); 
		query.append("							'PENSO','PGUSO','PKGSC','SINSC'," ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							'$$')),'N') DOC_PART" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if(${doc_part} =='Y')" ).append("\n"); 
		query.append("								,'Y' DOC_PART " ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							" ).append("\n"); 
		query.append("					 " ).append("\n"); 
		query.append("					FROM BKG_SR_HIS H, BKG_SR_CRNT_RQST SR, BKG_BOOKING B, BKG_DPCS_USR_GRP G" ).append("\n"); 
		query.append("					WHERE 1=1" ).append("\n"); 
		query.append("						AND SR.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("						AND SR.SR_KND_CD = H.SR_KND_CD" ).append("\n"); 
		query.append("						AND SR.SR_NO = H.SR_NO" ).append("\n"); 
		query.append("						AND SR.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("						AND H.ATND_USR_ID = G.USR_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						/* PERIOD */" ).append("\n"); 
		query.append("						AND H.ST_DT >= TO_DATE(@[period_from_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append("						AND H.ST_DT <= TO_DATE(@[period_to_dt],'YYYY-MM-DD') +0.999999" ).append("\n"); 
		query.append("						AND G.DPCS_WRK_GRP_CD IN ('I','R','A')" ).append("\n"); 
		query.append("						/* VVD */" ).append("\n"); 
		query.append("						#if(${vvd_cd} != '')" ).append("\n"); 
		query.append("						AND B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD LIKE '%'||@[vvd_cd]||'%'" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						/* BKG NO */" ).append("\n"); 
		query.append("						#if(${bkg_no} != '')" ).append("\n"); 
		query.append("						AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						/* POL */" ).append("\n"); 
		query.append("						#if(${pol_cd} != '')" ).append("\n"); 
		query.append("						AND B.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						/* POD */" ).append("\n"); 
		query.append("						#if(${pod_cd} != '')" ).append("\n"); 
		query.append("						AND B.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						/* PERFORMANCE_BY_PIC */" ).append("\n"); 
		query.append("						#if(${pfm_by_pic} != '')" ).append("\n"); 
		query.append("						AND  H.ATND_USR_ID = @[pfm_by_pic]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						/* BKG OFC */" ).append("\n"); 
		query.append("						#if(${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("						AND B.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("						/* S/R KIND */" ).append("\n"); 
		query.append("						#if(${sr_knd_cd} != '' &&  ${sr_knd_cd} != 'L')" ).append("\n"); 
		query.append("						AND SR.SR_AMD_TP_CD = @[sr_knd_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("						/* Performance by Queue */" ).append("\n"); 
		query.append("						#if(${pfm_by_queue_cd} == '%')" ).append("\n"); 
		query.append("						    /* D/C ALL*/" ).append("\n"); 
		query.append("							AND H.SR_STS_CD  IN ('ID', 'RD', 'AD')" ).append("\n"); 
		query.append("							AND G.DPCS_WRK_GRP_CD IN ('I','R','A')" ).append("\n"); 
		query.append("						#elseif(${pfm_by_queue_cd} == 'S')" ).append("\n"); 
		query.append("							/* FONT OFC */" ).append("\n"); 
		query.append("							AND H.SR_STS_CD = 'ST'" ).append("\n"); 
		query.append("							AND G.DPCS_WRK_GRP_CD = @[pfm_by_queue_cd]" ).append("\n"); 
		query.append("						/* 나머지 */" ).append("\n"); 
		query.append("						#else" ).append("\n"); 
		query.append("							AND H.SR_STS_CD IN('ID','RD','AD')" ).append("\n"); 
		query.append("							AND G.DPCS_WRK_GRP_CD = @[pfm_by_queue_cd]" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					) X" ).append("\n"); 
		query.append("					WHERE 1=1" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("						AND X.DOC_PART ='Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("					ORDER BY DPCS_WRK_GRP_CD, PIC, BKG_NO, SR_AMD_TP_CD" ).append("\n"); 
		query.append("       ) Y" ).append("\n"); 

	}
}