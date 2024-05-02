/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOSearchOriginAdjustHisSeqListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.14
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOSearchOriginAdjustHisSeqListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * get ORIGINAL ADJUST HISTORY SEQUENCE
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOSearchOriginAdjustHisSeqListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ots_his_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOSearchOriginAdjustHisSeqListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("    ADJ_HIS_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    SAR_ADJ_HIS" ).append("\n"); 
		query.append("WHERE  ADJ_NO = @[adj_no]" ).append("\n"); 
		query.append("AND OTS_HIS_SEQ = @[ots_his_seq]" ).append("\n"); 
		query.append("AND CHG_TP_CD = @[chg_tp_cd]" ).append("\n"); 
		query.append("AND ADJ_HIS_SEQ <> @[adj_his_seq]" ).append("\n"); 

	}
}