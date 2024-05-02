/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLIssuanceDBDAOGrpBlDtInRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOGrpBlDtInRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GrpBlDtIn
	  * 2011.04.11 이일민 [CHM-201109940-01] B/L Issue & Onboard date update 보완 요청
	  * 2011.04.25 이일민 [CHM-201110395] BL Issue & Onboard date update 화면 보완 요청
	  * </pre>
	  */
	public BLIssuanceDBDAOGrpBlDtInRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOGrpBlDtInRSQL").append("\n"); 
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
		query.append("select '' vvd" ).append("\n"); 
		query.append(",      '' pol_cd" ).append("\n"); 
		query.append(",      '' bkg_ofc_cd" ).append("\n"); 
		query.append(",      '' obl_iss_flg" ).append("\n"); 
		query.append(",      '' obl_rlse_flg" ).append("\n"); 
		query.append(",      '' shipper_cd" ).append("\n"); 
		query.append(",      '' ob_srep_cd" ).append("\n"); 
		query.append(",      '' act_arr_dt" ).append("\n"); 
		query.append(",      '' act_dep_dt" ).append("\n"); 
		query.append(",      '' chkd_iss" ).append("\n"); 
		query.append(",      '' pol_clpt_ind_seq" ).append("\n"); 
		query.append(",      '' act_arr_dt" ).append("\n"); 
		query.append(",      '' act_dep_dt" ).append("\n"); 
		query.append(",      '' bl_rdy_flg" ).append("\n"); 
		query.append("from dual" ).append("\n"); 

	}
}