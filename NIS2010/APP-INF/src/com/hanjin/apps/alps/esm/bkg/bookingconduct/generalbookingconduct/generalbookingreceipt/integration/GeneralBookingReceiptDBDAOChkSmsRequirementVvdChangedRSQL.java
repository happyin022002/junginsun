/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOChkSmsRequirementVvdChangedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOChkSmsRequirementVvdChangedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingReceiptDBDAOChkSmsRequirementVvdChangedRSQL
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOChkSmsRequirementVvdChangedRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol_cd_old",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("new_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOChkSmsRequirementVvdChangedRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD AS VVD " ).append("\n"); 
		query.append("      ,(SELECT VSL_SLAN_CD " ).append("\n"); 
		query.append("          FROM VSK_VSL_SKD V " ).append("\n"); 
		query.append("         WHERE V.VSL_CD = A.VSL_CD " ).append("\n"); 
		query.append("           AND V.SKD_VOY_NO = A.SKD_VOY_NO " ).append("\n"); 
		query.append("           AND V.SKD_DIR_CD = A.SKD_DIR_CD) AS SLAN_CD" ).append("\n"); 
		query.append("      ,(SELECT nvl(COUNT(*),0)" ).append("\n"); 
		query.append("          FROM BKG_CONTAINER D " ).append("\n"); 
		query.append("         WHERE D.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("       ) AS CNTR_CNT" ).append("\n"); 
		query.append("      ,A.POL_CD || A.POL_YD_CD AS POL_YD" ).append("\n"); 
		query.append("      ,(SELECT DISTINCT 'Y' FROM VSK_VSL_PORT_SKD V " ).append("\n"); 
		query.append("         WHERE V.VSL_CD= A.VSL_CD" ).append("\n"); 
		query.append("           AND V.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND V.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND V.VPS_PORT_CD = A.POL_CD" ).append("\n"); 
		query.append("           AND V.YD_CD = A.POL_CD || A.POL_YD_CD" ).append("\n"); 
		query.append("           AND EXISTS (SELECT DISTINCT 'X'" ).append("\n"); 
		query.append("                         FROM VSK_VSL_PORT_SKD VV" ).append("\n"); 
		query.append("                        WHERE V.VSL_CD= VV.VSL_CD" ).append("\n"); 
		query.append("                          AND V.SKD_VOY_NO = VV.SKD_VOY_NO" ).append("\n"); 
		query.append("                          AND V.SKD_DIR_CD = VV.SKD_DIR_CD" ).append("\n"); 
		query.append("                          AND V.VPS_PORT_CD = VV.VPS_PORT_CD" ).append("\n"); 
		query.append("                          AND VV.CLPT_IND_SEQ >1" ).append("\n"); 
		query.append("                      )           " ).append("\n"); 
		query.append("       ) AS DC_FLG" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_TML_EDI_SND_LOG A" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND A.FNL_EDI_SND_FLG = 'Y'" ).append("\n"); 
		query.append("   AND A.POL_CD IN ('KRPUS', 'KRKAN','KRUSN','KRINC','KRPTK','KRGIN')" ).append("\n"); 
		query.append("   AND A.KR_CLL_TS_CD IS NULL" ).append("\n"); 
		query.append("   AND A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD IN (@[old_vvd], @[new_vvd] )" ).append("\n"); 
		query.append("   AND ('KRPUS' IN (@[bkg_pol_cd], @[bkg_pol_cd_old])" ).append("\n"); 
		query.append("		OR 'KRKAN' IN (@[bkg_pol_cd], @[bkg_pol_cd_old])" ).append("\n"); 
		query.append("		OR 'KRUSN' IN (@[bkg_pol_cd], @[bkg_pol_cd_old])" ).append("\n"); 
		query.append("        OR 'KRINC' IN (@[bkg_pol_cd], @[bkg_pol_cd_old])" ).append("\n"); 
		query.append("		OR 'KRPTK' IN (@[bkg_pol_cd], @[bkg_pol_cd_old])" ).append("\n"); 
		query.append("		OR 'KRGIN' IN (@[bkg_pol_cd], @[bkg_pol_cd_old]))" ).append("\n"); 
		query.append("   AND (A.CNTR_LIST_NO LIKE SUBSTR(@[old_vvd], 1, 4)||'%'" ).append("\n"); 
		query.append("		OR A.CNTR_LIST_NO LIKE SUBSTR(@[new_vvd], 1, 4)||'%')" ).append("\n"); 

	}
}