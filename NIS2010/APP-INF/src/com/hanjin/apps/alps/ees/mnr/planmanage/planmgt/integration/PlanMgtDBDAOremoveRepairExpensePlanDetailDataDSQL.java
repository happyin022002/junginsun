/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PlanMgtDBDAOremoveRepairExpensePlanDetailDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.16
*@LastModifier : 한종희
*@LastVersion : 1.0
* 2014.06.16 한종희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Justin(Jonghee) HAN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanMgtDBDAOremoveRepairExpensePlanDetailDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * removeRepairExpensePlanDetailData delete
	  * -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * 2014-06-16 BY JUSTIN HAN CSR ID : CHM-201430738, TITLE ALPS MNR-General Performance에서 Local Currency-> USD로 변환하는 로직 수정 요청
	  *                   FIXED BUG DELETED BB OF HQ, HO DATA WHEN HQ, HO DATA MODIFICATION
	  * -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public PlanMgtDBDAOremoveRepairExpensePlanDetailDataDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("ofc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration").append("\n"); 
		query.append("FileName : PlanMgtDBDAOremoveRepairExpensePlanDetailDataDSQL").append("\n"); 
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
		query.append("#if(${delall} == 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DELETE FROM MNR_PLN_DTL" ).append("\n"); 
		query.append(" 	WHERE	1 =1 " ).append("\n"); 
		query.append("   	AND MNR_PLN_SEQ = @[mnr_pln_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	DELETE FROM MNR_PLN_DTL" ).append("\n"); 
		query.append(" 	WHERE	1 =1 " ).append("\n"); 
		query.append("   	AND MNR_PLN_SEQ = @[mnr_pln_seq]" ).append("\n"); 
		query.append("   	AND CTRL_OFC_CD = @[ctrl_ofc_cd]" ).append("\n"); 
		query.append("   	AND OFC_TP_CD   = @[ofc_tp_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}