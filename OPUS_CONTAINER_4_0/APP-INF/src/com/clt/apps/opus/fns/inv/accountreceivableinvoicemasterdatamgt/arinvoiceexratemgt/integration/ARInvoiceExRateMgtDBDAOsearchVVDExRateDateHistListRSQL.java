/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOsearchVVDExRateDateHistListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOsearchVVDExRateDateHistListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [] ARInvoiceExRateMgtDBDAO::searchVVDExRateDateList ( vvdExrateDateHisVO )
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOsearchVVDExRateDateHistListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOsearchVVDExRateDateHistListRSQL").append("\n"); 
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
		query.append("SELECT A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD_CD," ).append("\n"); 
		query.append("  A.VSL_CD," ).append("\n"); 
		query.append("  A.SKD_VOY_NO," ).append("\n"); 
		query.append("  A.SKD_DIR_CD," ).append("\n"); 
		query.append("  A.PORT_CD," ).append("\n"); 
		query.append("  DECODE(A.IO_BND_CD, 'O' , 'O/B', 'I', 'I/B') IO_BND_CD," ).append("\n"); 
		query.append("  A.SVC_SCP_CD," ).append("\n"); 
		query.append("  A.AR_OFC_CD," ).append("\n"); 
		query.append("  A.XCH_RT_DT," ).append("\n"); 
		query.append("  A.CNG_RMK," ).append("\n"); 
		query.append("  A.OP_STS_NM," ).append("\n"); 
		query.append("  A.CRE_USR_ID," ).append("\n"); 
		query.append("  TO_CHAR(A.LOCL_CRE_DT, 'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append("FROM INV_VVD_XCH_RT_DT_HIS A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${ar_ofc_cd} != '') " ).append("\n"); 
		query.append("  AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '') " ).append("\n"); 
		query.append("  AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${from_dt} != '' && ${to_dt} != '') " ).append("\n"); 
		query.append("  AND A.LOCL_CRE_DT BETWEEN TO_DATE(@[from_dt],'YYYY-MM-DD') AND TO_DATE(@[to_dt],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY CRE_DT DESC" ).append("\n"); 

	}
}