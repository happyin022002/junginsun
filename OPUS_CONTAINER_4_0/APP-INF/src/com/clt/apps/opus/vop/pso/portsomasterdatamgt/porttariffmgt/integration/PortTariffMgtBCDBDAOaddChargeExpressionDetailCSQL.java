/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOaddChargeExpressionDetailCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.25 박명종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author myoungjong park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOaddChargeExpressionDetailCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pso_chg_xpr_dtl 테이블 입력
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOaddChargeExpressionDetailCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
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

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_xpr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("uppr_chg_xpr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
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

		tmp = java.sql.Types.NUMERIC + ",N";
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
		query.append("INSERT INTO PSO_CHG_XPR_DTL (" ).append("\n"); 
		query.append("CHG_XPR_NO" ).append("\n"); 
		query.append(",	CHG_XPR_SEQ" ).append("\n"); 
		query.append(",	PSO_CTRL_STMT_TP_CD" ).append("\n"); 
		query.append(",	COND_NO" ).append("\n"); 
		query.append(",	DFLT_FOML_FLG" ).append("\n"); 
		query.append(",	FOML_NO" ).append("\n"); 
		query.append(",	UPPR_CHG_XPR_SEQ" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[chg_xpr_no]" ).append("\n"); 
		query.append(",	@[chg_xpr_seq]" ).append("\n"); 
		query.append(",	@[pso_ctrl_stmt_tp_cd]" ).append("\n"); 
		query.append(",	@[cond_no]" ).append("\n"); 
		query.append(",	@[dflt_foml_flg]" ).append("\n"); 
		query.append(",	@[foml_no]" ).append("\n"); 
		query.append(",	@[uppr_chg_xpr_seq]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOaddChargeExpressionDetailCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}