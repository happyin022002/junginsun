/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOJooStlVvdDupRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.18 
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

public class JointOperationMasterDataMgtDBDAOJooStlVvdDupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * duplication check
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOJooStlVvdDupRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_mnu_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("stl_vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOJooStlVvdDupRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("       A.VSL_CD," ).append("\n"); 
		query.append("       A.SKD_VOY_NO," ).append("\n"); 
		query.append("       A.SKD_DIR_CD," ).append("\n"); 
		query.append("       A.REV_DIR_CD," ).append("\n"); 
		query.append("       A.JO_STL_ITM_CD," ).append("\n"); 
		query.append("       A.JO_MNU_NM," ).append("\n"); 
		query.append("       A.STL_BZC_PORT_CD," ).append("\n"); 
		query.append("       A.STL_TGT_VVD_BSS_CD," ).append("\n"); 
		query.append("       A.JO_STL_CFM_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.BZC_PORT_ETA_DT,'YYYYMMDDHH24MISS') BZC_PORT_ETA_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.BZC_PORT_ETD_DT,'YYYYMMDDHH24MISS') BZC_PORT_ETD_DT," ).append("\n"); 
		query.append("       A.STL_PAIR_PORT_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.PAIR_PORT_ETA_DT,'YYYYMMDDHH24MISS') PAIR_PORT_ETA_DT," ).append("\n"); 
		query.append("       TO_CHAR(A.PAIR_PORT_ETD_DT,'YYYYMMDDHH24MISS') PAIR_PORT_ETD_DT," ).append("\n"); 
		query.append("       A.STL_RMK," ).append("\n"); 
		query.append("       A.ACCT_YRMON," ).append("\n"); 
		query.append("       A.STL_VVD_SEQ," ).append("\n"); 
		query.append("       A.TRD_CD," ).append("\n"); 
		query.append("       A.JO_CRR_CD," ).append("\n"); 
		query.append("       A.RLANE_CD," ).append("\n"); 
		query.append("       A.JO_MNU_NM," ).append("\n"); 
		query.append("       A.PROC_JB_FLG," ).append("\n"); 
		query.append("       A.RE_DIVR_CD," ).append("\n"); 
		query.append("       A.UC_BSS_PORT_CD," ).append("\n"); 
		query.append("       TO_CHAR(A.UC_BSS_PORT_ETD_DT,'YYYYMMDDHH24MISS') UC_BSS_PORT_ETD_DT" ).append("\n"); 
		query.append("FROM JOO_STL_VVD A" ).append("\n"); 
		query.append("WHERE	ACCT_YRMON = REPLACE(@[acct_yrmon],'-')" ).append("\n"); 
		query.append("AND	TRD_CD = @[trd_cd]" ).append("\n"); 
		query.append("AND	JO_CRR_CD = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND	RLANE_CD = @[rlane_cd]" ).append("\n"); 
		query.append("AND	RE_DIVR_CD = @[re_divr_cd]" ).append("\n"); 
		query.append("AND	JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 
		query.append("AND	JO_MNU_NM = @[jo_mnu_nm]" ).append("\n"); 
		query.append("AND	VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND	SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND	SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND	REV_DIR_CD = @[rev_dir_cd]" ).append("\n"); 
		query.append("#if (${ibflag} == 'U')" ).append("\n"); 
		query.append("AND STL_VVD_SEQ <> TO_NUMBER(@[stl_vvd_seq])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}