/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOwrsFullBkgIRGVerifyResultLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2009.10.20 박연진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOwrsFullBkgIRGVerifyResultLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * wrsFullBkgIRGVerifyResultLog
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOwrsFullBkgIRGVerifyResultLogRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_org_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_dest_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.railbilling.requestcreation.integration ").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOwrsFullBkgIRGVerifyResultLogRSQL").append("\n"); 
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
		query.append("SELECT rout_org_nod_cd" ).append("\n"); 
		query.append(",rout_dest_nod_cd" ).append("\n"); 
		query.append(",rout_seq" ).append("\n"); 
		query.append(",wrs_full_cmdt_cd" ).append("\n"); 
		query.append(",pctl_io_bnd_cd" ).append("\n"); 
		query.append(",NVL(delt_flg, 'N') delt_flg" ).append("\n"); 
		query.append("FROM prd_inlnd_rout_mst mst" ).append("\n"); 
		query.append("WHERE rout_org_nod_cd  = @[rout_org_nod_cd]" ).append("\n"); 
		query.append("AND rout_dest_nod_cd = @[rout_dest_nod_cd]" ).append("\n"); 
		query.append("ORDER BY rout_org_nod_cd, rout_dest_nod_cd, rout_seq" ).append("\n"); 

	}
}