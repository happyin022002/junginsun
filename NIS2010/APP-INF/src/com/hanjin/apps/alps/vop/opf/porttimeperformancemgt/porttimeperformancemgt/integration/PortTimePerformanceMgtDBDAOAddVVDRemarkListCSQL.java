/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PortTimePerformanceMgtDBDAOAddVVDRemarkListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.01
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.02.01 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTimePerformanceMgtDBDAOAddVVDRemarkListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.06.08 허철용 [CHM-201217512-01] PTRP 화면에 Dashboard 기능 추가
	  * </pre>
	  */
	public PortTimePerformanceMgtDBDAOAddVVDRemarkListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_rhq_rmk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.integration").append("\n"); 
		query.append("FileName : PortTimePerformanceMgtDBDAOAddVVDRemarkListCSQL").append("\n"); 
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
		query.append("INSERT INTO OPF_PORT_TM_RMK" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    VSL_CD" ).append("\n"); 
		query.append("  , SKD_VOY_NO" ).append("\n"); 
		query.append("  , SKD_DIR_CD" ).append("\n"); 
		query.append("  , VPS_PORT_CD" ).append("\n"); 
		query.append("  , CLPT_IND_SEQ" ).append("\n"); 
		query.append("  , RHQ_CD" ).append("\n"); 
		query.append("  , SLAN_CD" ).append("\n"); 
		query.append("  , VVD_RMK" ).append("\n"); 
		query.append("  , VVD_RHQ_RMK	" ).append("\n"); 
		query.append("  , CRE_USR_ID" ).append("\n"); 
		query.append("  , CRE_DT" ).append("\n"); 
		query.append("  , UPD_USR_ID" ).append("\n"); 
		query.append("  , UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    @[vsl_cd]" ).append("\n"); 
		query.append("  , @[skd_voy_no]" ).append("\n"); 
		query.append("  , @[skd_dir_cd]" ).append("\n"); 
		query.append("  , @[vps_port_cd]" ).append("\n"); 
		query.append("  , @[clpt_ind_seq]" ).append("\n"); 
		query.append("  , @[rhq_cd]" ).append("\n"); 
		query.append("  , @[slan_cd]" ).append("\n"); 
		query.append("  , @[vvd_rmk]" ).append("\n"); 
		query.append("  , @[vvd_rhq_rmk]" ).append("\n"); 
		query.append("  , @[cre_usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append("  , @[upd_usr_id]" ).append("\n"); 
		query.append("  , SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}