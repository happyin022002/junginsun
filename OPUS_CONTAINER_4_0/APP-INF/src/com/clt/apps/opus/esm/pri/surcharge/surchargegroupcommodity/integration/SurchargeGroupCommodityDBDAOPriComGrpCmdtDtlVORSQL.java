/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.14
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2010.05.14 문동규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Moon Dong Gyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * commodity detail select
	  * </pre>
	  */
	public SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_grp_cmdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.surcharge.surchargegroupcommodity.integration").append("\n"); 
		query.append("FileName : SurchargeGroupCommodityDBDAOPriComGrpCmdtDtlVORSQL").append("\n"); 
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
		query.append("SELECT A.SVC_SCP_CD" ).append("\n"); 
		query.append("     , A.CHG_CD" ).append("\n"); 
		query.append("     , A.SCG_GRP_CMDT_SEQ" ).append("\n"); 
		query.append("     , A.SCG_GRP_CMDT_DTL_SEQ" ).append("\n"); 
		query.append("     , A.CMDT_CD" ).append("\n"); 
		query.append("     , TO_CHAR(A.EFF_DT,'YYYY-MM-DD') AS EFF_DT" ).append("\n"); 
		query.append("     , TO_CHAR(A.EXP_DT,'YYYY-MM-DD') AS EXP_DT" ).append("\n"); 
		query.append("     , A.CRE_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(A.CRE_DT,'YYYY-MM-DD') AS CRE_DT" ).append("\n"); 
		query.append("     , A.UPD_USR_ID" ).append("\n"); 
		query.append("     , TO_CHAR(A.UPD_DT,'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append("     , NVL(B.CMDT_NM,'') AS CMDT_DES" ).append("\n"); 
		query.append("FROM PRI_SCG_GRP_CMDT_DTL A" ).append("\n"); 
		query.append("   , MDM_COMMODITY B" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND   A.CHG_CD = @[chg_cd]" ).append("\n"); 
		query.append("AND   A.SCG_GRP_CMDT_SEQ = @[scg_grp_cmdt_seq]" ).append("\n"); 
		query.append("AND   A.CMDT_CD = B.CMDT_CD(+)" ).append("\n"); 
		query.append("ORDER BY A.CMDT_CD" ).append("\n"); 

	}
}