/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableAdjustDBDAOmodifyWFRECToADJDtrbUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.03
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.03 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableAdjustDBDAOmodifyWFRECToADJDtrbUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyWFRECToADJDtrb
	  * </pre>
	  */
	public AccountReceivableAdjustDBDAOmodifyWFRECToADJDtrbUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_src_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dtrb_src_tbl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.integration ").append("\n"); 
		query.append("FileName : AccountReceivableAdjustDBDAOmodifyWFRECToADJDtrbUSQL").append("\n"); 
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
		query.append("UPDATE SAR_CLT_DTRB SET " ).append("\n"); 
		query.append("(GL_CONV_XCH_RT,GL_ACCT_DR_AMT,GL_ACCT_CR_AMT)" ).append("\n"); 
		query.append("= " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append(" SELECT GL_CONV_XCH_RT,GL_ACCT_CR_AMT,GL_ACCT_DR_AMT" ).append("\n"); 
		query.append("  FROM SAR_CLT_DTRB" ).append("\n"); 
		query.append(" WHERE " ).append("\n"); 
		query.append("     DTRB_SRC_SEQ = @[dtrb_src_seq]  " ).append("\n"); 
		query.append("     AND DTRB_SRC_TBL_CD = @[dtrb_src_tbl_cd]" ).append("\n"); 
		query.append("     AND DTRB_SRC_TP_CD = 'REC'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("     DTRB_SRC_SEQ = @[dtrb_src_seq]  " ).append("\n"); 
		query.append("     AND DTRB_SRC_TBL_CD = @[dtrb_src_tbl_cd]" ).append("\n"); 
		query.append("     AND DTRB_SRC_TP_CD = 'ADJ' " ).append("\n"); 

	}
}