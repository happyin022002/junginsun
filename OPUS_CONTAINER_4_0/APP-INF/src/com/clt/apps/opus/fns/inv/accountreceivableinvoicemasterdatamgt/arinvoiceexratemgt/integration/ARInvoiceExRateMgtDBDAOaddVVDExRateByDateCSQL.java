/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ARInvoiceExRateMgtDBDAOaddVVDExRateByDateCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.15 
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

public class ARInvoiceExRateMgtDBDAOaddVVDExRateByDateCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * INV_VVD_XCH_RT
	  * [] ARInvoiceExRateMgtDBDAO::addVVDExRateByDate ( vvdExrateVos )
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOaddVVDExRateByDateCSQL(){
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
		params.put("xch_rt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : ARInvoiceExRateMgtDBDAOaddVVDExRateByDateCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_VVD_XCH_RT (" ).append("\n"); 
		query.append("	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	PORT_CD" ).append("\n"); 
		query.append(",	SVC_SCP_CD" ).append("\n"); 
		query.append(",	IO_BND_CD" ).append("\n"); 
		query.append(",	LOCL_CURR_CD" ).append("\n"); 
		query.append(",	CHG_CURR_CD " ).append("\n"); 
		query.append(",	AR_OFC_CD" ).append("\n"); 
		query.append(",	INV_XCH_RT" ).append("\n"); 
		query.append(",	IVS_XCH_RT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",   XCH_RT_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" ( SELECT" ).append("\n"); 
		query.append("	@[vsl_cd]" ).append("\n"); 
		query.append(",	@[skd_voy_no]" ).append("\n"); 
		query.append(",	@[skd_dir_cd]" ).append("\n"); 
		query.append(",	@[port_cd]" ).append("\n"); 
		query.append(",	@[svc_scp_cd]" ).append("\n"); 
		query.append(",	@[io_bnd_cd]" ).append("\n"); 
		query.append(",	LOCL_CURR_CD" ).append("\n"); 
		query.append(",	CHG_CURR_CD" ).append("\n"); 
		query.append(",	@[ar_ofc_cd]" ).append("\n"); 
		query.append(",	INV_XCH_RT" ).append("\n"); 
		query.append(",	IVS_XCH_RT" ).append("\n"); 
		query.append(",	'SYSTEM'" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	'SYSTEM'" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",   @[xch_rt_dt]" ).append("\n"); 
		query.append("  FROM INV_CUST_AND_DLY_XCH_RT" ).append("\n"); 
		query.append(" WHERE AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("   AND FM_DT = @[xch_rt_dt]" ).append("\n"); 
		query.append("   AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("   AND CUST_CNT_CD = 'XX'" ).append("\n"); 
		query.append("   AND CUST_SEQ = 0" ).append("\n"); 
		query.append("   AND XCH_RT_TP_CD = 'V'" ).append("\n"); 
		query.append(" )" ).append("\n"); 

	}
}