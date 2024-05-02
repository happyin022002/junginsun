/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOAddHPEDIChgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.16
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.12.16 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOAddHPEDIChgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOAddHPEDIChgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hp_inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOAddHPEDIChgCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_HP_EDI_CHG" ).append("\n"); 
		query.append("SELECT @[hp_inv_no] HP_INV_NO" ).append("\n"); 
		query.append("      ,@[inv_seq] INV_SEQ" ).append("\n"); 
		query.append("	  ,ROWNUM CHG_SEQ" ).append("\n"); 
		query.append("	  ,CHG_CD" ).append("\n"); 
		query.append("	  ,TRF_RT_AMT" ).append("\n"); 
		query.append("      ,RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("      ,CHG_AMT" ).append("\n"); 
		query.append("      ,PER_TP_CD" ).append("\n"); 
		query.append("      ,CURR_CD" ).append("\n"); 
		query.append("      ,FRT_TERM_CD" ).append("\n"); 
		query.append("      ,INV_XCH_RT" ).append("\n"); 
		query.append("      ,@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE CRE_DT" ).append("\n"); 
		query.append("      ,@[upd_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("      ,SYSDATE UPD_DT" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("SELECT C.CHG_CD" ).append("\n"); 
		query.append("      ,C.TRF_RT_AMT" ).append("\n"); 
		query.append("      ,C.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("      ,SUM(C.CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append("      ,C.PER_TP_CD" ).append("\n"); 
		query.append("      ,C.CURR_CD" ).append("\n"); 
		query.append("      ,DECODE(M.IO_BND_CD,'I','C','P') FRT_TERM_CD" ).append("\n"); 
		query.append("      ,C.INV_XCH_RT" ).append("\n"); 
		query.append("  FROM INV_AR_MN M" ).append("\n"); 
		query.append("      ,INV_AR_CHG C" ).append("\n"); 
		query.append(" WHERE M.AR_IF_NO = C.AR_IF_NO" ).append("\n"); 
		query.append("   AND M.INV_NO = @[inv_no]" ).append("\n"); 
		query.append("   AND M.BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append(" GROUP BY C.CHG_CD" ).append("\n"); 
		query.append("      ,C.TRF_RT_AMT" ).append("\n"); 
		query.append("      ,C.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append("      ,C.PER_TP_CD" ).append("\n"); 
		query.append("      ,C.CURR_CD" ).append("\n"); 
		query.append("      ,DECODE(M.IO_BND_CD,'I','C','P')" ).append("\n"); 
		query.append("      ,C.INV_XCH_RT" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}