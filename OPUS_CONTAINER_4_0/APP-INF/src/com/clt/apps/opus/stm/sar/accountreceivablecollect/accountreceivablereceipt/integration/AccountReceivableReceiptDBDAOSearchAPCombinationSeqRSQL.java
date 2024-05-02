/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableReceiptDBDAOSearchAPCombinationSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableReceiptDBDAOSearchAPCombinationSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search AP combination sequence
	  * </pre>
	  */
	public AccountReceivableReceiptDBDAOSearchAPCombinationSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clr_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pay_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ap_ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_cd_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration").append("\n"); 
		query.append("FileName : AccountReceivableReceiptDBDAOSearchAPCombinationSeqRSQL").append("\n"); 
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
		query.append("SELECT SLC2.CD_CMB_SEQ" ).append("\n"); 
		query.append("FROM SCO_LEGR_CD_CMB SLC1," ).append("\n"); 
		query.append("     SCO_LEGR_CD_CMB SLC2" ).append("\n"); 
		query.append("WHERE SLC1.SGM_CTNT1 = SLC2.SGM_CTNT1" ).append("\n"); 
		query.append("AND SLC1.SGM_CTNT2 = SLC2.SGM_CTNT2" ).append("\n"); 
		query.append("#if(${ap_if_tbl_tp_cd} == 'HEADER')" ).append("\n"); 
		query.append("	AND SLC2.SGM_CTNT3 = @[ap_ctr_cd]" ).append("\n"); 
		query.append("	AND SLC2.SGM_CTNT4 = @[pay_acct_cd]" ).append("\n"); 
		query.append("	AND SLC2.SGM_CTNT5 = @[inter_co_cd]" ).append("\n"); 
		query.append("#elseif(${ap_if_tbl_tp_cd} == 'LINE')" ).append("\n"); 
		query.append("	AND SLC1.SGM_CTNT3 = SLC2.SGM_CTNT3" ).append("\n"); 
		query.append("	AND SLC2.SGM_CTNT4 = @[clr_acct_cd]" ).append("\n"); 
		query.append("	AND SLC1.SGM_CTNT5 = SLC2.SGM_CTNT5" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND SLC1.CD_CMB_SEQ = @[rcv_cd_cmb_seq]          " ).append("\n"); 
		query.append("#if(${acct_ctnt3} == 'COM')" ).append("\n"); 
		query.append("	AND SLC2.SGM_CTNT6 = 'CNTC0000MM'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND SLC1.SGM_CTNT6 = SLC2.SGM_CTNT6" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}