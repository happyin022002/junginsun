/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PaymentInvoiceDBDAOSearchArRevenueVVDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.03.10 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PaymentInvoiceDBDAOSearchArRevenueVVDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 재무 항차 정보 취득
	  * </pre>
	  */
	public PaymentInvoiceDBDAOSearchArRevenueVVDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.integration").append("\n"); 
		query.append("FileName : PaymentInvoiceDBDAOSearchArRevenueVVDRSQL").append("\n"); 
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
		query.append("    VSL_CD" ).append("\n"); 
		query.append("  , SKD_VOY_NO" ).append("\n"); 
		query.append("  , SKD_DIR_CD" ).append("\n"); 
		query.append("  , RLANE_DIR_CD" ).append("\n"); 
		query.append("  , VOY_TP_CD" ).append("\n"); 
		query.append("  , SLAN_CD" ).append("\n"); 
		query.append("  , PORT_CHK_FLG" ).append("\n"); 
		query.append("  , REV_PORT_CD" ).append("\n"); 
		query.append("  , LOD_QTY" ).append("\n"); 
		query.append("  , REV_YRMON" ).append("\n"); 
		query.append("  , COM_VVD_FLG" ).append("\n"); 
		query.append("  , VVD_COM_LVL" ).append("\n"); 
		query.append("  , RLANE_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    AR_MST_REV_VVD" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("    VSL_CD         = @[vsl_cd]" ).append("\n"); 
		query.append("    AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("    AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("    AND SLAN_CD    = @[slan_cd]" ).append("\n"); 
		query.append("    AND DELT_FLG   = 'N'" ).append("\n"); 

	}
}