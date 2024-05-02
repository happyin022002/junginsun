/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchTrnkVvdByRlaneRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.29 
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

public class GeneralBookingReceiptDBDAOSearchTrnkVvdByRlaneRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력한 vvd 중 trunk vvd를 coa 항차 기준으로 계산한다
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchTrnkVvdByRlaneRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4_pod_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2_pol_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3_pod_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4_pol_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3_pol_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1_pol_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1_pod_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2_pod_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n4_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2_pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchTrnkVvdByRlaneRSQL").append("\n"); 
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
		query.append("WITH VVD AS (" ).append("\n"); 
		query.append("SELECT N1ST_SLAN_CD" ).append("\n"); 
		query.append("	, @[n1_pol] N1ST_POL_CD" ).append("\n"); 
		query.append("    , @[n1_pod] N1ST_POD_CD" ).append("\n"); 
		query.append("	, (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[n1_pol]) N1ST_ORG_CONTI_CD" ).append("\n"); 
		query.append("	, (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[n1_pod]) N1ST_DEST_CONTI_CD" ).append("\n"); 
		query.append("    , SUBSTR(@[n1_vvd], 9, 1) N1ST_SKD_DIR_CD" ).append("\n"); 
		query.append("	, CASE WHEN (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = N1ST_SLAN_CD) = 'O' THEN 'RBCCO'--OFF는 RBCCO" ).append("\n"); 
		query.append("	       ELSE DECODE(N1ST_R_LANE, 'RBCCO', 'NOFDR', N1ST_R_LANE) END N1ST_R_LANE" ).append("\n"); 
		query.append("	, NVL((SELECT MIN(rnk.RNK_SEQ)" ).append("\n"); 
		query.append("	         FROM AR_ROUT_RNK rnk" ).append("\n"); 
		query.append("            WHERE rnk.ZN_IOC_CD   like DECODE(N1ST_ORG_CONTI_CD, DECODE(N1ST_DEST_CONTI_CD,'F', DECODE(N1ST_R_LANE, 'WAFIE', 'E', 'RESIA', 'A', N1ST_DEST_CONTI_CD), N1ST_DEST_CONTI_CD), 'I'||N1ST_ORG_CONTI_CD, 'OO')||'%'" ).append("\n"); 
		query.append("	          AND rnk.RLANE_CD    = DECODE(N1ST_R_LANE, 'RBCCO', 'X', N1ST_R_LANE)" ).append("\n"); 
		query.append("	       ), 9999) N1ST_AR_RNK" ).append("\n"); 
		query.append("	, N2ND_SLAN_CD" ).append("\n"); 
		query.append("    , @[n2_pol] N2ND_POL_CD" ).append("\n"); 
		query.append("    , @[n2_pod] N2ND_POD_CD" ).append("\n"); 
		query.append("	, (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[n2_pol]) N2ND_ORG_CONTI_CD" ).append("\n"); 
		query.append("	, (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[n2_pod]) N2ND_DEST_CONTI_CD" ).append("\n"); 
		query.append("    , SUBSTR(@[n2_vvd], 9, 1) N2ND_SKD_DIR_CD" ).append("\n"); 
		query.append("	, CASE WHEN (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = N2ND_SLAN_CD) = 'O' THEN 'RBCCO'--OFF는 RBCCO" ).append("\n"); 
		query.append("	       ELSE DECODE(N2ND_R_LANE, 'RBCCO', 'NOFDR', N2ND_R_LANE) END N2ND_R_LANE" ).append("\n"); 
		query.append("	, NVL((SELECT MIN(rnk.RNK_SEQ)" ).append("\n"); 
		query.append("	         FROM AR_ROUT_RNK rnk" ).append("\n"); 
		query.append("	        WHERE rnk.SLAN_CD     = N2nd_SLAN_CD" ).append("\n"); 
		query.append("	          AND rnk.ZN_IOC_CD   like DECODE(N2ND_ORG_CONTI_CD, DECODE(N2nd_DEST_CONTI_CD,'F', DECODE(N2nd_R_LANE, 'WAFIE', 'E', 'RESIA', 'A', N2nd_DEST_CONTI_CD), N2nd_DEST_CONTI_CD), 'I'||N2nd_ORG_CONTI_CD, 'OO')||'%'" ).append("\n"); 
		query.append("	          AND rnk.RLANE_CD    = DECODE(N2ND_R_LANE, 'RBCCO', 'X', N2ND_R_LANE)" ).append("\n"); 
		query.append("	      ), 9999) N2ND_AR_RNK" ).append("\n"); 
		query.append("	, N3RD_SLAN_CD" ).append("\n"); 
		query.append("    , @[n3_pol] N3RD_POL_CD" ).append("\n"); 
		query.append("    , @[n3_pod] N3RD_POD_CD" ).append("\n"); 
		query.append("	, (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[n3_pol]) N3RD_ORG_CONTI_CD" ).append("\n"); 
		query.append("	, (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[n3_pod]) N3RD_DEST_CONTI_CD" ).append("\n"); 
		query.append("    , SUBSTR(@[n3_vvd], 9, 1) N3RD_SKD_DIR_CD" ).append("\n"); 
		query.append("	, CASE WHEN (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = N3RD_SLAN_CD) = 'O' THEN 'RBCCO'--OFF는 RBCCO" ).append("\n"); 
		query.append("	       ELSE DECODE(N3RD_R_LANE, 'RBCCO', 'NOFDR', N3RD_R_LANE) END N3RD_R_LANE" ).append("\n"); 
		query.append("	, NVL((SELECT MIN(rnk.RNK_SEQ)" ).append("\n"); 
		query.append("	         FROM AR_ROUT_RNK rnk" ).append("\n"); 
		query.append("	        WHERE rnk.SLAN_CD     = N3rd_SLAN_CD" ).append("\n"); 
		query.append("	          AND rnk.ZN_IOC_CD   like DECODE(N3rd_ORG_CONTI_CD, DECODE(N3rd_DEST_CONTI_CD,'F', DECODE(N3rd_R_LANE, 'WAFIE', 'E', 'RESIA', 'A', N3rd_DEST_CONTI_CD), N3rd_DEST_CONTI_CD), 'I'||N3rd_ORG_CONTI_CD, 'OO')||'%'" ).append("\n"); 
		query.append("	          AND rnk.RLANE_CD    = DECODE(N3RD_R_LANE, 'RBCCO', 'X', N3RD_R_LANE)	" ).append("\n"); 
		query.append("	      ), 9999) N3RD_AR_RNK" ).append("\n"); 
		query.append("	, N4TH_SLAN_CD" ).append("\n"); 
		query.append("    , @[n4_pol] N4TH_POL_CD" ).append("\n"); 
		query.append("    , @[n4_pod] N4TH_POD_CD" ).append("\n"); 
		query.append("	, (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[n4_pol]) N4TH_ORG_CONTI_CD" ).append("\n"); 
		query.append("	, (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[n4_pod]) N4TH_DEST_CONTI_CD" ).append("\n"); 
		query.append("    , SUBSTR(@[n4_vvd], 9, 1) N4TH_SKD_DIR_CD" ).append("\n"); 
		query.append("	, CASE WHEN (SELECT VSL_SVC_TP_CD FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = N4TH_SLAN_CD) = 'O' THEN 'RBCCO'--OFF는 RBCCO" ).append("\n"); 
		query.append("	       ELSE DECODE(N4TH_R_LANE, 'RBCCO', 'NOFDR', N4TH_R_LANE) END N4TH_R_LANE" ).append("\n"); 
		query.append("	, NVL((SELECT MIN(Rnk.RNK_SEQ)" ).append("\n"); 
		query.append("	         FROM AR_ROUT_RNK rnk" ).append("\n"); 
		query.append("	        WHERE rnk.SLAN_CD     = N4th_SLAN_CD" ).append("\n"); 
		query.append("	          AND rnk.ZN_IOC_CD   like DECODE(N4th_ORG_CONTI_CD, DECODE(N4th_DEST_CONTI_CD,'F', DECODE(N4th_R_LANE, 'WAFIE', 'E', 'RESIA', 'A', N4th_DEST_CONTI_CD), N4th_DEST_CONTI_CD), 'I'||N4th_ORG_CONTI_CD, 'OO')||'%'" ).append("\n"); 
		query.append("	          AND rnk.RLANE_CD    = DECODE(N4TH_R_LANE, 'RBCCO', 'X', N4TH_R_LANE)" ).append("\n"); 
		query.append("			), 9999) N4TH_AR_RNK" ).append("\n"); 
		query.append("	, (SELECT SEQ --MAX TRANSIT TIME - SEQ" ).append("\n"); 
		query.append("	     FROM " ).append("\n"); 
		query.append("    	  (SELECT TZ_TM, SEQ" ).append("\n"); 
		query.append("    	     FROM ( SELECT MAX(POD.VPS_ETA_DT) - MIN(POL.VPS_ETD_DT) TZ_TM, 1 SEQ" ).append("\n"); 
		query.append("            	      FROM VSK_VSL_PORT_SKD POL, VSK_VSL_PORT_SKD POD" ).append("\n"); 
		query.append("            	     WHERE POL.VSL_CD = SUBSTR(@[n1_vvd], 1, 4) AND POL.SKD_VOY_NO = SUBSTR(@[n1_vvd], 5, 4) AND POL.SKD_DIR_CD = SUBSTR(@[n1_vvd], 9, 1) AND POL.VPS_PORT_CD = @[n1_pol]" ).append("\n"); 
		query.append("            	       AND POD.VSL_CD = SUBSTR(@[n1_vvd], 1, 4) AND POD.SKD_VOY_NO = SUBSTR(@[n1_vvd], 5, 4) AND POD.SKD_DIR_CD = SUBSTR(@[n1_vvd], 9, 1) AND POD.VPS_PORT_CD = @[n1_pod]" ).append("\n"); 
		query.append("            	    UNION ALL " ).append("\n"); 
		query.append("            	    SELECT MAX(POD.VPS_ETA_DT) - MIN(POL.VPS_ETD_DT) TZ_TM, 2 SEQ" ).append("\n"); 
		query.append("            	      FROM VSK_VSL_PORT_SKD POL, VSK_VSL_PORT_SKD POD" ).append("\n"); 
		query.append("            	     WHERE POL.VSL_CD = SUBSTR(@[n2_vvd], 1, 4) AND POL.SKD_VOY_NO = SUBSTR(@[n2_vvd], 5, 4) AND POL.SKD_DIR_CD = SUBSTR(@[n2_vvd], 9, 1) AND POL.VPS_PORT_CD = @[n2_pol]" ).append("\n"); 
		query.append("            	       AND POD.VSL_CD = SUBSTR(@[n2_vvd], 1, 4) AND POD.SKD_VOY_NO = SUBSTR(@[n2_vvd], 5, 4) AND POD.SKD_DIR_CD = SUBSTR(@[n2_vvd], 9, 1) AND POD.VPS_PORT_CD = @[n2_pod]" ).append("\n"); 
		query.append("            	    UNION ALL" ).append("\n"); 
		query.append("            	    SELECT MAX(POD.VPS_ETA_DT) - MIN(POL.VPS_ETD_DT) TZ_TM, 3 SEQ" ).append("\n"); 
		query.append("            	      FROM VSK_VSL_PORT_SKD POL, VSK_VSL_PORT_SKD POD" ).append("\n"); 
		query.append("            	     WHERE POL.VSL_CD = SUBSTR(@[n3_vvd], 1, 4) AND POL.SKD_VOY_NO = SUBSTR(@[n3_vvd], 5, 4) AND POL.SKD_DIR_CD = SUBSTR(@[n3_vvd], 9, 1) AND POL.VPS_PORT_CD = @[n3_pol]" ).append("\n"); 
		query.append("            	       AND POD.VSL_CD = SUBSTR(@[n3_vvd], 1, 4) AND POD.SKD_VOY_NO = SUBSTR(@[n3_vvd], 5, 4) AND POD.SKD_DIR_CD = SUBSTR(@[n3_vvd], 9, 1) AND POD.VPS_PORT_CD = @[n3_pod]" ).append("\n"); 
		query.append("            	    UNION ALL" ).append("\n"); 
		query.append("            	    SELECT MAX(POD.VPS_ETA_DT) - MIN(POL.VPS_ETD_DT) TZ_TM, 4 SEQ" ).append("\n"); 
		query.append("            	      FROM VSK_VSL_PORT_SKD POL, VSK_VSL_PORT_SKD POD" ).append("\n"); 
		query.append("            	     WHERE POL.VSL_CD = SUBSTR(@[n4_vvd], 1, 4) AND POL.SKD_VOY_NO = SUBSTR(@[n4_vvd], 5, 4) AND POL.SKD_DIR_CD = SUBSTR(@[n4_vvd], 9, 1) AND POL.VPS_PORT_CD = @[n4_pol]" ).append("\n"); 
		query.append("            	       AND POD.VSL_CD = SUBSTR(@[n4_vvd], 1, 4) AND POD.SKD_VOY_NO = SUBSTR(@[n4_vvd], 5, 4) AND POD.SKD_DIR_CD = SUBSTR(@[n4_vvd], 9, 1) AND POD.VPS_PORT_CD = @[n4_pod])" ).append("\n"); 
		query.append("           WHERE TZ_TM IS NOT NULL" ).append("\n"); 
		query.append("            ORDER BY TZ_TM DESC)" ).append("\n"); 
		query.append("        WHERE ROWNUM = 1) MAX_TZ_SEQ" ).append("\n"); 
		query.append("	" ).append("\n"); 
		query.append("FROM (SELECT (SELECT VSL_SLAN_CD FROM VSK_VSL_SKD WHERE VSL_CD = SUBSTR(@[n1_vvd], 1, 4) AND SKD_VOY_NO = SUBSTR(@[n1_vvd], 5, 4) AND SKD_DIR_CD = SUBSTR(@[n1_vvd], 9, 1)) N1ST_SLAN_CD" ).append("\n"); 
		query.append("           , (SELECT VSL_SLAN_CD FROM VSK_VSL_SKD WHERE VSL_CD = SUBSTR(@[n2_vvd], 1, 4) AND SKD_VOY_NO = SUBSTR(@[n2_vvd], 5, 4) AND SKD_DIR_CD = SUBSTR(@[n2_vvd], 9, 1)) N2ND_SLAN_CD" ).append("\n"); 
		query.append("           , (SELECT VSL_SLAN_CD FROM VSK_VSL_SKD WHERE VSL_CD = SUBSTR(@[n3_vvd], 1, 4) AND SKD_VOY_NO = SUBSTR(@[n3_vvd], 5, 4) AND SKD_DIR_CD = SUBSTR(@[n3_vvd], 9, 1)) N3RD_SLAN_CD" ).append("\n"); 
		query.append("           , (SELECT VSL_SLAN_CD FROM VSK_VSL_SKD WHERE VSL_CD = SUBSTR(@[n4_vvd], 1, 4) AND SKD_VOY_NO = SUBSTR(@[n4_vvd], 5, 4) AND SKD_DIR_CD = SUBSTR(@[n4_vvd], 9, 1)) N4TH_SLAN_CD" ).append("\n"); 
		query.append("           , DECODE(NVL(@[n1_vvd], 'X'), 'X', NULL, MAS_SLANE_RLANE_CONV_FNC(@[n1_vvd]" ).append("\n"); 
		query.append("					, (SELECT VSL_SLAN_CD FROM VSK_VSL_SKD WHERE VSL_CD = SUBSTR(@[n1_vvd], 1, 4) AND SKD_VOY_NO = SUBSTR(@[n1_vvd], 5, 4) AND SKD_DIR_CD = SUBSTR(@[n1_vvd], 9, 1))" ).append("\n"); 
		query.append("					, SUBSTR(@[n1_pol], 1, 5)" ).append("\n"); 
		query.append("					, SUBSTR(@[n1_pod], 1, 5))) N1ST_R_LANE" ).append("\n"); 
		query.append("           , DECODE(NVL(@[n2_vvd], 'X'), 'X', NULL, MAS_SLANE_RLANE_CONV_FNC(@[n2_vvd]" ).append("\n"); 
		query.append("					, (SELECT VSL_SLAN_CD FROM VSK_VSL_SKD WHERE VSL_CD = SUBSTR(@[n2_vvd], 1, 4) AND SKD_VOY_NO = SUBSTR(@[n2_vvd], 5, 4) AND SKD_DIR_CD = SUBSTR(@[n2_vvd], 9, 1))" ).append("\n"); 
		query.append("					, SUBSTR(@[n2_pol], 1, 5)" ).append("\n"); 
		query.append("					, SUBSTR(@[n2_pod], 1, 5))) N2ND_R_LANE" ).append("\n"); 
		query.append("           , DECODE(NVL(@[n3_vvd], 'X'), 'X', NULL, MAS_SLANE_RLANE_CONV_FNC(@[n3_vvd]" ).append("\n"); 
		query.append("					, (SELECT VSL_SLAN_CD FROM VSK_VSL_SKD WHERE VSL_CD = SUBSTR(@[n3_vvd], 1, 4) AND SKD_VOY_NO = SUBSTR(@[n3_vvd], 5, 4) AND SKD_DIR_CD = SUBSTR(@[n3_vvd], 9, 1))" ).append("\n"); 
		query.append("					, SUBSTR(@[n3_pol], 1, 5)" ).append("\n"); 
		query.append("					, SUBSTR(@[n3_pod], 1, 5))) N3RD_R_LANE" ).append("\n"); 
		query.append("           , DECODE(NVL(@[n4_vvd], 'X'), 'X', NULL, MAS_SLANE_RLANE_CONV_FNC(@[n4_vvd]" ).append("\n"); 
		query.append("					, (SELECT VSL_SLAN_CD FROM VSK_VSL_SKD WHERE VSL_CD = SUBSTR(@[n4_vvd], 1, 4) AND SKD_VOY_NO = SUBSTR(@[n4_vvd], 5, 4) AND SKD_DIR_CD = SUBSTR(@[n4_vvd], 9, 1))" ).append("\n"); 
		query.append("					, SUBSTR(@[n4_pol], 1, 5)" ).append("\n"); 
		query.append("					, SUBSTR(@[n4_pod], 1, 5))) N4TH_R_LANE" ).append("\n"); 
		query.append("	       , (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[n1_pol]) N1ST_ORG_CONTI_CD" ).append("\n"); 
		query.append("	       , (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[n2_pol]) N2ND_ORG_CONTI_CD" ).append("\n"); 
		query.append("	       , (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[n3_pol]) N3RD_ORG_CONTI_CD" ).append("\n"); 
		query.append("	       , (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[n4_pol]) N4TH_ORG_CONTI_CD" ).append("\n"); 
		query.append("           , (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[n1_pod]) N1ST_DEST_CONTI_CD" ).append("\n"); 
		query.append("           , (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[n2_pod]) N2ND_DEST_CONTI_CD" ).append("\n"); 
		query.append("           , (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[n3_pod]) N3RD_DEST_CONTI_CD" ).append("\n"); 
		query.append("           , (SELECT CONTI_CD FROM MDM_LOCATION WHERE LOC_CD = @[n4_pod]) N4TH_DEST_CONTI_CD" ).append("\n"); 
		query.append("        FROM DUAL)" ).append("\n"); 
		query.append(")    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT CASE WHEN N1ST_R_LANE = 'NOFDR' OR N2ND_R_LANE = 'NOFDR' OR N3RD_R_LANE = 'NOFDR' OR N4TH_R_LANE = 'NOFDR' THEN MAX_TZ_SEQ" ).append("\n"); 
		query.append("            WHEN N1ST_AR_RNK = 0       OR N2ND_AR_RNK = 0       OR N3RD_AR_RNK = 0       OR N4TH_AR_RNK = 0       THEN MAX_TZ_SEQ" ).append("\n"); 
		query.append("            WHEN   (N1ST_SLAN_CD is not null and N1ST_R_LANE is not null and N1ST_R_LANE <> 'RBCCO' and N1ST_AR_RNK = 9999)" ).append("\n"); 
		query.append("                OR (N2ND_SLAN_CD is not null and N2ND_R_LANE is not null and N2ND_R_LANE <> 'RBCCO' and N2ND_AR_RNK = 9999)" ).append("\n"); 
		query.append("                OR (N3RD_SLAN_CD is not null and N3RD_R_LANE is not null and N3RD_R_LANE <> 'RBCCO' and N3RD_AR_RNK = 9999)" ).append("\n"); 
		query.append("                or (N4TH_SLAN_CD is not null and N4TH_R_LANE is not null and N4TH_R_LANE <> 'RBCCO' and N4TH_AR_RNK = 9999) THEN MAX_TZ_SEQ" ).append("\n"); 
		query.append("            WHEN EXISTS (SELECT '1' -- 아래 조건 값 있으면 MAS_RANK_INFO_COMP_FNC 사용" ).append("\n"); 
		query.append("                     FROM BKG_HRD_CDG_CTNT" ).append("\n"); 
		query.append("                    WHERE HRD_CDG_ID = 'BKG_VALIDATION'" ).append("\n"); 
		query.append("                      AND ATTR_CTNT1 = 'MAS_RANK_INFO_COMP_FNC'" ).append("\n"); 
		query.append("                      AND ATTR_CTNT2 = 'ON') " ).append("\n"); 
		query.append("                 THEN MAS_RANK_INFO_COMP_FNC( --NEW				        " ).append("\n"); 
		query.append("                      N1ST_R_LANE" ).append("\n"); 
		query.append("                    , N2ND_R_LANE" ).append("\n"); 
		query.append("                    , N3RD_R_LANE" ).append("\n"); 
		query.append("                    , N4TH_R_LANE" ).append("\n"); 
		query.append("                    , DECODE(N1ST_ORG_CONTI_CD, DECODE(N1ST_DEST_CONTI_CD,'F', DECODE(N1ST_R_LANE, 'WAFIE', 'E', 'RESIA', 'A', N1ST_DEST_CONTI_CD), N1ST_DEST_CONTI_CD), 'I'||N1ST_ORG_CONTI_CD, 'OO')" ).append("\n"); 
		query.append("                    , DECODE(N2ND_ORG_CONTI_CD, DECODE(N2ND_DEST_CONTI_CD,'F', DECODE(N2ND_R_LANE, 'WAFIE', 'E', 'RESIA', 'A', N2ND_DEST_CONTI_CD), N2ND_DEST_CONTI_CD), 'I'||N2ND_ORG_CONTI_CD, 'OO')" ).append("\n"); 
		query.append("                    , DECODE(N3RD_ORG_CONTI_CD, DECODE(N3RD_DEST_CONTI_CD,'F', DECODE(N3RD_R_LANE, 'WAFIE', 'E', 'RESIA', 'A', N3RD_DEST_CONTI_CD), N3RD_DEST_CONTI_CD), 'I'||N3RD_ORG_CONTI_CD, 'OO')" ).append("\n"); 
		query.append("                    , DECODE(N4TH_ORG_CONTI_CD, DECODE(N4TH_DEST_CONTI_CD,'F', DECODE(N4TH_R_LANE, 'WAFIE', 'E', 'RESIA', 'A', N4TH_DEST_CONTI_CD), N4TH_DEST_CONTI_CD), 'I'||N4TH_ORG_CONTI_CD, 'OO') " ).append("\n"); 
		query.append("                    , 'V' -- BKG: B /PCLT : P / VVD : V " ).append("\n"); 
		query.append("                    , '' --BKG_NO" ).append("\n"); 
		query.append("                    , '' --PCTL_NO" ).append("\n"); 
		query.append("                    , @[n1_vvd]" ).append("\n"); 
		query.append("                    , @[n2_vvd]" ).append("\n"); 
		query.append("                    , @[n3_vvd]" ).append("\n"); 
		query.append("                    , @[n4_vvd] " ).append("\n"); 
		query.append("                    , @[n1_pol]||@[n1_pol_yd]" ).append("\n"); 
		query.append("                    , @[n2_pol]||@[n2_pol_yd]" ).append("\n"); 
		query.append("                    , @[n3_pol]||@[n3_pol_yd]" ).append("\n"); 
		query.append("                    , @[n4_pol]||@[n4_pol_yd]" ).append("\n"); 
		query.append("                    , @[n1_pod]||@[n1_pod_yd]" ).append("\n"); 
		query.append("                    , @[n2_pod]||@[n2_pod_yd]" ).append("\n"); 
		query.append("                    , @[n3_pod]||@[n3_pod_yd]" ).append("\n"); 
		query.append("                    , @[n4_pod]||@[n4_pod_yd]" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("            ELSE MAS_RANK_INFO_FNC(	--OLD			        " ).append("\n"); 
		query.append("                      N1ST_R_LANE" ).append("\n"); 
		query.append("                    , N2ND_R_LANE" ).append("\n"); 
		query.append("                    , N3RD_R_LANE" ).append("\n"); 
		query.append("                    , N4TH_R_LANE" ).append("\n"); 
		query.append("                	, DECODE(N1ST_ORG_CONTI_CD, DECODE(N1ST_DEST_CONTI_CD,'F', DECODE(N1ST_R_LANE, 'WAFIE', 'E', 'RESIA', 'A', N1ST_DEST_CONTI_CD), N1ST_DEST_CONTI_CD), 'I'||N1ST_ORG_CONTI_CD, 'OO')" ).append("\n"); 
		query.append("                	, DECODE(N2ND_ORG_CONTI_CD, DECODE(N2ND_DEST_CONTI_CD,'F', DECODE(N2ND_R_LANE, 'WAFIE', 'E', 'RESIA', 'A', N2ND_DEST_CONTI_CD), N2ND_DEST_CONTI_CD), 'I'||N2ND_ORG_CONTI_CD, 'OO')" ).append("\n"); 
		query.append("                	, DECODE(N3RD_ORG_CONTI_CD, DECODE(N3RD_DEST_CONTI_CD,'F', DECODE(N3RD_R_LANE, 'WAFIE', 'E', 'RESIA', 'A', N3RD_DEST_CONTI_CD), N3RD_DEST_CONTI_CD), 'I'||N3RD_ORG_CONTI_CD, 'OO')" ).append("\n"); 
		query.append("                	, DECODE(N4TH_ORG_CONTI_CD, DECODE(N4TH_DEST_CONTI_CD,'F', DECODE(N4TH_R_LANE, 'WAFIE', 'E', 'RESIA', 'A', N4TH_DEST_CONTI_CD), N4TH_DEST_CONTI_CD), 'I'||N4TH_ORG_CONTI_CD, 'OO') " ).append("\n"); 
		query.append("                    , @[n1_vvd]" ).append("\n"); 
		query.append("                    , @[n2_vvd]" ).append("\n"); 
		query.append("                    , @[n3_vvd]" ).append("\n"); 
		query.append("                    , @[n4_vvd]                    " ).append("\n"); 
		query.append("                    ) end trunk_seq" ).append("\n"); 
		query.append("  FROM VVD" ).append("\n"); 

	}
}