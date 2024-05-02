/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SceAdminManageDBDAOaddSceMngRplnCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SceAdminManageDBDAOaddSceMngRplnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * manual replan table에 대상을 INSERT 한다.
	  * </pre>
	  */
	public SceAdminManageDBDAOaddSceMngRplnCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpln_jb_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpln_scs_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.sceadminmanage.sceadminmanage.integration").append("\n"); 
		query.append("FileName : SceAdminManageDBDAOaddSceMngRplnCSQL").append("\n"); 
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
		query.append("MERGE INTO SCE_MNL_RPLN A" ).append("\n"); 
		query.append("USING (SELECT COP_NO FROM SCE_COP_HDR WHERE COP_NO = @[cop_no]) B" ).append("\n"); 
		query.append("   ON (A.COP_NO = B.COP_NO)" ).append("\n"); 
		query.append(" WHEN MATCHED THEN" ).append("\n"); 
		query.append(" UPDATE SET" ).append("\n"); 
		query.append("  A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append(", A.RPLN_SCS_FLG = @[rpln_scs_flg]" ).append("\n"); 
		query.append(", A.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append(", A.CRE_DT = SYSDATE" ).append("\n"); 
		query.append(", A.UPD_USR_ID = 'SYSTEM'" ).append("\n"); 
		query.append(", A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append(", A.RPLN_JB_TP_CD = @[rpln_jb_tp_cd]" ).append("\n"); 
		query.append(" WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append(" INSERT (" ).append("\n"); 
		query.append("  COP_NO" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", RPLN_SCS_FLG" ).append("\n"); 
		query.append(", PCTL_NO" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", RPLN_JB_TP_CD" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("  @[cop_no]" ).append("\n"); 
		query.append(", @[io_bnd_cd]" ).append("\n"); 
		query.append(", @[rpln_scs_flg]" ).append("\n"); 
		query.append(", @[pctl_no]" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", 'SYSTEM'" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[rpln_jb_tp_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}