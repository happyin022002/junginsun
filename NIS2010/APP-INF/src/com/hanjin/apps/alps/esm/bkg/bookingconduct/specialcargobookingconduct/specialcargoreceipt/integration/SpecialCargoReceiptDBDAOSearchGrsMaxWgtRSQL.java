/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOSearchGrsMaxWgtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOSearchGrsMaxWgtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * grs_max_wgt 와 비교하여 wgt_pass 판정
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOSearchGrsMaxWgtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("grs_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOSearchGrsMaxWgtRSQL").append("\n"); 
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
		query.append("SELECT  CASE WHEN SUM(K.GRS_MAX_WGT) = 0 THEN 'X' " ).append("\n"); 
		query.append("          WHEN SUM(K.GRS_MAX_WGT) >" ).append("\n"); 
		query.append("           @[grs_wgt] + " ).append("\n"); 
		query.append("           SUM(DECODE(NVL(MST_CNTR_SPEC.TARE_WGT, 0), 0 , DECODE(NVL(MDM_CNTR_TP_SZ.CNTR_TPSZ_TARE_WGT, 0), 0 , DECODE(MST_CONTAINER.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0), MDM_CNTR_TP_SZ.CNTR_TPSZ_TARE_WGT) , MST_CNTR_SPEC.TARE_WGT )) " ).append("\n"); 
		query.append("          THEN 'Y' ELSE 'N' END WGT_PASS," ).append("\n"); 
		query.append("		CASE WHEN MAX(MST_CONTAINER.CNTR_TPSZ_CD) IN ('F2','F4','F5','A2','A4','O2','O4','P2','P4','S2','S4','A5') THEN" ).append("\n"); 
		query.append("#if (${wgt_ut_cd}=='LBS')" ).append("\n"); 
		query.append("             CASE WHEN @[grs_wgt] * 0.453599 <=" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("             CASE WHEN @[grs_wgt] <=" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           SUM(DECODE(NVL(MST_CNTR_SPEC.CNTR_GRS_WGT - MST_CNTR_SPEC.TARE_WGT, 0), 0, NVL(MDM_CNTR_TP_SZ.CNTR_TPSZ_LODG_WGT, 0), MST_CNTR_SPEC.CNTR_GRS_WGT - MST_CNTR_SPEC.TARE_WGT ))" ).append("\n"); 
		query.append("	          THEN 'Y' ELSE 'N' END" ).append("\n"); 
		query.append("		ELSE 'Y' END CNTR_TP_SZ_WGT_PASS," ).append("\n"); 
		query.append("	    SUM(DECODE(NVL(MST_CNTR_SPEC.CNTR_GRS_WGT - MST_CNTR_SPEC.TARE_WGT, 0), 0, NVL(MDM_CNTR_TP_SZ.CNTR_TPSZ_LODG_WGT, 0), MST_CNTR_SPEC.CNTR_GRS_WGT - MST_CNTR_SPEC.TARE_WGT )) CNTR_TP_SZ_WGT" ).append("\n"); 
		query.append("  FROM MST_CONTAINER," ).append("\n"); 
		query.append("       MST_CNTR_SPEC," ).append("\n"); 
		query.append("       MDM_CNTR_TP_SZ," ).append("\n"); 
		query.append("       (    SELECT  MIN(NVL(GRS_MAX_WGT,0) * 1000) GRS_MAX_WGT" ).append("\n"); 
		query.append("			FROM    BKG_VVD A, " ).append("\n"); 
		query.append("					VSK_PORT_GNTR_CRN B" ).append("\n"); 
		query.append("			WHERE   A.POD_YD_CD = B.YD_CD(+)" ).append("\n"); 
		query.append("			AND     A.BKG_NO 	= @[bkg_no]) K" ).append("\n"); 
		query.append("WHERE MST_CONTAINER.CNTR_SPEC_NO   = MST_CNTR_SPEC.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("   AND MST_CONTAINER.CNTR_TPSZ_CD   = MDM_CNTR_TP_SZ.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("   AND MST_CONTAINER.CNTR_NO        = @[cntr_no] " ).append("\n"); 

	}
}