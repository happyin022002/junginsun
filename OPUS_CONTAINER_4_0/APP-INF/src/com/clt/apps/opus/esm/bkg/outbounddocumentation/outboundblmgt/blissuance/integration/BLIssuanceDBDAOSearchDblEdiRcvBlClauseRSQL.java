/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchDblEdiRcvBlClauseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.29
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchDblEdiRcvBlClauseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOSearchDblEdiRcvBlClause
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchDblEdiRcvBlClauseRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchDblEdiRcvBlClauseRSQL").append("\n"); 
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
		query.append("SELECT 'BL_CLAUSE:' || D_MARKS AS BL_CLAUSE" ).append("\n"); 
		query.append("                                  FROM " ).append("\n"); 
		query.append("                                  (" ).append("\n"); 
		query.append("                                        SELECT BKG_NO, LV, ROW_LV, SUBSTR(MARKS, LV, 90) AS D_MARKS -- 1 라인에 90자씩 짜름 LEVEL 단위로 자른다." ).append("\n"); 
		query.append("                                        FROM " ).append("\n"); 
		query.append("                                        (" ).append("\n"); 
		query.append("                                            SELECT DISTINCT BKG_NO, LEVEL AS ROW_LV, REGEXP_SUBSTR(MARKS, '[^♣$]+', 1, LEVEL ) AS MARKS -- ♣ 문자 기준으로 잘라 행을 분리시킨다." ).append("\n"); 
		query.append("                                            FROM " ).append("\n"); 
		query.append("                                            (" ).append("\n"); 
		query.append("                                                SELECT BKG_NO,REGEXP_REPLACE(REPLACE(REPLACE(REPLACE(MARKS, CHR(13)||CHR(10), CHR(13)), CHR(10), CHR(13)), CHR(13), '♣'), '[[:space:]]+$', '') AS MARKS" ).append("\n"); 
		query.append("                                                FROM (" ).append("\n"); 
		query.append("                                                    SELECT RTRIM(NVL(MARK.OBL_ISS_RMK,''), CHR(13)||CHR(10))  AS MARKS -- 맨 끝자리를 CARRIAGE RETURN" ).append("\n"); 
		query.append("                                                            ,DOC.BKG_NO" ).append("\n"); 
		query.append("                                                    FROM BKG_BL_ISS MARK" ).append("\n"); 
		query.append("                                                        ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("                                                    WHERE 1=1" ).append("\n"); 
		query.append("                                                    AND DOC.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                                                    AND DOC.BKG_NO = MARK.BKG_NO(+))" ).append("\n"); 
		query.append("                                            )" ).append("\n"); 
		query.append("                                            CONNECT BY REGEXP_SUBSTR(MARKS, '[^♣$]+', 1, LEVEL ) IS NOT NULL" ).append("\n"); 
		query.append("                                            ORDER BY BKG_NO, LEVEL" ).append("\n"); 
		query.append("                                        ) " ).append("\n"); 
		query.append("                                        ,(SELECT LEVEL LV FROM DUAL CONNECT BY LEVEL < = 4000)      -- 컬럼 사이즈가 4000 BYTE" ).append("\n"); 
		query.append("                                  ) A" ).append("\n"); 
		query.append("                                  WHERE LV = FLOOR(LV/90)*90 + 1  -- 1 라인에 90자씩 짜름" ).append("\n"); 
		query.append("                                  AND D_MARKS IS NOT NULL" ).append("\n"); 

	}
}