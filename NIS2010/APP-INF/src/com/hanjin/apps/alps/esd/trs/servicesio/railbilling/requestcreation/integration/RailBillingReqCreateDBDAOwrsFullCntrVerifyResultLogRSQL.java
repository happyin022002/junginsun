/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RailBillingReqCreateDBDAOwrsFullCntrVerifyResultLogRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.06
*@LastModifier : 박연진
*@LastVersion : 1.0
* 2009.11.06 박연진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailBillingReqCreateDBDAOwrsFullCntrVerifyResultLogRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * wrsFullCntrVerifyResultLog
	  * </pre>
	  */
	public RailBillingReqCreateDBDAOwrsFullCntrVerifyResultLogRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.railbilling.requestcreation.integration").append("\n"); 
		query.append("FileName : RailBillingReqCreateDBDAOwrsFullCntrVerifyResultLogRSQL").append("\n"); 
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
		query.append("SELECT hdr.cop_no" ).append("\n"); 
		query.append(",grp.pctl_no" ).append("\n"); 
		query.append(",grp.cost_act_grp_seq" ).append("\n"); 
		query.append(",grp.n1st_nod_cd" ).append("\n"); 
		query.append(",grp.n2nd_nod_cd" ).append("\n"); 
		query.append(",grp.n3rd_nod_cd" ).append("\n"); 
		query.append(",grp.n4th_nod_cd" ).append("\n"); 
		query.append(",grp.rout_org_nod_cd" ).append("\n"); 
		query.append(",grp.rout_dest_nod_cd" ).append("\n"); 
		query.append(",grp.rout_seq" ).append("\n"); 
		query.append("FROM SCE_COP_HDR hdr" ).append("\n"); 
		query.append(",PRD_PROD_CTL_ACT_GRP_DTL grp" ).append("\n"); 
		query.append(",SCE_PLN_SO_LIST pln" ).append("\n"); 
		query.append("WHERE hdr.cop_no = pln.cop_no" ).append("\n"); 
		query.append("AND hdr.pctl_no = grp.pctl_no" ).append("\n"); 
		query.append("#if ($actGrpKey.size() > 0)" ).append("\n"); 
		query.append("AND hdr.cop_no in(" ).append("\n"); 
		query.append("#foreach( ${key} in ${actGrpKey})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("'$key.velParamField1'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",'$key.velParamField1'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND(pln.cop_no, pln.COST_ACT_GRP_SEQ) IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${actGrpKey})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("('$key.velParamField1','$key.velParamField2')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(",('$key.velParamField1','$key.velParamField2')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}