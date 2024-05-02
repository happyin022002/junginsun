/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOMergePsoChgXprDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.09.18 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOMergePsoChgXprDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_CHG_XPR_DTL <merge>
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOMergePsoChgXprDtlCSQL(){
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
		params.put("dflt_foml_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_xpr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uppr_chg_xpr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foml_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_ctrl_stmt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cond_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration ").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOMergePsoChgXprDtlCSQL").append("\n"); 
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
		query.append("MERGE INTO PSO_CHG_XPR_DTL A" ).append("\n"); 
		query.append("USING DUAL ON (    A.CHG_XPR_NO  = @[chg_xpr_no]" ).append("\n"); 
		query.append("AND A.CHG_XPR_SEQ = @[chg_xpr_seq])" ).append("\n"); 
		query.append("WHEN MATCHED" ).append("\n"); 
		query.append("THEN UPDATE SET" ).append("\n"); 
		query.append("A.PSO_CTRL_STMT_TP_CD   = @[pso_ctrl_stmt_tp_cd]" ).append("\n"); 
		query.append(",A.COND_NO               = @[cond_no]" ).append("\n"); 
		query.append(",A.DFLT_FOML_FLG         = @[dflt_foml_flg]" ).append("\n"); 
		query.append(",A.FOML_NO               = @[foml_no]" ).append("\n"); 
		query.append(",A.UPPR_CHG_XPR_SEQ      = @[uppr_chg_xpr_seq]" ).append("\n"); 
		query.append(",A.UPD_USR_ID            = @[cre_usr_id]" ).append("\n"); 
		query.append(",A.UPD_DT                = SYSDATE" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.CHG_XPR_NO  = @[chg_xpr_no]" ).append("\n"); 
		query.append("AND    A.CHG_XPR_SEQ = @[chg_xpr_seq]" ).append("\n"); 
		query.append("WHEN NOT MATCHED" ).append("\n"); 
		query.append("THEN INSERT (A.CHG_XPR_NO" ).append("\n"); 
		query.append(",A.CHG_XPR_SEQ" ).append("\n"); 
		query.append(",A.PSO_CTRL_STMT_TP_CD" ).append("\n"); 
		query.append(",A.COND_NO" ).append("\n"); 
		query.append(",A.DFLT_FOML_FLG" ).append("\n"); 
		query.append(",A.FOML_NO" ).append("\n"); 
		query.append(",A.UPPR_CHG_XPR_SEQ" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",A.CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",A.UPD_DT)" ).append("\n"); 
		query.append("VALUES (@[chg_xpr_no]" ).append("\n"); 
		query.append(",@[chg_xpr_seq]" ).append("\n"); 
		query.append(",@[pso_ctrl_stmt_tp_cd]" ).append("\n"); 
		query.append(",@[cond_no]" ).append("\n"); 
		query.append(",@[dflt_foml_flg]" ).append("\n"); 
		query.append(",@[foml_no]" ).append("\n"); 
		query.append(",@[uppr_chg_xpr_seq]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}