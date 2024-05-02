/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOInvoiceDAOSearchOffhireSelectionListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.06.30 정윤태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JUNGYOONTAE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOInvoiceDAOSearchOffhireSelectionListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOInvoiceDAOSearchOffhireSelectionListRSQL
	  * </pre>
	  */
	public TCharterIOInvoiceDAOSearchOffhireSelectionListRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("TO_CHAR(EFF_DT,'YYYY-MM-DD HH24:MI') || ' ~ ' || TO_CHAR(EXP_DT,'YYYY-MM-DD HH24:MI') DURATION," ).append("\n"); 
		query.append("(SELECT" ).append("\n"); 
		query.append("INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD01523'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = FLET_OFFH_RSN_CD" ).append("\n"); 
		query.append("AND ROWNUM = 1) FLET_OFFH_RSN_NM," ).append("\n"); 
		query.append("FLET_OFFH_RSN_CD," ).append("\n"); 
		query.append("INV_SEQ," ).append("\n"); 
		query.append("(SELECT VSL_CD || SKD_VOY_NO || SKD_DIR_CD || REV_DIR_CD" ).append("\n"); 
		query.append("FROM FMS_INV_DTL" ).append("\n"); 
		query.append("WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND FLET_ISS_TP_CD = 'OFF'" ).append("\n"); 
		query.append("AND INV_SEQ = FI.INV_SEQ" ).append("\n"); 
		query.append("AND ROWNUM =1) BUNKER_VVD," ).append("\n"); 
		query.append("TO_CHAR(EFF_DT,'YYYY-MM-DD') EFF_DT," ).append("\n"); 
		query.append("TO_CHAR(EXP_DT,'YYYY-MM-DD') EXP_DT," ).append("\n"); 
		query.append("TO_CHAR(EFF_DT,'HH24:MI') FROM_TIME," ).append("\n"); 
		query.append("TO_CHAR(EXP_DT,'HH24:MI') TO_TIME," ).append("\n"); 
		query.append("TO_CHAR(INV_USD_DYS,'FM999,990.0000') INV_USD_DYS" ).append("\n"); 
		query.append("FROM  FMS_INVOICE FI" ).append("\n"); 
		query.append("WHERE  FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 
		query.append("AND  FLET_ISS_TP_CD = 'OFF'" ).append("\n"); 
		query.append("ORDER  BY INV_SEQ DESC" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.fms.timecharterinoutaccounting.tcharterioinvoice.integration").append("\n"); 
		query.append("FileName : TCharterIOInvoiceDAOSearchOffhireSelectionListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}