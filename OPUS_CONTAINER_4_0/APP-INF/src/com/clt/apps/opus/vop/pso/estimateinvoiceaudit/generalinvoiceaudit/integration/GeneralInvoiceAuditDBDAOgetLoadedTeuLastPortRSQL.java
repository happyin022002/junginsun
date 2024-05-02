/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOgetLoadedTeuLastPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOgetLoadedTeuLastPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 VVD, Port의 이전 Port에서 선적된 CNTR TEU를 구한다.
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOgetLoadedTeuLastPortRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOgetLoadedTeuLastPortRSQL").append("\n"); 
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
		query.append("SELECT SUM(DECODE(H.CNTR_SIZE, '2', 1, 2) * H.QTY) TEU" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT B.VSL_CD" ).append("\n"); 
		query.append("             , B.VOY_NO" ).append("\n"); 
		query.append("             , B.DIR_CD" ).append("\n"); 
		query.append("             , B.PORT_CD" ).append("\n"); 
		query.append("             , B.CALL_IND" ).append("\n"); 
		query.append("             , B.CNTR_SIZE" ).append("\n"); 
		query.append("             , COUNT(*) QTY" ).append("\n"); 
		query.append("          FROM (" ).append("\n"); 
		query.append("                SELECT VPS.VSL_CD" ).append("\n"); 
		query.append("                     , VPS.SKD_VOY_NO AS SKD_VOY_NO" ).append("\n"); 
		query.append("                     , VPS.SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("                     , VPS.VPS_PORT_CD AS VPS_PORT_CD" ).append("\n"); 
		query.append("                     , VPS.CLPT_SEQ AS CLPT_SEQ" ).append("\n"); 
		query.append("                     , VPS.CLPT_IND_SEQ AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("                     , VPS.VPS_ETD_DT" ).append("\n"); 
		query.append("                     , VPS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                     , VPS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                     , VPS.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                  FROM VSK_VSL_SKD VSL" ).append("\n"); 
		query.append("                     , MDM_VSL_CNTR MVL" ).append("\n"); 
		query.append("                     , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                     , MDM_VSL_SVC_LANE_DIR MVS" ).append("\n"); 
		query.append("                     , (" ).append("\n"); 
		query.append("                         SELECT VPS.*" ).append("\n"); 
		query.append("                              FROM (SELECT VPS.VSL_CD" ).append("\n"); 
		query.append("                                         , VPS.SKD_VOY_NO AS SKD_VOY_NO" ).append("\n"); 
		query.append("                                         , VPS.SKD_DIR_CD AS SKD_DIR_CD" ).append("\n"); 
		query.append("                                         , VPS.VPS_PORT_CD AS VPS_PORT_CD" ).append("\n"); 
		query.append("                                         , VPS.CLPT_SEQ AS CLPT_SEQ" ).append("\n"); 
		query.append("                                         , VPS.CLPT_IND_SEQ AS CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                         , VPS.VPS_ETD_DT" ).append("\n"); 
		query.append("                                         , VPS.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                                         , VPS.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                                         , VPS.TURN_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                      FROM VSK_VSL_SKD VSL" ).append("\n"); 
		query.append("                                         , MDM_VSL_CNTR MVL" ).append("\n"); 
		query.append("                                         , VSK_VSL_PORT_SKD VPS" ).append("\n"); 
		query.append("                                         , MDM_VSL_SVC_LANE_DIR MVS" ).append("\n"); 
		query.append("                                     WHERE 1=1" ).append("\n"); 
		query.append("                                       AND VPS.VSL_CD       = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("                                       AND VPS.SKD_VOY_NO   = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("                                       AND VPS.SKD_DIR_CD   = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("                                       AND VPS.YD_CD        = @[yd_cd]" ).append("\n"); 
		query.append("                                       AND VPS.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("                                       AND VSL.VSL_CD       = MVL.VSL_CD" ).append("\n"); 
		query.append("                                       AND VSL.VSL_CD       = VPS.VSL_CD" ).append("\n"); 
		query.append("                                       AND VSL.SKD_VOY_NO   = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                       AND VSL.SKD_DIR_CD   = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                       AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                                       AND VSL.VSL_SLAN_CD  = MVS.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                       AND VSL.SKD_DIR_CD   = MVS.VSL_SLAN_DIR_CD" ).append("\n"); 
		query.append("                                     ORDER BY MVS.VSL_SLAN_DIR_SEQ, VPS.CLPT_SEQ ) VPS" ).append("\n"); 
		query.append("                             WHERE ROWNUM = 1 " ).append("\n"); 
		query.append("                       ) SVV" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   AND VPS.VSL_CD       = SVV.VSL_CD" ).append("\n"); 
		query.append("                   AND VPS.SKD_VOY_NO   = SVV.TURN_SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VPS.SKD_DIR_CD   = SVV.TURN_SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND VSL.VSL_CD       = MVL.VSL_CD" ).append("\n"); 
		query.append("                   AND VSL.VSL_CD       = VPS.VSL_CD" ).append("\n"); 
		query.append("                   AND VSL.SKD_VOY_NO   = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND VSL.SKD_DIR_CD   = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND VPS.CLPT_SEQ = ( SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                                          FROM VSK_VSL_PORT_SKD V" ).append("\n"); 
		query.append("                                         WHERE V.VSL_CD = VPS.VSL_CD" ).append("\n"); 
		query.append("                                           AND V.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                           AND V.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                           AND V.TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("                                           AND NVL(V.SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("                                           AND NVL(V.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/ )" ).append("\n"); 
		query.append("                   AND VPS.TURN_PORT_IND_CD IN ('Y', 'N')" ).append("\n"); 
		query.append("                   AND NVL(VPS.SKD_CNG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("                   AND NVL(VPS.VT_ADD_CALL_FLG, 'N') = 'N' /*2015.07.21 Add*/" ).append("\n"); 
		query.append("                   AND ROWNUM = 1" ).append("\n"); 
		query.append("               ) A" ).append("\n"); 
		query.append("             , BAY_PLAN B" ).append("\n"); 
		query.append("         WHERE 1=1         " ).append("\n"); 
		query.append("           AND A.VSL_CD         = B.VSL_CD" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO     = B.VOY_NO" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD     = B.DIR_CD" ).append("\n"); 
		query.append("           AND A.VPS_PORT_CD    = B.PORT_CD" ).append("\n"); 
		query.append("           AND A.CLPT_IND_SEQ   = B.CALL_IND " ).append("\n"); 
		query.append("           AND B.FE             = 'F' -- Full CNTR만 대상으로 한다." ).append("\n"); 
		query.append("         GROUP BY B.VSL_CD" ).append("\n"); 
		query.append("             , B.VOY_NO" ).append("\n"); 
		query.append("             , B.DIR_CD" ).append("\n"); 
		query.append("             , B.PORT_CD" ).append("\n"); 
		query.append("             , B.CALL_IND" ).append("\n"); 
		query.append("             , B.CNTR_SIZE   " ).append("\n"); 
		query.append("       ) H" ).append("\n"); 

	}
}