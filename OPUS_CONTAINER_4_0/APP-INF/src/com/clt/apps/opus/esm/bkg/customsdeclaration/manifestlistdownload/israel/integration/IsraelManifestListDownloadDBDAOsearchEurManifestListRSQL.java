/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : IsraelManifestListDownloadDBDAOsearchEurManifestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2016.02.12 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelManifestListDownloadDBDAOsearchEurManifestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 이스라엘 manifest 목록을 조회
	  * </pre>
	  */
	public IsraelManifestListDownloadDBDAOsearchEurManifestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.integration").append("\n"); 
		query.append("FileName : IsraelManifestListDownloadDBDAOsearchEurManifestListRSQL").append("\n"); 
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
		query.append("SELECT T2.*" ).append("\n"); 
		query.append("      ,NVL2(SND_DT,DECODE(SUBSTR(T2.RCV,1,1), null ,'Not Received','A','Accepted'||CHR(10)||'('||SUBSTR(T2.RCV,2,20)||')','R','Rejected'||CHR(10)||'('||SUBSTR(T2.RCV,2,20)||')')" ).append("\n"); 
		query.append("      ,DECODE(SUBSTR(T2.RCV,1,1), null ,'','A','Accepted'||CHR(10)||'('||SUBSTR(T2.RCV,2,20)||')','R','Rejected'||CHR(10)||'('||SUBSTR(T2.RCV,2,20)||')')) AS RCV_TIME" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(SELECT T1.*" ).append("\n"); 
		query.append("       ,NVL2(T1.SND_DT,'Sent'||CHR(10)||'('||TO_CHAR(SND_DT,'YYYY-MM-DD HH24:MI')||')','Initial') AS SND_TIME" ).append("\n"); 
		query.append("     ,(SELECT EUR_ACK_RCV_STS_CD||CHR(10)||'('||TO_CHAR(ACK_DT,'YYYY-MM-DD HH24:MI')||')'" ).append("\n"); 
		query.append("       FROM BKG_CSTMS_EUR_IB_RCV" ).append("\n"); 
		query.append("       WHERE MSG_RCV_NO = T1.SND) RCV" ).append("\n"); 
		query.append("     , CASE WHEN SH_NM IS NULL " ).append("\n"); 
		query.append("              OR SH_AD IS NULL " ).append("\n"); 
		query.append("              OR CNEE_NM IS NULL " ).append("\n"); 
		query.append("              OR CNEE_AD IS NULL " ).append("\n"); 
		query.append("              OR NTFY_NM IS NULL " ).append("\n"); 
		query.append("              OR NTFY_AD IS NULL" ).append("\n"); 
		query.append("            THEN 'Y'" ).append("\n"); 
		query.append("            ELSE 'N'" ).append("\n"); 
		query.append("       END AS ERR_YN " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("FROM ( SELECT" ).append("\n"); 
		query.append("        BB.BL_NO" ).append("\n"); 
		query.append("       , DENSE_RANK() OVER (ORDER BY BV.POD_CD, BB.BL_NO) AS DT_SEQ" ).append("\n"); 
		query.append("       , BC.CNTR_NO" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("       , BB.BKG_CGO_TP_CD" ).append("\n"); 
		query.append("       , BV.POL_CD" ).append("\n"); 
		query.append("       , BV.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("       , BB.POL_CD AS B_POL_CD" ).append("\n"); 
		query.append("       , BB.POD_CD AS B_POD_CD" ).append("\n"); 
		query.append("       , BB.DEL_CD AS DEL_CD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       , NVL(TO_CHAR(SKD2.VPS_ETA_DT,'YYYY-MM-DD HH24:MI'),' ') AS IL_ETA" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       , BC.PCK_QTY" ).append("\n"); 
		query.append("       , BC.PCK_TP_CD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       , REPLACE(SHPR.CUST_NM, CHR(13)||CHR(10), ' ')      AS SH_NM" ).append("\n"); 
		query.append("       , REPLACE(SHPR.CUST_ADDR, CHR(13)||CHR(10), ' ')    AS SH_AD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       , REPLACE(CNEE.CUST_NM, CHR(13)||CHR(10), ' ')      AS CNEE_NM" ).append("\n"); 
		query.append("       , REPLACE(CNEE.CUST_ADDR, CHR(13)||CHR(10), ' ')    AS CNEE_AD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       , REPLACE(NTFY.CUST_NM, CHR(13)||CHR(10), ' ')      AS NTFY_NM" ).append("\n"); 
		query.append("       , REPLACE(NTFY.CUST_ADDR, CHR(13)||CHR(10), ' ')    AS NTFY_AD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       , BB.BKG_NO" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       , NVL(B.CALL_SGN_NO, '')     AS VSL_CALLSIGN" ).append("\n"); 
		query.append("       , NVL(B.LLOYD_NO, '')        AS VSL_LLOYDCODE" ).append("\n"); 
		query.append("       , NVL(B.VSL_ENG_NM, '')      AS VSL_FULLNAME" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       , NVL(TO_CHAR(SKD1.VPS_ETA_DT,'YYYY-MM-DD HH24:MI'),' ') AS ETA" ).append("\n"); 
		query.append("       , NVL(TO_CHAR(SKD1.VPS_ETD_DT,'YYYY-MM-DD HH24:MI'),' ') AS ETD" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       , SKD1.SLAN_CD" ).append("\n"); 
		query.append("       , BB.CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("       ,(SELECT SND_DT" ).append("\n"); 
		query.append("         FROM(SELECT *" ).append("\n"); 
		query.append("              FROM BKG_CSTMS_EUR_IB_SND" ).append("\n"); 
		query.append("              ORDER BY SND_GDT DESC)" ).append("\n"); 
		query.append("         WHERE BL_NO = BB.BL_NO" ).append("\n"); 
		query.append("         AND ROWNUM=1" ).append("\n"); 
		query.append("          ) AS SND_DT" ).append("\n"); 
		query.append("       ,(SELECT MAX(MSG_SND_NO)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_EUR_IB_SND " ).append("\n"); 
		query.append("          WHERE BB.BL_NO = BL_NO" ).append("\n"); 
		query.append("          ) SND" ).append("\n"); 
		query.append("    FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("        , BKG_VVD BV" ).append("\n"); 
		query.append("        , BKG_CUSTOMER SHPR" ).append("\n"); 
		query.append("        , BKG_CUSTOMER CNEE" ).append("\n"); 
		query.append("        , BKG_CUSTOMER NTFY" ).append("\n"); 
		query.append("        , VSK_VSL_PORT_SKD SKD1" ).append("\n"); 
		query.append("        , VSK_VSL_PORT_SKD SKD2" ).append("\n"); 
		query.append("        , VSK_VSL_PORT_SKD SKD3" ).append("\n"); 
		query.append("        , MDM_VSL_CNTR B" ).append("\n"); 
		query.append("        , BKG_CONTAINER BC " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    WHERE BB.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("    AND BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND BB.BKG_NO = SHPR.BKG_NO (+)" ).append("\n"); 
		query.append("    AND SHPR.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("    AND BB.BKG_NO = CNEE.BKG_NO (+)" ).append("\n"); 
		query.append("    AND CNEE.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("    AND BB.BKG_NO = NTFY.BKG_NO (+)" ).append("\n"); 
		query.append("    AND NTFY.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND SKD1.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("    AND SKD1.VSL_CD        =  BV.VSL_CD" ).append("\n"); 
		query.append("    AND SKD1.SKD_VOY_NO    =  BV.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND SKD1.SKD_DIR_CD    =  BV.SKD_DIR_CD " ).append("\n"); 
		query.append("    AND SKD1.VPS_PORT_CD   =  BV.POL_CD" ).append("\n"); 
		query.append("    AND NVL(SKD1.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("    AND SKD1.CLPT_IND_SEQ = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND SKD2.VSL_CD        = BV.VSL_CD" ).append("\n"); 
		query.append("    AND SKD2.SKD_VOY_NO    = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND SKD2.SKD_DIR_CD    = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND SKD2.CLPT_IND_SEQ  = 1" ).append("\n"); 
		query.append("    AND SKD2.VPS_PORT_CD LIKE 'IL%'" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("    AND SKD1.CLPT_SEQ < SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND BV.VSL_CD         = SKD3.VSL_CD" ).append("\n"); 
		query.append("    AND BV.SKD_VOY_NO     = SKD3.SKD_VOY_NO" ).append("\n"); 
		query.append("    AND BV.SKD_DIR_CD     = SKD3.SKD_DIR_CD" ).append("\n"); 
		query.append("    AND BV.POD_CD         = SKD3.VPS_PORT_CD" ).append("\n"); 
		query.append("    AND BV.POD_CLPT_IND_SEQ = SKD3.CLPT_IND_SEQ" ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("    AND SKD2.CLPT_SEQ  < SKD3.CLPT_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    AND BV.VSL_CD		= SUBSTR(@[vvd_cd], 1, 4)   " ).append("\n"); 
		query.append("    AND BV.SKD_VOY_NO	= SUBSTR(@[vvd_cd], 5, 4)   " ).append("\n"); 
		query.append("    AND BV.SKD_DIR_CD	= SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${pol_cd} != '') " ).append("\n"); 
		query.append("	AND SKD1.VPS_PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("    #if (${pod_cd} != '') " ).append("\n"); 
		query.append("    AND BV.POD_CD		= @[pod_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${bl_no} != '') " ).append("\n"); 
		query.append("    AND BB.BL_NO		= @[bl_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    AND BB.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    ) T1" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("ORDER BY DT_SEQ" ).append("\n"); 
		query.append(")T2" ).append("\n"); 

	}
}