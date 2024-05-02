/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOBsaInformationEntryHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.20
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.10.20 민정호
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

public class JointOperationMasterDataMgtDBDAOBsaInformationEntryHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BsaInformationEntryHis
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOBsaInformationEntryHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : JointOperationMasterDataMgtDBDAOBsaInformationEntryHisCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_BSA_AGMT_HIS" ).append("\n"); 
		query.append("SELECT TRD_CD" ).append("\n"); 
		query.append("     , RLANE_CD" ).append("\n"); 
		query.append("     , VSL_CD" ).append("\n"); 
		query.append("     , SKD_VOY_NO" ).append("\n"); 
		query.append("     , SKD_DIR_CD" ).append("\n"); 
		query.append("     , PORT_CD" ).append("\n"); 
		query.append("     , PORT_SEQ" ).append("\n"); 
		query.append("     , (SELECT NVL(MAX(HIS_SEQ), 0)+1" ).append("\n"); 
		query.append("          FROM JOO_BSA_AGMT_HIS" ).append("\n"); 
		query.append("         WHERE TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("           AND RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("           AND VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("           AND SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("           AND SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND PORT_CD	    = @[port_cd]" ).append("\n"); 
		query.append("           AND PORT_SEQ	    = @[port_seq]" ).append("\n"); 
		query.append("       ) AS HIS_SEQ" ).append("\n"); 
		query.append("     , OFC_CD" ).append("\n"); 
		query.append("     , RE_DIVR_CD" ).append("\n"); 
		query.append("     , JO_CRR_CD" ).append("\n"); 
		query.append("     , JO_BSA_TEU_QTY" ).append("\n"); 
		query.append("     , JO_BSA_ADD_TEU_QTY" ).append("\n"); 
		query.append("     , JO_ADD_BSA_CRR_FLG" ).append("\n"); 
		query.append("     , JO_OVR_BSA_TEU_QTY" ).append("\n"); 
		query.append("     , JO_TON_TEU_QTY" ).append("\n"); 
		query.append("     , JO_OVR_TON_WGT" ).append("\n"); 
		query.append("     , JO_20FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("     , JO_20FT_OVR_RTO" ).append("\n"); 
		query.append("     , JO_40FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("     , JO_40FT_OVR_RTO" ).append("\n"); 
		query.append("     , JO_45FT_SUB_TEU_QTY" ).append("\n"); 
		query.append("     , JO_45FT_OVR_RTO" ).append("\n"); 
		query.append("     , JO_45FT_UND_RTO" ).append("\n"); 
		query.append("     , JO_RF_OCN_TEU_QTY" ).append("\n"); 
		query.append("     , JO_RF_INTER_TEU_QTY" ).append("\n"); 
		query.append("     , JO_RND_KND_FLG" ).append("\n"); 
		query.append("     , JO_RND_RULE_LVL" ).append("\n"); 
		query.append("     , JO_INTER_OVR_FLG" ).append("\n"); 
		query.append("     , JO_RDR_PORT_CD" ).append("\n"); 
		query.append("     , JO_FSH_FLG" ).append("\n"); 
		query.append("     , JO_BSA_PRC" ).append("\n"); 
		query.append("     , JO_OVR_OCN_PRC" ).append("\n"); 
		query.append("     , JO_OVR_INTER_PRC" ).append("\n"); 
		query.append("     , JO_OVR_MT_OCN_PRC" ).append("\n"); 
		query.append("     , JO_OVR_MT_INTER_PRC" ).append("\n"); 
		query.append("     , JO_SCTR_PRC_FLG" ).append("\n"); 
		query.append("     , JO_RF_OCN_PRC" ).append("\n"); 
		query.append("     , JO_RF_INTER_PRC" ).append("\n"); 
		query.append("     , JO_PRC_FSH_FLG" ).append("\n"); 
		query.append("     , YRWK" ).append("\n"); 
		query.append("     , REV_PORT_ETD_DT" ).append("\n"); 
		query.append("     , JO_BSA_ENTR_RMK" ).append("\n"); 
		query.append("     , JO_BSA_ENTR_RDR_RMK" ).append("\n"); 
		query.append("     , DELT_FLG" ).append("\n"); 
		query.append("     , CRE_DT" ).append("\n"); 
		query.append("     , CRE_USR_ID" ).append("\n"); 
		query.append("     , UPD_DT" ).append("\n"); 
		query.append("     , UPD_USR_ID " ).append("\n"); 
		query.append("  FROM JOO_BSA_AGMT" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND TRD_CD       = @[trd_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD     = @[rlane_cd]" ).append("\n"); 
		query.append("   AND VSL_CD       = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND PORT_CD	    = @[port_cd]" ).append("\n"); 
		query.append("   AND PORT_SEQ	    = @[port_seq]" ).append("\n"); 

	}
}