/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChargeOfficeTransferMgtDBDAOCheckOfficeTransferHistoryByPartialPaymentRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.05
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2010.07.05 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeOfficeTransferMgtDBDAOCheckOfficeTransferHistoryByPartialPaymentRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChargeOfficeTransferMgtDBDAOCheckOfficeTransferHistoryByPartialPaymentRSQL
	  * </pre>
	  */
	public ChargeOfficeTransferMgtDBDAOCheckOfficeTransferHistoryByPartialPaymentRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_chg_loc_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.integration").append("\n"); 
		query.append("FileName : ChargeOfficeTransferMgtDBDAOCheckOfficeTransferHistoryByPartialPaymentRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("NVL(" ).append("\n"); 
		query.append("(SELECT	'Y'" ).append("\n"); 
		query.append("FROM	DMT_OFC_TRNS_HIS" ).append("\n"); 
		query.append("WHERE	CNTR_NO					= @[cntr_no]" ).append("\n"); 
		query.append("AND		CNTR_CYC_NO				= @[cntr_cyc_no]" ).append("\n"); 
		query.append("AND		DMDT_TRF_CD				= @[dmdt_trf_cd]" ).append("\n"); 
		query.append("AND		DMDT_CHG_LOC_DIV_CD		= @[dmdt_chg_loc_div_cd]" ).append("\n"); 
		query.append("AND		CHG_SEQ					= @[chg_seq]" ).append("\n"); 
		query.append("AND		ROWNUM = 1" ).append("\n"); 
		query.append("), 'N'" ).append("\n"); 
		query.append(") AS EXIST_YN" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}