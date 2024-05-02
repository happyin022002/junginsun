/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOJooStlBssPortVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.10.08 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOJooStlBssPortVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOJooStlBssPortVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_stl_bzc_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n2nd_stl_pair_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_mon_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agmt_port_tp_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_port_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("uc_bss_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_tgt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_stl_pair_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_stl_bzc_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3rd_stl_bzc_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n1st_stl_pair_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_op_tp_cond_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_tgt_vvd_bss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOJooStlBssPortVOCSQL").append("\n"); 
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
		query.append("INSERT INTO JOO_STL_BSS_PORT(" ).append("\n"); 
		query.append("JO_CRR_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",SKD_DIR_CD" ).append("\n"); 
		query.append(",JO_STL_ITM_CD" ).append("\n"); 
		query.append(",JO_STL_TGT_TP_CD" ).append("\n"); 
		query.append(",N1ST_STL_BZC_PORT_CD" ).append("\n"); 
		query.append(",N2ND_STL_BZC_PORT_CD" ).append("\n"); 
		query.append(",N3RD_STL_BZC_PORT_CD" ).append("\n"); 
		query.append(",N1ST_STL_PAIR_PORT_CD" ).append("\n"); 
		query.append(",N2ND_STL_PAIR_PORT_CD" ).append("\n"); 
		query.append(",N3RD_STL_PAIR_PORT_CD" ).append("\n"); 
		query.append(",STL_TGT_VVD_BSS_CD" ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",UC_BSS_PORT_CD" ).append("\n"); 
		query.append(",AGMT_MON_COND_CD" ).append("\n"); 
		query.append(",AGMT_PORT_COND_CD" ).append("\n"); 
		query.append(",AGMT_PORT_TP_COND_CD" ).append("\n"); 
		query.append(",AGMT_OP_TP_COND_CD" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("@[jo_crr_cd]" ).append("\n"); 
		query.append(",@[rlane_cd]" ).append("\n"); 
		query.append(",@[skd_dir_cd]" ).append("\n"); 
		query.append(",@[jo_stl_itm_cd]" ).append("\n"); 
		query.append(",@[jo_stl_tgt_tp_cd]" ).append("\n"); 
		query.append(",@[n1st_stl_bzc_port_cd]" ).append("\n"); 
		query.append(",@[n2nd_stl_bzc_port_cd]" ).append("\n"); 
		query.append(",@[n3rd_stl_bzc_port_cd]" ).append("\n"); 
		query.append(",@[n1st_stl_pair_port_cd]" ).append("\n"); 
		query.append(",@[n2nd_stl_pair_port_cd]" ).append("\n"); 
		query.append(",@[n3rd_stl_pair_port_cd]" ).append("\n"); 
		query.append(",@[stl_tgt_vvd_bss_cd]" ).append("\n"); 
		query.append(",@[trd_cd]" ).append("\n"); 
		query.append(",@[uc_bss_port_cd]" ).append("\n"); 
		query.append(",@[agmt_mon_cond_cd]" ).append("\n"); 
		query.append(",@[agmt_port_cond_cd]" ).append("\n"); 
		query.append(",@[agmt_port_tp_cond_cd]" ).append("\n"); 
		query.append(",@[agmt_op_tp_cond_cd]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}