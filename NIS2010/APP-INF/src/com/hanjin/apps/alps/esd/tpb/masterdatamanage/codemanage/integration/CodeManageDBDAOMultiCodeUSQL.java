/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CodeManageDBDAOMultiCodeUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CodeManageDBDAOMultiCodeUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiCodeU
	  * </pre>
	  */
	public CodeManageDBDAOMultiCodeUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_tp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cml_sys_if_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_expn_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_expt_cs_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_if_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ida_sac_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n3pty_bil_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tpb.masterdatamanage.codemanage.integration").append("\n"); 
		query.append("FileName : CodeManageDBDAOMultiCodeUSQL").append("\n"); 
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
		query.append("UPDATE   TPB_N3RD_PTY_BIL_TP" ).append("\n"); 
		query.append("SET      N3PTY_EXPN_TP_CD = @[n3pty_expn_tp_cd]" ).append("\n"); 
		query.append("       , N3PTY_BIL_TP_NM = @[n3pty_bil_tp_nm]" ).append("\n"); 
		query.append("       , N3PTY_BIL_TP_DESC = @[n3pty_bil_tp_desc]" ).append("\n"); 
		query.append("	   , COP_EXPT_CS_CD =@[cop_expt_cs_cd]" ).append("\n"); 
		query.append("	   , CML_SYS_IF_CD = @[cml_sys_if_cd]" ).append("\n"); 
		query.append("	   , ACT_FLG = @[act_flg]" ).append("\n"); 
		query.append("	   , UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	   , UPD_DT = SYSDATE" ).append("\n"); 
		query.append("	   , N3PTY_IF_TP_CD = @[n3pty_if_tp_cd]" ).append("\n"); 
		query.append("       , CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("       , REV_ACCT_CD = ( SELECT NVL(MAX(M.HJS_CHG_ACCT_CD),@[rev_acct_cd]) FROM MDM_CHARGE M WHERE M.CHG_CD = @[chg_cd] )" ).append("\n"); 
		query.append("       , IDA_SAC_CD = @[ida_sac_cd]" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      N3PTY_BIL_TP_CD = @[n3pty_bil_tp_cd]" ).append("\n"); 

	}
}