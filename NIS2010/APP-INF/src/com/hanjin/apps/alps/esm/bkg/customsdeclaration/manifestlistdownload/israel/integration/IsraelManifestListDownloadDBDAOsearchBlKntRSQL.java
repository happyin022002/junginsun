/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : IsraelManifestListDownloadDBDAOsearchBlKntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.israel.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IsraelManifestListDownloadDBDAOsearchBlKntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TS type 별 BL count 구하기
	  * </pre>
	  */
	public IsraelManifestListDownloadDBDAOsearchBlKntRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.israel.integration").append("\n"); 
		query.append("FileName : IsraelManifestListDownloadDBDAOsearchBlKntRSQL").append("\n"); 
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
		query.append("SELECT SUM(DECODE(SUM_LOCAL,0,0,1)) LOCL_BL" ).append("\n"); 
		query.append("     , SUM(DECODE(SUM_TS,0,0,1)) TS_BL" ).append("\n"); 
		query.append("     , COUNT(*) TTL_BL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("     SELECT DT_SEQ" ).append("\n"); 
		query.append("          , SUM(LOCAL_CNT) SUM_LOCAL" ).append("\n"); 
		query.append("          , SUM(TS_CNT) SUM_TS" ).append("\n"); 
		query.append("     FROM (" ).append("\n"); 
		query.append("           SELECT DENSE_RANK() OVER (ORDER BY BV.POD_CD, BB.BL_NO) AS DT_SEQ" ).append("\n"); 
		query.append("                , DECODE(BB.POL_CD, BV.POL_CD, 1, 0)  AS LOCAL_CNT" ).append("\n"); 
		query.append("                , DECODE(BB.POL_CD, BV.POL_CD, 0, 1) AS TS_CNT" ).append("\n"); 
		query.append("           FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("                , BKG_VVD BV" ).append("\n"); 
		query.append("                , BKG_CUSTOMER SHPR" ).append("\n"); 
		query.append("                , BKG_CUSTOMER CNEE" ).append("\n"); 
		query.append("                , BKG_CUSTOMER NTFY" ).append("\n"); 
		query.append("                , VSK_VSL_PORT_SKD SKD1" ).append("\n"); 
		query.append("                , VSK_VSL_PORT_SKD SKD2" ).append("\n"); 
		query.append("                , VSK_VSL_PORT_SKD SKD3" ).append("\n"); 
		query.append("                , MDM_VSL_CNTR B" ).append("\n"); 
		query.append("                , BKG_CONTAINER BC " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            WHERE BB.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("            AND BB.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            AND BB.BKG_NO = SHPR.BKG_NO (+)" ).append("\n"); 
		query.append("            AND SHPR.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("            AND BB.BKG_NO = CNEE.BKG_NO (+)" ).append("\n"); 
		query.append("            AND CNEE.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("            AND BB.BKG_NO = NTFY.BKG_NO (+)" ).append("\n"); 
		query.append("            AND NTFY.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            AND SKD1.VSL_CD        = B.VSL_CD" ).append("\n"); 
		query.append("            AND SKD1.VSL_CD        =  BV.VSL_CD" ).append("\n"); 
		query.append("            AND SKD1.SKD_VOY_NO    =  BV.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND SKD1.SKD_DIR_CD    =  BV.SKD_DIR_CD " ).append("\n"); 
		query.append("            AND SKD1.VPS_PORT_CD   =  BV.POL_CD" ).append("\n"); 
		query.append("            AND NVL(SKD1.SKD_CNG_STS_CD, ' ')    <> 'S'" ).append("\n"); 
		query.append("            AND SKD1.CLPT_IND_SEQ = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("            AND SKD2.VSL_CD        = BV.VSL_CD" ).append("\n"); 
		query.append("            AND SKD2.SKD_VOY_NO    = BV.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND SKD2.SKD_DIR_CD    = BV.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND SKD2.CLPT_IND_SEQ  = 1" ).append("\n"); 
		query.append("            AND SKD2.VPS_PORT_CD LIKE 'IL%'" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("            AND SKD1.CLPT_SEQ < SKD2.CLPT_SEQ" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            AND BV.VSL_CD         = SKD3.VSL_CD" ).append("\n"); 
		query.append("            AND BV.SKD_VOY_NO     = SKD3.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND BV.SKD_DIR_CD     = SKD3.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND BV.POD_CD         = SKD3.VPS_PORT_CD" ).append("\n"); 
		query.append("            AND BV.POD_CLPT_IND_SEQ = SKD3.CLPT_IND_SEQ" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("            AND SKD2.CLPT_SEQ  < SKD3.CLPT_SEQ" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            AND BV.VSL_CD		= SUBSTR(@[vvd_cd], 1, 4)   " ).append("\n"); 
		query.append("            AND BV.SKD_VOY_NO	= SUBSTR(@[vvd_cd], 5, 4)   " ).append("\n"); 
		query.append("            AND BV.SKD_DIR_CD	= SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("            #if (${pol_cd} != '') " ).append("\n"); 
		query.append("            AND SKD1.VPS_PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("            #if (${pod_cd} != '') " ).append("\n"); 
		query.append("            AND BV.POD_CD		= @[pod_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            #if (${bl_no} != '') " ).append("\n"); 
		query.append("            AND BB.BL_NO		= @[bl_no]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("            AND BB.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("			AND BB.BKG_CGO_TP_CD NOT IN ('P')" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("     GROUP BY DT_SEQ" ).append("\n"); 
		query.append("     ORDER BY DT_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}