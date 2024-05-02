/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchScacReportRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchScacReportRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchScacReportRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mbl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hbl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scac",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchScacReportRSQL").append("\n"); 
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
		query.append("SELECT /*+ USE_NL(I B N S1 S2) */" ).append("\n"); 
		query.append("N.SCAC_CD SCAC," ).append("\n"); 
		query.append("DECODE(TRIM(S1.SCAC_NM),NULL,TRIM(S2.SCAC_NM),TRIM(S1.SCAC_NM)) SCAC_NM," ).append("\n"); 
		query.append("TRIM(N.NVOCC_CRR_BL_ID) NVOCC_CBL," ).append("\n"); 
		query.append("TRIM(N.NVOCC_BL_ID) HBL," ).append("\n"); 
		query.append("N.NVOCC_VSL_NM," ).append("\n"); 
		query.append("N.NVOCC_SKD_VOY_NO," ).append("\n"); 
		query.append("N.CSTMS_POD_CD," ).append("\n"); 
		query.append("N.NVOCC_POD_CD," ).append("\n"); 
		query.append("I.BL_NO MBL," ).append("\n"); 
		query.append("B.SCAC_CD HJS_SCAC," ).append("\n"); 
		query.append("DECODE(N.MF_RSPN_RCV_ID, 'XXX', ' ', N.MF_RSPN_RCV_ID) MF_RSPN_RCV_FLG," ).append("\n"); 
		query.append("TO_CHAR(N.RCV_DT,'YYYY-MM-DD HH24:MI:SS') RCV_DT," ).append("\n"); 
		query.append("CASE WHEN NVL(L.LOC_AMS_PORT_CD, '-') =  NVL(N.CSTMS_POD_CD , '-') THEN 0 ELSE 1 END POD_ERR" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_ADV_BL I, BKG_BOOKING B, BKG_CSTMS_ADV_NVOCC_FILE N, BKG_CSTMS_ADV_SCAC S1, BKG_CSTMS_ADV_SCAC S2, MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE  I.BL_NO     = B.BL_NO" ).append("\n"); 
		query.append("AND    I.CNT_CD = 'US'" ).append("\n"); 
		query.append("AND    I.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND    I.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND    I.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND    I.POD_CD LIKE NVL(@[pod],'%')" ).append("\n"); 
		query.append("#if (${scac} != '')" ).append("\n"); 
		query.append("AND N.SCAC_CD = @[scac]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mbl} != '')" ).append("\n"); 
		query.append("AND I.BL_NO like '%' || @[mbl] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${hbl} != '')" ).append("\n"); 
		query.append("AND N.NVOCC_BL_ID like '%' || @[hbl] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${err} != '')" ).append("\n"); 
		query.append("AND ( ( NVL(L.LOC_AMS_PORT_CD, '-') !=  NVL(N.CSTMS_POD_CD , '-') ) OR N.NVOCC_CRR_BL_ID IS NULL ) AND @[err] = @[err]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    I.MF_STS_CD  = 'A'" ).append("\n"); 
		query.append("AND    I.CSTMS_FILE_TP_CD = '2'" ).append("\n"); 
		query.append("--AND    I.BL_NO      = SUBSTR(N.NVOCC_CRR_BL_ID, 1, 12)" ).append("\n"); 
		query.append("AND    N.NVOCC_CRR_BL_ID LIKE I.BL_NO || '%'" ).append("\n"); 
		query.append("AND    N.SCAC_CD  = S1.SCAC_CD (+)" ).append("\n"); 
		query.append("AND    B.SCAC_CD    = S2.SCAC_CD (+)" ).append("\n"); 
		query.append("AND	   I.POD_CD = L.LOC_CD(+)" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT /*+ NO_EXPAND */" ).append("\n"); 
		query.append("N.SCAC_CD SCAC," ).append("\n"); 
		query.append("DECODE(TRIM(S1.SCAC_NM),NULL,TRIM(S2.SCAC_NM),TRIM(S1.SCAC_NM))," ).append("\n"); 
		query.append("TRIM(N.NVOCC_CRR_BL_ID) NVOCC_CBL," ).append("\n"); 
		query.append("TRIM(N.NVOCC_BL_ID) HBL," ).append("\n"); 
		query.append("N.NVOCC_VSL_NM," ).append("\n"); 
		query.append("N.NVOCC_SKD_VOY_NO," ).append("\n"); 
		query.append("N.CSTMS_POD_CD," ).append("\n"); 
		query.append("N.NVOCC_POD_CD," ).append("\n"); 
		query.append("I.BL_NO MBL," ).append("\n"); 
		query.append("B.SCAC_CD HJS_SCAC," ).append("\n"); 
		query.append("DECODE(N.MF_RSPN_RCV_ID, 'XXX', ' ', N.MF_RSPN_RCV_ID) MF_RSPN_RCV_FLG," ).append("\n"); 
		query.append("TO_CHAR(N.RCV_DT,'YYYY-MM-DD HH24:MI:SS') RCV_DT," ).append("\n"); 
		query.append("CASE WHEN NVL(L.LOC_AMS_PORT_CD, '-') =  NVL(N.CSTMS_POD_CD , '-') THEN 0 ELSE 1 END POD_ERR" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_ADV_BL I, BKG_BOOKING B, BKG_CSTMS_ADV_NVOCC_FILE N, BKG_CSTMS_ADV_SCAC S1, BKG_CSTMS_ADV_SCAC S2, MDM_LOCATION L" ).append("\n"); 
		query.append("WHERE   I.BL_NO     = B.BL_NO" ).append("\n"); 
		query.append("AND    I.CNT_CD = 'US'" ).append("\n"); 
		query.append("AND    I.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND    I.SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND    I.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND    I.CSTMS_POD_CD LIKE NVL(@[pod],'%')" ).append("\n"); 
		query.append("#if (${scac} != '')" ).append("\n"); 
		query.append("AND N.SCAC_CD = @[scac]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mbl} != '')" ).append("\n"); 
		query.append("AND I.BL_NO like '%' || @[mbl] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${hbl} != '')" ).append("\n"); 
		query.append("AND N.NVOCC_BL_ID like '%' || @[hbl] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${err} != '')" ).append("\n"); 
		query.append("AND ( ( NVL(L.LOC_AMS_PORT_CD, '-') !=  NVL(N.CSTMS_POD_CD , '-') ) OR N.NVOCC_CRR_BL_ID IS NULL ) AND @[err] = @[err]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    I.MF_STS_CD  = 'A'" ).append("\n"); 
		query.append("AND    I.CSTMS_FILE_TP_CD = '2'" ).append("\n"); 
		query.append("AND    I.BL_NO      = SUBSTR(N.NVOCC_CRR_BL_ID (+), 5, 12)" ).append("\n"); 
		query.append("AND    N.SCAC_CD  = S1.SCAC_CD (+)" ).append("\n"); 
		query.append("AND    B.SCAC_CD    = S2.SCAC_CD (+)" ).append("\n"); 
		query.append("AND	   I.CSTMS_POD_CD = L.LOC_CD(+)" ).append("\n"); 

	}
}