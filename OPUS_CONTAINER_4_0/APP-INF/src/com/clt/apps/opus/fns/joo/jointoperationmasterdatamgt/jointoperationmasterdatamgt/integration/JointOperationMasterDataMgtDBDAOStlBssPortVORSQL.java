/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOStlBssPortVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOStlBssPortVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Basic Port Choose By Settlement Item
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOStlBssPortVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOStlBssPortVORSQL").append("\n"); 
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
		query.append("SELECT A.JO_CRR_CD" ).append("\n"); 
		query.append("     , A.TRD_CD" ).append("\n"); 
		query.append("     , A.RLANE_CD" ).append("\n"); 
		query.append("     , A.JO_STL_ITM_CD" ).append("\n"); 
		query.append("     , A.SKD_DIR_CD" ).append("\n"); 
		query.append("     , M.VSL_SLAN_DIR_SEQ AS SEQ" ).append("\n"); 
		query.append("     , A.STL_TGT_VVD_BSS_CD" ).append("\n"); 
		query.append("     , A.JO_STL_TGT_TP_CD" ).append("\n"); 
		query.append("     , A.N1ST_STL_BZC_PORT_CD" ).append("\n"); 
		query.append("     , A.N2ND_STL_BZC_PORT_CD" ).append("\n"); 
		query.append("     , A.N3RD_STL_BZC_PORT_CD" ).append("\n"); 
		query.append("     , A.N1ST_STL_PAIR_PORT_CD" ).append("\n"); 
		query.append("     , A.N2ND_STL_PAIR_PORT_CD" ).append("\n"); 
		query.append("     , A.N3RD_STL_PAIR_PORT_CD" ).append("\n"); 
		query.append("     , A.UC_BSS_PORT_CD" ).append("\n"); 
		query.append("     , A.AGMT_MON_COND_CD" ).append("\n"); 
		query.append("     , A.AGMT_PORT_COND_CD" ).append("\n"); 
		query.append("     , A.AGMT_PORT_TP_COND_CD" ).append("\n"); 
		query.append("     , A.AGMT_OP_TP_COND_CD" ).append("\n"); 
		query.append("     , B.JO_STL_ITM_NM" ).append("\n"); 
		query.append("  FROM JOO_STL_BSS_PORT A" ).append("\n"); 
		query.append("     , JOO_STL_ITM B" ).append("\n"); 
		query.append("     ,MDM_VSL_SVC_LANE_DIR M" ).append("\n"); 
		query.append(" WHERE A.JO_STL_ITM_CD = B.JO_STL_ITM_CD" ).append("\n"); 
		query.append("   AND A.JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("   AND A.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("   AND M.VSL_SLAN_CD = SUBSTR(A.RLANE_CD, 1,3)" ).append("\n"); 
		query.append("   AND M.VSL_SLAN_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("#if(${jo_stl_itm_cd}!= '')" ).append("\n"); 
		query.append("AND    A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${skd_dir_cd}!= '')" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY M.VSL_SLAN_DIR_SEQ, B.ORD_SEQ, A.JO_STL_ITM_CD" ).append("\n"); 

	}
}