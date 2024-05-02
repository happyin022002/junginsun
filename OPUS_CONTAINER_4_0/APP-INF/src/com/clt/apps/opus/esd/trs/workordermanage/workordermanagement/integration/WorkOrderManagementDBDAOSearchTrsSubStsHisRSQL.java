/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderManagementDBDAOSearchTrsSubStsHisRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderManagementDBDAOSearchTrsSubStsHisRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderManagementDBDAOSearchTrsSubStsHis
	  * </pre>
	  */
	public WorkOrderManagementDBDAOSearchTrsSubStsHisRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.integration").append("\n"); 
		query.append("FileName : WorkOrderManagementDBDAOSearchTrsSubStsHisRSQL").append("\n"); 
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
		query.append("SELECT A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("      ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("	  ,A.TRSP_SO_OFC_CTY_CD || A.TRSP_SO_SEQ TRSP_SO_OFC_CTY_CD_SEQ" ).append("\n"); 
		query.append("      ,A.HIS_SEQ" ).append("\n"); 
		query.append("      ,ROW_NUMBER() OVER(PARTITION BY A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ ORDER BY A.HIS_SEQ DESC) SRCH_SEQ" ).append("\n"); 
		query.append("      ,A.PRE_TRSP_SUB_STS_CD" ).append("\n"); 
		query.append("	  ,DECODE(A.PRE_TRSP_SUB_STS_CD, 'DF', 'Draft', 'OR','Ordered', 'ST', 'Started', 'AC', 'Accepted', 'CM', 'Completed') PRE_TRSP_SUB_STS_CD_NM" ).append("\n"); 
		query.append("      ,A.CRNT_TRSP_SUB_STS_CD" ).append("\n"); 
		query.append("	  ,DECODE(A.CRNT_TRSP_SUB_STS_CD, 'DF', 'Draft', 'OR','Ordered', 'ST', 'Started', 'AC', 'Accepted', 'CM', 'Completed') CRNT_TRSP_SUB_STS_CD_NM" ).append("\n"); 
		query.append("      ,A.CRE_USR_ID" ).append("\n"); 
		query.append("      ,B.USR_NM CRE_USR_NM" ).append("\n"); 
		query.append("      ,SO.CRE_OFC_CD" ).append("\n"); 
		query.append("	  ,TO_CHAR(opusadm.globaldate_pkg.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(), A.CRE_DT, opusadm.globaldate_pkg.GET_LOCCD_FNC(@[loc_ofc_cd])), 'YYYY-MM-DD HH24:MI:SS')  LOC_CRE_DT" ).append("\n"); 
		query.append("	  ,TO_CHAR(opusadm.globaldate_pkg.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(), A.CRE_DT, 'GMT'), 'YYYY-MM-DD HH24:MI:SS') GMT_CRE_DT" ).append("\n"); 
		query.append("  FROM TRS_SUB_STS_HIS A" ).append("\n"); 
		query.append("      ,COM_USER        B" ).append("\n"); 
		query.append("	  ,TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("	 AND A.TRSP_SO_OFC_CTY_CD = SO.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("	 AND A.TRSP_SO_SEQ = SO.TRSP_SO_SEQ" ).append("\n"); 
		query.append("	 AND A.CRE_USR_ID = B.USR_ID(+)" ).append("\n"); 
		query.append("  	 AND (" ).append("\n"); 
		query.append("  #foreach( ${key} in ${voList})" ).append("\n"); 
		query.append("	(A.TRSP_SO_OFC_CTY_CD = '${key.trspSoOfcCtyCd}' AND A.TRSP_SO_SEQ = '${key.trspSoSeq}')   " ).append("\n"); 
		query.append("	#if ($velocityCount < $voList.size())" ).append("\n"); 
		query.append("		OR " ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("  #end " ).append("\n"); 
		query.append("  	)" ).append("\n"); 
		query.append(" 	ORDER BY A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("         ,A.TRSP_SO_SEQ" ).append("\n"); 
		query.append("         ,A.HIS_SEQ DESC" ).append("\n"); 

	}
}