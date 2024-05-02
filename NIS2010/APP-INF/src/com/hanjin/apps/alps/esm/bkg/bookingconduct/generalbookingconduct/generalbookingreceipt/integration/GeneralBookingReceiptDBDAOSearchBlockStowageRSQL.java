/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBlockStowageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.05
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.05 
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

public class GeneralBookingReceiptDBDAOSearchBlockStowageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2017.11.20 iylee 로직 정리(PRD-Block Stowage Group Creation & Inquiry)
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBlockStowageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stwg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_trunk_vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBlockStowageRSQL").append("\n"); 
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
		query.append("SELECT AAA.BLCK_STWG_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT AA.BLCK_STWG_CD, ORD_FIRST, ORD, RNK" ).append("\n"); 
		query.append("             , RANK() OVER(ORDER BY AA.ORD_FIRST, AA.ORD, AA.RNK) RK_ORD" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("              -- 1. INLAND 구간이 존재 할 경우" ).append("\n"); 
		query.append("              SELECT A.BLCK_STWG_CD BLCK_STWG_CD" ).append("\n"); 
		query.append("                   , RANK() OVER(ORDER BY DECODE(A.STWG_CD, 'ALL', 2, 1)" ).append("\n"); 
		query.append("                                        , (CASE WHEN DECODE(A.PORT_CD, 'ALL', NULL, A.PORT_CD) <> DECODE(A.HUB_LOC_CD, 'ALL', NULL, A.HUB_LOC_CD)  THEN 1 ELSE 2 END) -- 내륙운송이 있으면 ALL보다 ROUTE를 우선 순위로 한다." ).append("\n"); 
		query.append("                                        , DECODE(A.VSL_SLAN_CD, 'ALL', 2, 1)" ).append("\n"); 
		query.append("                                        , D.PCTL_SEQ) RNK" ).append("\n"); 
		query.append("                   , 1 ORD" ).append("\n"); 
		query.append("                   , 1 ORD_FIRST           " ).append("\n"); 
		query.append("               FROM  PRD_BLCK_STWG A" ).append("\n"); 
		query.append("                   , PRD_INLND_ROUT_MST C" ).append("\n"); 
		query.append("                   , PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("              WHERE 1=1" ).append("\n"); 
		query.append("              AND D.PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("              AND D.TRSP_MOD_CD <> 'X'" ).append("\n"); 
		query.append("              AND D.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("              AND NVL(A.DELT_FLG, 'N')    <>'Y'" ).append("\n"); 
		query.append("              AND A.PORT_CD IN (SUBSTR(C.ROUT_ORG_NOD_CD,1,5), 'ALL')" ).append("\n"); 
		query.append("              AND A.HUB_LOC_CD IN (DECODE(SUBSTR(C.HUB_NOD_CD,1,5),NULL,SUBSTR(C.ROUT_ORG_NOD_CD,1,5),SUBSTR(C.HUB_NOD_CD,1,5)), 'ALL')     " ).append("\n"); 
		query.append("              AND D.ROUT_ORG_NOD_CD  = C.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("              AND D.ROUT_DEST_NOD_CD = C.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("              AND D.ROUT_SEQ         = C.ROUT_SEQ    " ).append("\n"); 
		query.append("              AND C.INLND_ROUT_BKG_FLG ='Y'" ).append("\n"); 
		query.append("              AND NVL(C.DELT_FLG, 'N') <>'Y'     " ).append("\n"); 
		query.append("              AND C.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("              AND A.VSL_SLAN_CD  IN ((SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("                                        FROM (SELECT RANK() OVER(ORDER BY RK, ARR_ST_DT DESC) RK, VSL_SLAN_CD" ).append("\n"); 
		query.append("                                                FROM (SELECT /*+ INDEX_DESC (Y XAK4VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("                                                             1 RK" ).append("\n"); 
		query.append("                                                            ,X.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                                            ,X.UPD_DT ARR_ST_DT  " ).append("\n"); 
		query.append("                                                        FROM VSK_VSL_SKD X" ).append("\n"); 
		query.append("                                                            ,VSK_VSL_PORT_SKD Y" ).append("\n"); 
		query.append("                                                       WHERE X.VSL_CD = Y.VSL_CD" ).append("\n"); 
		query.append("                                                         AND X.SKD_VOY_NO = Y.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                         AND X.SKD_DIR_CD = Y.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                         AND X.VSL_CD     = SUBSTR(@[bkg_trunk_vvd], 1, 4)" ).append("\n"); 
		query.append("                                                         AND X.SKD_VOY_NO = SUBSTR(@[bkg_trunk_vvd], 5, 4)" ).append("\n"); 
		query.append("                                                         AND X.SKD_DIR_CD = SUBSTR(@[bkg_trunk_vvd], 9, 1)" ).append("\n"); 
		query.append("                                                         AND Y.VPS_PORT_CD = @[bkg_pod_cd]" ).append("\n"); 
		query.append("                                                         AND ROWNUM = 1 " ).append("\n"); 
		query.append("                                                       UNION                                       " ).append("\n"); 
		query.append("                                                      SELECT 2 RK, VSL_SLAN_CD, ARR_ST_DT" ).append("\n"); 
		query.append("                                                        FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                                                       WHERE PCTL_NO = @[pctl_no] " ).append("\n"); 
		query.append("                                                         AND SUBSTR(DEST_NOD_CD,1,5) = @[bkg_pod_cd]" ).append("\n"); 
		query.append("                                                         AND TRSP_MOD_CD = 'VD'                                  " ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                                       WHERE RK = 1 " ).append("\n"); 
		query.append("                                     ), 'ALL')" ).append("\n"); 
		query.append("              AND A.STWG_CD IN (@[stwg_cd], 'ALL')" ).append("\n"); 
		query.append("              UNION ALL" ).append("\n"); 
		query.append("              -- INLAND 구간이 없거나 ALL 인 경우" ).append("\n"); 
		query.append("              SELECT BLCK_STWG_CD" ).append("\n"); 
		query.append("                   , RANK() OVER(ORDER BY DECODE(STWG_CD, 'ALL', 2, 1)" ).append("\n"); 
		query.append("                                        , DECODE(PORT_CD||HUB_LOC_CD, 'ALLALL', 2, 1)" ).append("\n"); 
		query.append("                                        , DECODE(VSL_SLAN_CD, 'ALL', 2, 1)) RNK    " ).append("\n"); 
		query.append("                   , 2 ORD" ).append("\n"); 
		query.append("                   , DECODE(PORT_CD, 'ALL', 0, 1) ORD_FIRST           " ).append("\n"); 
		query.append("                FROM PRD_BLCK_STWG A" ).append("\n"); 
		query.append("               WHERE 1=1" ).append("\n"); 
		query.append("                 AND NVL(DELT_FLG, 'N')    <>'Y'" ).append("\n"); 
		query.append("                 AND PORT_CD IN (@[bkg_pod_cd], 'ALL')" ).append("\n"); 
		query.append("                 AND HUB_LOC_CD IN (@[bkg_del_cd], 'ALL')" ).append("\n"); 
		query.append("                 AND STWG_CD IN (@[stwg_cd], 'ALL')  " ).append("\n"); 
		query.append("                 AND DELT_FLG = 'N'         " ).append("\n"); 
		query.append("                 AND VSL_SLAN_CD  IN ((SELECT VSL_SLAN_CD" ).append("\n"); 
		query.append("                                         FROM (SELECT RANK() OVER(ORDER BY RK, ARR_ST_DT DESC) RK, VSL_SLAN_CD" ).append("\n"); 
		query.append("                                                FROM (SELECT /*+ INDEX_DESC (Y XAK4VSK_VSL_PORT_SKD) */" ).append("\n"); 
		query.append("                                                             1 RK" ).append("\n"); 
		query.append("                                                            ,X.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                                            ,X.UPD_DT ARR_ST_DT  " ).append("\n"); 
		query.append("                                                        FROM VSK_VSL_SKD X" ).append("\n"); 
		query.append("                                                            ,VSK_VSL_PORT_SKD Y" ).append("\n"); 
		query.append("                                                       WHERE X.VSL_CD = Y.VSL_CD" ).append("\n"); 
		query.append("                                                         AND X.SKD_VOY_NO = Y.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                         AND X.SKD_DIR_CD = Y.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                         AND X.VSL_CD     = SUBSTR(@[bkg_trunk_vvd], 1, 4)" ).append("\n"); 
		query.append("                                                         AND X.SKD_VOY_NO = SUBSTR(@[bkg_trunk_vvd], 5, 4)" ).append("\n"); 
		query.append("                                                         AND X.SKD_DIR_CD = SUBSTR(@[bkg_trunk_vvd], 9, 1)" ).append("\n"); 
		query.append("                                                         AND Y.VPS_PORT_CD = @[bkg_pod_cd]" ).append("\n"); 
		query.append("                                                         AND ROWNUM = 1 " ).append("\n"); 
		query.append("                                                       UNION                                       " ).append("\n"); 
		query.append("                                                      SELECT 2 RK, VSL_SLAN_CD, ARR_ST_DT" ).append("\n"); 
		query.append("                                                        FROM PRD_PROD_CTL_ROUT_DTL " ).append("\n"); 
		query.append("                                                       WHERE PCTL_NO = @[pctl_no]" ).append("\n"); 
		query.append("                                                         AND SUBSTR(DEST_NOD_CD,1,5) = @[bkg_pod_cd]" ).append("\n"); 
		query.append("                                                         AND TRSP_MOD_CD = 'VD'                                  " ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("                                             )" ).append("\n"); 
		query.append("                                       WHERE RK = 1 " ).append("\n"); 
		query.append("                                     ), 'ALL')" ).append("\n"); 
		query.append("        ) AA" ).append("\n"); 
		query.append("        WHERE RNK = 1" ).append("\n"); 
		query.append(") AAA" ).append("\n"); 
		query.append("WHERE AAA.RK_ORD = 1" ).append("\n"); 

	}
}