/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TerminalProductivityDBDAOAddEGEVMappingCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.05
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalProductivityDBDAOAddEGEVMappingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Terminal Productivity Target Input 을 저장한다.
	  * </pre>
	  */
	public TerminalProductivityDBDAOAddEGEVMappingCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kpi_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_yr",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("kpi_tgt_rto",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.integration").append("\n"); 
		query.append("FileName : TerminalProductivityDBDAOAddEGEVMappingCSQL").append("\n"); 
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
		query.append("INSERT INTO SPE_EV_GRP_TML_PROD_TGT(EG_ID" ).append("\n"); 
		query.append("                                  , EG_TML_PROD_TGT_SEQ" ).append("\n"); 
		query.append("                                  , EV_YR" ).append("\n"); 
		query.append("                                  , SP_SEQ" ).append("\n"); 
		query.append("                                  , TML_CD" ).append("\n"); 
		query.append("                                  , KPI_TGT_RTO" ).append("\n"); 
		query.append("                                  , KPI_RMK" ).append("\n"); 
		query.append("                                  , CRE_USR_ID" ).append("\n"); 
		query.append("                                  , CRE_DT" ).append("\n"); 
		query.append("                                  , UPD_USR_ID" ).append("\n"); 
		query.append("                                  , UPD_DT " ).append("\n"); 
		query.append("                                  )VALUES(" ).append("\n"); 
		query.append("                                    @[eg_id]" ).append("\n"); 
		query.append("                                  , SPE_EV_GRP_TML_PROD_TGT_SEQ.NEXTVAL" ).append("\n"); 
		query.append("                                  , @[ev_yr]" ).append("\n"); 
		query.append("                                  , @[sp_seq]" ).append("\n"); 
		query.append("                                  , @[tml_cd]" ).append("\n"); 
		query.append("                                  , @[kpi_tgt_rto]" ).append("\n"); 
		query.append("                                  , @[kpi_rmk]" ).append("\n"); 
		query.append("                                  , @[cre_usr_id]" ).append("\n"); 
		query.append("                                  , SYSDATE" ).append("\n"); 
		query.append("                                  , @[upd_usr_id]" ).append("\n"); 
		query.append("                                  , SYSDATE" ).append("\n"); 
		query.append("                                  )" ).append("\n"); 

	}
}