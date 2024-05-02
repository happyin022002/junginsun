/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DemandNoteSendDBDAOSearchDemandNoteRDListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim Chang Bin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemandNoteSendDBDAOSearchDemandNoteRDListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDemandNoteRDListVO
	  * </pre>
	  */
	public DemandNoteSendDBDAOSearchDemandNoteRDListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.integration").append("\n"); 
		query.append("FileName : DemandNoteSendDBDAOSearchDemandNoteRDListVORSQL").append("\n"); 
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
		query.append("SELECT    B.CNTR_NO                                                         AS CNTR_NO" ).append("\n"); 
		query.append("        , B.CNTR_TPSZ_CD                                                    AS CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        , TO_CHAR (C.FM_MVMT_DT, 'DDMonYY', 'NLS_DATE_LANGUAGE = American') AS FM_MVMT_DT" ).append("\n"); 
		query.append("        , TO_CHAR (C.TO_MVMT_DT, 'DDMonYY', 'NLS_DATE_LANGUAGE = American') AS TO_MVMT_DT" ).append("\n"); 
		query.append("        , CASE" ).append("\n"); 
		query.append("          WHEN C.CXL_BKG_CHG_FLG = 'Y' AND C.SYS_AREA_GRP_ID != 'KOR' AND C.FT_DYS = 0 THEN " ).append("\n"); 
		query.append("                 ''" ).append("\n"); 
		query.append("          ELSE " ).append("\n"); 
		query.append("                 TO_CHAR (C.FT_CMNC_DT, 'DDMonYY', 'NLS_DATE_LANGUAGE = American') " ).append("\n"); 
		query.append("          END                               AS FT_CMNC_DT            " ).append("\n"); 
		query.append("        , CASE" ).append("\n"); 
		query.append("          WHEN C.CXL_BKG_CHG_FLG = 'Y' AND C.SYS_AREA_GRP_ID != 'KOR' AND C.FT_DYS = 0 THEN " ).append("\n"); 
		query.append("                 ''" ).append("\n"); 
		query.append("          ELSE " ).append("\n"); 
		query.append("                TO_CHAR (C.FT_END_DT, 'DDMonYY', 'NLS_DATE_LANGUAGE = American') " ).append("\n"); 
		query.append("          END                               AS FT_END_DT" ).append("\n"); 
		query.append("        , C.FT_DYS                          AS FT_DYS" ).append("\n"); 
		query.append("        , C.ORG_FT_OVR_DYS                  AS ORG_FT_OVR_DYS" ).append("\n"); 
		query.append("        , C.FX_FT_OVR_DYS                   AS FX_FT_OVR_DYS" ).append("\n"); 
		query.append("        , C.BZC_TRF_CURR_CD                 AS BZC_TRF_CURR_CD" ).append("\n"); 
		query.append("        , C.SYS_AREA_GRP_ID                 AS SVR_ID" ).append("\n"); 
		query.append("        , C.CNTR_CYC_NO                     AS CNTR_CYC_NO" ).append("\n"); 
		query.append("        , C.DMDT_TRF_CD                     AS DMDT_TRF_CD" ).append("\n"); 
		query.append("        , C.DMDT_CHG_LOC_DIV_CD             AS DMDT_CHG_LOC_DIV_CD" ).append("\n"); 
		query.append("        , C.CHG_SEQ                         AS CHG_SEQ" ).append("\n"); 
		query.append("        , C.BZC_TRF_SEQ                     AS BZC_TRF_SEQ" ).append("\n"); 
		query.append("        , NVL(C.BZC_DMDT_DE_TERM_CD, 'N')   AS BZC_DMDT_DE_TERM_CD" ).append("\n"); 
		query.append("        , C.BZC_TRF_GRP_SEQ                 AS BZC_TRF_GRP_SEQ" ).append("\n"); 
		query.append("        , C.DMDT_CHG_STS_CD                 AS DMDT_CHG_STS_CD" ).append("\n"); 
		query.append("        , C.RFA_EXPT_DAR_NO                 AS RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("        , C.RFA_EXPT_MAPG_SEQ               AS RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("        , C.RFA_EXPT_VER_SEQ                AS RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("        , C.RFA_RQST_DTL_SEQ                AS RFA_RQST_DTL_SEQ" ).append("\n"); 
		query.append("        , C.SC_NO                           AS SC_NO" ).append("\n"); 
		query.append("        , C.SC_EXPT_VER_SEQ                 AS SC_EXPT_VER_SEQ " ).append("\n"); 
		query.append("        , C.SC_EXPT_GRP_SEQ                 AS SC_EXPT_GRP_SEQ" ).append("\n"); 
		query.append("        , C.DMDT_TRF_APLY_TP_CD             AS DMDT_TRF_APLY_TP_CD" ).append("\n"); 
		query.append("        , C.FM_MVMT_YD_CD" ).append("\n"); 
		query.append("        , TO_CHAR(C.BZC_TRF_APLY_DT    , 'YYYY-MM-DD')    AS BZC_TRF_APLY_DT" ).append("\n"); 
		query.append("        , TO_CHAR(C.SC_RFA_EXPT_APLY_DT, 'YYYY-MM-DD')    AS SC_RFA_EXPT_APLY_DT" ).append("\n"); 
		query.append("        , NVL(C.SC_RFA_EXPT_AMT, 0)        AS SC_RFA_EXPT_AMT" ).append("\n"); 
		query.append("FROM    DMT_CHG_BKG_CNTR    B," ).append("\n"); 
		query.append("        DMT_CHG_CALC        C" ).append("\n"); 
		query.append("WHERE   B.SYS_AREA_GRP_ID       = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND     B.CNTR_NO               = C.CNTR_NO" ).append("\n"); 
		query.append("AND     B.CNTR_CYC_NO           = C.CNTR_CYC_NO   " ).append("\n"); 
		query.append("AND     C.SYS_AREA_GRP_ID       = @[svr_id]" ).append("\n"); 
		query.append("AND     C.CNTR_NO               = @[cntr_no]" ).append("\n"); 
		query.append("AND     C.CNTR_CYC_NO           = @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND     C.DMDT_TRF_CD           = @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND     C.DMDT_CHG_LOC_DIV_CD   = @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND     C.CHG_SEQ               = @[chg_seq]" ).append("\n"); 

	}
}