/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOMergePsoChgXprCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.09.18 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOMergePsoChgXprCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_CHG_XPR <merge>
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOMergePsoChgXprCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_xpr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dflt_xpr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xpr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_xpr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_mnu_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_chg_xpr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dflt_sys_xpr_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOMergePsoChgXprCSQL").append("\n"); 
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
		query.append("MERGE INTO PSO_CHG_XPR A" ).append("\n"); 
		query.append("USING DUAL ON (A.CHG_XPR_NO = @[chg_xpr_no])" ).append("\n"); 
		query.append("WHEN MATCHED" ).append("\n"); 
		query.append("THEN UPDATE SET" ).append("\n"); 
		query.append("A.PSO_CHG_XPR_TP_CD   = @[pso_chg_xpr_tp_cd]" ).append("\n"); 
		query.append(",A.XPR_DESC            = @[xpr_desc]" ).append("\n"); 
		query.append(",A.DFLT_XPR_DESC       = @[dflt_xpr_desc]" ).append("\n"); 
		query.append(",A.SYS_XPR_DESC        = @[sys_xpr_desc]" ).append("\n"); 
		query.append(",A.DFLT_SYS_XPR_DESC   = @[dflt_sys_xpr_desc]" ).append("\n"); 
		query.append(",A.UPD_MNU_NO          = @[upd_mnu_no]" ).append("\n"); 
		query.append(",A.UPD_USR_ID          = @[cre_usr_id]" ).append("\n"); 
		query.append(",A.UPD_DT              = SYSDATE" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.CHG_XPR_NO = @[chg_xpr_no]" ).append("\n"); 
		query.append("WHEN NOT MATCHED" ).append("\n"); 
		query.append("THEN INSERT (A.CHG_XPR_NO" ).append("\n"); 
		query.append(",A.PSO_CHG_XPR_TP_CD" ).append("\n"); 
		query.append(",A.XPR_DESC" ).append("\n"); 
		query.append(",A.DFLT_XPR_DESC" ).append("\n"); 
		query.append(",A.SYS_XPR_DESC" ).append("\n"); 
		query.append(",A.DFLT_SYS_XPR_DESC" ).append("\n"); 
		query.append(",A.UPD_MNU_NO" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT)" ).append("\n"); 
		query.append("VALUES (@[chg_xpr_no]" ).append("\n"); 
		query.append(",@[pso_chg_xpr_tp_cd]" ).append("\n"); 
		query.append(",@[xpr_desc]" ).append("\n"); 
		query.append(",@[dflt_xpr_desc]" ).append("\n"); 
		query.append(",@[sys_xpr_desc]" ).append("\n"); 
		query.append(",@[dflt_sys_xpr_desc]" ).append("\n"); 
		query.append(",@[upd_mnu_no]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}