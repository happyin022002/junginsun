/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WorkOrderMainDBDAOInsertTrsSubStsHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.25 
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

public class WorkOrderMainDBDAOInsertTrsSubStsHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderMainDBDAOInsertTrsSubStsHis
	  * </pre>
	  */
	public WorkOrderMainDBDAOInsertTrsSubStsHisCSQL(){
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
		params.put("trs_sub_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderMainDBDAOInsertTrsSubStsHisCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_SUB_STS_HIS (" ).append("\n"); 
		query.append("   TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("  ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("  ,HIS_SEQ" ).append("\n"); 
		query.append("  ,PRE_TRSP_SUB_STS_CD" ).append("\n"); 
		query.append("  ,CRNT_TRSP_SUB_STS_CD" ).append("\n"); 
		query.append("  ,CRE_USR_ID" ).append("\n"); 
		query.append("  ,CRE_DT" ).append("\n"); 
		query.append("  ,UPD_USR_ID" ).append("\n"); 
		query.append("  ,UPD_DT" ).append("\n"); 
		query.append(" ) " ).append("\n"); 
		query.append(" SELECT TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("        ,TRS_SUB_STS_HIS_SEQ1.NEXTVAL" ).append("\n"); 
		query.append("        ,SO.TRS_SUB_STS_CD" ).append("\n"); 
		query.append("        ,@[trs_sub_sts_cd]" ).append("\n"); 
		query.append("        ,'EDIUSER'" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("        ,'EDIUSER'" ).append("\n"); 
		query.append("        ,SYSDATE" ).append("\n"); 
		query.append("    FROM TRS_TRSP_SVC_ORD SO" ).append("\n"); 
		query.append("   WHERE SO.TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("     AND SO.TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 
		query.append("     AND NVL(SO.TRS_SUB_STS_CD, 'X') <> NVL(@[trs_sub_sts_cd], 'X')" ).append("\n"); 

	}
}