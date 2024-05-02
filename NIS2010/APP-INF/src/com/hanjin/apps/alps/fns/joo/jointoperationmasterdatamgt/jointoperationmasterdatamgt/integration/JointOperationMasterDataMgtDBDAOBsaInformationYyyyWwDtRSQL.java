/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOBsaInformationYyyyWwDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.26
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.06.26 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOBsaInformationYyyyWwDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BsaInformationYyyyWwDt
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOBsaInformationYyyyWwDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOBsaInformationYyyyWwDtRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(CMV.COST_YRMON,1,4)||COST_WK YRWK" ).append("\n"); 
		query.append("	  , BVM.REV_PORT_CD JO_RDR_PORT_CD" ).append("\n"); 
		query.append("      ,TO_CHAR(BVM.REV_PORT_ETD_DT,'YYYYMMDD') REV_PORT_ETD_DT" ).append("\n"); 
		query.append("  FROM MAS_MON_VVD CMV" ).append("\n"); 
		query.append("      ,BSA_VVD_MST BVM" ).append("\n"); 
		query.append("WHERE CMV.TRD_CD = BVM.TRD_CD" ).append("\n"); 
		query.append("  AND CMV.RLANE_CD = BVM.RLANE_CD" ).append("\n"); 
		query.append("  AND CMV.VSL_CD = BVM.VSL_CD" ).append("\n"); 
		query.append("  AND CMV.SKD_VOY_NO = BVM.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND CMV.DIR_CD = BVM.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND CMV.TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("  AND CMV.RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("  AND CMV.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("  AND CMV.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND CMV.DIR_CD = @[skd_dir_cd]" ).append("\n"); 

	}
}