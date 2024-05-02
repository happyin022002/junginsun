/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OfficeManageDBDAOMultiTPBOfficeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeManageDBDAOMultiTPBOfficeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiTPBOffice
	  * </pre>
	  */
	public OfficeManageDBDAOMultiTPBOfficeUSQL(){
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
		params.put("n3pty_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3pty_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_ofc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tpb.masterdatamanage.officemanage.integration").append("\n"); 
		query.append("FileName : OfficeManageDBDAOMultiTPBOfficeUSQL").append("\n"); 
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
		query.append("MERGE INTO tpb_hndl_ofc a " ).append("\n"); 
		query.append("    USING DUAL " ).append("\n"); 
		query.append("    ON ( a.n3pty_ofc_tp_cd = @[n3pty_ofc_tp_cd] " ).append("\n"); 
		query.append("        AND a.ofc_cd = @[ofc_cd] ) " ).append("\n"); 
		query.append("WHEN MATCHED THEN        " ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("    SET rhq_cd = @[rhq_cd]" ).append("\n"); 
		query.append("          ,n3pty_ctrl_ofc_cd = @[n3pty_ctrl_ofc_cd]" ).append("\n"); 
		query.append("          ,n3pty_ofc_cd = @[n3pty_ofc_cd]" ).append("\n"); 
		query.append("          ,n3pty_ar_ofc_cd = @[n3pty_ar_ofc_cd]" ).append("\n"); 
		query.append("          ,delt_flg = @[delt_flg]" ).append("\n"); 
		query.append("          ,upd_usr_id = @[upd_usr_id]" ).append("\n"); 
		query.append("          ,upd_dt= SYSDATE" ).append("\n"); 
		query.append("    WHERE n3pty_ofc_tp_cd = @[n3pty_ofc_tp_cd]" ).append("\n"); 
		query.append("    AND ofc_cd = @[ofc_cd]" ).append("\n"); 
		query.append("          " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT " ).append("\n"); 
		query.append("                (" ).append("\n"); 
		query.append("                 n3pty_ofc_tp_cd " ).append("\n"); 
		query.append("                ,ofc_cd" ).append("\n"); 
		query.append("                ,rhq_cd" ).append("\n"); 
		query.append("                ,n3pty_ctrl_ofc_cd" ).append("\n"); 
		query.append("                ,n3pty_ofc_cd" ).append("\n"); 
		query.append("                ,n3pty_ar_ofc_cd" ).append("\n"); 
		query.append("                ,delt_flg" ).append("\n"); 
		query.append("                ,cre_usr_id" ).append("\n"); 
		query.append("                ,cre_dt" ).append("\n"); 
		query.append("                ,upd_usr_id" ).append("\n"); 
		query.append("                ,upd_dt" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("         VALUES (" ).append("\n"); 
		query.append("                 @[n3pty_ofc_tp_cd]" ).append("\n"); 
		query.append("                ,@[ofc_cd]" ).append("\n"); 
		query.append("                ,@[rhq_cd]" ).append("\n"); 
		query.append("                ,@[n3pty_ctrl_ofc_cd]" ).append("\n"); 
		query.append("                ,@[n3pty_ofc_cd]" ).append("\n"); 
		query.append("                ,@[n3pty_ar_ofc_cd]" ).append("\n"); 
		query.append("                ,@[delt_flg]" ).append("\n"); 
		query.append("                ,@[upd_usr_id]" ).append("\n"); 
		query.append("                ,SYSDATE" ).append("\n"); 
		query.append("                ,@[upd_usr_id]" ).append("\n"); 
		query.append("                ,SYSDATE" ).append("\n"); 
		query.append("                )" ).append("\n"); 

	}
}