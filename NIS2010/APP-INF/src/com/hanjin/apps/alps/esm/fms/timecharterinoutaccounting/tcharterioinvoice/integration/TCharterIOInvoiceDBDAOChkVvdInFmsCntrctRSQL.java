/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TCharterIOInvoiceDBDAOChkVvdInFmsCntrctRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.02
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDBDAOChkVvdInFmsCntrctRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FMS_CONTRACT의 용선 VVD Check
	  * </pre>
	  */
	public TCharterIOInvoiceDBDAOChkVvdInFmsCntrctRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDBDAOChkVvdInFmsCntrctRSQL").append("\n"); 
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
		query.append("SELECT 'OK' as CHK" ).append("\n"); 
		query.append("FROM AR_MST_REV_VVD A," ).append("\n"); 
		query.append("     FMS_CONTRACT B" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("  AND B.FLET_CTRT_TP_CD = 'TI'" ).append("\n"); 
		query.append("  AND B.FLET_CTRT_FACT_CD = 'ACT'" ).append("\n"); 
		query.append("  AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("  AND A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.RLANE_DIR_CD = @[vvd]" ).append("\n"); 
		query.append("  AND ROWNUM = 1" ).append("\n"); 

	}
}