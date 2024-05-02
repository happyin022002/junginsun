/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderMainDBDAOSearchEdi315SendingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderMainDBDAOSearchEdi315SendingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderMainDBDAOSearchEdi315SendingList
	  * </pre>
	  */
	public WorkOrderMainDBDAOSearchEdi315SendingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderMainDBDAOSearchEdi315SendingListRSQL").append("\n"); 
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
		query.append("SELECT B.COP_NO           as cop_no" ).append("\n"); 
		query.append("      ,B.COST_ACT_GRP_SEQ as cost_act_grp_seq" ).append("\n"); 
		query.append("      ,B.VNDR_SEQ         as vndr_seq" ).append("\n"); 
		query.append("	  ,B.TRSP_BND_CD      as bnd_cd" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD B" ).append("\n"); 
		query.append(" WHERE B.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND B.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("   AND B.TRSP_SO_STS_CD <> 'C'" ).append("\n"); 
		query.append("   AND B.COP_NO IS NOT NULL" ).append("\n"); 
		query.append("ORDER BY B.COP_NO ASC" ).append("\n"); 

	}
}