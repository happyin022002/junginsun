/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LaneInformationMgtDBDAOStatusDeployedVesselVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.17 
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

public class LaneInformationMgtDBDAOStatusDeployedVesselVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public LaneInformationMgtDBDAOStatusDeployedVesselVORSQL(){
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
		query.append("FileName : LaneInformationMgtDBDAOStatusDeployedVesselVORSQL").append("\n"); 
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
		query.append("SELECT  OPR, COUNT                                                                                          " ).append("\n"); 
		query.append(" FROM    (                                                                                                  " ).append("\n"); 
		query.append("             SELECT DECODE(B.CRR_CD, COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC(), COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC(), 'HLC', 'HLC', 'OOL', 'OOL', 'APL', 'APL', 'MOL','MOL','HMM','HMM' ,'Others') OPR, " ).append("\n"); 
		query.append("                    COUNT(DISTINCT A.VSL_CD) COUNT                                                          " ).append("\n"); 
		query.append("             FROM   VSK_VSL_PORT_SKD A, MDM_VSL_CNTR B, MDM_VSL_SVC_LANE C                                  " ).append("\n"); 
		query.append("             WHERE  A.VSL_CD           = B.VSL_CD                                                           " ).append("\n"); 
		query.append("             AND    A.SLAN_CD          = C.VSL_SLAN_CD                                                      " ).append("\n"); 
		query.append("             AND    C.VSKD_FLET_GRP_CD IS NOT NULL                                                          " ).append("\n"); 
		query.append("             AND    A.VPS_ETB_DT       > SYSDATE                                                            " ).append("\n"); 
		query.append("             AND    A.VPS_ETB_DT       < SYSDATE + 90                                                       " ).append("\n"); 
		query.append("             AND    C.VSKD_FLET_GRP_CD IS NOT NULL" ).append("\n"); 
		query.append("            AND	C.VSKD_FLET_GRP_CD LIKE @[vskd_flet_grp_cd]" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("			 AND	A.SLAN_CD 		   = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("             GROUP BY DECODE(B.CRR_CD, COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC(), COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC(), 'HLC', 'HLC', 'OOL', 'OOL', 'APL', 'APL', 'MOL','MOL','HMM','HMM' , 'Others')    " ).append("\n"); 
		query.append("         )                                                                                                  " ).append("\n"); 
		query.append(" ORDER BY DECODE(OPR, COM_CONSTANTMGR_PKG.COM_getCompanyCode_FNC(), 1, 'HLC', 2, 'OOL', 3, 'APL', 4, 'MOL', 5, 'HMM',6, 7)" ).append("\n"); 

	}
}