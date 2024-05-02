/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CIMCommonDBDAOModifyCntrTypeSizeDivUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.16
*@LastModifier : 김창헌
*@LastVersion : 1.0
* 2012.04.16 김창헌
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang Hun Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CIMCommonDBDAOModifyCntrTypeSizeDivUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CIM Container Type Size Division Modify
	  * </pre>
	  */
	public CIMCommonDBDAOModifyCntrTypeSizeDivUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.cim.cimcommon.cimcommon.integration ").append("\n"); 
		query.append("FileName : CIMCommonDBDAOModifyCntrTypeSizeDivUSQL").append("\n"); 
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
		query.append("UPDATE CIM_TP_SZ_DP_SEQ SET " ).append("\n"); 
		query.append("	CNTR_TPSZ_CD = @[cntr_tpsz_cd]," ).append("\n"); 
		query.append("    CNTR_TPSZ_DIV_CD = @[cntr_tpsz_div_cd]," ).append("\n"); 
		query.append("    UPD_OFC_CD = @[upd_ofc_cd]," ).append("\n"); 
		query.append("	UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("	UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE	DP_SEQ = @[dp_seq]" ).append("\n"); 

	}
}