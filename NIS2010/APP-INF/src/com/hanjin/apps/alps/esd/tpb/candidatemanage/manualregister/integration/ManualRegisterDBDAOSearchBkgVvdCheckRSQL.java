/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ManualRegisterDBDAOSearchBkgVvdCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.07
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualRegisterDBDAOSearchBkgVvdCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BkgVvd
	  * </pre>
	  */
	public ManualRegisterDBDAOSearchBkgVvdCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.integration").append("\n"); 
		query.append("FileName : ManualRegisterDBDAOSearchBkgVvdCheckRSQL").append("\n"); 
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
		query.append("#if (${yd_cd} !='')" ).append("\n"); 
		query.append("SELECT V.SKD_DIR_CD||V.RLANE_DIR_CD AS FINC_DIR_CD" ).append("\n"); 
		query.append("FROM AR_MST_REV_VVD V " ).append("\n"); 
		query.append("WHERE (VSL_CD, SKD_VOY_NO, SKD_DIR_CD, RLANE_DIR_CD) IN ( " ).append("\n"); 
		query.append("       SELECT SUBSTR(@[vvd_cd],1,4) AS VSL_CD, SUBSTR(@[vvd_cd],5,4) AS SKD_VOY_NO, " ).append("\n"); 
		query.append("              SUBSTR(@[vvd_cd],9,1) AS SKD_DIR_CD, AR.RLANE_DIR_CD AS RLANE_DIR_CD" ).append("\n"); 
		query.append("       FROM AR_FINC_DIR_CONV AR," ).append("\n"); 
		query.append("       (  SELECT SCONTI_CD" ).append("\n"); 
		query.append("            FROM MDM_LOCATION" ).append("\n"); 
		query.append("           WHERE LOC_CD = @[yd_cd]" ).append("\n"); 
		query.append("             AND DELT_FLG = 'N') LOC," ).append("\n"); 
		query.append("       (  SELECT SLAN_CD" ).append("\n"); 
		query.append("            FROM BKG_VVD" ).append("\n"); 
		query.append("           WHERE VSL_CD     = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("             AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("             AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("   #if (${bkg_no} !='')" ).append("\n"); 
		query.append("             AND BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("             AND ROWNUM = 1) VVD" ).append("\n"); 
		query.append("     WHERE VVD.SLAN_CD = AR.SLAN_CD" ).append("\n"); 
		query.append("       AND LOC.SCONTI_CD = AR.SCONTI_CD" ).append("\n"); 
		query.append("       AND AR.SLAN_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("     UNION ALL" ).append("\n"); 
		query.append("     SELECT SUBSTR(@[vvd_cd],1,4) AS VSL_CD, SUBSTR(@[vvd_cd],5,4) AS SKD_VOY_NO, " ).append("\n"); 
		query.append("            SUBSTR(@[vvd_cd],9,1) AS SKD_DIR_CD, SUBSTR(@[vvd_cd],9,1) AS RLANE_DIR_CD" ).append("\n"); 
		query.append("     FROM BKG_VVD" ).append("\n"); 
		query.append("     WHERE VSL_CD   = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("     AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("     AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("   #if (${bkg_no} !='')" ).append("\n"); 
		query.append("     AND BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("     )   " ).append("\n"); 
		query.append("AND V.DELT_FLG ='N'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT DISTINCT V.SKD_DIR_CD||V.RLANE_DIR_CD  AS FINC_DIR_CD" ).append("\n"); 
		query.append("  FROM AR_MST_REV_VVD V " ).append("\n"); 
		query.append("  #if (${bkg_no} !='') " ).append("\n"); 
		query.append("       , BKG_VVD B" ).append("\n"); 
		query.append(" WHERE V.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND V.RLANE_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND B.BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("   AND B.VSL_CD       = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("   AND B.SKD_VOY_NO   = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("   AND B.SKD_DIR_CD   = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("  #else" ).append("\n"); 
		query.append("   WHERE V.VSL_CD   = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("   AND V.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("   AND V.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("   AND V.RLANE_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("   AND V.DELT_FLG ='N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}