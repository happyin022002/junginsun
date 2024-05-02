/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOModifyFmsCsulSlpUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.01 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOModifyFmsCsulSlpUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public OwnersAccountDBDAOModifyFmsCsulSlpUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("csr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOModifyFmsCsulSlpUSQL").append("\n"); 
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
		query.append("UPDATE FMS_CSUL_SLP" ).append("\n"); 
		query.append(" SET PAIR_SLP_TP_CD = ''," ).append("\n"); 
		query.append("     PAIR_SLP_FUNC_CD = ''," ).append("\n"); 
		query.append("     PAIR_SLP_OFC_CD = ''," ).append("\n"); 
		query.append("     PAIR_SLP_ISS_DT = ''," ).append("\n"); 
		query.append("     PAIR_SLP_SER_NO = ''," ).append("\n"); 
		query.append("     PAIR_SLP_SEQ_NO = ''" ).append("\n"); 
		query.append(" WHERE SLP_TP_CD||SLP_FUNC_CD||SLP_OFC_CD||SLP_ISS_DT||SLP_SER_NO||SLP_SEQ_NO  = @[csr_no]" ).append("\n"); 

	}
}