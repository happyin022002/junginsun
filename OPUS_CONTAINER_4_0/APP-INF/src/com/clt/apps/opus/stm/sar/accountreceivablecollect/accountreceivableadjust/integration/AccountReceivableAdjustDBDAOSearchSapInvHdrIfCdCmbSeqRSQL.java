/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOSearchSapInvHdrIfCdCmbSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.08.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.08.18 
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

public class AccountReceivableAdjustDBDAOSearchSapInvHdrIfCdCmbSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * get Code Combinatino Sequence No for AP HDR IF
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOSearchSapInvHdrIfCdCmbSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOSearchSapInvHdrIfCdCmbSeqRSQL").append("\n"); 
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
		query.append("#if(${sys_tp_cd} == 'ADJ')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("FROM SCO_LEGR_CD_CMB SLCC, " ).append("\n"); 
		query.append("     SAR_ACCT_MTX SAM" ).append("\n"); 
		query.append("WHERE SLCC.SGM_CTNT1 = @[co_cd]" ).append("\n"); 
		query.append("AND SLCC.SGM_CTNT2 = @[cnt_cd]" ).append("\n"); 
		query.append("AND SLCC.SGM_CTNT3 = @[ctr_cd]" ).append("\n"); 
		query.append("AND SLCC.SGM_CTNT4 = SAM.PAY_ACCT_CD " ).append("\n"); 
		query.append("AND SAM.ACCT_CTNT1 = 'ADJ'" ).append("\n"); 
		query.append("AND SAM.ACCT_TP_CD = @[adj_tp_cd]" ).append("\n"); 
		query.append("AND SLCC.SGM_CTNT5 = @[inter_co_cd]" ).append("\n"); 
		query.append("AND SLCC.SGM_CTNT6 = '0000000000'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${sys_tp_cd} == 'OFF')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SLCC.CD_CMB_SEQ" ).append("\n"); 
		query.append("FROM SCO_LEGR_CD_CMB SLCC, " ).append("\n"); 
		query.append("     SAR_ACCT_MTX SAM" ).append("\n"); 
		query.append("WHERE SLCC.SGM_CTNT1 = @[co_cd]" ).append("\n"); 
		query.append("AND SLCC.SGM_CTNT2 = @[cnt_cd]" ).append("\n"); 
		query.append("AND SLCC.SGM_CTNT3 = @[ctr_cd]" ).append("\n"); 
		query.append("AND SLCC.SGM_CTNT4 = SAM.PAY_ACCT_CD " ).append("\n"); 
		query.append("AND SAM.ACCT_CTNT1 = 'ADJ'" ).append("\n"); 
		query.append("AND SAM.ACCT_TP_CD = @[adj_tp_cd]" ).append("\n"); 
		query.append("AND SLCC.SGM_CTNT5 = @[inter_co_cd]" ).append("\n"); 
		query.append("AND SLCC.SGM_CTNT6 = @[vvd_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}