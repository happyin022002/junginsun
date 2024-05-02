/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOCopyPsoChgNoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOCopyPsoChgNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * pso charge table copy
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOCopyPsoChgNoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOCopyPsoChgNoCSQL").append("\n"); 
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
		query.append("INSERT INTO PSO_YD_CHG (" ).append("\n"); 
		query.append("	YD_CHG_NO" ).append("\n"); 
		query.append(",	YD_CHG_VER_SEQ" ).append("\n"); 
		query.append(",	LGS_COST_CD" ).append("\n"); 
		query.append(",	YD_CD" ).append("\n"); 
		query.append(",	VNDR_SEQ" ).append("\n"); 
		query.append(",	EFF_DT" ).append("\n"); 
		query.append(",	EXP_DT" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append(",	CPLS_FLG" ).append("\n"); 
		query.append(",	ORG_VNDR_NM" ).append("\n"); 
		query.append(",	RLT_AGMT_NO" ).append("\n"); 
		query.append(",	LST_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",   CRE_DT" ).append("\n"); 
		query.append(",   UPD_DT" ).append("\n"); 
		query.append(",	PORT_TRF_RMK" ).append("\n"); 
		query.append(",	PORT_TRF_URL  ) " ).append("\n"); 
		query.append("(  SELECT " ).append("\n"); 
		query.append("    @[new_yd_chg_no]  " ).append("\n"); 
		query.append(",   1" ).append("\n"); 
		query.append(",   @[cost_cd]  " ).append("\n"); 
		query.append(",   @[new_yd_cd] " ).append("\n"); 
		query.append(",   @[vndr_seq2]" ).append("\n"); 
		query.append(",   TO_DATE(TO_NUMBER(TO_CHAR(SYSDATE,'YYYY'))-1||'0101','YYYYMMDD')" ).append("\n"); 
		query.append(",   TO_DATE('99991231','YYYYMMDD')" ).append("\n"); 
		query.append(",   CURR_CD" ).append("\n"); 
		query.append(", 	CPLS_FLG" ).append("\n"); 
		query.append(",	ORG_VNDR_NM" ).append("\n"); 
		query.append(",	RLT_AGMT_NO" ).append("\n"); 
		query.append(",	LST_FLG" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",   SYSDATE" ).append("\n"); 
		query.append(",   SYSDATE" ).append("\n"); 
		query.append(",	PORT_TRF_RMK" ).append("\n"); 
		query.append(",	PORT_TRF_URL" ).append("\n"); 
		query.append("FROM PSO_YD_CHG" ).append("\n"); 
		query.append("WHERE YD_CD          = @[yd_cd]" ).append("\n"); 
		query.append("  AND LGS_COST_CD    = @[cost_cd]" ).append("\n"); 
		query.append("  --AND LST_FLG        = 'Y'" ).append("\n"); 
		query.append("  AND VNDR_SEQ       = @[vndr_seq]" ).append("\n"); 
		query.append("  AND YD_CHG_NO      = @[yd_chg_no]" ).append("\n"); 
		query.append("  AND YD_CHG_VER_SEQ =  @[yd_chg_ver_seq] )" ).append("\n"); 

	}
}