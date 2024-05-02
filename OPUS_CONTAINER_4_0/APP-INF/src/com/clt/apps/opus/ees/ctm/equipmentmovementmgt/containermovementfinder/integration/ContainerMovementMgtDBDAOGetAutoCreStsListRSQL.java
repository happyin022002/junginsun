/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOGetAutoCreStsListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOGetAutoCreStsListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 자동 생성 된 Movement 내역을 조회한다
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOGetAutoCreStsListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOGetAutoCreStsListRSQL").append("\n"); 
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
		query.append("SELECT STS_CD," ).append("\n"); 
		query.append("       CNTR_NO," ).append("\n"); 
		query.append("       BKG_NO," ).append("\n"); 
		query.append("       TP_SZ," ).append("\n"); 
		query.append("       YD_CD," ).append("\n"); 
		query.append("       TO_CHAR (TAR_DATE, 'YYYY-MM-DD HH24:MI') AS TAR_DATE," ).append("\n"); 
		query.append("       TO_CHAR (CRE_DT, 'YYYY-MM-DD HH24:MI') AS CRE_DT," ).append("\n"); 
		query.append("       PRE_STS," ).append("\n"); 
		query.append("       PRE_YD_CD," ).append("\n"); 
		query.append("       TO_CHAR (PRE_EVNT_DT, 'YYYY-MM-DD HH24:MI') AS PRE_EVNT_DT," ).append("\n"); 
		query.append("       DECODE (MVMT_CRE_TP_CD, 'A', 'N', 'Y') AS MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("       CNMV_YR," ).append("\n"); 
		query.append("       CNMV_ID," ).append("\n"); 
		query.append("       TO_CHAR (TAR_DATE, 'YYYY-MM-DD HH24:MI') AS EVENT_DT," ).append("\n"); 
		query.append("       MTY_PLN_NO" ).append("\n"); 
		query.append("  FROM (SELECT STS_CD," ).append("\n"); 
		query.append("               CNTR_NO," ).append("\n"); 
		query.append("               BKG_NO," ).append("\n"); 
		query.append("               TP_SZ," ).append("\n"); 
		query.append("               YD_CD," ).append("\n"); 
		query.append("               TAR_DATE," ).append("\n"); 
		query.append("               CRE_DT," ).append("\n"); 
		query.append("               LAG (STS_CD, 1) OVER (PARTITION BY CNTR_NO ORDER BY CNMV_YR, CNMV_SEQ, CNMV_SPLIT_NO) AS PRE_STS," ).append("\n"); 
		query.append("               LAG (YD_CD, 1) OVER (PARTITION BY CNTR_NO ORDER BY CNMV_YR, CNMV_SEQ, CNMV_SPLIT_NO) AS PRE_YD_CD," ).append("\n"); 
		query.append("               LAG (TAR_DATE, 1) OVER (PARTITION BY CNTR_NO ORDER BY CNMV_YR, CNMV_SEQ, CNMV_SPLIT_NO) AS PRE_EVNT_DT," ).append("\n"); 
		query.append("               MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("               CNMV_YR," ).append("\n"); 
		query.append("               CNMV_ID," ).append("\n"); 
		query.append("               MTY_PLN_NO" ).append("\n"); 
		query.append("          FROM (SELECT DISTINCT /*+ INDEX(A XAK11CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                       A.MVMT_STS_CD AS STS_CD," ).append("\n"); 
		query.append("                       A.CNTR_NO AS CNTR_NO," ).append("\n"); 
		query.append("                       A.CNTR_TPSZ_CD AS TP_SZ," ).append("\n"); 
		query.append("                       A.BKG_NO," ).append("\n"); 
		query.append("                       A.ORG_YD_CD AS YD_CD," ).append("\n"); 
		query.append("                       A.CNMV_EVNT_DT AS TAR_DATE," ).append("\n"); 
		query.append("                       A.CRE_LOCL_DT AS CRE_DT," ).append("\n"); 
		query.append("                       A.MVMT_CRE_TP_CD AS MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("                       A.CNMV_YR AS CNMV_YR," ).append("\n"); 
		query.append("                       A.CNMV_ID_NO AS CNMV_ID," ).append("\n"); 
		query.append("                       A.CNMV_SEQ," ).append("\n"); 
		query.append("                       A.CNMV_SPLIT_NO," ).append("\n"); 
		query.append("                       NVL(A.MTY_PLN_NO, NVL(A.MTY_REPO_NO, '')) AS MTY_PLN_NO" ).append("\n"); 
		query.append("                  FROM CTM_MOVEMENT A," ).append("\n"); 
		query.append("                       (SELECT CNTR_NO," ).append("\n"); 
		query.append("                               CNMV_YR AA," ).append("\n"); 
		query.append("                               CNMV_SEQ BB," ).append("\n"); 
		query.append("                               CNMV_SPLIT_NO CC," ).append("\n"); 
		query.append("                               CNMV_CYC_NO CYC_NO" ).append("\n"); 
		query.append("                          FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("                         WHERE CNMV_EVNT_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD')+.0 AND TO_DATE (@[p_date2], 'YYYY-MM-DD')+.9999" ).append("\n"); 
		query.append("#if (${loc_type} == '1')" ).append("\n"); 
		query.append("                           AND ORG_YD_CD IN (SELECT /*+ ORDERED USE_NL(E L Y) */" ).append("\n"); 
		query.append("                                                    Y.YD_CD" ).append("\n"); 
		query.append("                                               FROM MDM_EQ_ORZ_CHT E," ).append("\n"); 
		query.append("                                                    MDM_LOCATION L," ).append("\n"); 
		query.append("                                                    MDM_YARD Y" ).append("\n"); 
		query.append("                                              WHERE E.LCC_CD = @[loc_cd]" ).append("\n"); 
		query.append("                                                AND E.SCC_CD = L.SCC_CD" ).append("\n"); 
		query.append("                                                AND Y.LOC_CD = L.LOC_CD)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                           AND ORG_YD_CD IN (SELECT YD_CD" ).append("\n"); 
		query.append("                                               FROM MDM_YARD" ).append("\n"); 
		query.append("                                              WHERE YD_CD LIKE @[loc_cd]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sts_cd} != '')" ).append("\n"); 
		query.append("                           AND MVMT_STS_CD IN (${sts_cd})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_tp_cd} != '')" ).append("\n"); 
		query.append("                           AND MVMT_CRE_TP_CD = @[cre_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                       ) B" ).append("\n"); 
		query.append("                 WHERE A.CNTR_NO = B.CNTR_NO" ).append("\n"); 
		query.append("                   AND A.CNMV_CYC_NO IN (B.CYC_NO, B.CYC_NO - 1)" ).append("\n"); 
		query.append("                   AND A.CNMV_YR||TO_CHAR (A.CNMV_SEQ, '0000')||A.CNMV_SPLIT_NO <= B.AA||TO_CHAR (B.BB, '0000')||B.CC) TT)" ).append("\n"); 
		query.append(" WHERE TAR_DATE BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD')+.0 AND TO_DATE (@[p_date2], 'YYYY-MM-DD')+.9999" ).append("\n"); 
		query.append("#if (${cre_tp_cd} != '')" ).append("\n"); 
		query.append("   AND MVMT_CRE_TP_CD = @[cre_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}