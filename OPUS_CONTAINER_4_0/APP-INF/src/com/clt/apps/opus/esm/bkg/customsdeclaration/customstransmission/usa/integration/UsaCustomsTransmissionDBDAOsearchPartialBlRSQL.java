/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchPartialBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchPartialBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신 outVO : None, 연관VO: UsaPartialBlVO
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchPartialBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("in_cntr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchPartialBlRSQL").append("\n"); 
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
		query.append("#if (${ibflag} != 'CNTR') " ).append("\n"); 
		query.append("	SELECT DISTINCT" ).append("\n"); 
		query.append("		   PBL.BL_NO         AS LCL_BL_NBR_A " ).append("\n"); 
		query.append("	      ,CR.CSTMS_CLR_CD   AS LCL_CUSTC_IND_A" ).append("\n"); 
		query.append("	      ,'' AS J_COUNT" ).append("\n"); 
		query.append("	      ,'' AS Y_COUNT" ).append("\n"); 
		query.append("	  FROM BKG_CSTMS_ADV_BL   OBL" ).append("\n"); 
		query.append("	      ,BKG_CSTMS_ADV_CNTR OCNTR" ).append("\n"); 
		query.append("	      ,BKG_CSTMS_ADV_BL   PBL" ).append("\n"); 
		query.append("	      ,BKG_CSTMS_ADV_CNTR PCNTR" ).append("\n"); 
		query.append("	      ,BKG_CGO_RLSE       CR" ).append("\n"); 
		query.append("	 WHERE OBL.CNT_CD        = 'US' " ).append("\n"); 
		query.append("	   AND OBL.BL_NO         = @[bl_no]" ).append("\n"); 
		query.append("	   AND OBL.MF_STS_CD     = 'A'" ).append("\n"); 
		query.append("	   AND OBL.CNT_CD        = OCNTR.CNT_CD" ).append("\n"); 
		query.append("	   AND OBL.BL_NO         = OCNTR.BL_NO" ).append("\n"); 
		query.append("	   AND PBL.CNT_CD        = PCNTR.CNT_CD" ).append("\n"); 
		query.append("	   AND PBL.BL_NO         = PCNTR.BL_NO" ).append("\n"); 
		query.append("	   AND PCNTR.CNT_CD      = OCNTR.CNT_CD" ).append("\n"); 
		query.append("	   AND PCNTR.CNTR_NO     = OCNTR.CNTR_NO" ).append("\n"); 
		query.append("	   AND PBL.VSL_CD        = OBL.VSL_CD" ).append("\n"); 
		query.append("	   AND PBL.SKD_VOY_NO    = OBL.SKD_VOY_NO" ).append("\n"); 
		query.append("	   AND PBL.SKD_DIR_CD    = OBL.SKD_DIR_CD" ).append("\n"); 
		query.append("	   AND PBL.MF_STS_CD     = 'A'" ).append("\n"); 
		query.append("	   AND PBL.MF_NO IS NULL" ).append("\n"); 
		query.append("	   AND PBL.BL_NO         = CR.BL_NO(+)" ).append("\n"); 
		query.append("	   AND PBL.BL_NO         <> OBL.BL_NO" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("    SELECT TB.BL_NO         AS LCL_BL_NBR_A" ).append("\n"); 
		query.append("          ,TB.CSTMS_CLR_CD  AS LCL_CUSTC_IND_A" ).append("\n"); 
		query.append("      FROM (" ).append("\n"); 
		query.append("            SELECT TB.BL_NO" ).append("\n"); 
		query.append("                  ,NVL(RS.CSTMS_CLR_CD,'N') AS CSTMS_CLR_CD" ).append("\n"); 
		query.append("                  ,ROW_NUMBER() OVER(PARTITION BY TB.BL_NO, TB.CNTR_NO ORDER BY RS.CSTMS_SEQ DESC) AS RNUM" ).append("\n"); 
		query.append("                  , (SELECT C.CSTMS_CLR_CD" ).append("\n"); 
		query.append("                        FROM BKG_CSTMS_ADV_CNTR B, BKG_CSTMS_ADV_CNTR_RSLT C" ).append("\n"); 
		query.append("                          WHERE B.CNT_CD= 'US'" ).append("\n"); 
		query.append("                          AND B.BL_NO =  TB.BL_NO" ).append("\n"); 
		query.append("                          AND B.CNTR_NO <> TB.CNTR_NO" ).append("\n"); 
		query.append("                          AND B.CNT_CD= C.CNT_cD(+)" ).append("\n"); 
		query.append("                          AND B.BL_NO = C.BL_NO(+)" ).append("\n"); 
		query.append("                          AND B.CNTR_NO LIKE TRIM(C.CNTR_NO(+))||'%'" ).append("\n"); 
		query.append("                            AND ( C.CSTMS_SEQ IS NULL" ).append("\n"); 
		query.append("                                  OR C.CSTMS_SEQ = (" ).append("\n"); 
		query.append("                                                    SELECT MAX( CSTMS_SEQ )" ).append("\n"); 
		query.append("                                                    FROM BKG_CSTMS_ADV_CNTR_RSLT" ).append("\n"); 
		query.append("                                                    WHERE BL_NO = C.BL_NO" ).append("\n"); 
		query.append("                                                      AND CNT_CD = C.CNT_CD" ).append("\n"); 
		query.append("                                                      AND CNTR_NO = C.CNTR_NO" ).append("\n"); 
		query.append("                                                      )" ).append("\n"); 
		query.append("                                )" ).append("\n"); 
		query.append("                          AND NVL(C.CSTMS_CLR_CD,'N') <> 'Y'" ).append("\n"); 
		query.append("                          AND ROWNUM=1" ).append("\n"); 
		query.append("                        )    OTH_CNTR_CFLG  -- Partial B/L 중에 C-flag ='N' 이 존재하는 경우에는 해당 bl은 처리제외." ).append("\n"); 
		query.append("              FROM (" ).append("\n"); 
		query.append("        			SELECT DISTINCT" ).append("\n"); 
		query.append("        				   PCNTR.CNT_CD" ).append("\n"); 
		query.append("        				  ,PCNTR.BL_NO" ).append("\n"); 
		query.append("        				  ,PCNTR.CNTR_NO" ).append("\n"); 
		query.append("        			  FROM BKG_CSTMS_ADV_BL   OBL" ).append("\n"); 
		query.append("        			      ,BKG_CSTMS_ADV_CNTR OCNTR" ).append("\n"); 
		query.append("        			      ,BKG_CSTMS_ADV_BL   PBL" ).append("\n"); 
		query.append("        			      ,BKG_CSTMS_ADV_CNTR PCNTR" ).append("\n"); 
		query.append("        			 WHERE OBL.CNT_CD        = 'US' " ).append("\n"); 
		query.append("        			   AND OCNTR.BL_NO       = @[bl_no]" ).append("\n"); 
		query.append("        			   AND OCNTR.CNTR_NO     LIKE TRIM(@[in_cntr])||'%'" ).append("\n"); 
		query.append("        			   AND OBL.MF_STS_CD     = 'A'" ).append("\n"); 
		query.append("        			   AND OBL.CNT_CD        = OCNTR.CNT_CD" ).append("\n"); 
		query.append("        			   AND OBL.BL_NO         = OCNTR.BL_NO" ).append("\n"); 
		query.append("        			   AND PBL.CNT_CD        = PCNTR.CNT_CD" ).append("\n"); 
		query.append("        			   AND PBL.BL_NO         = PCNTR.BL_NO" ).append("\n"); 
		query.append("        			   AND PCNTR.CNT_CD      = OCNTR.CNT_CD" ).append("\n"); 
		query.append("        			   AND PCNTR.CNTR_NO     = OCNTR.CNTR_NO" ).append("\n"); 
		query.append("        			   AND PBL.VSL_CD        = OBL.VSL_CD" ).append("\n"); 
		query.append("        			   AND PBL.SKD_VOY_NO    = OBL.SKD_VOY_NO" ).append("\n"); 
		query.append("        			   AND PBL.SKD_DIR_CD    = OBL.SKD_DIR_CD" ).append("\n"); 
		query.append("        			   AND PBL.MF_STS_CD     = 'A'" ).append("\n"); 
		query.append("        			   AND PBL.MF_NO IS NULL" ).append("\n"); 
		query.append("        			   AND PBL.BL_NO         <> OBL.BL_NO" ).append("\n"); 
		query.append("                   ) TB" ).append("\n"); 
		query.append("                  ,BKG_CSTMS_ADV_CNTR_RSLT RS" ).append("\n"); 
		query.append("             WHERE TB.CNT_CD = RS.CNT_CD(+)" ).append("\n"); 
		query.append("               AND TB.BL_NO  = RS.BL_NO(+)" ).append("\n"); 
		query.append("               AND TB.CNTR_NO LIKE TRIM(RS.CNTR_NO(+)) || '%'" ).append("\n"); 
		query.append("           ) TB" ).append("\n"); 
		query.append("     WHERE TB.RNUM = 1" ).append("\n"); 
		query.append("     AND NVL(OTH_CNTR_CFLG,'X') <>'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}