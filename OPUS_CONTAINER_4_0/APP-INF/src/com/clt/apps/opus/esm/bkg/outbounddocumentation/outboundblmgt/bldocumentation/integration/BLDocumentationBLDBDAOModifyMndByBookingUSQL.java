/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOModifyMndByBookingUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.12.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.12.20 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOModifyMndByBookingUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyMndByBooking
	  * </pre>
	  */
	public BLDocumentationBLDBDAOModifyMndByBookingUSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOModifyMndByBookingUSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_BL_MK_DESC_HIS" ).append("\n"); 
		query.append("SET CMDT_DESC = (" ).append("\n"); 
		query.append("                SELECT LISTAGG(D_MARKS_2, CHR(13)||CHR(10)) WITHIN GROUP (ORDER BY BKG_NO, LV_1, LV_2) AS MARKS_NEW" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                     SELECT BKG_NO" ).append("\n"); 
		query.append("                            , LV_1, LV AS LV_2, MARKS_ORG, D_MARKS, D_MARKS_LEN" ).append("\n"); 
		query.append("                            , CASE WHEN D_MARKS_LEN <= 33 AND LV = 1 THEN D_MARKS" ).append("\n"); 
		query.append("                                   ELSE SUBSTR(D_MARKS, ((LV-1)*33)+1, 33) END D_MARKS_2" ).append("\n"); 
		query.append("                     FROM (" ).append("\n"); 
		query.append("                          SELECT BKG_NO, LV AS LV_1,MARKS_ORG" ).append("\n"); 
		query.append("                                 , REGEXP_SUBSTR(MARKS, '[^'||CHR(8)||']+', 1, LV ) AS D_MARKS" ).append("\n"); 
		query.append("                                 , LENGTH(REGEXP_SUBSTR(MARKS, '[^'||CHR(8)||']+', 1, LV )) AS D_MARKS_LEN" ).append("\n"); 
		query.append("                          FROM " ).append("\n"); 
		query.append("                          (" ).append("\n"); 
		query.append("                              SELECT BKG_NO" ).append("\n"); 
		query.append("                                     , MARKS AS MARKS_ORG" ).append("\n"); 
		query.append("                                     , MARKS" ).append("\n"); 
		query.append("                                     , LENGTH(MARKS) - LENGTH(REPLACE(MARKS, CHR(8),'')) +1 AS COPY_CNT -- REMARK에 포함된 줄바꿈의 개수" ).append("\n"); 
		query.append("                              FROM" ).append("\n"); 
		query.append("                              (" ).append("\n"); 
		query.append("                                  SELECT /*+ NO_MERGE */" ).append("\n"); 
		query.append("                                       BKG_NO" ).append("\n"); 
		query.append("                                       , MARKS AS MARKS_ORG" ).append("\n"); 
		query.append("                                       , REPLACE(REPLACE(REPLACE(MARKS, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(8)) AS MARKS" ).append("\n"); 
		query.append("                                  FROM (" ).append("\n"); 
		query.append("                                          SELECT /*+ NO_MERGE */" ).append("\n"); 
		query.append("                                                 RTRIM(NVL(UPPER(MARK.CMDT_DESC),''), CHR(13)||CHR(10)) MARKS -- 맨 끝자리를 CARRIAGE RETURN" ).append("\n"); 
		query.append("                                                          ,DOC.BKG_NO" ).append("\n"); 
		query.append("                                          FROM BKG_BL_MK_DESC_HIS MARK" ).append("\n"); 
		query.append("                                               ,BKG_BL_DOC_HIS DOC" ).append("\n"); 
		query.append("                                          WHERE 1=1" ).append("\n"); 
		query.append("                                          AND DOC.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("                                          AND DOC.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                                          AND DOC.BKG_NO = MARK.BKG_NO(+)" ).append("\n"); 
		query.append("                                          AND DOC.CORR_NO = MARK.CORR_NO(+)" ).append("\n"); 
		query.append("                                          AND ROWNUM > 0" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                          ) " ).append("\n"); 
		query.append("                          ,(SELECT LEVEL LV FROM DUAL CONNECT BY LEVEL < = 1000)" ).append("\n"); 
		query.append("                            WHERE LV <= COPY_CNT " ).append("\n"); 
		query.append("                            AND   ROWNUM > 0" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                          ,(SELECT LEVEL LV FROM DUAL CONNECT BY LEVEL < = 100)" ).append("\n"); 
		query.append("                            WHERE LV <= (TRUNC(D_MARKS_LEN / 33)  + 1)" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                     GROUP BY BKG_NO" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND  CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_BL_MK_DESC" ).append("\n"); 
		query.append("SET CMDT_DESC = (" ).append("\n"); 
		query.append("                SELECT LISTAGG(D_MARKS_2, CHR(13)||CHR(10)) WITHIN GROUP (ORDER BY BKG_NO, LV_1, LV_2) AS MARKS_NEW" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                     SELECT BKG_NO" ).append("\n"); 
		query.append("                            , LV_1, LV AS LV_2, MARKS_ORG, D_MARKS, D_MARKS_LEN" ).append("\n"); 
		query.append("                            , CASE WHEN D_MARKS_LEN <= 33 AND LV = 1 THEN D_MARKS" ).append("\n"); 
		query.append("                                   ELSE SUBSTR(D_MARKS, ((LV-1)*33)+1, 33) END D_MARKS_2" ).append("\n"); 
		query.append("                     FROM (" ).append("\n"); 
		query.append("                          SELECT BKG_NO, LV AS LV_1,MARKS_ORG" ).append("\n"); 
		query.append("                                 , REGEXP_SUBSTR(MARKS, '[^'||CHR(8)||']+', 1, LV ) AS D_MARKS" ).append("\n"); 
		query.append("                                 , LENGTH(REGEXP_SUBSTR(MARKS, '[^'||CHR(8)||']+', 1, LV )) AS D_MARKS_LEN" ).append("\n"); 
		query.append("                          FROM " ).append("\n"); 
		query.append("                          (" ).append("\n"); 
		query.append("                              SELECT BKG_NO" ).append("\n"); 
		query.append("                                     , MARKS AS MARKS_ORG" ).append("\n"); 
		query.append("                                     , MARKS" ).append("\n"); 
		query.append("                                     , LENGTH(MARKS) - LENGTH(REPLACE(MARKS, CHR(8),'')) +1 AS COPY_CNT -- REMARK에 포함된 줄바꿈의 개수" ).append("\n"); 
		query.append("                              FROM" ).append("\n"); 
		query.append("                              (" ).append("\n"); 
		query.append("                                  SELECT /*+ NO_MERGE */" ).append("\n"); 
		query.append("                                       BKG_NO" ).append("\n"); 
		query.append("                                       , MARKS AS MARKS_ORG" ).append("\n"); 
		query.append("                                       , REPLACE(REPLACE(REPLACE(MARKS, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), CHR(8)) AS MARKS" ).append("\n"); 
		query.append("                                  FROM (" ).append("\n"); 
		query.append("                                          SELECT /*+ NO_MERGE */" ).append("\n"); 
		query.append("                                                 RTRIM(NVL(UPPER(MARK.CMDT_DESC),''), CHR(13)||CHR(10)) MARKS -- 맨 끝자리를 CARRIAGE RETURN" ).append("\n"); 
		query.append("                                                          ,DOC.BKG_NO" ).append("\n"); 
		query.append("                                          FROM BKG_BL_MK_DESC MARK" ).append("\n"); 
		query.append("                                               ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("                                          WHERE 1=1" ).append("\n"); 
		query.append("                                          AND DOC.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("                                          AND DOC.BKG_NO = MARK.BKG_NO(+)" ).append("\n"); 
		query.append("                                          AND ROWNUM > 0" ).append("\n"); 
		query.append("                                      )" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("                          ) " ).append("\n"); 
		query.append("                          ,(SELECT LEVEL LV FROM DUAL CONNECT BY LEVEL < = 1000)" ).append("\n"); 
		query.append("                            WHERE LV <= COPY_CNT " ).append("\n"); 
		query.append("                            AND   ROWNUM > 0" ).append("\n"); 
		query.append("                          )" ).append("\n"); 
		query.append("                          ,(SELECT LEVEL LV FROM DUAL CONNECT BY LEVEL < = 100)" ).append("\n"); 
		query.append("                            WHERE LV <= (TRUNC(D_MARKS_LEN / 33)  + 1)" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                     GROUP BY BKG_NO" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}