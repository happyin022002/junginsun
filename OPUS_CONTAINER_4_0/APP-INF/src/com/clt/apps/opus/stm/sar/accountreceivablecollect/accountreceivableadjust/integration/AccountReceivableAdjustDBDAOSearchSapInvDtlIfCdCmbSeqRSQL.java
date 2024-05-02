/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOSearchSapInvDtlIfCdCmbSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.25 
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

public class AccountReceivableAdjustDBDAOSearchSapInvDtlIfCdCmbSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * get Code Combination Sequence No for AP DTL IF
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOSearchSapInvDtlIfCdCmbSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("off_inter_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("off_ar_acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("adj_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOSearchSapInvDtlIfCdCmbSeqRSQL").append("\n"); 
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
		query.append("SELECT ADJ_CD_CMB_SEQ CD_CMB_SEQ" ).append("\n"); 
		query.append("FROM SAR_ADJ_HIS" ).append("\n"); 
		query.append("WHERE ADJ_NO = @[adj_no]" ).append("\n"); 
		query.append("AND ADJ_STS_CD = 'ADJUST'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif(${sys_tp_cd} == 'OFF')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT SLCC2.CD_CMB_SEQ" ).append("\n"); 
		query.append("FROM SCO_LEGR_CD_CMB SLCC1, " ).append("\n"); 
		query.append("	 SCO_LEGR_CD_CMB SLCC2" ).append("\n"); 
		query.append("WHERE SLCC1.SGM_CTNT1 = SLCC2.SGM_CTNT1" ).append("\n"); 
		query.append("AND SLCC1.SGM_CTNT2 = SLCC2.SGM_CTNT2" ).append("\n"); 
		query.append("AND SLCC1.SGM_CTNT3 = SLCC2.SGM_CTNT3" ).append("\n"); 
		query.append("AND SLCC2.SGM_CTNT4 = @[off_ar_acct_cd]" ).append("\n"); 
		query.append("AND SLCC2.SGM_CTNT5 = @[off_inter_co_cd]" ).append("\n"); 
		query.append("AND SLCC1.SGM_CTNT6 = SLCC2.SGM_CTNT6" ).append("\n"); 
		query.append("AND SLCC1.CD_CMB_SEQ = (SELECT ADJ_CD_CMB_SEQ" ).append("\n"); 
		query.append("						FROM SAR_ADJ_HIS" ).append("\n"); 
		query.append("						WHERE ADJ_NO = @[adj_no]" ).append("\n"); 
		query.append("						AND ADJ_STS_CD = 'ADJUST'" ).append("\n"); 
		query.append("						AND ROWNUM = 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}