/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOCgoHndPerformInputVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOCgoHndPerformInputVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2011.06.27
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOCgoHndPerformInputVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("option_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("to_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOCgoHndPerformInputVORSQL").append("\n"); 
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
		query.append("SELECT DECODE(C3,1,'G.Total',DECODE(C5,1,'G.Total',PORT)) PORT," ).append("\n"); 
		query.append("       DECODE(C2,1,'Total',LANE)                          LANE," ).append("\n"); 
		query.append("       VVD," ).append("\n"); 
		query.append("       DECODE(C1,1,'S.Total',DECODE(C3,1,'Total',OPR))    OPR," ).append("\n"); 
		query.append("       DS_FL_20," ).append("\n"); 
		query.append("       DS_FL_2H," ).append("\n"); 
		query.append("       DS_FL_40," ).append("\n"); 
		query.append("       DS_FL_4H," ).append("\n"); 
		query.append("       DS_FL_45," ).append("\n"); 
		query.append("       DS_ET_20," ).append("\n"); 
		query.append("       DS_ET_2H," ).append("\n"); 
		query.append("       DS_ET_40," ).append("\n"); 
		query.append("       DS_ET_4H," ).append("\n"); 
		query.append("       DS_ET_45," ).append("\n"); 
		query.append("       LD_FL_20," ).append("\n"); 
		query.append("       LD_FL_2H," ).append("\n"); 
		query.append("       LD_FL_40," ).append("\n"); 
		query.append("       LD_FL_4H," ).append("\n"); 
		query.append("       LD_FL_45," ).append("\n"); 
		query.append("       LD_ET_20," ).append("\n"); 
		query.append("       LD_ET_2H," ).append("\n"); 
		query.append("       LD_ET_40," ).append("\n"); 
		query.append("       LD_ET_4H," ).append("\n"); 
		query.append("       LD_ET_45," ).append("\n"); 
		query.append("       TL_FL_20," ).append("\n"); 
		query.append("       TL_FL_2H," ).append("\n"); 
		query.append("       TL_FL_40," ).append("\n"); 
		query.append("       TL_FL_4H," ).append("\n"); 
		query.append("       TL_FL_45," ).append("\n"); 
		query.append("       TL_ET_20," ).append("\n"); 
		query.append("       TL_ET_2H," ).append("\n"); 
		query.append("       TL_ET_40," ).append("\n"); 
		query.append("       TL_ET_4H," ).append("\n"); 
		query.append("       TL_ET_45," ).append("\n"); 
		query.append("       WT_20," ).append("\n"); 
		query.append("       WT_2H," ).append("\n"); 
		query.append("       WT_40," ).append("\n"); 
		query.append("       WT_4H," ).append("\n"); 
		query.append("       WT_45" ).append("\n"); 
		query.append("FROM ( SELECT S.PORT_CD                    PORT," ).append("\n"); 
		query.append("              V.LANE                       LANE," ).append("\n"); 
		query.append("              S.VSL_CD||S.VOY_NO||S.DIR_CD VVD," ).append("\n"); 
		query.append("              S.OPR_CD                     OPR," ).append("\n"); 
		query.append("              GROUPING(S.PORT_CD) P, GROUPING(V.LANE) L, GROUPING(S.VSL_CD||S.VOY_NO||S.DIR_CD) V, GROUPING(S.OPR_CD) O," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN GROUPING(S.PORT_CD)=0 AND GROUPING(V.LANE)=0 AND GROUPING(S.VSL_CD||S.VOY_NO||S.DIR_CD)=0 AND GROUPING(S.OPR_CD)=1 THEN 1" ).append("\n"); 
		query.append("              ELSE 0" ).append("\n"); 
		query.append("              END C1," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN GROUPING(S.PORT_CD)=0 AND GROUPING(V.LANE)=1 AND GROUPING(S.VSL_CD||S.VOY_NO||S.DIR_CD)=1 AND GROUPING(S.OPR_CD)=1 THEN 1" ).append("\n"); 
		query.append("              ELSE 0" ).append("\n"); 
		query.append("              END C2," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN GROUPING(S.PORT_CD)=1 AND GROUPING(V.LANE)=1 AND GROUPING(S.VSL_CD||S.VOY_NO||S.DIR_CD)=1 AND GROUPING(S.OPR_CD)=1 THEN 1" ).append("\n"); 
		query.append("              ELSE 0" ).append("\n"); 
		query.append("              END C3," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN GROUPING(S.PORT_CD)=0 AND GROUPING(V.LANE)=0 AND GROUPING(S.VSL_CD||S.VOY_NO||S.DIR_CD)=0 AND GROUPING(S.OPR_CD)=0 THEN 1" ).append("\n"); 
		query.append("              ELSE 0" ).append("\n"); 
		query.append("              END C4," ).append("\n"); 
		query.append("              CASE" ).append("\n"); 
		query.append("              WHEN GROUPING(S.PORT_CD)=1 AND GROUPING(V.LANE)=1 AND GROUPING(S.VSL_CD||S.VOY_NO||S.DIR_CD)=1 AND GROUPING(S.OPR_CD)=0 THEN 1" ).append("\n"); 
		query.append("              ELSE 0" ).append("\n"); 
		query.append("              END C5," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'2',QTY,0),'DT',DECODE(S.CNTR_SIZE,'2',QTY,0),0)))   DS_FL_20," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'3',QTY,0),'DT',DECODE(S.CNTR_SIZE,'3',QTY,0),0)))   DS_FL_2H," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'4',QTY,0),'DT',DECODE(S.CNTR_SIZE,'4',QTY,0),0)))   DS_FL_40," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'H',QTY,0),'DT',DECODE(S.CNTR_SIZE,'H',QTY,0),0)))   DS_FL_4H," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'L',QTY,0),'DT',DECODE(S.CNTR_SIZE,'L',QTY,0),0)))   DS_FL_45," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'2',QTY,0),'DT',DECODE(S.CNTR_SIZE,'2',QTY,0),0),0))   DS_ET_20," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'3',QTY,0),'DT',DECODE(S.CNTR_SIZE,'3',QTY,0),0),0))   DS_ET_2H," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'4',QTY,0),'DT',DECODE(S.CNTR_SIZE,'4',QTY,0),0),0))   DS_ET_40," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'H',QTY,0),'DT',DECODE(S.CNTR_SIZE,'H',QTY,0),0),0))   DS_ET_4H," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'L',QTY,0),'DT',DECODE(S.CNTR_SIZE,'L',QTY,0),0),0))   DS_ET_45," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'2',QTY,0),'LI',DECODE(S.CNTR_SIZE,'2',QTY,0),0)))   LD_FL_20," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'3',QTY,0),'LI',DECODE(S.CNTR_SIZE,'3',QTY,0),0)))   LD_FL_2H," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'4',QTY,0),'LI',DECODE(S.CNTR_SIZE,'4',QTY,0),0)))   LD_FL_40," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'H',QTY,0),'LI',DECODE(S.CNTR_SIZE,'H',QTY,0),0)))   LD_FL_4H," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'L',QTY,0),'LI',DECODE(S.CNTR_SIZE,'L',QTY,0),0)))   LD_FL_45," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'2',QTY,0),'LI',DECODE(S.CNTR_SIZE,'2',QTY,0),0),0))   LD_ET_20," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'3',QTY,0),'LI',DECODE(S.CNTR_SIZE,'3',QTY,0),0),0))   LD_ET_2H," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'4',QTY,0),'LI',DECODE(S.CNTR_SIZE,'4',QTY,0),0),0))   LD_ET_40," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'H',QTY,0),'LI',DECODE(S.CNTR_SIZE,'H',QTY,0),0),0))   LD_ET_4H," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'L',QTY,0),'LI',DECODE(S.CNTR_SIZE,'L',QTY,0),0),0))   LD_ET_45," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'2',QTY,0),'DT',DECODE(S.CNTR_SIZE,'2',QTY,0),0))) +" ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'2',QTY,0),'LI',DECODE(S.CNTR_SIZE,'2',QTY,0),0)))   TL_FL_20," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'3',QTY,0),'DT',DECODE(S.CNTR_SIZE,'3',QTY,0),0))) +" ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'3',QTY,0),'LI',DECODE(S.CNTR_SIZE,'3',QTY,0),0)))   TL_FL_2H," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'4',QTY,0),'DT',DECODE(S.CNTR_SIZE,'4',QTY,0),0))) +" ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'4',QTY,0),'LI',DECODE(S.CNTR_SIZE,'4',QTY,0),0)))   TL_FL_40," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'H',QTY,0),'DT',DECODE(S.CNTR_SIZE,'H',QTY,0),0))) +" ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'H',QTY,0),'LI',DECODE(S.CNTR_SIZE,'H',QTY,0),0)))   TL_FL_4H," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'L',QTY,0),'DT',DECODE(S.CNTR_SIZE,'L',QTY,0),0))) +" ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',0,DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'L',QTY,0),'LI',DECODE(S.CNTR_SIZE,'L',QTY,0),0)))   TL_FL_45," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'2',QTY,0),'DT',DECODE(S.CNTR_SIZE,'2',QTY,0),0),0)) +" ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'2',QTY,0),'LI',DECODE(S.CNTR_SIZE,'2',QTY,0),0),0))   TL_ET_20," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'3',QTY,0),'DT',DECODE(S.CNTR_SIZE,'3',QTY,0),0),0)) +" ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'3',QTY,0),'LI',DECODE(S.CNTR_SIZE,'3',QTY,0),0),0))   TL_ET_2H," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'4',QTY,0),'DT',DECODE(S.CNTR_SIZE,'4',QTY,0),0),0)) +" ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'4',QTY,0),'LI',DECODE(S.CNTR_SIZE,'4',QTY,0),0),0))   TL_ET_40," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'H',QTY,0),'DT',DECODE(S.CNTR_SIZE,'H',QTY,0),0),0)) +" ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'H',QTY,0),'LI',DECODE(S.CNTR_SIZE,'H',QTY,0),0),0))   TL_ET_4H," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'DS',DECODE(S.CNTR_SIZE,'L',QTY,0),'DT',DECODE(S.CNTR_SIZE,'L',QTY,0),0),0)) +" ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_TYPE,'E',DECODE(S.STATUS,'LM',DECODE(S.CNTR_SIZE,'L',QTY,0),'LI',DECODE(S.CNTR_SIZE,'L',QTY,0),0),0))   TL_ET_45," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_SIZE,'2',WEIGHT,0)) WT_20," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_SIZE,'3',WEIGHT,0)) WT_2H," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_SIZE,'4',WEIGHT,0)) WT_40," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_SIZE,'H',WEIGHT,0)) WT_4H," ).append("\n"); 
		query.append("              SUM(DECODE(S.CNTR_SIZE,'L',WEIGHT,0)) WT_45" ).append("\n"); 
		query.append("       FROM   TDR_SUMMARY S," ).append("\n"); 
		query.append("              ( SELECT   A.VSL_CD          VSL, " ).append("\n"); 
		query.append("                         A.SKD_VOY_NO      VOY, " ).append("\n"); 
		query.append("                         A.SKD_DIR_CD      DIR, " ).append("\n"); 
		query.append("                         A.VPS_PORT_CD     LOC, " ).append("\n"); 
		query.append("                         A.CLPT_IND_SEQ    CAL, " ).append("\n"); 
		query.append("                         A.SLAN_CD         LANE " ).append("\n"); 
		query.append("                FROM     VSK_VSL_PORT_SKD A" ).append("\n"); 
		query.append("                WHERE    A.PORT_SKD_STS_CD = 'D'" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("                AND      A.SLAN_CD         LIKE @[slan_cd]||'%'                                                  --:lane_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                AND      A.VPS_ETD_DT      BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')              --:fm_dt" ).append("\n"); 
		query.append("                                           AND     TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD') + 0.99999      --:to_dt" ).append("\n"); 
		query.append("#if (${yd_cd} == 'All')" ).append("\n"); 
		query.append("                AND      A.YD_CD           LIKE @[loc_cd]||'%' " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                AND      A.YD_CD           LIKE @[loc_cd]||@[yd_cd]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ) V,              --:yd_cd                                           " ).append("\n"); 
		query.append("              MDM_LOCATION L, MDM_COUNTRY C, MDM_VSL_SVC_LANE T" ).append("\n"); 
		query.append("       WHERE  S.VSL_CD   = V.VSL " ).append("\n"); 
		query.append("       AND    S.VOY_NO   = V.VOY " ).append("\n"); 
		query.append("       AND    S.DIR_CD   = V.DIR " ).append("\n"); 
		query.append("       AND    S.PORT_CD  = V.LOC" ).append("\n"); 
		query.append("       AND    S.CALL_IND = V.CAL " ).append("\n"); 
		query.append("       AND    S.STATUS   IN ('DS','DT','LM','LI')" ).append("\n"); 
		query.append("       AND    S.PORT_CD  = L.LOC_CD(+)" ).append("\n"); 
		query.append("       AND    L.CNT_CD   = C.CNT_CD" ).append("\n"); 
		query.append("--     AND    DECODE(C.SCONTI_CD,'EE','E','EN','E','ES','E','EC','E','AO','T'," ).append("\n"); 
		query.append("--            'AF','A','AW','A','AE','A','AM','D','MS','S','MC','M','MN','M','1') IN ('A','E','M') --[Cargo Handling Performace 대륙제약조건 제거 : 2011.06.27]" ).append("\n"); 
		query.append("       AND    V.LANE     = T.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("       AND    T.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${opr_cd} != '')" ).append("\n"); 
		query.append("       AND    S.OPR_CD   LIKE @[opr_cd]||'%'                                                            --:opr_cd (SML Check시 'SML', All Check시 Null)" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("#if (${option_cd} != '')" ).append("\n"); 
		query.append("       AND    T.VSL_SVC_TP_CD LIKE @[option_cd]||'%'                                                    --:option_cd (Truck Check시 Null, Feeder Check시 'O')" ).append("\n"); 
		query.append("#end       " ).append("\n"); 
		query.append("       GROUP BY CUBE( S.PORT_CD, V.LANE, S.VSL_CD||S.VOY_NO||S.DIR_CD, S.OPR_CD) )" ).append("\n"); 
		query.append("WHERE (C1 = 1 OR C2 = 1 OR C3 = 1 OR C4 = 1 OR C5 = 1)" ).append("\n"); 
		query.append("ORDER BY DECODE(C3,1,'ZZZZZ',DECODE(C5,1,'YYYYY',PORT)), DECODE(C2,1,'ZZZ',LANE), VVD, DECODE(C1,1,'ZZZZ',DECODE(C3,1,'YYYY',OPR))" ).append("\n"); 

	}
}