/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOModifyAddBsaCarrieListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.02
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.11.02 민정호
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

public class JointOperationMasterDataMgtDBDAOModifyAddBsaCarrieListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Add Bsa Carrier에 저장된 Teu Qty값을 JOO_BSA_INFO_ENTR 테이블에 Update 한다
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOModifyAddBsaCarrieListUSQL(){
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
		params.put("port_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : JointOperationMasterDataMgtDBDAOModifyAddBsaCarrieListUSQL").append("\n"); 
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
		query.append("UPDATE JOO_BSA_AGMT" ).append("\n"); 
		query.append("   SET JO_ADD_BSA_CRR_FLG   = 'Y'    " ).append("\n"); 
		query.append("   , JO_BSA_ADD_TEU_QTY   = (SELECT SUM(JO_BSA_TEU_QTY)" ).append("\n"); 
		query.append("                               FROM JOO_ADD_BSA_CRR   " ).append("\n"); 
		query.append("                              WHERE VSL_CD     =  @[vsl_cd] " ).append("\n"); 
		query.append("                                AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                                AND PORT_SEQ = @[port_seq]" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("   , JO_OVR_BSA_TEU_QTY   = JO_BSA_TEU_QTY + (SELECT SUM(JO_BSA_TEU_QTY)" ).append("\n"); 
		query.append("                                                FROM JOO_ADD_BSA_CRR   " ).append("\n"); 
		query.append("                                               WHERE VSL_CD     =  @[vsl_cd] " ).append("\n"); 
		query.append("                                                 AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("                                                 AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("                                                 AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("                                                 AND PORT_SEQ = @[port_seq]" ).append("\n"); 
		query.append("                                              )" ).append("\n"); 
		query.append("	,UPD_DT                 = sysdate" ).append("\n"); 
		query.append("    ,UPD_USR_ID             = @[upd_usr_id]" ).append("\n"); 
		query.append(" WHERE VSL_CD     =  @[vsl_cd] " ).append("\n"); 
		query.append("   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("   AND PORT_SEQ = @[port_seq]" ).append("\n"); 
		query.append("   AND JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 

	}
}