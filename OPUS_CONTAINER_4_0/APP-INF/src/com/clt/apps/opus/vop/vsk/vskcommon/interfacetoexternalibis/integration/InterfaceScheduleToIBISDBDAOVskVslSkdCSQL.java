/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceScheduleToIBISDBDAOVskVslSkdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceScheduleToIBISDBDAOVskVslSkdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ..
	  * </pre>
	  */
	public InterfaceScheduleToIBISDBDAOVskVslSkdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_port_brth_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibis_if_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_sts_mnl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pf_skd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("st_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.integration").append("\n"); 
		query.append("FileName : InterfaceScheduleToIBISDBDAOVskVslSkdCSQL").append("\n"); 
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
		query.append("#if (${if_mnpl_cd} == '')" ).append("\n"); 
		query.append("INSERT INTO VSK_VSL_SKD_IBIS_IF" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("      VSL_CD" ).append("\n"); 
		query.append("    , SKD_VOY_NO" ).append("\n"); 
		query.append("    , SKD_DIR_CD" ).append("\n"); 
		query.append("    , IBIS_IF_SEQ" ).append("\n"); 
		query.append("    , IF_SND_CD" ).append("\n"); 
		query.append("    , IF_MNPL_CD" ).append("\n"); 
		query.append("    , VSL_SLAN_CD" ).append("\n"); 
		query.append("    , SKD_STS_CD" ).append("\n"); 
		query.append("    , SKD_STS_MNL_FLG" ).append("\n"); 
		query.append("    , SKD_VOY_TP_CD" ).append("\n"); 
		query.append("    , PF_SKD_TP_CD" ).append("\n"); 
		query.append("    , ST_PORT_CD" ).append("\n"); 
		query.append("    , N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("    , ACT_CRR_CD" ).append("\n"); 
		query.append("    , SKD_RMK" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("      @[vsl_cd]" ).append("\n"); 
		query.append("    , @[skd_voy_no]" ).append("\n"); 
		query.append("    , @[skd_dir_cd]" ).append("\n"); 
		query.append("    , @[ibis_if_seq]" ).append("\n"); 
		query.append("    , NVL((SELECT /*+ INDEX_DESC(A XPKVSK_VSL_SKD_IBIS_IF) */ 'N'" ).append("\n"); 
		query.append("             FROM VSK_VSL_SKD_IBIS_IF A WHERE VSL_CD=@[vsl_cd] AND SKD_VOY_NO=@[skd_voy_no] AND SKD_DIR_CD=@[skd_dir_cd] AND IF_SND_CD='Y' AND ROWNUM=1) ,'X')" ).append("\n"); 
		query.append("    , 'D'" ).append("\n"); 
		query.append("    , @[vsl_slan_cd]" ).append("\n"); 
		query.append("    , @[skd_sts_cd]" ).append("\n"); 
		query.append("    , @[skd_sts_mnl_flg]" ).append("\n"); 
		query.append("    , @[skd_voy_tp_cd]" ).append("\n"); 
		query.append("    , @[pf_skd_tp_cd]" ).append("\n"); 
		query.append("    , @[st_port_cd]" ).append("\n"); 
		query.append("    , TO_DATE(@[n1st_port_brth_dt] , 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("    , @[act_crr_cd]" ).append("\n"); 
		query.append("    , @[skd_rmk]" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO VSK_VSL_SKD_IBIS_IF" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("      VSL_CD" ).append("\n"); 
		query.append("    , SKD_VOY_NO" ).append("\n"); 
		query.append("    , SKD_DIR_CD" ).append("\n"); 
		query.append("    , IBIS_IF_SEQ" ).append("\n"); 
		query.append("    , IF_SND_CD" ).append("\n"); 
		query.append("    , IF_MNPL_CD" ).append("\n"); 
		query.append("    , VSL_SLAN_CD" ).append("\n"); 
		query.append("    , SKD_STS_CD" ).append("\n"); 
		query.append("    , SKD_STS_MNL_FLG" ).append("\n"); 
		query.append("    , SKD_VOY_TP_CD" ).append("\n"); 
		query.append("    , PF_SKD_TP_CD" ).append("\n"); 
		query.append("    , ST_PORT_CD" ).append("\n"); 
		query.append("    , N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("    , ACT_CRR_CD" ).append("\n"); 
		query.append("    , SKD_RMK" ).append("\n"); 
		query.append("    , CRE_USR_ID" ).append("\n"); 
		query.append("    , CRE_DT" ).append("\n"); 
		query.append("    , UPD_USR_ID" ).append("\n"); 
		query.append("    , UPD_DT" ).append("\n"); 
		query.append(") " ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("      VSL_CD" ).append("\n"); 
		query.append("    , SKD_VOY_NO" ).append("\n"); 
		query.append("    , SKD_DIR_CD" ).append("\n"); 
		query.append("    , @[ibis_if_seq]" ).append("\n"); 
		query.append("    , 'N'" ).append("\n"); 
		query.append("    , 'I'" ).append("\n"); 
		query.append("    , VSL_SLAN_CD" ).append("\n"); 
		query.append("    , SKD_STS_CD" ).append("\n"); 
		query.append("    , SKD_STS_MNL_FLG" ).append("\n"); 
		query.append("    , SKD_VOY_TP_CD" ).append("\n"); 
		query.append("    , PF_SKD_TP_CD" ).append("\n"); 
		query.append("    , ST_PORT_CD" ).append("\n"); 
		query.append("    , N1ST_PORT_BRTH_DT" ).append("\n"); 
		query.append("    , ACT_CRR_CD" ).append("\n"); 
		query.append("    , SKD_RMK" ).append("\n"); 
		query.append("    , @[cre_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append("    , @[upd_usr_id]" ).append("\n"); 
		query.append("    , SYSDATE" ).append("\n"); 
		query.append(" FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("  AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}