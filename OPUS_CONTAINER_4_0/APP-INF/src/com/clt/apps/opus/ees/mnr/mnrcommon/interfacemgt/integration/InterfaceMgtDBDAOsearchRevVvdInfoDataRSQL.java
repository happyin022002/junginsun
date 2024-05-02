/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceMgtDBDAOsearchRevVvdInfoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOsearchRevVvdInfoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public InterfaceMgtDBDAOsearchRevVvdInfoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOsearchRevVvdInfoDataRSQL").append("\n"); 
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
		query.append("SELECT   " ).append("\n"); 
		query.append("      CASE  " ).append("\n"); 
		query.append("      WHEN 'RBCCO' = CASE RNK WHEN 1 THEN N1ST_RLANE_CD WHEN 2 THEN N2ND_RLANE_CD WHEN 3 THEN N3RD_RLANE_CD ELSE N4TH_RLANE_CD END " ).append("\n"); 
		query.append("      THEN 'CFDR'||TO_CHAR (SYSDATE, 'YYMM')||'EE'  " ).append("\n"); 
		query.append("      ELSE  " ).append("\n"); 
		query.append("         (  " ).append("\n"); 
		query.append("      CASE RNK  " ).append("\n"); 
		query.append("      WHEN 1  " ).append("\n"); 
		query.append("      THEN N1ST_VVD_CD  " ).append("\n"); 
		query.append("      WHEN 2  " ).append("\n"); 
		query.append("      THEN N2ND_VVD_CD  " ).append("\n"); 
		query.append("      WHEN 3  " ).append("\n"); 
		query.append("      THEN N3RD_VVD_CD  " ).append("\n"); 
		query.append("      ELSE N4TH_VVD_CD  " ).append("\n"); 
		query.append("       END  " ).append("\n"); 
		query.append("         )  " ).append("\n"); 
		query.append("       END  || SLAN_CD AS REV_VVD_CD" ).append("\n"); 
		query.append("      FROM " ).append("\n"); 
		query.append("         ( " ).append("\n"); 
		query.append("               SELECT " ).append("\n"); 
		query.append("                      C.BKG_NO       AS BKG_NO, " ).append("\n"); 
		query.append("                      C.SLAN_CD      AS SLAN_CD," ).append("\n"); 
		query.append("                      COA_RANK_INFO_FNC " ).append("\n"); 
		query.append("                    ( " ).append("\n"); 
		query.append("                      NVL (ACM_GET_RLANE_FNC (C.SLAN_CD,C.POL_CD,C.POD_CD), 'RBCCO'),                               -- N1ST_RLANE_CD " ).append("\n"); 
		query.append("                      CASE WHEN D.SLAN_CD IS NULL THEN '' ELSE ACM_GET_RLANE_FNC (D.SLAN_CD,D.POL_CD,D.POD_CD) END, -- N2ND_RLANE_CD " ).append("\n"); 
		query.append("                      CASE WHEN E.SLAN_CD IS NULL THEN '' ELSE ACM_GET_RLANE_FNC (E.SLAN_CD,E.POL_CD,E.POD_CD) END, -- N3RD_RLANE_CD " ).append("\n"); 
		query.append("                      CASE WHEN F.SLAN_CD IS NULL THEN '' ELSE ACM_GET_RLANE_FNC (F.SLAN_CD,F.POL_CD,F.POD_CD) END, -- N4TH_RLANE_CD " ).append("\n"); 
		query.append("                      CASE WHEN POL2.CONTI_CD = POD2.CONTI_CD THEN 'I'||POD2.CONTI_CD ELSE 'OO' END,                -- N1ST_CONTI " ).append("\n"); 
		query.append("                      CASE WHEN POD2.CONTI_CD = POD3.CONTI_CD THEN 'I'||POD3.CONTI_CD ELSE 'OO' END,                -- N2ND_CONTI " ).append("\n"); 
		query.append("                      CASE WHEN POD3.CONTI_CD = POD4.CONTI_CD THEN 'I'||POD4.CONTI_CD ELSE 'OO' END,                -- N3RD_CONTI " ).append("\n"); 
		query.append("                      CASE WHEN POL2.CONTI_CD = POD2.CONTI_CD THEN 'I'||POD2.CONTI_CD ELSE 'OO' END                -- N4TH_CONTI " ).append("\n"); 
		query.append("                    ) AS RNK, " ).append("\n"); 
		query.append("                      CASE WHEN POL2.CONTI_CD = POD2.CONTI_CD THEN 'I'||POD2.CONTI_CD ELSE 'OO' END AS N1ST_CONTI,  " ).append("\n"); 
		query.append("                      CASE WHEN POD2.CONTI_CD = POD3.CONTI_CD THEN 'I'||POD3.CONTI_CD ELSE 'OO' END AS N2ND_CONTI,  " ).append("\n"); 
		query.append("                      CASE WHEN POD3.CONTI_CD = POD4.CONTI_CD THEN 'I'||POD4.CONTI_CD ELSE 'OO' END AS N3RD_CONTI,  " ).append("\n"); 
		query.append("                      CASE WHEN POD4.CONTI_CD = POD5.CONTI_CD THEN 'I'||POD5.CONTI_CD ELSE 'OO' END AS N4TH_CONTI, " ).append("\n"); 
		query.append("                      NVL (ACM_GET_RLANE_FNC (C.SLAN_CD,C.POL_CD,C.POD_CD), 'RBCCO') AS N1ST_RLANE_CD,  " ).append("\n"); 
		query.append("                      CASE WHEN D.SLAN_CD IS NULL THEN '' ELSE ACM_GET_RLANE_FNC (D.SLAN_CD,D.POL_CD,D.POD_CD) END AS N2ND_RLANE_CD,  " ).append("\n"); 
		query.append("                      CASE WHEN E.SLAN_CD IS NULL THEN '' ELSE ACM_GET_RLANE_FNC (E.SLAN_CD,E.POL_CD,E.POD_CD) END AS N3RD_RLANE_CD,  " ).append("\n"); 
		query.append("                      CASE WHEN F.SLAN_CD IS NULL THEN '' ELSE ACM_GET_RLANE_FNC (F.SLAN_CD,F.POL_CD,F.POD_CD) END AS N4TH_RLANE_CD, " ).append("\n"); 
		query.append("                      C.VSL_CD " ).append("\n"); 
		query.append("                   || C.SKD_VOY_NO " ).append("\n"); 
		query.append("                   || C.SKD_DIR_CD " ).append("\n"); 
		query.append("                   || NVL " ).append("\n"); 
		query.append("                    ( " ).append("\n"); 
		query.append("                    ( " ).append("\n"); 
		query.append("                          SELECT -- COA_REV_DIR_CONV_FNC (C.SLAN_CD, C.POL_CD, C.SKD_DIR_CD) " ).append("\n"); 
		query.append("                                 RLANE_DIR_CD " ).append("\n"); 
		query.append("                            FROM AR_FINC_DIR_CONV " ).append("\n"); 
		query.append("                           WHERE SLAN_CD = C.SLAN_CD " ).append("\n"); 
		query.append("                             AND SCONTI_CD = POL2.SCONTI_CD " ).append("\n"); 
		query.append("                             AND SLAN_DIR_CD = C.SKD_DIR_CD " ).append("\n"); 
		query.append("                             AND DELT_FLG ='N' " ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("                    , C.SKD_DIR_CD " ).append("\n"); 
		query.append("                    )                                             AS N1ST_VVD_CD,  " ).append("\n"); 
		query.append("                      D.VSL_CD " ).append("\n"); 
		query.append("                   || D.SKD_VOY_NO " ).append("\n"); 
		query.append("                   || D.SKD_DIR_CD  " ).append("\n"); 
		query.append("                   ||  " ).append("\n"); 
		query.append("                 CASE D.SLAN_CD  " ).append("\n"); 
		query.append("                 WHEN NULL  " ).append("\n"); 
		query.append("                 THEN D.SKD_DIR_CD  " ).append("\n"); 
		query.append("                 ELSE NVL " ).append("\n"); 
		query.append("                    ( " ).append("\n"); 
		query.append("                    ( " ).append("\n"); 
		query.append("                          SELECT -- COA_REV_DIR_CONV_FNC (D.SLAN_CD, D.POL_CD, D.SKD_DIR_CD) " ).append("\n"); 
		query.append("                                 RLANE_DIR_CD " ).append("\n"); 
		query.append("                            FROM AR_FINC_DIR_CONV " ).append("\n"); 
		query.append("                           WHERE SLAN_CD = D.SLAN_CD " ).append("\n"); 
		query.append("                             AND SCONTI_CD = POL3.SCONTI_CD " ).append("\n"); 
		query.append("                             AND SLAN_DIR_CD = D.SKD_DIR_CD " ).append("\n"); 
		query.append("                             AND DELT_FLG ='N' " ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("                    , D.SKD_DIR_CD " ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("                  END                                                                           AS N2ND_VVD_CD,  " ).append("\n"); 
		query.append("                      E.VSL_CD||E.SKD_VOY_NO||E.SKD_DIR_CD  " ).append("\n"); 
		query.append("                   ||  " ).append("\n"); 
		query.append("                 CASE E.SLAN_CD  " ).append("\n"); 
		query.append("                 WHEN NULL  " ).append("\n"); 
		query.append("                 THEN E.SKD_DIR_CD " ).append("\n"); 
		query.append("                 ELSE NVL " ).append("\n"); 
		query.append("                    ( " ).append("\n"); 
		query.append("                    ( " ).append("\n"); 
		query.append("                          SELECT -- COA_REV_DIR_CONV_FNC (E.SLAN_CD, E.POL_CD, E.SKD_DIR_CD) " ).append("\n"); 
		query.append("                                 RLANE_DIR_CD " ).append("\n"); 
		query.append("                            FROM AR_FINC_DIR_CONV " ).append("\n"); 
		query.append("                           WHERE SLAN_CD     = E.SLAN_CD " ).append("\n"); 
		query.append("                             AND SCONTI_CD   = POL4.SCONTI_CD " ).append("\n"); 
		query.append("                             AND SLAN_DIR_CD = E.SKD_DIR_CD " ).append("\n"); 
		query.append("                             AND DELT_FLG    ='N' " ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("                    , E.SKD_DIR_CD " ).append("\n"); 
		query.append("                    )  " ).append("\n"); 
		query.append("                  END                                                                           AS N3RD_VVD_CD,  " ).append("\n"); 
		query.append("                      F.VSL_CD||F.SKD_VOY_NO||F.SKD_DIR_CD  " ).append("\n"); 
		query.append("                   ||  " ).append("\n"); 
		query.append("                 CASE F.SLAN_CD  " ).append("\n"); 
		query.append("                 WHEN NULL  " ).append("\n"); 
		query.append("                 THEN F.SKD_DIR_CD " ).append("\n"); 
		query.append("                 ELSE NVL " ).append("\n"); 
		query.append("                    ( " ).append("\n"); 
		query.append("                    ( " ).append("\n"); 
		query.append("                          SELECT -- COA_REV_DIR_CONV_FNC (F.SLAN_CD, F.POL_CD, F.SKD_DIR_CD) " ).append("\n"); 
		query.append("                                 RLANE_DIR_CD " ).append("\n"); 
		query.append("                            FROM AR_FINC_DIR_CONV " ).append("\n"); 
		query.append("                           WHERE SLAN_CD     = F.SLAN_CD " ).append("\n"); 
		query.append("                             AND SCONTI_CD   = POL5.SCONTI_CD " ).append("\n"); 
		query.append("                             AND SLAN_DIR_CD = F.SKD_DIR_CD " ).append("\n"); 
		query.append("                             AND DELT_FLG    ='N' " ).append("\n"); 
		query.append("                    ) " ).append("\n"); 
		query.append("                    , F.SKD_DIR_CD " ).append("\n"); 
		query.append("                    )  " ).append("\n"); 
		query.append("                  END                                                                           AS N4TH_VVD_CD " ).append("\n"); 
		query.append("                 FROM    " ).append("\n"); 
		query.append("                      BKG_VVD D, " ).append("\n"); 
		query.append("                      BKG_VVD E, " ).append("\n"); 
		query.append("                      BKG_VVD F, " ).append("\n"); 
		query.append("                      MDM_LOCATION POL2,                           " ).append("\n"); 
		query.append("                      MDM_LOCATION POD2, " ).append("\n"); 
		query.append("                      MDM_LOCATION POL3, " ).append("\n"); 
		query.append("                      MDM_LOCATION POD3, " ).append("\n"); 
		query.append("                      MDM_LOCATION POL4, " ).append("\n"); 
		query.append("                      MDM_LOCATION POD4, " ).append("\n"); 
		query.append("                      MDM_LOCATION POL5, " ).append("\n"); 
		query.append("                      MDM_LOCATION POD5, " ).append("\n"); 
		query.append("                    ( " ).append("\n"); 
		query.append("                          SELECT " ).append("\n"); 
		query.append("                                 VVD.BKG_NO, " ).append("\n"); 
		query.append("                                 VVD.VSL_CD, " ).append("\n"); 
		query.append("                                 VVD.SKD_VOY_NO, " ).append("\n"); 
		query.append("                                 VVD.SKD_DIR_CD, " ).append("\n"); 
		query.append("                                 VVD.SLAN_CD, " ).append("\n"); 
		query.append("                                 VVD.POL_CD, " ).append("\n"); 
		query.append("                                 VVD.POD_CD " ).append("\n"); 
		query.append("                            FROM BKG_VVD     VVD, " ).append("\n"); 
		query.append("                                 BKG_BOOKING BKG " ).append("\n"); 
		query.append("                           WHERE BKG.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("                             AND VVD.BKG_NO   = BKG.BKG_NO " ).append("\n"); 
		query.append("                             AND VVD.POL_CD   = BKG.POL_CD " ).append("\n"); 
		query.append("                    ) C " ).append("\n"); 
		query.append("                WHERE D.BKG_NO(+)   = C.BKG_NO " ).append("\n"); 
		query.append("                  AND D.POL_CD(+)   = C.POD_CD " ).append("\n"); 
		query.append("                  AND E.BKG_NO(+)   = D.BKG_NO " ).append("\n"); 
		query.append("                  AND E.POL_CD(+)   = D.POD_CD " ).append("\n"); 
		query.append("                  AND F.BKG_NO(+)   = E.BKG_NO " ).append("\n"); 
		query.append("                  AND F.POL_CD(+)   = E.POD_CD " ).append("\n"); 
		query.append("                  AND C.POL_CD      = POL2.LOC_CD (+) " ).append("\n"); 
		query.append("                  AND C.POD_CD      = POD2.LOC_CD (+) " ).append("\n"); 
		query.append("                  AND D.POL_CD      = POL3.LOC_CD (+) " ).append("\n"); 
		query.append("                  AND D.POD_CD      = POD3.LOC_CD (+) " ).append("\n"); 
		query.append("                  AND E.POL_CD      = POL4.LOC_CD (+) " ).append("\n"); 
		query.append("                  AND E.POD_CD      = POD4.LOC_CD (+) " ).append("\n"); 
		query.append("                  AND F.POL_CD      = POL5.LOC_CD (+) " ).append("\n"); 
		query.append("                  AND F.POD_CD      = POD5.LOC_CD (+) " ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}