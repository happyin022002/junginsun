/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.04.30 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author saeil kim
 * @see 
 * @since J2EE 1.4
 */

public class ARInvoiceExRateMgtDBDAOSearchVVDexRateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ARInvoiceExRateMgtDBDAOSearchVVDexRateVORSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_curr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("select" ).append("\n"); 
		query.append("vsl_cd||skd_voy_no||skd_dir_cd vsl_cd," ).append("\n"); 
		query.append("skd_voy_no," ).append("\n"); 
		query.append("skd_dir_cd," ).append("\n"); 
		query.append("port_cd," ).append("\n"); 
		query.append("svc_scp_cd," ).append("\n"); 
		query.append("decode(io_bnd_cd,'I','I/B','O/B') io_bnd_cd," ).append("\n"); 
		query.append("locl_curr_cd," ).append("\n"); 
		query.append("chg_curr_cd," ).append("\n"); 
		query.append("a.ar_ofc_cd ar_ofc_cd," ).append("\n"); 
		query.append("decode(XCH_RT_RVS_FLG,'Y',ivs_xch_rt,inv_xch_rt) inv_xch_rt," ).append("\n"); 
		query.append("decode(XCH_RT_RVS_FLG,'Y',inv_xch_rt,ivs_xch_rt) ivs_xch_rt" ).append("\n"); 
		query.append("from inv_vvd_xch_rt a, inv_ar_stup_ofc b" ).append("\n"); 
		query.append("where a.AR_OFC_CD = b.AR_OFC_CD" ).append("\n"); 
		query.append("and	vsl_cd = @[vsl_cd]" ).append("\n"); 
		query.append("and skd_voy_no=@[skd_voy_no]" ).append("\n"); 
		query.append("and skd_dir_cd=@[skd_dir_cd]" ).append("\n"); 
		query.append("#if (${port_cd} != '')" ).append("\n"); 
		query.append("and	port_cd = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${locl_curr_cd} != '')" ).append("\n"); 
		query.append("and	locl_curr_cd = @[locl_curr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("and	svc_scp_cd = upper(@[svc_scp_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != '')" ).append("\n"); 
		query.append("and	io_bnd_cd = @[io_bnd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration").append("\n"); 
		query.append("FileName : ARInvoiceExRateMgtDBDAOSearchVVDexRateVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}