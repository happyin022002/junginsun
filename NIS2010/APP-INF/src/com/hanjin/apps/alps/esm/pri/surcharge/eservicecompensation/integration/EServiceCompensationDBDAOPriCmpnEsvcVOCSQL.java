/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EServiceCompensationDBDAOPriCmpnEsvcVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.04.29 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EServiceCompensationDBDAOPriCmpnEsvcVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * E-SVC Compensation 데이터 입력
	  * </pre>
	  */
	public EServiceCompensationDBDAOPriCmpnEsvcVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dc_per",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_rgn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cmpn_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmpn_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prc_ctrt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.integration").append("\n"); 
		query.append("FileName : EServiceCompensationDBDAOPriCmpnEsvcVOCSQL").append("\n"); 
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
		query.append("INSERT INTO PRI_CMPN_ESVC (" ).append("\n"); 
		query.append("    SVC_SCP_CD" ).append("\n"); 
		query.append(",   CMPN_SEQ" ).append("\n"); 
		query.append(",   ORG_RGN_CD" ).append("\n"); 
		query.append(",   DEST_RGN_CD" ).append("\n"); 
		query.append(",   PRC_CTRT_TP_CD" ).append("\n"); 
		query.append(",   SC_NO" ).append("\n"); 
		query.append(",   RFA_NO" ).append("\n"); 
		query.append(",   CHG_CD" ).append("\n"); 
		query.append(",   CURR_CD" ).append("\n"); 
		query.append(",   FLT_PCT_TP_CD" ).append("\n"); 
		query.append(",   DC_AMT" ).append("\n"); 
		query.append(",   EFF_DT" ).append("\n"); 
		query.append(",   EXP_DT" ).append("\n"); 
		query.append(",   CMPN_RMK" ).append("\n"); 
		query.append(",   CRE_USR_ID" ).append("\n"); 
		query.append(",   CRE_DT" ).append("\n"); 
		query.append(",   UPD_USR_ID" ).append("\n"); 
		query.append(",   UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("    @[svc_scp_cd]" ).append("\n"); 
		query.append(",   @[cmpn_seq]" ).append("\n"); 
		query.append(",   @[org_rgn_cd]" ).append("\n"); 
		query.append(",   @[dest_rgn_cd]" ).append("\n"); 
		query.append(",   @[prc_ctrt_tp_cd]" ).append("\n"); 
		query.append(",   @[sc_no]" ).append("\n"); 
		query.append(",   @[rfa_no]" ).append("\n"); 
		query.append(",   @[chg_cd]" ).append("\n"); 
		query.append(",   @[curr_cd]" ).append("\n"); 
		query.append(",   DECODE(LENGTH(TRIM(@[curr_cd])),0,'P','F')" ).append("\n"); 
		query.append(",   NVL2(@[curr_cd],@[dc_amt],@[dc_per])" ).append("\n"); 
		query.append(",   TO_DATE(@[eff_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",   TO_DATE(@[exp_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",   @[cmpn_rmk]" ).append("\n"); 
		query.append(",   @[cre_usr_id]" ).append("\n"); 
		query.append(",   SYSDATE" ).append("\n"); 
		query.append(",   @[upd_usr_id]" ).append("\n"); 
		query.append(",   SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}