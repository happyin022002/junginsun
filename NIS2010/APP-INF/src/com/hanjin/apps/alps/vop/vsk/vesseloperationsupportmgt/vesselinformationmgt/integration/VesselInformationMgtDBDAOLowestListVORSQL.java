/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselInformationMgtDBDAOLowestListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselInformationMgtDBDAOLowestListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lowest 정보를 조회한다.
	  * </pre>
	  */
	public VesselInformationMgtDBDAOLowestListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_pf_skd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("h_vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesselinformationmgt.integration").append("\n"); 
		query.append("FileName : VesselInformationMgtDBDAOLowestListVORSQL").append("\n"); 
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
		query.append("SELECT   PP.VSL_SLAN_CD" ).append("\n"); 
		query.append("      ,  PP.PF_SVC_TP_CD" ).append("\n"); 
		query.append("      ,  PP.FM_PORT_CD" ).append("\n"); 
		query.append("      ,  PP.TO_PORT_CD" ).append("\n"); 
		query.append("      ,  PP.FM_PORT_CD || ' - ' || PP.TO_PORT_CD  AS LOW_PORT_PAIR" ).append("\n"); 
		query.append("      ,  PP.LNK_SPD" ).append("\n"); 
		query.append("      ,  PP.LNK_DIST" ).append("\n"); 
		query.append("FROM     (" ).append("\n"); 
		query.append("          SELECT   P.VSL_SLAN_CD" ).append("\n"); 
		query.append("                ,  P.PF_SVC_TP_CD" ).append("\n"); 
		query.append("                ,  P.PORT_CD                                            AS FM_PORT_CD" ).append("\n"); 
		query.append("                ,  LEAD(P.PORT_CD) OVER (ORDER BY P.PORT_ROTN_SEQ ASC)  AS TO_PORT_CD" ).append("\n"); 
		query.append("                ,  P.LNK_SPD" ).append("\n"); 
		query.append("                ,  P.LNK_DIST" ).append("\n"); 
		query.append("          FROM     VSK_PF_SKD_DTL       P" ).append("\n"); 
		query.append("          WHERE    1 = 1" ).append("\n"); 
		query.append("          AND      P.VSL_SLAN_CD        = @[h_vsl_slan_cd]" ).append("\n"); 
		query.append("          AND      P.PF_SVC_TP_CD       = @[h_pf_skd_tp_cd]" ).append("\n"); 
		query.append("          ) PP" ).append("\n"); 
		query.append("WHERE     1 = 1" ).append("\n"); 
		query.append("AND       PP.TO_PORT_CD                 IS NOT NULL" ).append("\n"); 
		query.append("AND       PP.LNK_SPD                    < (" ).append("\n"); 
		query.append("                                           ----------------------------------------------------------------------" ).append("\n"); 
		query.append("                                            SELECT   (SELECT    ROUND(SUM(D.LNK_DIST)/SUM(D.TZTM_HRS),2)" ).append("\n"); 
		query.append("                                                      FROM      VSK_PF_SKD_DTL    D" ).append("\n"); 
		query.append("                                                      WHERE     D.VSL_SLAN_CD     = VS.VSL_SLAN_CD" ).append("\n"); 
		query.append("                                                      AND       D.PF_SVC_TP_CD    = VS.PF_SKD_TP_CD" ).append("\n"); 
		query.append("                                                      )                " ).append("\n"); 
		query.append("                                            FROM     VSK_VSL_SKD        VS" ).append("\n"); 
		query.append("                                            WHERE    1 = 1" ).append("\n"); 
		query.append("											AND		 ROWNUM				= 1" ).append("\n"); 
		query.append("                                            AND      VS.VSL_CD          = @[vsl_cd]" ).append("\n"); 
		query.append("                                            AND      VS.PF_SKD_TP_CD    = @[h_pf_skd_tp_cd]" ).append("\n"); 
		query.append("                                            AND      EXISTS             (SELECT   ''" ).append("\n"); 
		query.append("                                                                         FROM     VSK_VSL_PORT_SKD          PS" ).append("\n"); 
		query.append("                                                                         WHERE    1 = 1" ).append("\n"); 
		query.append("                                                                         AND      PS.VSL_CD                 = VS.VSL_CD" ).append("\n"); 
		query.append("                                                                         AND      PS.SKD_VOY_NO             = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                         AND      PS.SKD_DIR_CD             = VS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                         AND      PS.TURN_PORT_IND_CD       IN ('Y','N')" ).append("\n"); 
		query.append("                                                                         AND      PS.CLPT_SEQ               = (SELECT   MIN(PPS.CLPT_SEQ)" ).append("\n"); 
		query.append("                                                                                                               FROM     VSK_VSL_PORT_SKD  PPS" ).append("\n"); 
		query.append("                                                                                                               WHERE    PPS.VSL_CD        = PS.VSL_CD" ).append("\n"); 
		query.append("                                                                                                               AND      PPS.SKD_VOY_NO    = PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                                               AND      PPS.SKD_DIR_CD    = PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                                               AND      PPS.TURN_PORT_IND_CD = PS.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                                                                                                               AND      NVL(PS.SKD_CNG_STS_CD,'*')<> 'S'" ).append("\n"); 
		query.append("                                                                                                               )" ).append("\n"); 
		query.append("                                                                         AND      PS.VPS_ETA_DT             < SYSDATE" ).append("\n"); 
		query.append("                                                                         )" ).append("\n"); 
		query.append("                                            AND      EXISTS             (SELECT   ''" ).append("\n"); 
		query.append("                                                                         FROM     VSK_VSL_PORT_SKD          PS" ).append("\n"); 
		query.append("                                                                         WHERE    1 = 1" ).append("\n"); 
		query.append("                                                                         AND      PS.VSL_CD                 = VS.VSL_CD" ).append("\n"); 
		query.append("                                                                         AND      PS.SKD_VOY_NO             = VS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                         AND      PS.SKD_DIR_CD             = VS.SKD_DIR_CD  " ).append("\n"); 
		query.append("                                                                         AND      PS.TURN_PORT_IND_CD       IN ('Y','N')                          " ).append("\n"); 
		query.append("                                                                         AND      PS.CLPT_SEQ               = (SELECT   MAX(PPS.CLPT_SEQ)" ).append("\n"); 
		query.append("                                                                                                               FROM     VSK_VSL_PORT_SKD  PPS" ).append("\n"); 
		query.append("                                                                                                               WHERE    PPS.VSL_CD        = PS.VSL_CD" ).append("\n"); 
		query.append("                                                                                                               AND      PPS.SKD_VOY_NO    = PS.SKD_VOY_NO" ).append("\n"); 
		query.append("                                                                                                               AND      PPS.SKD_DIR_CD    = PS.SKD_DIR_CD" ).append("\n"); 
		query.append("                                                                                                               AND      PPS.TURN_PORT_IND_CD = PS.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("                                                                                                               AND      NVL(PS.SKD_CNG_STS_CD,'*')<> 'S'" ).append("\n"); 
		query.append("                                                                                                               )" ).append("\n"); 
		query.append("                                                                         AND      PS.VPS_ETD_DT             > SYSDATE" ).append("\n"); 
		query.append("                                                                         )   " ).append("\n"); 
		query.append("                                           ----------------------------------------------------------------------" ).append("\n"); 
		query.append("                                          )" ).append("\n"); 

	}
}