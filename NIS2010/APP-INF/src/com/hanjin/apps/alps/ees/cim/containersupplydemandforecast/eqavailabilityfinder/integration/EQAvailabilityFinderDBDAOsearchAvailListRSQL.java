/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EQAvailabilityFinderDBDAOsearchAvailListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2010.02.09 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim jong jun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQAvailabilityFinderDBDAOsearchAvailListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EQ Availability
	  * </pre>
	  */
	public EQAvailabilityFinderDBDAOsearchAvailListRSQL(){
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
		params.put("cntr_tpsz_cd_val4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd_val3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd_val2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd_val1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.integration").append("\n"); 
		query.append("FileName : EQAvailabilityFinderDBDAOsearchAvailListRSQL").append("\n"); 
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
		query.append("WITH LV_YARD_QTY AS (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           'YARD' LOC_LEVEL" ).append("\n"); 
		query.append("          ,A.YD_CD" ).append("\n"); 
		query.append("          ,A.SCC_CD" ).append("\n"); 
		query.append("          ,TO_CHAR(A.FCAST_DT,'YYYYMMDD') FCAST_DT" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL1,A.EA)) EA1" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL1,A.BR)) BR1" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL1,A.PUP)) PUP1" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL1,A.RO)) RO1" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL1,A.OFH)) OFH1" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL1,A.DG)) DG1" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL1,A.SN)) SN1" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL1,A.IG)) IG1" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL1,A.RTN)) RTN1" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL1,A.RI)) RI1" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL1,A.ONH)) ONH1" ).append("\n"); 
		query.append("		  ,'' CELLSPACE1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL2,A.EA)) EA2" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL2,A.BR)) BR2" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL2,A.PUP)) PUP2" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL2,A.RO)) RO2" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL2,A.OFH)) OFH2" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL2,A.DG)) DG2" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL2,A.SN)) SN2" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL2,A.IG)) IG2" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL2,A.RTN)) RTN2" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL2,A.RI)) RI2" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL2,A.ONH)) ONH2" ).append("\n"); 
		query.append("		  ,'' CELLSPACE2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL3,A.EA)) EA3" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL3,A.BR)) BR3" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL3,A.PUP)) PUP3" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL3,A.RO)) RO3" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL3,A.OFH)) OFH3" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL3,A.DG)) DG3" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL3,A.SN)) SN3" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL3,A.IG)) IG3" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL3,A.RTN)) RTN3" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL3,A.RI)) RI3" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL3,A.ONH)) ONH3" ).append("\n"); 
		query.append("		  ,'' CELLSPACE3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL4,A.EA)) EA4" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL4,A.BR)) BR4" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL4,A.PUP)) PUP4" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL4,A.RO)) RO4" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL4,A.OFH)) OFH4" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL4,A.DG)) DG4" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL4,A.SN)) SN4" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL4,A.IG)) IG4" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL4,A.RTN)) RTN4" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL4,A.RI)) RI4" ).append("\n"); 
		query.append("          ,SUM(DECODE(A.CNTR_TPSZ_CD,C.CNTR_TPSZ_CD_VAL4,A.ONH)) ONH4" ).append("\n"); 
		query.append("		  ,'' CELLSPACE4" ).append("\n"); 
		query.append("    FROM CIM_AVAL_SMRY_V A,MDM_LOCATION B," ).append("\n"); 
		query.append("		(	" ).append("\n"); 
		query.append("		    SELECT" ).append("\n"); 
		query.append("		        MAX(DECODE(RANK,1,CNTR_TPSZ_CD)) CNTR_TPSZ_CD_VAL1 " ).append("\n"); 
		query.append("		       ,MAX(DECODE(RANK,2,CNTR_TPSZ_CD)) CNTR_TPSZ_CD_VAL2 " ).append("\n"); 
		query.append("		       ,MAX(DECODE(RANK,3,CNTR_TPSZ_CD)) CNTR_TPSZ_CD_VAL3 " ).append("\n"); 
		query.append("		       ,MAX(DECODE(RANK,4,CNTR_TPSZ_CD)) CNTR_TPSZ_CD_VAL4 " ).append("\n"); 
		query.append("		    FROM" ).append("\n"); 
		query.append("		    (" ).append("\n"); 
		query.append("		        SELECT" ).append("\n"); 
		query.append("		               A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		               ,RANK() OVER (ORDER BY A.CNTR_TPSZ_CD) RANK" ).append("\n"); 
		query.append("		          FROM MDM_CNTR_TP_SZ A" ).append("\n"); 
		query.append("		          WHERE A.CNTR_TPSZ_CD IN (@[cntr_tpsz_cd_val1],@[cntr_tpsz_cd_val2],@[cntr_tpsz_cd_val3],@[cntr_tpsz_cd_val4])" ).append("\n"); 
		query.append("		          ORDER BY A.RPT_DP_SEQ" ).append("\n"); 
		query.append("		    )" ).append("\n"); 
		query.append("		) C" ).append("\n"); 
		query.append("    WHERE A.SCC_CD=B.SCC_CD" ).append("\n"); 
		query.append("	#if (${loc_type_code} == 'Y')" ).append("\n"); 
		query.append("	    AND B.LOC_CD = SUBSTR(@[loc_cd],1,5)" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("	    AND B.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    AND A.CNTR_TPSZ_CD IN (@[cntr_tpsz_cd_val1],@[cntr_tpsz_cd_val2],@[cntr_tpsz_cd_val3],@[cntr_tpsz_cd_val4])" ).append("\n"); 
		query.append("    GROUP BY A.SCC_CD,A.YD_CD,A.FCAST_DT,A.FCAST_DT" ).append("\n"); 
		query.append("    ORDER BY A.SCC_CD,A.YD_CD,A.FCAST_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",LV_SCC_QTY AS(" ).append("\n"); 
		query.append("    SELECT  " ).append("\n"); 
		query.append("            'SCC' LOC_LEVEL" ).append("\n"); 
		query.append("           ,'' YD_CD" ).append("\n"); 
		query.append("           ,A.SCC_CD" ).append("\n"); 
		query.append("           ,A.FCAST_DT" ).append("\n"); 
		query.append("           ,SUM(A.EA1) EA1" ).append("\n"); 
		query.append("           ,SUM(A.BR1) BR1" ).append("\n"); 
		query.append("           ,SUM(A.PUP1) PUP1" ).append("\n"); 
		query.append("           ,SUM(A.RO1) RO1" ).append("\n"); 
		query.append("           ,SUM(A.OFH1) OFH1" ).append("\n"); 
		query.append("           ,SUM(A.DG1) DG1" ).append("\n"); 
		query.append("           ,SUM(A.SN1) SN1" ).append("\n"); 
		query.append("           ,SUM(A.IG1) IG1" ).append("\n"); 
		query.append("           ,SUM(A.RTN1) RTN1" ).append("\n"); 
		query.append("           ,SUM(A.RI1) RI1" ).append("\n"); 
		query.append("           ,SUM(A.ONH1) ONH1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ,SUM(A.EA2) EA2" ).append("\n"); 
		query.append("           ,SUM(A.BR2) BR2" ).append("\n"); 
		query.append("           ,SUM(A.PUP2) PUP2" ).append("\n"); 
		query.append("           ,SUM(A.RO2) RO2" ).append("\n"); 
		query.append("           ,SUM(A.OFH2) OFH2" ).append("\n"); 
		query.append("           ,SUM(A.DG2) DG2" ).append("\n"); 
		query.append("           ,SUM(A.SN2) SN2" ).append("\n"); 
		query.append("           ,SUM(A.IG2) IG2" ).append("\n"); 
		query.append("           ,SUM(A.RTN2) RTN2" ).append("\n"); 
		query.append("           ,SUM(A.RI2) RI2" ).append("\n"); 
		query.append("           ,SUM(A.ONH2) ONH2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ,SUM(A.EA3) EA3" ).append("\n"); 
		query.append("           ,SUM(A.BR3) BR3" ).append("\n"); 
		query.append("           ,SUM(A.PUP3) PUP3" ).append("\n"); 
		query.append("           ,SUM(A.RO3) RO3" ).append("\n"); 
		query.append("           ,SUM(A.OFH3) OFH3" ).append("\n"); 
		query.append("           ,SUM(A.DG3) DG3" ).append("\n"); 
		query.append("           ,SUM(A.SN3) SN3" ).append("\n"); 
		query.append("           ,SUM(A.IG3) IG3" ).append("\n"); 
		query.append("           ,SUM(A.RTN3) RTN3" ).append("\n"); 
		query.append("           ,SUM(A.RI3) RI3" ).append("\n"); 
		query.append("           ,SUM(A.ONH3) ONH3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           ,SUM(A.EA4) EA4" ).append("\n"); 
		query.append("           ,SUM(A.BR4) BR4" ).append("\n"); 
		query.append("           ,SUM(A.PUP4) PUP4" ).append("\n"); 
		query.append("           ,SUM(A.RO4) RO4" ).append("\n"); 
		query.append("           ,SUM(A.OFH4) OFH4" ).append("\n"); 
		query.append("           ,SUM(A.DG4) DG4" ).append("\n"); 
		query.append("           ,SUM(A.SN4) SN4" ).append("\n"); 
		query.append("           ,SUM(A.IG4) IG4" ).append("\n"); 
		query.append("           ,SUM(A.RTN4) RTN4" ).append("\n"); 
		query.append("           ,SUM(A.RI4) RI4" ).append("\n"); 
		query.append("           ,SUM(A.ONH4) ONH4" ).append("\n"); 
		query.append("    FROM LV_YARD_QTY A" ).append("\n"); 
		query.append("    GROUP BY A.SCC_CD,A.FCAST_DT,A.FCAST_DT" ).append("\n"); 
		query.append("    ORDER BY A.SCC_CD,A.FCAST_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("   LOC_LEVEL" ).append("\n"); 
		query.append("  ,YD_CD" ).append("\n"); 
		query.append("  ,SCC_CD" ).append("\n"); 
		query.append("  ,SCC_CD SCC_YD_CD" ).append("\n"); 
		query.append("  ,FCAST_DT" ).append("\n"); 
		query.append("  ,EA1+BR1+PUP1+RO1+OFH1+SN1+DG1+IG1+RTN1+RI1+ONH1 avail1" ).append("\n"); 
		query.append("  ,EA1" ).append("\n"); 
		query.append("  ,BR1" ).append("\n"); 
		query.append("  ,PUP1" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  ,RO1" ).append("\n"); 
		query.append("  ,OFH1" ).append("\n"); 
		query.append("  ,DG1" ).append("\n"); 
		query.append("  ,SN1" ).append("\n"); 
		query.append("  ,IG1" ).append("\n"); 
		query.append("  ,RTN1" ).append("\n"); 
		query.append("  ,RI1" ).append("\n"); 
		query.append("  ,ONH1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,EA2+BR2+PUP2+RO2+OFH2+SN2+DG2+IG2+RTN2+RI2+ONH2 avail2" ).append("\n"); 
		query.append("  ,EA2" ).append("\n"); 
		query.append("  ,BR2" ).append("\n"); 
		query.append("  ,PUP2" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  ,RO2" ).append("\n"); 
		query.append("  , OFH2" ).append("\n"); 
		query.append("  ,DG2" ).append("\n"); 
		query.append("  ,SN2" ).append("\n"); 
		query.append("  ,IG2" ).append("\n"); 
		query.append("  ,RTN2" ).append("\n"); 
		query.append("  ,RI2" ).append("\n"); 
		query.append("  ,ONH2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,EA3+BR3+PUP4+RO3+OFH3+DG3+SN3+IG3+RTN3+RI3+ONH3 avail3" ).append("\n"); 
		query.append("  ,EA3" ).append("\n"); 
		query.append("  ,BR3" ).append("\n"); 
		query.append("  ,PUP3" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  ,RO3" ).append("\n"); 
		query.append("  , OFH3" ).append("\n"); 
		query.append("  ,DG3" ).append("\n"); 
		query.append("  ,SN3" ).append("\n"); 
		query.append("  ,IG3" ).append("\n"); 
		query.append("  ,RTN3" ).append("\n"); 
		query.append("  ,RI3" ).append("\n"); 
		query.append("  ,ONH3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,EA4+BR4+PUP4+RO4+OFH4+DG4+SN4+IG4+RI4+RTN4+ONH4 avail14" ).append("\n"); 
		query.append("  ,EA4" ).append("\n"); 
		query.append("  ,BR4" ).append("\n"); 
		query.append("  ,PUP4" ).append("\n"); 
		query.append("  " ).append("\n"); 
		query.append("  ,RO4" ).append("\n"); 
		query.append("  ,OFH4" ).append("\n"); 
		query.append("  ,DG4" ).append("\n"); 
		query.append("  ,SN4" ).append("\n"); 
		query.append("  ,IG4" ).append("\n"); 
		query.append("  ,RTN4" ).append("\n"); 
		query.append("  ,RI4" ).append("\n"); 
		query.append("  ,ONH4  " ).append("\n"); 
		query.append("FROM LV_SCC_QTY" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("   LOC_LEVEL" ).append("\n"); 
		query.append("  ,YD_CD" ).append("\n"); 
		query.append("  ,SCC_CD" ).append("\n"); 
		query.append("  ,YD_CD SCC_YD_CD" ).append("\n"); 
		query.append("  ,FCAST_DT" ).append("\n"); 
		query.append("  ,EA1+BR1+PUP1+RO1+OFH1+SN1+DG1+IG1+RTN1+RI1+ONH1 avail1" ).append("\n"); 
		query.append("  ,EA1" ).append("\n"); 
		query.append("  ,BR1" ).append("\n"); 
		query.append("  ,PUP1" ).append("\n"); 
		query.append("  ,RO1" ).append("\n"); 
		query.append("  ,OFH1" ).append("\n"); 
		query.append("  ,DG1" ).append("\n"); 
		query.append("  ,SN1" ).append("\n"); 
		query.append("  ,IG1" ).append("\n"); 
		query.append("  ,RTN1" ).append("\n"); 
		query.append("  ,RI1" ).append("\n"); 
		query.append("  ,ONH1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,EA2+BR2+PUP2+RO2+OFH2+SN2+DG2+IG2+RTN2+RI2+ONH2 avail2" ).append("\n"); 
		query.append("  ,EA2" ).append("\n"); 
		query.append("  ,BR2" ).append("\n"); 
		query.append("  ,PUP2" ).append("\n"); 
		query.append("  ,RO2" ).append("\n"); 
		query.append("  , OFH2" ).append("\n"); 
		query.append("  ,DG2" ).append("\n"); 
		query.append("  ,SN2" ).append("\n"); 
		query.append("  ,IG2" ).append("\n"); 
		query.append("  ,RTN2" ).append("\n"); 
		query.append("  ,RI2" ).append("\n"); 
		query.append("  ,ONH2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,EA3+BR3+PUP3+RO3+OFH3+SN3+DG3+IG3+RTN3+RI3+ONH3 avail3" ).append("\n"); 
		query.append("  ,EA3" ).append("\n"); 
		query.append("  ,BR3" ).append("\n"); 
		query.append("  ,PUP3" ).append("\n"); 
		query.append("  ,RO3" ).append("\n"); 
		query.append("  , OFH3" ).append("\n"); 
		query.append("  ,DG3" ).append("\n"); 
		query.append("  ,SN3" ).append("\n"); 
		query.append("  ,IG3" ).append("\n"); 
		query.append("  ,RTN3" ).append("\n"); 
		query.append("  ,RI3" ).append("\n"); 
		query.append("  ,ONH3" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  ,EA4+BR4+PUP4+RO4+OFH4+SN4+DG4+IG4+RTN4+RI4+ONH4 avail14" ).append("\n"); 
		query.append("  ,EA4" ).append("\n"); 
		query.append("  ,BR4" ).append("\n"); 
		query.append("  ,PUP4" ).append("\n"); 
		query.append("  ,RO4" ).append("\n"); 
		query.append("  ,OFH4" ).append("\n"); 
		query.append("  ,DG4" ).append("\n"); 
		query.append("  ,SN4" ).append("\n"); 
		query.append("  ,IG4" ).append("\n"); 
		query.append("  ,RTN4" ).append("\n"); 
		query.append("  ,RI4" ).append("\n"); 
		query.append("  ,ONH4" ).append("\n"); 
		query.append("FROM LV_YARD_QTY A" ).append("\n"); 
		query.append("#if (${loc_type_code} == 'Y')" ).append("\n"); 
		query.append("	WHERE YD_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}