/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : LaneInformationMgtDBDAOStatusServiceVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneInformationMgtDBDAOStatusServiceVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Status Service Search
	  * </pre>
	  */
	public LaneInformationMgtDBDAOStatusServiceVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vskd_flet_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration").append("\n"); 
		query.append("FileName : LaneInformationMgtDBDAOStatusServiceVORSQL").append("\n"); 
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
		query.append("SELECT  C.INTG_CD_VAL_DP_DESC TYPE, COUNT, HJS_VSL_SVC                                     " ).append("\n"); 
		query.append("FROM    (                                                                                  " ).append("\n"); 
		query.append("            SELECT  VSKD_FLET_GRP_CD TYPE, COUNT(*)  COUNT                                 " ).append("\n"); 
		query.append("            FROM    MDM_VSL_SVC_LANE                                                       " ).append("\n"); 
		query.append("            WHERE   VSKD_FLET_GRP_CD <> ' '                                                " ).append("\n"); 
		query.append("            GROUP   BY VSKD_FLET_GRP_CD                                                    " ).append("\n"); 
		query.append("        ) A,                                                                               " ).append("\n"); 
		query.append("        (                                                                                  " ).append("\n"); 
		query.append("            SELECT  VSKD_FLET_GRP_CD, COUNT(DISTINCT A.SLAN_CD) HJS_VSL_SVC                " ).append("\n"); 
		query.append("            FROM    VSK_VSL_PORT_SKD A, MDM_VSL_CNTR B, MDM_VSL_SVC_LANE C, VSK_VSL_SKD D  " ).append("\n"); 
		query.append("            WHERE   B.VSL_CD        = D.VSL_CD                                             " ).append("\n"); 
		query.append("            AND     A.SLAN_CD       = C.VSL_SLAN_CD                                        " ).append("\n"); 
		query.append("            AND     A.VSL_CD        = D.VSL_CD                                             " ).append("\n"); 
		query.append("            AND     A.SKD_VOY_NO    = D.SKD_VOY_NO                                         " ).append("\n"); 
		query.append("            AND     A.SKD_DIR_CD    = D.SKD_DIR_CD                                         " ).append("\n"); 
		query.append("            AND     B.CRR_CD        = 'SML'                                                " ).append("\n"); 
		query.append("            AND     A.VPS_ETB_DT    > SYSDATE                                              " ).append("\n"); 
		query.append("            AND     A.VPS_ETB_DT    < SYSDATE + 90                                         " ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("			AND		A.SLAN_CD 		= @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("            AND     EXISTS                                                                 " ).append("\n"); 
		query.append("            (                                                                              " ).append("\n"); 
		query.append("                    SELECT  'X'                                                            " ).append("\n"); 
		query.append("                    FROM    MDM_VSL_SVC_LANE C                                             " ).append("\n"); 
		query.append("                    WHERE   A.SLAN_CD   = C.VSL_SLAN_CD                                    " ).append("\n"); 
		query.append("                    AND     NVL(C.VSKD_FLET_GRP_CD, 'N') <> 'N'                            " ).append("\n"); 
		query.append("                    AND     ROWNUM          = 1                                            " ).append("\n"); 
		query.append("            )                                                                              " ).append("\n"); 
		query.append("            GROUP BY C.VSKD_FLET_GRP_CD                                                    " ).append("\n"); 
		query.append("        ) B, COM_INTG_CD_DTL C                                                             " ).append("\n"); 
		query.append("WHERE   TYPE         = B.VSKD_FLET_GRP_CD (+)                                              " ).append("\n"); 
		query.append("AND     C.INTG_CD_ID = 'CD02121'                                                           " ).append("\n"); 
		query.append("AND		B.VSKD_FLET_GRP_CD LIKE @[vskd_flet_grp_cd]                                          " ).append("\n"); 
		query.append("AND     TYPE         = C.INTG_CD_VAL_CTNT                                                  " ).append("\n"); 
		query.append("ORDER BY DECODE(C.INTG_CD_VAL_CTNT, 'M', 1, 'C', 2, 'O', 3, 4)" ).append("\n"); 

	}
}