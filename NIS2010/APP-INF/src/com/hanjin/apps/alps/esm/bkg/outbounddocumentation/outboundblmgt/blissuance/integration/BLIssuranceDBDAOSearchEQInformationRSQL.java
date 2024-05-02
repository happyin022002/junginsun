/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BLIssuranceDBDAOSearchEQInformationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuranceDBDAOSearchEQInformationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Email (E/Q)를 위한 데이터 검색
	  * </pre>
	  */
	public BLIssuranceDBDAOSearchEQInformationRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuranceDBDAOSearchEQInformationRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("		(SELECT VSL_ENG_NM " ).append("\n"); 
		query.append("			FROM MDM_VSL_CNTR VSL" ).append("\n"); 
		query.append("     		WHERE DELT_FLG ='N'" ).append("\n"); 
		query.append("     		AND VSL.VSL_CD = BK.VSL_CD" ).append("\n"); 
		query.append("     		AND ROWNUM = 1 )||' '||BK.SKD_VOY_NO||BK.SKD_DIR_CD VVD_NM," ).append("\n"); 
		query.append("     	BK.BKG_NO BKG_NO," ).append("\n"); 
		query.append("		BK.POL_CD POL_CD," ).append("\n"); 
		query.append("		BK.POD_CD POD_CD," ).append("\n"); 
		query.append("		TO_CHAR(VVD.VPS_ETB_DT,'YYYY-MM-DD HH24:MI') ETB," ).append("\n"); 
		query.append("		TO_CHAR(VVD.VPS_ETD_DT,'YYYY-MM-DD HH24:MI') ETD," ).append("\n"); 
		query.append("		NVL(TO_CHAR((SELECT CASE WHEN 'KR' = (SELECT SUBSTR(POL_CD,1,2) FROM BKG_BOOKING WHERE BKG_NO =  @[bkg_no] ) THEN ETB -0.41667 " ).append("\n"); 
		query.append("													 ELSE CCT" ).append("\n"); 
		query.append("													 END CCT" ).append("\n"); 
		query.append("													 FROM (select PRD_GET_CCT_FNC(skd.pol_nod_cd, SKD.SLAN_CD, SKD.SLAN_DIR_CD, SKD.CGO_TP_CD, SKD.VPS_ETB_DT, SKD.VPS_ETD_DT, SKD.VSL_CD||SKD.SKD_VOY_NO||SKD.SKD_DIR_CD) CCT, SKD.VPS_ETB_DT ETB" ).append("\n"); 
		query.append("                                                     from (SELECT SKD.SLAN_CD SLAN_CD" ).append("\n"); 
		query.append("                                                                 , VVD.SKD_DIR_CD SLAN_DIR_CD" ).append("\n"); 
		query.append("                                                                 , CASE WHEN RC_FLG   = 'Y' THEN 'RF'" ).append("\n"); 
		query.append("                                                                        WHEN DCGO_FLG = 'Y' THEN 'DG'" ).append("\n"); 
		query.append("                                                                        WHEN DCGO_FLG = 'N' AND RC_FLG = 'N' AND AWK_CGO_FLG = 'N' AND BB_CGO_FLG = 'N' THEN 'DR'" ).append("\n"); 
		query.append("                                                                        ELSE 'AL' END CGO_TP_CD" ).append("\n"); 
		query.append("                                                                 , VPS_ETB_DT" ).append("\n"); 
		query.append("                                                                 , VPS_ETD_DT" ).append("\n"); 
		query.append("                                                                 , pol_nod_cd" ).append("\n"); 
		query.append("                                                                 , VVD.VSL_CD" ).append("\n"); 
		query.append("                                                                 , VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                 , VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                               FROM BKG_BOOKING BK, BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                                                              WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                                                                AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("                                                                AND VVD.VSL_PRE_PST_CD IN ('S', 'T')" ).append("\n"); 
		query.append("																AND VVD.VSL_CD	   NOT IN ('SMXX','SMYY','SMZZ')" ).append("\n"); 
		query.append("                                                                AND VVD.VSL_CD     = SKD.VSL_CD" ).append("\n"); 
		query.append("                                                                AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                AND VVD.POL_CD     = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                                                AND NVL(VVD.POL_CLPT_IND_SEQ, 1) = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                                AND BK.BKG_NO      = @[bkg_no]) skd)),'YYYY-MM-DD HH24:MM'),' ') CGO_CUT_OFF_TM," ).append("\n"); 
		query.append("		BKG_JOIN_FNC( CURSOR(SELECT CNTR_TPSZ_CD||'-'||ltrim(TO_CHAR(NVL(OP_CNTR_QTY, 0),'99990.99'))" ).append("\n"); 
		query.append("                                                                                                     FROM BKG_QUANTITY" ).append("\n"); 
		query.append("                                                                                                     WHERE BKG_NO = BK.BKG_NO                                                     " ).append("\n"); 
		query.append("                                                                                                     AND   CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                                                                     ORDER BY CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                   ) bkg_qty," ).append("\n"); 
		query.append("        BKG_JOIN_FNC( CURSOR(SELECT  CNTR_TPSZ_CD||'-'||ltrim(TO_CHAR(NVL(sum(CNTR_VOL_QTY), 0),'99990.99'))" ).append("\n"); 
		query.append("                                                                                                     FROM    BKG_CONTAINER" ).append("\n"); 
		query.append("                                                                                                     WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                                                                                                     AND   CNTR_TPSZ_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                                                                     GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append("                                                                                                     ORDER BY CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                   ) cntr_qty" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("	,(SELECT VVD.BKG_NO ,VVD.POL_CD, VVD.POL_CLPT_IND_SEQ, VVD.VSL_CD, VVD.SKD_VOY_NO, VVD.SKD_DIR_CD, VSK.VPS_ETB_DT VPS_ETB_DT ,VSK.VPS_ETD_DT VPS_ETD_DT, VSK.SLAN_CD SLAN_CD, VSK.YD_CD YD_CD" ).append("\n"); 
		query.append("        FROM BKG_VVD VVD" ).append("\n"); 
		query.append("            ,VSK_VSL_PORT_SKD VSK" ).append("\n"); 
		query.append("       WHERE 1=1" ).append("\n"); 
		query.append("         AND VVD.VSL_CD = VSK.VSL_CD" ).append("\n"); 
		query.append("         AND VVD.SKD_VOY_NO = VSK.SKD_VOY_NO" ).append("\n"); 
		query.append("         AND VVD.SKD_DIR_CD = VSK.SKD_DIR_CD" ).append("\n"); 
		query.append("         AND VVD.POL_CD = VSK.VPS_PORT_CD" ).append("\n"); 
		query.append("         AND VVD.POL_CLPT_IND_SEQ = VSK.CLPT_IND_SEQ" ).append("\n"); 
		query.append("         AND VVD.VSL_PRE_PST_CD||VVD.VSL_SEQ = ( SELECT MIN(VSL_PRE_PST_CD||VSL_SEQ) FROM BKG_VVD VVD2 WHERE VVD2.BKG_NO = VVD.BKG_NO)) VVD   " ).append("\n"); 
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD <>'X'" ).append("\n"); 
		query.append("AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 

	}
}