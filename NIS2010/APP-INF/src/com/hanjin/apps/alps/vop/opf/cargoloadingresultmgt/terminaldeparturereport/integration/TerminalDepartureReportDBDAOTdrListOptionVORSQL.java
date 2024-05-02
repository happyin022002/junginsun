/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TerminalDepartureReportDBDAOTdrListOptionVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2010.03.11 장석현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Suk Hyun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalDepartureReportDBDAOTdrListOptionVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public TerminalDepartureReportDBDAOTdrListOptionVORSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.integration").append("\n"); 
		query.append("FileName : TerminalDepartureReportDBDAOTdrListOptionVORSQL").append("\n"); 
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
		query.append("SELECT A.LANE," ).append("\n"); 
		query.append("A.VVD," ).append("\n"); 
		query.append("A.PORT," ).append("\n"); 
		query.append("A.ETA," ).append("\n"); 
		query.append("A.ETB," ).append("\n"); 
		query.append("A.ETD," ).append("\n"); 
		query.append("MAX(A.ADA)                         AS ADA," ).append("\n"); 
		query.append("MAX(A.ADF)                         AS ADF," ).append("\n"); 
		query.append("MAX(A.DDA)                         AS DDA," ).append("\n"); 
		query.append("MAX(A.DDF)                         AS DDF," ).append("\n"); 
		query.append("MAX(A.BA)                          AS BA," ).append("\n"); 
		query.append("MAX(A.BD)                          AS BD," ).append("\n"); 
		query.append("MAX(A.SA)                          AS SA," ).append("\n"); 
		query.append("MAX(A.SD)                          AS SD," ).append("\n"); 
		query.append("MAX(A.AFO)                         AS AFO," ).append("\n"); 
		query.append("MAX(A.ADO)                         AS ADO," ).append("\n"); 
		query.append("MAX(A.ALSFO)                       AS ALSFO," ).append("\n"); 
		query.append("MAX(A.ALSDO)                       AS ALSDO," ).append("\n"); 
		query.append("MAX(A.DFO)                         AS DFO," ).append("\n"); 
		query.append("MAX(A.DDO)                         AS DDO," ).append("\n"); 
		query.append("MAX(A.DLSFO)                       AS DLSFO," ).append("\n"); 
		query.append("MAX(A.DLSDO)                       AS DLSDO," ).append("\n"); 
		query.append("MAX(A.BSFO)                        AS BSFO," ).append("\n"); 
		query.append("MAX(A.BSDO)                        AS BSDO," ).append("\n"); 
		query.append("MAX(A.BSLSFO)                      AS BSLSFO," ).append("\n"); 
		query.append("MAX(A.BSLSDO)                      AS BSLSDO," ).append("\n"); 
		query.append("MAX(A.BCFO)                        AS BCFO," ).append("\n"); 
		query.append("MAX(A.BCDO)                        AS BCDO," ).append("\n"); 
		query.append("MAX(A.BCLSFO)                      AS BCLSFO," ).append("\n"); 
		query.append("MAX(A.BCLSDO)                      AS BCLSDO," ).append("\n"); 
		query.append("NVL(MAX(A.DFO) - MAX(B.AFO),0)     AS BCDFO," ).append("\n"); 
		query.append("NVL(MAX(A.DDO) - MAX(B.ADO),0)     AS BCDDO," ).append("\n"); 
		query.append("NVL(MAX(A.DLSFO) - MAX(B.ALSFO),0) AS BCDLSFO," ).append("\n"); 
		query.append("NVL(MAX(A.DLSDO) - MAX(B.ALSDO),0) AS BCDLSDO" ).append("\n"); 
		query.append("FROM   ( SELECT V.SLAN_CD                                                        LANE," ).append("\n"); 
		query.append("T.VSL_CD||T.VOY_NO||T.DIR_CD                                     VVD," ).append("\n"); 
		query.append("V.CLPT_SEQ                                                       SEQ," ).append("\n"); 
		query.append("V.VPS_PORT_CD                                                    PORT," ).append("\n"); 
		query.append("V.VPS_ETA_DT                                                     ETA," ).append("\n"); 
		query.append("V.VPS_ETB_DT                                                     ETB," ).append("\n"); 
		query.append("V.VPS_ETD_DT                                                     ETD," ).append("\n"); 
		query.append("NVL(T.DRAFT_AFT_ARR,0)                                           ADA," ).append("\n"); 
		query.append("NVL(T.DRAFT_FWD_ARR,0)                                           ADF," ).append("\n"); 
		query.append("NVL(T.DRAFT_AFT_DEP,0)                                           DDA," ).append("\n"); 
		query.append("NVL(T.DRAFT_FWD_DEP,0)                                           DDF," ).append("\n"); 
		query.append("NVL(T.BALLAST_ARR,0)                                             BA," ).append("\n"); 
		query.append("NVL(T.BALLAST_DEP,0)                                             BD," ).append("\n"); 
		query.append("NVL(T.GM_ARR,0)                                                  SA," ).append("\n"); 
		query.append("NVL(T.GM_DEP,0)                                                  SD," ).append("\n"); 
		query.append("NVL(T.ROB_FO_ARR,0)                                              AFO," ).append("\n"); 
		query.append("NVL(T.ROB_DO_ARR,0)                                              ADO," ).append("\n"); 
		query.append("NVL(T.SULPHUR_FO_ARR,0)                                          ALSFO," ).append("\n"); 
		query.append("NVL(T.SULPHUR_DO_ARR,0)                                          ALSDO," ).append("\n"); 
		query.append("NVL(T.ROB_FO_DEP,0)                                              DFO," ).append("\n"); 
		query.append("NVL(T.ROB_DO_DEP,0)                                              DDO," ).append("\n"); 
		query.append("NVL(T.SULPHUR_FO_DEP,0)                                          DLSFO," ).append("\n"); 
		query.append("NVL(T.SULPHUR_DO_DEP,0)                                          DLSDO," ).append("\n"); 
		query.append("NVL(T.BUNKER_FO_DEP,0)                                           BSFO," ).append("\n"); 
		query.append("NVL(T.BUNKER_DO_DEP,0)                                           BSDO," ).append("\n"); 
		query.append("NVL(T.SUPPLY_SULPHUR_FO,0)                                       BSLSFO," ).append("\n"); 
		query.append("NVL(T.SUPPLY_SULPHUR_DO,0)                                       BSLSDO," ).append("\n"); 
		query.append("NVL(NVL(T.ROB_FO_ARR,0) + NVL(T.BUNKER_FO_DEP,0) - NVL(T.ROB_FO_DEP,0),0)             BCFO," ).append("\n"); 
		query.append("NVL(NVL(T.ROB_DO_ARR,0) + NVL(T.BUNKER_DO_DEP,0) - NVL(T.ROB_DO_DEP,0),0)             BCDO," ).append("\n"); 
		query.append("NVL(NVL(T.SULPHUR_FO_ARR,0) + NVL(T.SUPPLY_SULPHUR_FO,0) - NVL(T.SULPHUR_FO_DEP,0),0) BCLSFO," ).append("\n"); 
		query.append("NVL(NVL(T.SULPHUR_DO_ARR,0) + NVL(T.SUPPLY_SULPHUR_DO,0) - NVL(T.SULPHUR_DO_DEP,0),0) BCLSDO" ).append("\n"); 
		query.append("FROM   TDR_HEADER T, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  T.VSL_CD   = V.VSL_CD" ).append("\n"); 
		query.append("AND    T.VOY_NO   = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    T.DIR_CD   = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    T.PORT_CD  = V.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    T.CALL_IND = V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND    V.TURN_PORT_IND_CD NOT IN ('D','V','F')" ).append("\n"); 
		query.append("#if (${loc_cd} != '' && ${yd_cd} == 'All')" ).append("\n"); 
		query.append("AND    V.YD_CD    LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '' && ${yd_cd} != 'All')" ).append("\n"); 
		query.append("AND    V.YD_CD    LIKE @[loc_cd]||@[yd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    T.BERTH    BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND     TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD') + 0.99999 ) A,  --:tm_dt" ).append("\n"); 
		query.append("( SELECT V.SLAN_CD                                                        LANE," ).append("\n"); 
		query.append("T.VSL_CD||T.VOY_NO||T.DIR_CD                                     VVD," ).append("\n"); 
		query.append("V.CLPT_SEQ                                                       SEQ," ).append("\n"); 
		query.append("V.VPS_PORT_CD                                                    PORT," ).append("\n"); 
		query.append("V.VPS_ETA_DT                                                     ETA," ).append("\n"); 
		query.append("V.VPS_ETB_DT                                                     ETB," ).append("\n"); 
		query.append("V.VPS_ETD_DT                                                     ETD," ).append("\n"); 
		query.append("NVL(T.DRAFT_AFT_ARR,0)                                           ADA," ).append("\n"); 
		query.append("NVL(T.DRAFT_FWD_ARR,0)                                           ADF," ).append("\n"); 
		query.append("NVL(T.DRAFT_AFT_DEP,0)                                           DDA," ).append("\n"); 
		query.append("NVL(T.DRAFT_FWD_DEP,0)                                           DDF," ).append("\n"); 
		query.append("NVL(T.BALLAST_ARR,0)                                             BA," ).append("\n"); 
		query.append("NVL(T.BALLAST_DEP,0)                                             BD," ).append("\n"); 
		query.append("NVL(T.GM_ARR,0)                                                  SA," ).append("\n"); 
		query.append("NVL(T.GM_DEP,0)                                                  SD," ).append("\n"); 
		query.append("NVL(T.ROB_FO_ARR,0)                                              AFO," ).append("\n"); 
		query.append("NVL(T.ROB_DO_ARR,0)                                              ADO," ).append("\n"); 
		query.append("NVL(T.SULPHUR_FO_ARR,0)                                          ALSFO," ).append("\n"); 
		query.append("NVL(T.SULPHUR_DO_ARR,0)                                          ALSDO," ).append("\n"); 
		query.append("NVL(T.ROB_FO_DEP,0)                                              DFO," ).append("\n"); 
		query.append("NVL(T.ROB_DO_DEP,0)                                              DDO," ).append("\n"); 
		query.append("NVL(T.SULPHUR_FO_DEP,0)                                          DLSFO," ).append("\n"); 
		query.append("NVL(T.SULPHUR_DO_DEP,0)                                          DLSDO," ).append("\n"); 
		query.append("NVL(T.BUNKER_FO_DEP,0)                                           BSFO," ).append("\n"); 
		query.append("NVL(T.BUNKER_DO_DEP,0)                                           BSDO," ).append("\n"); 
		query.append("NVL(T.SUPPLY_SULPHUR_FO,0)                                       BSLSFO," ).append("\n"); 
		query.append("NVL(T.SUPPLY_SULPHUR_DO,0)                                       BSLSDO," ).append("\n"); 
		query.append("NVL(NVL(T.ROB_FO_ARR,0) + NVL(T.BUNKER_FO_DEP,0) - NVL(T.ROB_FO_DEP,0),0)             BCFO," ).append("\n"); 
		query.append("NVL(NVL(T.ROB_DO_ARR,0) + NVL(T.BUNKER_DO_DEP,0) - NVL(T.ROB_DO_DEP,0),0)             BCDO," ).append("\n"); 
		query.append("NVL(NVL(T.SULPHUR_FO_ARR,0) + NVL(T.SUPPLY_SULPHUR_FO,0) - NVL(T.SULPHUR_FO_DEP,0),0) BCLSFO," ).append("\n"); 
		query.append("NVL(NVL(T.SULPHUR_DO_ARR,0) + NVL(T.SUPPLY_SULPHUR_DO,0) - NVL(T.SULPHUR_DO_DEP,0),0) BCLSDO" ).append("\n"); 
		query.append("FROM   TDR_HEADER T, VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("WHERE  T.VSL_CD   = V.VSL_CD" ).append("\n"); 
		query.append("AND    T.VOY_NO   = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    T.DIR_CD   = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    T.PORT_CD  = V.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    T.CALL_IND = V.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND    V.TURN_PORT_IND_CD NOT IN ('D','V','F')" ).append("\n"); 
		query.append("#if (${loc_cd} != '' && ${yd_cd} == 'All')" ).append("\n"); 
		query.append("AND    V.YD_CD    LIKE @[loc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${loc_cd} != '' && ${yd_cd} != 'All')" ).append("\n"); 
		query.append("AND    V.YD_CD    LIKE @[loc_cd]||@[yd_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    T.BERTH    BETWEEN TO_DATE(REPLACE(@[from_date],'-',''),'YYYYMMDD')" ).append("\n"); 
		query.append("AND     TO_DATE(REPLACE(@[to_date],'-',''),'YYYYMMDD') + 0.99999 ) B," ).append("\n"); 
		query.append("MDM_VSL_SVC_LANE L" ).append("\n"); 
		query.append("WHERE A.LANE            = L.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND   L.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("AND   A.VVD             = B.VVD(+)" ).append("\n"); 
		query.append("AND   A.SEQ             = B.SEQ(+) - 1" ).append("\n"); 
		query.append("#if (${slan_cd} != '')" ).append("\n"); 
		query.append("AND   A.LANE            = @[slan_cd]                                          --:lane_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND   SUBSTR(A.VVD,1,4) LIKE @[vsl_cd]||'%'                                   --:vsl_cd" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--AND   A.PORT            LIKE 'GBFXT'||'%'                                      --:port_cd" ).append("\n"); 
		query.append("GROUP BY A.LANE, A.VVD, A.PORT, A.ETA, A.ETB, A.ETD" ).append("\n"); 
		query.append("ORDER BY A.LANE, A.VVD, A.ETA, A.ETB, A.ETD, A.PORT" ).append("\n"); 

	}
}