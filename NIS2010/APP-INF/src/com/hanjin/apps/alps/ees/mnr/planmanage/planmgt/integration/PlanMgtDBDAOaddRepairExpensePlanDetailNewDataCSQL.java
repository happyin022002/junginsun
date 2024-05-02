/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PlanMgtDBDAOaddRepairExpensePlanDetailNewDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.07
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.08.07 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanMgtDBDAOaddRepairExpensePlanDetailNewDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SELOPB일때 최초 입력 데이터의 Detail 정보를 저장한다.
	  * </pre>
	  */
	public PlanMgtDBDAOaddRepairExpensePlanDetailNewDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_pln_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_pln_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration").append("\n"); 
		query.append("FileName : PlanMgtDBDAOaddRepairExpensePlanDetailNewDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_PLN_DTL (" ).append("\n"); 
		query.append("    		MNR_PLN_SEQ" ).append("\n"); 
		query.append("    		,	MNR_PLN_DTL_SEQ" ).append("\n"); 
		query.append("    		,	CTRL_OFC_CD" ).append("\n"); 
		query.append("    		,	EQ_TPSZ_CD" ).append("\n"); 
		query.append("    		,	EQ_QTY" ).append("\n"); 
		query.append("    		,	ACCT_CD" ).append("\n"); 
		query.append("    		,	MNR_PLN_AMT" ).append("\n"); 
		query.append("    		,	MNR_PLN_DTL_RMK" ).append("\n"); 
		query.append("    		,   OFC_TP_CD" ).append("\n"); 
		query.append("    		,	CRE_USR_ID " ).append("\n"); 
		query.append("    		,	CRE_DT" ).append("\n"); 
		query.append("    		,	UPD_USR_ID" ).append("\n"); 
		query.append("    		,	UPD_DT" ).append("\n"); 
		query.append("            ) VALUES(" ).append("\n"); 
		query.append("               (SELECT MNR_PLN_SEQ" ).append("\n"); 
		query.append("            	  FROM MNR_PLN_HDR" ).append("\n"); 
		query.append("            	 WHERE 1=1" ).append("\n"); 
		query.append("                   AND MNR_PLN_YR  = @[mnr_pln_yr]" ).append("\n"); 
		query.append("            	AND MNR_PLN_OFC_CD = @[ctrl_ofc_cd]" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("    		,	@[mnr_pln_dtl_seq]" ).append("\n"); 
		query.append("    		,	@[ctrl_ofc_cd]" ).append("\n"); 
		query.append("    		,	'D2' " ).append("\n"); 
		query.append("    		,	'1' " ).append("\n"); 
		query.append("    		,	@[acct_cd]" ).append("\n"); 
		query.append("    		,	 @[mnr_pln_amt] " ).append("\n"); 
		query.append("    		,	''   " ).append("\n"); 
		query.append("    		,   @[ofc_tp_cd]" ).append("\n"); 
		query.append("    		,	@[cre_usr_id]" ).append("\n"); 
		query.append("    		,	SYSDATE" ).append("\n"); 
		query.append("    		,	@[cre_usr_id]" ).append("\n"); 
		query.append("    		,	SYSDATE" ).append("\n"); 
		query.append("    		) " ).append("\n"); 

	}
}