/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanMgtDBDAOmodifyRepairExpensePlanDetailDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.06.30 정영훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.planmanage.planmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author chung young hun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanMgtDBDAOmodifyRepairExpensePlanDetailDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyRepairExpensePlanDetailData update
	  * </pre>
	  */
	public PlanMgtDBDAOmodifyRepairExpensePlanDetailDataUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_pln_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE MNR_PLN_DTL SET" ).append("\n"); 
		query.append("CTRL_OFC_CD = @[ctrl_ofc_cd]" ).append("\n"); 
		query.append(",	ACCT_CD = @[acct_cd]" ).append("\n"); 
		query.append(",	MNR_PLN_AMT = @[mnr_pln_amt]" ).append("\n"); 
		query.append(",	UPD_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE	MNR_PLN_SEQ = @[mnr_pln_seq]" ).append("\n"); 
		query.append("AND	MNR_PLN_DTL_SEQ = @[mnr_pln_dtl_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.planmanage.planmgt.integration ").append("\n"); 
		query.append("FileName : PlanMgtDBDAOmodifyRepairExpensePlanDetailDataUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}