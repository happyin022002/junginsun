/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOaddInvEdiGlovisChgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.31
*@LastModifier : 
*@LastVersion : 1.0
* 2011.08.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOaddInvEdiGlovisChgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * charge table에 입력
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOaddInvEdiGlovisChgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eur_gubun",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("euro_locl_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOaddInvEdiGlovisChgCSQL").append("\n"); 
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
		query.append("#if (${ind} == 'CANCEL')" ).append("\n"); 
		query.append("INSERT INTO INV_EDI_GLOVIS_CHG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("AR_IF_NO, IF_SEQ, CHG_SEQ, CHG_CD" ).append("\n"); 
		query.append(", CURR_CD, PER_TP_CD, TRF_RT_AMT, RAT_AS_CNTR_QTY, CHG_AMT, INV_XCH_RT, CHG_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append(", EURO_LOCL_XCH_RT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  AR_IF_NO, IF_SEQ, CHG_SEQ, CHG_CD" ).append("\n"); 
		query.append(", CURR_CD, PER_TP_CD, TRF_RT_AMT, RAT_AS_CNTR_QTY, CHG_AMT, INV_XCH_RT, CHG_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append(", EURO_LOCL_XCH_RT" ).append("\n"); 
		query.append("FROM    INV_EDI_GLOVIS_CHG" ).append("\n"); 
		query.append("WHERE   AR_IF_NO    = @[ar_if_no]" ).append("\n"); 
		query.append("AND     IF_SEQ      = @[if_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("INSERT INTO INV_EDI_GLOVIS_CHG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("AR_IF_NO, IF_SEQ, CHG_SEQ, CHG_CD" ).append("\n"); 
		query.append(", CURR_CD, PER_TP_CD, TRF_RT_AMT, RAT_AS_CNTR_QTY, CHG_AMT, INV_XCH_RT, CHG_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append(", EURO_LOCL_XCH_RT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  AR_IF_NO, @[if_seq], CHG_SEQ, CHG_CD, CURR_CD, PER_TP_CD, TRF_RT_AMT, RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append(", CHG_AMT" ).append("\n"); 
		query.append(", DECODE(CURR_CD, 'KRW', INV_XCH_RT  , @[inv_xch_rt])" ).append("\n"); 
		query.append(", @[chg_rmk]" ).append("\n"); 
		query.append(", @[cre_usr_id], SYSDATE, @[upd_usr_id], SYSDATE" ).append("\n"); 
		query.append(", DECODE(CURR_CD||@[eur_gubun], 'USDY', @[euro_locl_xch_rt], 0)" ).append("\n"); 
		query.append("FROM    INV_AR_CHG" ).append("\n"); 
		query.append("WHERE   AR_IF_NO    = @[ar_if_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}