/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOsearchVVDExRateDateListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.22 
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

public class ARInvoiceExRateMgtDBDAOsearchVVDExRateDateListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [] ARInvoiceExRateMgtDBDAO::searchVVDExRateDateList ( searchVVDExRateVOs )
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOsearchVVDExRateDateListRSQL(){
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
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOsearchVVDExRateDateListRSQL").append("\n"); 
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
		query.append("  A.CRE_USR_ID," ).append("\n"); 
		query.append("  TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("  A.UPD_USR_ID," ).append("\n"); 
		query.append("  TO_CHAR(A.UPD_DT, 'YYYY-MM-DD') UPD_DT," ).append("\n"); 
		query.append("  DECODE(A.IO_BND_CD, 'I', TO_CHAR(C.VPS_ETA_DT, 'YYYYMMDD'), TO_CHAR(C.VPS_ETD_DT, 'YYYYMMDD')) ETDA_DT," ).append("\n"); 
		query.append("  XCH_RT_DT," ).append("\n"); 
		query.append("  CNG_RMK," ).append("\n"); 
		query.append("  CNG_RMK ORG_RMK" ).append("\n"); 
		query.append("FROM INV_VVD_XCH_RT_DT A," ).append("\n"); 
		query.append("  VSK_VSL_PORT_SKD C" ).append("\n"); 
		query.append("WHERE A.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("  AND A.PORT_CD = C.VPS_PORT_CD" ).append("\n"); 
		query.append("  AND C.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("  AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("  AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("  AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("  AND A.AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
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