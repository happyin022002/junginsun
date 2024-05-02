/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOSearchVVDExchangeRateInquiryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ARInvoiceExRateMgtDBDAOSearchVVDExchangeRateInquiryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOSearchVVDExchangeRateInquiryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chg_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOSearchVVDExchangeRateInquiryListRSQL").append("\n"); 
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
		query.append("  A.PORT_CD," ).append("\n"); 
		query.append("  DECODE(A.IO_BND_CD, 'O' , 'O/B', 'I', 'I/B') IO_BND_CD," ).append("\n"); 
		query.append("  A.SVC_SCP_CD," ).append("\n"); 
		query.append("  A.AR_OFC_CD," ).append("\n"); 
		query.append("  A.LOCL_CURR_CD," ).append("\n"); 
		query.append("  A.CHG_CURR_CD," ).append("\n"); 
		query.append("  A.INV_XCH_RT," ).append("\n"); 
		query.append("  A.IVS_XCH_RT," ).append("\n"); 
		query.append("  DECODE(A.IO_BND_CD, 'I', TO_CHAR(B.VPS_ETA_DT, 'YYYYMMDD'), TO_CHAR(B.VPS_ETD_DT, 'YYYYMMDD')) ETDA_DT" ).append("\n"); 
		query.append("FROM INV_VVD_XCH_RT A," ).append("\n"); 
		query.append("  VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("WHERE A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("  AND A.PORT_CD = B.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("  AND B.CLPT_IND_SEQ(+) = 1" ).append("\n"); 
		query.append("  AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#if (${chg_curr_cd} != '') " ).append("\n"); 
		query.append("  AND A.CHG_CURR_CD = @[chg_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${locl_curr_cd} != '') " ).append("\n"); 
		query.append("  AND A.LOCL_CURR_CD = @[locl_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${port_cd} != 'ALL') &&(${port_cd} != ''))" ).append("\n"); 
		query.append("  AND A.PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ((${svc_scp_cd} != 'ALL') &&(${svc_scp_cd} != ''))" ).append("\n"); 
		query.append("  AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != 'ALL')" ).append("\n"); 
		query.append("  AND A.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}