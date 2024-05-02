/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CODCorrectionDBDAOsearchPrnrCodRcvrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.06.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOsearchPrnrCodRcvrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * mail 보내고 받는 사람 정보 조회
	  * 2011.05.16 이일민 [CHM-201110392] [Booking-COD] 오토 메일시 VVD의 Carrier별로 발신 가능하도록 로직 수정 요청건
	  * 2011.06.08 이일민 [CHM-201110392] [Booking-COD] 오토 메일시 VVD의 Carrier별로 발신 가능하도록 로직 수정 요청건
	  * </pre>
	  */
	public CODCorrectionDBDAOsearchPrnrCodRcvrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhnd_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOsearchPrnrCodRcvrRSQL").append("\n"); 
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
		query.append("SELECT BKG_JOIN_FNC(CURSOR(SELECT PIC_EML" ).append("\n"); 
		query.append("                             FROM VSK_LANE_PIC EML" ).append("\n"); 
		query.append("                            WHERE SLAN_CD = (SELECT VSL_SLAN_CD " ).append("\n"); 
		query.append("                                               FROM VSK_VSL_SKD " ).append("\n"); 
		query.append("                                              WHERE VSL_CD     = SUBSTR(@[rhnd_vvd], 1, 4)" ).append("\n"); 
		query.append("                                                AND SKD_VOY_NO = SUBSTR(@[rhnd_vvd], 5, 4)" ).append("\n"); 
		query.append("                                                AND SKD_DIR_CD = SUBSTR(@[rhnd_vvd], 9, 1))  " ).append("\n"); 
		query.append("                              AND RGN_SHP_OPR_CD = COD.RGN_CD " ).append("\n"); 
		query.append("                              AND (PIC_CRR_DESC IS NULL OR PIC_CRR_DESC LIKE '%'||(SELECT CRR_CD FROM MDM_VSL_CNTR WHERE VSL_CD = SUBSTR(@[rhnd_vvd], 1, 4))||'%')" ).append("\n"); 
		query.append("                              AND LANE_PIC_TP_CD = 'J'), ';') TO_EML" ).append("\n"); 
		query.append("     , USR_EML CC_EML" ).append("\n"); 
		query.append("     , (SELECT PIC_EML" ).append("\n"); 
		query.append("          FROM VSK_LANE_PIC EML" ).append("\n"); 
		query.append("         WHERE SLAN_CD = (SELECT VSL_SLAN_CD " ).append("\n"); 
		query.append("                            FROM VSK_VSL_SKD " ).append("\n"); 
		query.append("                           WHERE VSL_CD     = SUBSTR(@[rhnd_vvd], 1, 4)" ).append("\n"); 
		query.append("                             AND SKD_VOY_NO = SUBSTR(@[rhnd_vvd], 5, 4)" ).append("\n"); 
		query.append("                             AND SKD_DIR_CD = SUBSTR(@[rhnd_vvd], 9, 1))   " ).append("\n"); 
		query.append("           AND RGN_SHP_OPR_CD = COD.RGN_CD" ).append("\n"); 
		query.append("           AND (PIC_CRR_DESC IS NULL OR PIC_CRR_DESC LIKE '%'||(SELECT CRR_CD FROM MDM_VSL_CNTR WHERE VSL_CD = SUBSTR(@[rhnd_vvd], 1, 4))||'%')" ).append("\n"); 
		query.append("           AND LANE_PIC_TP_CD = 'I'" ).append("\n"); 
		query.append("           AND ROWNUM = 1        " ).append("\n"); 
		query.append("              ) FROM_EML " ).append("\n"); 
		query.append("     , (SELECT GLOBAL_NAME FROM GLOBAL_NAME) GLOBAL_NAME" ).append("\n"); 
		query.append("     , COD.RGN_CD" ).append("\n"); 
		query.append("  FROM COM_USER USR" ).append("\n"); 
		query.append("      ,BKG_COD COD" ).append("\n"); 
		query.append("WHERE UPPER(USR.USR_ID) = UPPER(@[usr_id])" ).append("\n"); 
		query.append("   AND COD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND COD.COD_RQST_SEQ = @[cod_rqst_seq]" ).append("\n"); 

	}
}