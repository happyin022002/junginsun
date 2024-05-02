/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderMainDBDAOModifyTrsTrspSvcOrdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.22 
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

public class WorkOrderMainDBDAOModifyTrsTrspSvcOrdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderMainDBDAOModifyTrsTrspSvcOrd
	  * </pre>
	  */
	public WorkOrderMainDBDAOModifyTrsTrspSvcOrdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("apnt_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trs_sub_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderMainDBDAOModifyTrsTrspSvcOrdUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD T" ).append("\n"); 
		query.append("   SET TRS_SUB_STS_CD 	= NVL(@[trs_sub_sts_cd], TRS_SUB_STS_CD)" ).append("\n"); 
		query.append("	  ,APNT_DT 		  	= NVL(TO_DATE(@[apnt_dt], 'YYYYMMDDHH24MISS'), APNT_DT)" ).append("\n"); 
		query.append("      ,DE_DT 		  	= NVL(TO_DATE(@[de_dt], 'YYYYMMDDHH24MISS'), DE_DT)" ).append("\n"); 
		query.append("      ,LOCL_UPD_DT   	= GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(T.CRE_OFC_CD)" ).append("\n"); 
		query.append("      ,UPD_USR_ID     	= 'EDIUSER'" ).append("\n"); 
		query.append("      ,UPD_DT         	= SYSDATE" ).append("\n"); 
		query.append(" WHERE TRSP_SO_OFC_CTY_CD 	= @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND TRSP_SO_SEQ 			= @[trsp_so_seq]" ).append("\n"); 

	}
}