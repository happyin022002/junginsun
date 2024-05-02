/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnContainerBookingForecastMgtDBDAOSearchCBFIFCarrierListRSQL.java
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

public class OwnContainerBookingForecastMgtDBDAOSearchCBFIFCarrierListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnContainerBookingForecastMgtDBDAOSearchCBFIFCarrierList
	  * </pre>
	  */
	public OwnContainerBookingForecastMgtDBDAOSearchCBFIFCarrierListRSQL(){
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
		query.append("FileName : OwnContainerBookingForecastMgtDBDAOSearchCBFIFCarrierListRSQL").append("\n"); 
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
		query.append("#if (${condition_gb} == 'searchCrrCd') " ).append("\n"); 
		query.append("SELECT  CRR_CD ," ).append("\n"); 
		query.append("      	DECODE(CRR_CD, 'SML','N',DECODE(( SELECT COUNT(1) " ).append("\n"); 
		query.append("                 FROM OPF_CGO_BKG_FCAST_SMRY" ).append("\n"); 
		query.append("                WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("                  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                  AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                  AND YD_CD||POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("                  AND CRR_CD = Y.CRR_CD),0,'N','Y')) AS CRR_CD_FLAG" ).append("\n"); 
		query.append(" FROM (" ).append("\n"); 
		query.append("WITH V_CRR AS (" ).append("\n"); 
		query.append("SELECT ROWNUM RN, X.CRR_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT B.CRR_CD" ).append("\n"); 
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
		query.append("UNION  " ).append("\n"); 
		query.append("SELECT 'SML'" ).append("\n"); 
		query.append("FROM   DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT CRR_CD" ).append("\n"); 
		query.append("FROM OPF_CGO_BKG_FCAST_SMRY" ).append("\n"); 
		query.append("WHERE VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND YD_CD||POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("GROUP BY CRR_CD ) X )" ).append("\n"); 
		query.append("SELECT * FROM V_CRR ) Y" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}