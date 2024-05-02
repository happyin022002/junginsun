/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ExceptionAckRailRoadDBDAOMultiExceptionAckRailRoadVendorCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.exceptionackrailroad.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionAckRailRoadDBDAOMultiExceptionAckRailRoadVendorCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExceptionAckRailRoadDBDAOMultiExceptionAckRailRoadVendor
	  * </pre>
	  */
	public ExceptionAckRailRoadDBDAOMultiExceptionAckRailRoadVendorCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("expt_ack_rail_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.codemanage.exceptionackrailroad.integration").append("\n"); 
		query.append("FileName : ExceptionAckRailRoadDBDAOMultiExceptionAckRailRoadVendorCSQL").append("\n"); 
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
		query.append("MERGE INTO TRS_EXPT_ACK_RAIL_VNDR A" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("ON (A.EXPT_ACK_RAIL_VNDR_SEQ = @[expt_ack_rail_vndr_seq])" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("  UPDATE SET DELT_FLG   = DECODE(@[delt_flg], '1' , 'Y', 'N')" ).append("\n"); 
		query.append("  DELETE WHERE  (A.EXPT_ACK_RAIL_VNDR_SEQ = @[expt_ack_rail_vndr_seq])" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("  INSERT (" ).append("\n"); 
		query.append("	 EXPT_ACK_RAIL_VNDR_SEQ" ).append("\n"); 
		query.append("    ,VNDR_SEQ" ).append("\n"); 
		query.append("    ,DELT_FLG" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append("  ) VALUES (" ).append("\n"); 
		query.append("     @[expt_ack_rail_vndr_seq]" ).append("\n"); 
		query.append("    ,@[vndr_seq]" ).append("\n"); 
		query.append("    ,'N'" ).append("\n"); 
		query.append("    ,@[cre_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,@[upd_usr_id]" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}