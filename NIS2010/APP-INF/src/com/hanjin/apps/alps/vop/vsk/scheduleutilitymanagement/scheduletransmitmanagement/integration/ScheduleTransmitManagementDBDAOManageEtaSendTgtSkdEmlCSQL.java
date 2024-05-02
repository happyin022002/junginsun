/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ScheduleTransmitManagementDBDAOManageEtaSendTgtSkdEmlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.24
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.12.24 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleTransmitManagementDBDAOManageEtaSendTgtSkdEmlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CHM-201221649-01 / ETA sending(Auto Fax)  황태진
	  * VSK_VSL_PORT_SKD_TRSM_EMAIL Insert
	  * </pre>
	  */
	public ScheduleTransmitManagementDBDAOManageEtaSendTgtSkdEmlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trsm_his_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_eml",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleutilitymanagement.scheduletransmitmanagement.integration").append("\n"); 
		query.append("FileName : ScheduleTransmitManagementDBDAOManageEtaSendTgtSkdEmlCSQL").append("\n"); 
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
		query.append("INSERT INTO VSK_VSL_PORT_SKD_TRSM_EML" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("   VSL_CD, " ).append("\n"); 
		query.append("   SKD_VOY_NO, " ).append("\n"); 
		query.append("   SKD_DIR_CD, " ).append("\n"); 
		query.append("   VPS_PORT_CD, " ).append("\n"); 
		query.append("   CLPT_IND_SEQ, " ).append("\n"); 
		query.append("   TRSM_HIS_SEQ, " ).append("\n"); 
		query.append("   EML_SEQ, " ).append("\n"); 
		query.append("   USR_EML, " ).append("\n"); 
		query.append("   CRE_USR_ID, " ).append("\n"); 
		query.append("   CRE_DT, " ).append("\n"); 
		query.append("   UPD_USR_ID, " ).append("\n"); 
		query.append("   UPD_DT" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("   @[vsl_cd], " ).append("\n"); 
		query.append("   @[skd_voy_no], " ).append("\n"); 
		query.append("   @[skd_dir_cd], " ).append("\n"); 
		query.append("   @[vps_port_cd], " ).append("\n"); 
		query.append("   @[clpt_ind_seq], " ).append("\n"); 
		query.append("   @[trsm_his_seq], " ).append("\n"); 
		query.append("   NVL((SELECT MAX(EML_SEQ) + 1" ).append("\n"); 
		query.append("     FROM VSK_VSL_PORT_SKD_TRSM_EML " ).append("\n"); 
		query.append("    WHERE 1 =1 " ).append("\n"); 
		query.append("      AND VSL_CD 	   = @[vsl_cd]" ).append("\n"); 
		query.append("      AND SKD_VOY_NO   = @[skd_voy_no]" ).append("\n"); 
		query.append("      AND SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("      AND CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("      AND TRSM_HIS_SEQ = @[trsm_his_seq]) , 1), " ).append("\n"); 
		query.append("   @[usr_eml], " ).append("\n"); 
		query.append("   @[cre_usr_id], " ).append("\n"); 
		query.append("   sysdate, " ).append("\n"); 
		query.append("   @[upd_usr_id], " ).append("\n"); 
		query.append("   sysdate" ).append("\n"); 
		query.append("   )" ).append("\n"); 

	}
}