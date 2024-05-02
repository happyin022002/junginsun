/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOSearchCBFIFCarrierAllListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnContainerBookingForecastMgtDBDAOSearchCBFIFCarrierAllListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * carrier 정보
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOSearchCBFIFCarrierAllListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.integration").append("\n"); 
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOSearchCBFIFCarrierAllListRSQL").append("\n"); 
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
		query.append("SELECT Y.FCAST_CRR_CD1," ).append("\n"); 
		query.append("      DECODE(( SELECT COUNT(1) " ).append("\n"); 
		query.append("                 FROM OPF_CGO_BKG_FCAST_SMRY" ).append("\n"); 
		query.append("                WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND YD_CD||POL_CLPT_IND_SEQ = @[yd_cd] " ).append("\n"); 
		query.append("                  AND CRR_CD = Y.FCAST_CRR_CD1),0, DECODE(( SELECT COUNT(1) " ).append("\n"); 
		query.append("                 FROM OPF_CGO_BKG_FCAST_SPCL_SMRY" ).append("\n"); 
		query.append("                WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD =@[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND YD_CD||POL_CLPT_IND_SEQ =  @[yd_cd] " ).append("\n"); 
		query.append("                  AND CRR_CD = Y.FCAST_CRR_CD1),0,'N','Y'),'Y') FCAST_CRR_CD_FLG1,  " ).append("\n"); 
		query.append("       Y.FCAST_CRR_CD2, " ).append("\n"); 
		query.append("       DECODE(( SELECT COUNT(1) " ).append("\n"); 
		query.append("                 FROM OPF_CGO_BKG_FCAST_SMRY" ).append("\n"); 
		query.append("                WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND YD_CD||POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("                  AND CRR_CD = Y.FCAST_CRR_CD2),0 ,DECODE(( SELECT COUNT(1) " ).append("\n"); 
		query.append("                 FROM OPF_CGO_BKG_FCAST_SPCL_SMRY" ).append("\n"); 
		query.append("                WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD =@[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND YD_CD||POL_CLPT_IND_SEQ =  @[yd_cd] " ).append("\n"); 
		query.append("                  AND CRR_CD = Y.FCAST_CRR_CD2),0,'N','Y'),'Y') FCAST_CRR_CD_FLG2," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       Y.FCAST_CRR_CD3, " ).append("\n"); 
		query.append("       DECODE(( SELECT COUNT(1) " ).append("\n"); 
		query.append("                 FROM OPF_CGO_BKG_FCAST_SMRY" ).append("\n"); 
		query.append("                WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND YD_CD||POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("                  AND CRR_CD = Y.FCAST_CRR_CD3),0,DECODE(( SELECT COUNT(1) " ).append("\n"); 
		query.append("                 FROM OPF_CGO_BKG_FCAST_SPCL_SMRY" ).append("\n"); 
		query.append("                WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD =@[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND YD_CD||POL_CLPT_IND_SEQ =  @[yd_cd] " ).append("\n"); 
		query.append("                  AND CRR_CD = Y.FCAST_CRR_CD3),0,'N','Y'),'Y') FCAST_CRR_CD_FLG3," ).append("\n"); 
		query.append("       Y.FCAST_CRR_CD4," ).append("\n"); 
		query.append("       DECODE(( SELECT COUNT(1) " ).append("\n"); 
		query.append("                 FROM OPF_CGO_BKG_FCAST_SMRY" ).append("\n"); 
		query.append("                WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND YD_CD||POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("                  AND CRR_CD = Y.FCAST_CRR_CD4),0,DECODE(( SELECT COUNT(1) " ).append("\n"); 
		query.append("                 FROM OPF_CGO_BKG_FCAST_SPCL_SMRY" ).append("\n"); 
		query.append("                WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD =@[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND YD_CD||POL_CLPT_IND_SEQ =  @[yd_cd] " ).append("\n"); 
		query.append("                  AND CRR_CD = Y.FCAST_CRR_CD4),0,'N','Y'),'Y') FCAST_CRR_CD_FLG4," ).append("\n"); 
		query.append("      Y.FCAST_CRR_CD5," ).append("\n"); 
		query.append("       DECODE(( SELECT COUNT(1) " ).append("\n"); 
		query.append("                 FROM OPF_CGO_BKG_FCAST_SMRY" ).append("\n"); 
		query.append("                WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND YD_CD||POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("                  AND CRR_CD = Y.FCAST_CRR_CD5),0,DECODE(( SELECT COUNT(1) " ).append("\n"); 
		query.append("                 FROM OPF_CGO_BKG_FCAST_SPCL_SMRY" ).append("\n"); 
		query.append("                WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD =@[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND YD_CD||POL_CLPT_IND_SEQ =  @[yd_cd] " ).append("\n"); 
		query.append("                  AND CRR_CD = Y.FCAST_CRR_CD5),0,'N','Y'),'Y') FCAST_CRR_CD_FLG5," ).append("\n"); 
		query.append("      Y.FCAST_CRR_CD6," ).append("\n"); 
		query.append("       DECODE(( SELECT COUNT(1) " ).append("\n"); 
		query.append("                 FROM OPF_CGO_BKG_FCAST_SMRY" ).append("\n"); 
		query.append("                WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND YD_CD||POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("                  AND CRR_CD = Y.FCAST_CRR_CD6),0,DECODE(( SELECT COUNT(1) " ).append("\n"); 
		query.append("                 FROM OPF_CGO_BKG_FCAST_SPCL_SMRY" ).append("\n"); 
		query.append("                WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD =@[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND YD_CD||POL_CLPT_IND_SEQ =  @[yd_cd] " ).append("\n"); 
		query.append("                  AND CRR_CD = Y.FCAST_CRR_CD6),0,'N','Y'),'Y') FCAST_CRR_CD_FLG6" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("WITH V_CRR AS (" ).append("\n"); 
		query.append("SELECT ROWNUM RN, X.CRR_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append(" SELECT MIN(SEQ) AS SEQ, CRR_CD" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT  3 AS SEQ , B.CRR_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("    BSA_VVD_MST A,  " ).append("\n"); 
		query.append("    BSA_VVD_CRR_PERF B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND A.TRD_CD      = B.TRD_CD(+)" ).append("\n"); 
		query.append("  AND A.RLANE_CD    = B.RLANE_CD(+)" ).append("\n"); 
		query.append("  AND A.VSL_CD      = B.VSL_CD(+)" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO  = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD  = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("  AND A.VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("  AND B. CRR_BSA_CAPA > 0" ).append("\n"); 
		query.append("  AND B.RLANE_CD   LIKE ( SELECT DISTINCT SLAN_CD " ).append("\n"); 
		query.append("                            FROM VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("                           WHERE C.VSL_cD = A.VSL_CD" ).append("\n"); 
		query.append("                            AND C.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("                            AND C.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("                            AND C.YD_CD||C.CLPT_IND_SEQ = @[yd_cd] )||'%'" ).append("\n"); 
		query.append("UNION  " ).append("\n"); 
		query.append("SELECT DISTINCT  1 AS SEQ , 'SML' AS CRR_CD" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT DISTINCT  2 AS SEQ , CRR_CD" ).append("\n"); 
		query.append("FROM OPF_CGO_BKG_FCAST_SMRY" ).append("\n"); 
		query.append("WHERE VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND YD_CD||POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("GROUP BY CRR_CD " ).append("\n"); 
		query.append("UNION " ).append("\n"); 
		query.append("SELECT DISTINCT  2 AS SEQ , CRR_CD" ).append("\n"); 
		query.append("FROM OPF_CGO_BKG_FCAST_SPCL_SMRY" ).append("\n"); 
		query.append("WHERE VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND YD_CD||POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("GROUP BY CRR_CD )  " ).append("\n"); 
		query.append("GROUP BY CRR_CD    " ).append("\n"); 
		query.append(" ORDER BY SEQ ) X )" ).append("\n"); 
		query.append("SELECT MAX(FCAST_CRR_CD1) FCAST_CRR_CD1, MAX(FCAST_CRR_CD2) FCAST_CRR_CD2, MAX(FCAST_CRR_CD3) FCAST_CRR_CD3, MAX(FCAST_CRR_CD4) FCAST_CRR_CD4,MAX(FCAST_CRR_CD5) FCAST_CRR_CD5,MAX(FCAST_CRR_CD6) FCAST_CRR_CD6" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("SELECT DECODE(RN,1,CRR_CD,NULL) AS FCAST_CRR_CD1,  DECODE(RN,2,CRR_CD,NULL) AS FCAST_CRR_CD2,  DECODE(RN,3,CRR_CD,NULL) AS FCAST_CRR_CD3, DECODE(RN,4,CRR_CD,NULL) AS FCAST_CRR_CD4 ," ).append("\n"); 
		query.append("       DECODE(RN,5,CRR_CD,NULL) AS FCAST_CRR_CD5,  DECODE(RN,6,CRR_CD,NULL) AS FCAST_CRR_CD6 " ).append("\n"); 
		query.append("FROM V_CRR" ).append("\n"); 
		query.append("WHERE RN IN (1,2,3,4,5,6))" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT MAX(FCAST_CRR_CD1) FCAST_CRR_CD1, MAX(FCAST_CRR_CD2) FCAST_CRR_CD2, MAX(FCAST_CRR_CD3) FCAST_CRR_CD3, MAX(FCAST_CRR_CD4) FCAST_CRR_CD4,MAX(FCAST_CRR_CD5) FCAST_CRR_CD5,MAX(FCAST_CRR_CD6) FCAST_CRR_CD6" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("SELECT DECODE(RN,7,CRR_CD,NULL) AS FCAST_CRR_CD1, DECODE(RN,8,CRR_CD,NULL) AS FCAST_CRR_CD2,DECODE(RN,9,CRR_CD,NULL) AS FCAST_CRR_CD3, DECODE(RN,10,CRR_CD,NULL) AS FCAST_CRR_CD4," ).append("\n"); 
		query.append("       DECODE(RN,11,CRR_CD,NULL) AS FCAST_CRR_CD5, DECODE(RN,12,CRR_CD,NULL) AS FCAST_CRR_CD6 FROM V_CRR" ).append("\n"); 
		query.append("WHERE RN IN (7,8,9,10,11,12))) Y" ).append("\n"); 

	}
}