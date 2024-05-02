/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LaneInformationMgtDBDAOStatusVesselMainVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.05.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneInformationMgtDBDAOStatusVesselMainVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search lane status vessel info.
	  * </pre>
	  */
	public LaneInformationMgtDBDAOStatusVesselMainVORSQL(){
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
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration").append("\n"); 
		query.append("FileName : LaneInformationMgtDBDAOStatusVesselMainVORSQL").append("\n"); 
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
		query.append("--SELECT A.GRP||'-'||DECODE(LENGTH(ROWNUM),1,'0'||ROWNUM,ROWNUM) GRP,  " ).append("\n"); 
		query.append("SELECT TMP_GRP||'-'||DECODE(LENGTH(RANK),1,'0'||RANK, RANK) GRP," ).append("\n"); 
		query.append("  SVC_LANE," ).append("\n"); 
		query.append("  OPT," ).append("\n"); 
		query.append("  VSL_CLASS," ).append("\n"); 
		query.append("  OWN," ).append("\n"); 
		query.append("  CHT," ).append("\n"); 
		query.append("  OTH," ).append("\n"); 
		query.append("  TTL" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("  --SELECT RANK() OVER (PARTITION BY A.GRP ORDER BY A.SVC_LANE,B.CRR_CD, NVL(B.CNTR_VSL_CLSS_CAPA,0)) AS RANK, A.GRP AS TMP_GRP,  " ).append("\n"); 
		query.append("    SELECT DENSE_RANK() OVER (PARTITION BY A.GRP ORDER BY A.SVC_LANE) AS RANK, A.GRP AS TMP_GRP,                                                " ).append("\n"); 
		query.append("        A.SVC_LANE,                                                                                                 " ).append("\n"); 
		query.append("        B.CRR_CD OPT,                                                                                               " ).append("\n"); 
		query.append("        NVL(B.CNTR_VSL_CLSS_CAPA,0) AS VSL_CLASS,                                                                      " ).append("\n"); 
		query.append("        SUM(DECODE(B.CRR_CD, COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC(), DECODE(B.VSL_OWN_IND_CD, 'O', 1, 0), 0)) AS OWN,                                   " ).append("\n"); 
		query.append("        SUM(DECODE(B.CRR_CD, COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC(), DECODE(B.VSL_OWN_IND_CD, 'C', 1, 0), 0)) AS CHT,                                   " ).append("\n"); 
		query.append("        SUM(DECODE(B.CRR_CD, COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC(), 0, 1))                                   AS OTH,                                   " ).append("\n"); 
		query.append("	    (                                                                                                           " ).append("\n"); 
		query.append("	    	SUM(DECODE(B.CRR_CD, COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC(), DECODE(B.VSL_OWN_IND_CD, 'O', 1, 0), 0)) +                                    " ).append("\n"); 
		query.append("	    	SUM(DECODE(B.CRR_CD, COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC(), DECODE(B.VSL_OWN_IND_CD, 'C', 1, 0), 0)) +                                    " ).append("\n"); 
		query.append("	    	SUM(DECODE(B.CRR_CD, COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC(), 0, 1))                                                                        " ).append("\n"); 
		query.append("	    ) AS	TTL                                                                                                   " ).append("\n"); 
		query.append("FROM    (                                                                                                           " ).append("\n"); 
		query.append("            SELECT  C.VSKD_FLET_GRP_CD GRP, A.SLAN_CD SVC_LANE, A.VSL_CD VSL                                        " ).append("\n"); 
		query.append("            FROM    VSK_VSL_PORT_SKD A, MDM_VSL_SVC_LANE C                                                          " ).append("\n"); 
		query.append("            WHERE   A.SLAN_CD       = C.VSL_SLAN_CD                                                                 " ).append("\n"); 
		query.append("            AND     A.VPS_ETB_DT    > SYSDATE                                                                       " ).append("\n"); 
		query.append("            AND     A.VPS_ETB_DT    < SYSDATE + 90                                                                  " ).append("\n"); 
		query.append("            AND     C.VSKD_FLET_GRP_CD   LIKE  @[vskd_flet_grp_cd]" ).append("\n"); 
		query.append("            AND     C.VSKD_FLET_GRP_CD IS NOT NULL                                                                  " ).append("\n"); 
		query.append("            GROUP BY C.VSKD_FLET_GRP_CD, A.SLAN_CD, A.VSL_CD                                                        " ).append("\n"); 
		query.append("        ) A, MDM_VSL_CNTR B                                                                                         " ).append("\n"); 
		query.append("WHERE   A.VSL                       = B.VSL_CD                                                                     " ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("AND		A.SVC_LANE					= @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("  GROUP BY B.CRR_CD, NVL(B.CNTR_VSL_CLSS_CAPA,0), A.GRP, A.SVC_LANE" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ORDER BY TMP_GRP, RANK" ).append("\n"); 
		query.append("--GROUP BY A.GRP||'-'||DECODE(LENGTH(ROWNUM),1,'0'||ROWNUM,ROWNUM), A.SVC_LANE, B.CRR_CD, NVL(B.CNTR_VSL_CLSS_CAPA,0) " ).append("\n"); 
		query.append("--ORDER BY A.GRP||'-'||DECODE(LENGTH(ROWNUM),1,'0'||ROWNUM,ROWNUM)" ).append("\n"); 

	}
}