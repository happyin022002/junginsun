/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountDBDAOTaxDtlDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.22
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2016.04.22 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Ho Min
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnersAccountDBDAOTaxDtlDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Tax Detail 정보 삭제
	  * </pre>
	  */
	public OwnersAccountDBDAOTaxDtlDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ser_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_func_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_iss_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slp_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.ownersaccount.integration ").append("\n"); 
		query.append("FileName : OwnersAccountDBDAOTaxDtlDSQL").append("\n"); 
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
		query.append("DELETE FROM FMS_TAX_DTL F" ).append("\n"); 
		query.append("WHERE (F.TAX_INV_YRMON, F.OFC_CD, F.TAX_SER_NO) IN (" ).append("\n"); 
		query.append("         SELECT F.TAX_INV_YRMON, F.OFC_CD, F.TAX_SER_NO FROM FMS_TAX F" ).append("\n"); 
		query.append("         WHERE F.SLP_TP_CD||F.SLP_FUNC_CD||F.SLP_OFC_CD||F.SLP_ISS_DT||F.SLP_SER_NO = @[slp_tp_cd]||@[slp_func_cd]||@[slp_ofc_cd]||@[slp_iss_dt]||@[slp_ser_no]" ).append("\n"); 
		query.append("                                                   )" ).append("\n"); 

	}
}