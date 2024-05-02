/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EmptyReleaseRedeliveryOrderMgtDBDAOManageSettleIssuedOrderUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.30
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.01.30 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseRedeliveryOrderMgtDBDAOManageSettleIssuedOrderUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public EmptyReleaseRedeliveryOrderMgtDBDAOManageSettleIssuedOrderUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("empty_cy",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("type_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("so_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.integration").append("\n"); 
		query.append("FileName : EmptyReleaseRedeliveryOrderMgtDBDAOManageSettleIssuedOrderUSQL").append("\n"); 
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
		query.append("UPDATE CIM_CNTR_STK" ).append("\n"); 
		query.append("   SET STL_FLG = 'Y'," ).append("\n"); 
		query.append("       UPD_LOCL_DT = GLOBALDATE_PKG.TIME_LOCAL_FNC(SUBSTR (@[empty_cy], 0, 5 ))," ).append("\n"); 
		query.append("       UPD_USR_ID = @[user_id]," ).append("\n"); 
		query.append("       UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE STK_LOC_CD = SUBSTR (@[empty_cy], 1, 5)" ).append("\n"); 
		query.append("   AND STK_YD_CD = @[empty_cy]" ).append("\n"); 
		query.append("   AND STK_GATE_IO_CD = @[bd]" ).append("\n"); 
		query.append("   AND TRSP_SO_TP_CD = @[type_cd]" ).append("\n"); 
		query.append("   AND SO_OFC_CTY_CD = @[so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND SO_SEQ = @[so_seq]" ).append("\n"); 

	}
}