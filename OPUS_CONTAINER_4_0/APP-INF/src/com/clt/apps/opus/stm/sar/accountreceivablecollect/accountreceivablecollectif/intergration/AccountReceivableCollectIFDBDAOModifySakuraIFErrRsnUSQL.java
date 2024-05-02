/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AccountReceivableCollectIFDBDAOModifySakuraIFErrRsnUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.intergration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableCollectIFDBDAOModifySakuraIFErrRsnUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Exception 발생시, IF_FLG, ERP_IF_ERR_FLG, ERP_IF_ERR_RSN 컬럼 Update
	  * </pre>
	  */
	public AccountReceivableCollectIFDBDAOModifySakuraIFErrRsnUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_err_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_seq_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("erp_if_err_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.intergration").append("\n"); 
		query.append("FileName : AccountReceivableCollectIFDBDAOModifySakuraIFErrRsnUSQL").append("\n"); 
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
		query.append("UPDATE SAR_AR_IF " ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("       IF_FLG = @[if_flg]" ).append("\n"); 
		query.append("      ,ERP_IF_ERR_FLG = @[erp_if_err_flg]" ).append("\n"); 
		query.append("      ,ERP_IF_ERR_RSN = SUBSTR(@[ar_if_err_desc],0,4000)" ).append("\n"); 
		query.append("WHERE IF_SEQ_NO = @[if_seq_no]" ).append("\n"); 

	}
}