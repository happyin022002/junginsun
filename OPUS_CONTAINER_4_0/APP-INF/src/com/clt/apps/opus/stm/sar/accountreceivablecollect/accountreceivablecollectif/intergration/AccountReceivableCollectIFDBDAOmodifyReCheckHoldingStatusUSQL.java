/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AccountReceivableCollectIFDBDAOmodifyReCheckHoldingStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.01
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.01 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.intergration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCollectIFDBDAOmodifyReCheckHoldingStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyReCheckHoldingStatus
	  * </pre>
	  */
	public AccountReceivableCollectIFDBDAOmodifyReCheckHoldingStatusUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.intergration ").append("\n"); 
		query.append("FileName : AccountReceivableCollectIFDBDAOmodifyReCheckHoldingStatusUSQL").append("\n"); 
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
		query.append("UPDATE SAR_AR_IF SET " ).append("\n"); 
		query.append("    ERP_IF_ERR_RSN = 'DR minus CR is not zero'" ).append("\n"); 
		query.append("WHERE IF_SEQ_NO = @[if_seq_no]" ).append("\n"); 
		query.append("AND IF_FLG = 'H'" ).append("\n"); 
		query.append("AND 'N' =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("   SELECT " ).append("\n"); 
		query.append("     CASE WHEN NVL(sum(decode(pst_key_cd,'01',NVL(locl_amt,0),40,NVL(locl_amt,0),11,NVL(locl_amt,0)*(-1), 50,NVL(locl_amt,0)*(-1))),0) = 0" ).append("\n"); 
		query.append("          AND NVL(sum(decode(pst_key_cd,'01',NVL(doc_amt,0),40,NVL(doc_amt,0),11,NVL(doc_amt,0)*(-1), 50,NVL(doc_amt,0)*(-1))),0) = 0 THEN 'Y'" ).append("\n"); 
		query.append("     ELSE 'N'" ).append("\n"); 
		query.append("   END" ).append("\n"); 
		query.append("      FROM SAR_AR_IF" ).append("\n"); 
		query.append("     WHERE IF_SEQ_NO = @[if_seq_no]" ).append("\n"); 
		query.append("       AND IF_FLG='H'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}