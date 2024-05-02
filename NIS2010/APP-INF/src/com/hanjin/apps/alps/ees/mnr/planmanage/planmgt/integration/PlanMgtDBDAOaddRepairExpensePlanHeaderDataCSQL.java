/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PlanMgtDBDAOaddRepairExpensePlanHeaderDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanMgtDBDAOaddRepairExpensePlanHeaderDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addRepairExpensePlanHeaderData insert
	  * </pre>
	  */
	public PlanMgtDBDAOaddRepairExpensePlanHeaderDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_pln_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_pln_grp_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_pln_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration").append("\n"); 
		query.append("FileName : PlanMgtDBDAOaddRepairExpensePlanHeaderDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_PLN_HDR (" ).append("\n"); 
		query.append("		   MNR_PLN_SEQ" ).append("\n"); 
		query.append("		,  EQ_KND_CD" ).append("\n"); 
		query.append("		,  MNR_GRP_TP_CD" ).append("\n"); 
		query.append("		,  MNR_PLN_GRP_NO" ).append("\n"); 
		query.append("		,  MNR_PLN_FLG" ).append("\n"); 
		query.append("		,  MNR_PLN_YR" ).append("\n"); 
		query.append("		,  MNR_PLN_OFC_CD" ).append("\n"); 
		query.append("		,  CRE_USR_ID" ).append("\n"); 
		query.append("		,  CRE_DT" ).append("\n"); 
		query.append("		,  UPD_USR_ID" ).append("\n"); 
		query.append("		,  UPD_DT" ).append("\n"); 
		query.append("		,  CURR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		) VALUES ( " ).append("\n"); 
		query.append("		    @[mnr_pln_seq]" ).append("\n"); 
		query.append("		,	'U' " ).append("\n"); 
		query.append("		,	'RPR'" ).append("\n"); 
		query.append("		,	@[mnr_pln_grp_no]" ).append("\n"); 
		query.append("		,	'N' " ).append("\n"); 
		query.append("		,	@[mnr_pln_yr]" ).append("\n"); 
		query.append("		,	@[mnr_pln_ofc_cd]" ).append("\n"); 
		query.append("		,	@[cre_usr_id]" ).append("\n"); 
		query.append("		,	SYSDATE " ).append("\n"); 
		query.append("		,	@[cre_usr_id]" ).append("\n"); 
		query.append("		,	SYSDATE  " ).append("\n"); 
		query.append("		,   'USD'" ).append("\n"); 
		query.append("		)			" ).append("\n"); 

	}
}