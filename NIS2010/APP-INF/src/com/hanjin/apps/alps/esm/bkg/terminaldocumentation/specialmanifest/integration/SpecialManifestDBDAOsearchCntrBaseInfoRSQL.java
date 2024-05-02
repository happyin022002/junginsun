/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpecialManifestDBDAOsearchCntrBaseInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.11
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialManifestDBDAOsearchCntrBaseInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 컨테이터 기본정보를 조회한다.
	  * </pre>
	  */
	public SpecialManifestDBDAOsearchCntrBaseInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fwrd_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("anr_role_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.integration").append("\n"); 
		query.append("FileName : SpecialManifestDBDAOsearchCntrBaseInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("     @[d_type]              D_TYPE" ).append("\n"); 
		query.append("    ,@[vvd_cd]              VVD_CD" ).append("\n"); 
		query.append("    ,@[port_cd]             PORT_CD" ).append("\n"); 
		query.append("    ,@[bl_no]               BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    /* CNTR */" ).append("\n"); 
		query.append("    ,A.CNTR_NO              CNTR_NO" ).append("\n"); 
		query.append("    ,A.CNTR_TPSZ_CD         CNTRTS_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT CNTR_TPSZ_ISO_CD " ).append("\n"); 
		query.append("        FROM MDM_CNTR_TP_SZ " ).append("\n"); 
		query.append("        WHERE CNTR_TPSZ_CD = A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("    ) ISO      -- ISO 값" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    , A.EUR_DG_DECL_TP_CD   IMEX" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    /* SUB_PARTIES */" ).append("\n"); 
		query.append("    ,'FW1' SUB_PARTY_TYPE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        CASE" ).append("\n"); 
		query.append("            WHEN @[d_type] = 'DO' OR @[d_type] = 'PL' THEN 'HANSHI'" ).append("\n"); 
		query.append("            ELSE NVL(@[fwrd_id], '')" ).append("\n"); 
		query.append("        END " ).append("\n"); 
		query.append("     ) SUB_PARTY_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'' SUB_AUTHORIZED" ).append("\n"); 
		query.append("	,'' SUB_ADDRESS1" ).append("\n"); 
		query.append("	,'' SUB_ADDRESS2" ).append("\n"); 
		query.append("	,'' SUB_ADDRESS3" ).append("\n"); 
		query.append("	,'' SUB_ADDRESS4" ).append("\n"); 
		query.append("	,'' SUB_ADDRESS5" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("		SELECT USR_NM" ).append("\n"); 
		query.append("		FROM COM_USER" ).append("\n"); 
		query.append("		WHERE USR_ID = @[usr_id]" ).append("\n"); 
		query.append("	  ) SUB_CONTACT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,(	" ).append("\n"); 
		query.append("		SELECT OFC_PHN_NO" ).append("\n"); 
		query.append("		FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("		WHERE OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("	 ) SUB_PHONE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("		SELECT OFC_FAX_NO" ).append("\n"); 
		query.append("		FROM MDM_ORGANIZATION " ).append("\n"); 
		query.append("		WHERE  OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("	 ) SUB_FAX" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,'' SUB_REF" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    /* SUB_MEANS */" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("	   CASE" ).append("\n"); 
		query.append("	       WHEN @[d_type] = 'D' OR @[d_type] ='DO' OR @[d_type] ='O' THEN '30'" ).append("\n"); 
		query.append("	       WHEN @[d_type] = 'L' OR @[d_type] ='PL' THEN '20'" ).append("\n"); 
		query.append("	       ELSE ''" ).append("\n"); 
		query.append("	   END" ).append("\n"); 
		query.append("	 ) SUB_MEANS_TYPE" ).append("\n"); 
		query.append("    ,A.FDR_VVD_ID             SUB_VVD" ).append("\n"); 
		query.append("    ,@[c_type]                SUB_MODE" ).append("\n"); 
		query.append("    ,A.FDR_VSL_NM             SUB_NAME" ).append("\n"); 
		query.append("    ,A.FDR_SVC_RQST_NO        SUB_SSR -- FEEDER SSR" ).append("\n"); 
		query.append("    ,'L'                    SUB_ID_TYPE" ).append("\n"); 
		query.append("    ,A.FDR_VSL_LLOYD_NO       SUB_ID" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("        FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("        WHERE VSL_CD = SUBSTR(@[vvd_cd], 1, 4)    " ).append("\n"); 
		query.append("    ) SUB_NATION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("                CASE" ).append("\n"); 
		query.append("                    WHEN (SPR_CNT + AMN_CNT + ZTG_CNT +ETC_CNT) = ETC_CNT THEN ''" ).append("\n"); 
		query.append("                    WHEN SPR_CNT > 0 THEN 'SPR'" ).append("\n"); 
		query.append("                    ELSE 'AMN'" ).append("\n"); 
		query.append("                END SUB_LICENSE" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                SELECT COUNT(ANR_SPCL_TP_ID) SPR_CNT" ).append("\n"); 
		query.append("                FROM BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append("                WHERE EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                AND   VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                AND   SKD_VOY_NO    = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                AND   SKD_DIR_CD    = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                AND   PORT_CD       = @[port_cd]" ).append("\n"); 
		query.append("                AND   BL_NO         = @[bl_no]" ).append("\n"); 
		query.append("                AND   ANR_SPCL_TP_ID    = 'SPR'" ).append("\n"); 
		query.append("              ) A" ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT COUNT(ANR_SPCL_TP_ID) AMN_CNT" ).append("\n"); 
		query.append("                FROM BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append("                WHERE EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                AND   VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                AND   SKD_VOY_NO    = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                AND   SKD_DIR_CD    = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                AND   PORT_CD       = @[port_cd]" ).append("\n"); 
		query.append("                AND   BL_NO         = @[bl_no]" ).append("\n"); 
		query.append("                AND   ANR_SPCL_TP_ID    = 'AMN'" ).append("\n"); 
		query.append("              ) B      " ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT COUNT(ANR_SPCL_TP_ID) ZTG_CNT" ).append("\n"); 
		query.append("                FROM BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append("                WHERE EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                AND   VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                AND   SKD_VOY_NO    = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                AND   SKD_DIR_CD    = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                AND   PORT_CD       = @[port_cd]" ).append("\n"); 
		query.append("                AND   BL_NO         = @[bl_no]" ).append("\n"); 
		query.append("                AND   ANR_SPCL_TP_ID    = 'ZTG'" ).append("\n"); 
		query.append("              ) C      " ).append("\n"); 
		query.append("              ,(" ).append("\n"); 
		query.append("                SELECT COUNT(ANR_SPCL_TP_ID) ETC_CNT" ).append("\n"); 
		query.append("                FROM BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append("                WHERE EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("                AND   VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                AND   SKD_VOY_NO    = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                AND   SKD_DIR_CD    = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                AND   PORT_CD       = @[port_cd]" ).append("\n"); 
		query.append("                AND   BL_NO         = @[bl_no]" ).append("\n"); 
		query.append("                AND   ANR_SPCL_TP_ID   IS NULL" ).append("\n"); 
		query.append("              ) D      " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) SUB_LICENSE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    /* BOOKINGS */" ).append("\n"); 
		query.append("    ,'L'                    L_BKG_ID_TYPE" ).append("\n"); 
		query.append("    ,@[bl_no]               L_BKG_ID" ).append("\n"); 
		query.append("    ,'B'                    B_BKG_ID_TYPE" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT BKG_NO" ).append("\n"); 
		query.append("        FROM BKG_BOOKING" ).append("\n"); 
		query.append("        WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("    ) B_BKG_ID" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("	   CASE" ).append("\n"); 
		query.append("	       WHEN (@[anr_role_div_cd] = 'BO' AND @[d_type] = 'PL') OR @[d_type] ='P' THEN 'PRE'" ).append("\n"); 
		query.append("	       WHEN (@[anr_role_div_cd] = 'BO' AND @[d_type] = 'DO') OR @[d_type] ='O' THEN 'ON'" ).append("\n"); 
		query.append("	       WHEN @[d_type] ='L'  THEN 'ON'" ).append("\n"); 
		query.append("	       ELSE ''" ).append("\n"); 
		query.append("	   END" ).append("\n"); 
		query.append("	 ) BKG_DATE_TYPE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	,(" ).append("\n"); 
		query.append("	   CASE" ).append("\n"); 
		query.append("	       WHEN (@[anr_role_div_cd] = 'BO' AND @[d_type] = 'PL')" ).append("\n"); 
		query.append("                    OR @[d_type] ='P' " ).append("\n"); 
		query.append("                    OR (@[anr_role_div_cd] = 'BO' AND @[d_type] = 'DO')" ).append("\n"); 
		query.append("                    OR @[d_type] ='O' " ).append("\n"); 
		query.append("                 THEN @[crr_dt]" ).append("\n"); 
		query.append("           WHEN @[d_type] ='L'  THEN @[crr_dt]        " ).append("\n"); 
		query.append("	       ELSE ''" ).append("\n"); 
		query.append("	   END " ).append("\n"); 
		query.append("	 ) BKG_DATE" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    ,'POL'                  POL_BKG_LOC_TYPE" ).append("\n"); 
		query.append("    ,A.POL_CD               POL_BKG_LOC" ).append("\n"); 
		query.append("    ,'POD'                  POD_BKG_LOC_TYPE" ).append("\n"); 
		query.append("    ,A.POD_CD               POD_BKG_LOC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_DG A" ).append("\n"); 
		query.append("    ,(" ).append("\n"); 
		query.append("        SELECT EUR_DG_DECL_TP_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, PORT_CD, BL_NO, CNTR_NO, MAX(CNTR_CGO_SEQ) CNTR_CGO_SEQ" ).append("\n"); 
		query.append("        FROM BKG_CSTMS_EUR_DG" ).append("\n"); 
		query.append("        WHERE EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("        AND   VSL_CD        = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("        AND   SKD_VOY_NO    = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("        AND   SKD_DIR_CD    = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("        AND   PORT_CD       = @[port_cd]" ).append("\n"); 
		query.append("        AND   BL_NO         = @[bl_no]" ).append("\n"); 
		query.append("        GROUP BY EUR_DG_DECL_TP_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, PORT_CD, BL_NO, CNTR_NO " ).append("\n"); 
		query.append("    ) B" ).append("\n"); 
		query.append("    ,BKG_CSTMS_EUR_DG_VSL_SKD C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE A.EUR_DG_DECL_TP_CD = @[d_type]" ).append("\n"); 
		query.append("AND   A.VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND   A.PORT_CD         =  @[port_cd]" ).append("\n"); 
		query.append("AND   A.BL_NO           =  @[bl_no]" ).append("\n"); 
		query.append("AND   A.CNTR_NO         = B.CNTR_NO" ).append("\n"); 
		query.append("AND   A.CNTR_CGO_SEQ    = B.CNTR_CGO_SEQ" ).append("\n"); 
		query.append("AND   A.EUR_DG_DECL_TP_CD = C.EUR_DG_DECL_TP_CD(+)" ).append("\n"); 
		query.append("AND   A.VSL_CD          = C.VSL_CD(+)" ).append("\n"); 
		query.append("AND   A.SKD_VOY_NO      = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND   A.SKD_DIR_CD      = C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND   A.PORT_CD         = C.PORT_CD(+)" ).append("\n"); 
		query.append("ORDER BY CNTR_NO" ).append("\n"); 

	}
}