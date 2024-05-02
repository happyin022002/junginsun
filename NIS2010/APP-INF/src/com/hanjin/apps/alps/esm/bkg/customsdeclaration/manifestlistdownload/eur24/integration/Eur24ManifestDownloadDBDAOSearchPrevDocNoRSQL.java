/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : Eur24ManifestDownloadDBDAOSearchPrevDocNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.08
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.10.08 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24ManifestDownloadDBDAOSearchPrevDocNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Prev.Doc 과 Subplace 를 조회한다.
	  * </pre>
	  */
	public Eur24ManifestDownloadDBDAOSearchPrevDocNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.integration").append("\n"); 
		query.append("FileName : Eur24ManifestDownloadDBDAOSearchPrevDocNoRSQL").append("\n"); 
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
		query.append("SELECT T1.*, DECODE(T1.PREV_DOC_NOS || T1.PRE_VSL_DCHG_YD_NM , T1.FIXED, 'Y', 'N') CHK" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT BL_NO, MF_NO, SUBSTR(MAX(MSG_FUNC_ID), 1,1) MSG_FUNC_ID, REF_GDS_ITM_NM, MAX(CRE_DT) CRE_DT, PRE_VSL_DCHG_YD_NM" ).append("\n"); 
		query.append("         , DECODE(CNT_CD, 'ES', MF_NO||REF_GDS_ITM_NM, 'PT', REF_GDS_ITM_NM, '') AS PREV_DOC_NOS" ).append("\n"); 
		query.append("         , (SELECT DECODE(CNT_CD, 'ES', MF_NO||REF_GDS_ITM_NM, 'PT', REF_GDS_ITM_NM, '') || PRE_VSL_DCHG_YD_NM" ).append("\n"); 
		query.append("             FROM BKG_CSTMS_EUR_CRN_RCV" ).append("\n"); 
		query.append("             WHERE 1=1" ).append("\n"); 
		query.append("#if (${cnt_cd} != '') " ).append("\n"); 
		query.append("			   AND CNT_CD = @[cnt_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			   AND MSG_FUNC_ID = 'F'" ).append("\n"); 
		query.append("               AND BL_NO = BB.BL_NO" ).append("\n"); 
		query.append("               AND ROWNUM = 1" ).append("\n"); 
		query.append("           ) AS FIXED " ).append("\n"); 
		query.append("     FROM BKG_CSTMS_EUR_CRN_RCV BB" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("#if (${cnt_cd} != '') " ).append("\n"); 
		query.append("      AND CNT_CD = @[cnt_cd] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      AND BL_NO = @[bl_no] " ).append("\n"); 
		query.append("      AND MSG_FUNC_ID <> 'F'" ).append("\n"); 
		query.append("      GROUP BY BL_NO,MF_NO,REF_GDS_ITM_NM, PRE_VSL_DCHG_YD_NM,DECODE(CNT_CD, 'ES', MF_NO||REF_GDS_ITM_NM, 'PT', REF_GDS_ITM_NM, '')" ).append("\n"); 
		query.append(") T1" ).append("\n"); 
		query.append("ORDER BY CRE_DT DESC" ).append("\n"); 

	}
}