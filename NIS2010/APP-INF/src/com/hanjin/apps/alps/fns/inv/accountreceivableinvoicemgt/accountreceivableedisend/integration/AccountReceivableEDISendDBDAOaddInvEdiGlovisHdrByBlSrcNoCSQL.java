/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOaddInvEdiGlovisHdrByBlSrcNoCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.03
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.03.03 최도순
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

public class AccountReceivableEDISendDBDAOaddInvEdiGlovisHdrByBlSrcNoCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AccountReceivableEDISendDBDAOaddInvEdiGlovisHdrByBlSrcNoCSQL
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOaddInvEdiGlovisHdrByBlSrcNoCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOaddInvEdiGlovisHdrByBlSrcNoCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_EDI_GLOVIS_HDR" ).append("\n"); 
		query.append("(AR_IF_NO,IF_SEQ,BL_SRC_NO,GLOVIS_EDI_MSG_NO,INV_NO,INV_SEQ,CUST_NM,CUST_EML,CUST_CNT_CD,CUST_SEQ,IO_BND_CD,SAIL_ARR_DT,INV_RMK" ).append("\n"); 
		query.append(",CXL_FLG" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID " ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", EDI_SND_FLG" ).append("\n"); 
		query.append(", EDI_SND_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  /*+INDEX_DESC(T1 XAK1INV_EDI_GLOVIS_HDR) */" ).append("\n"); 
		query.append("        AR_IF_NO" ).append("\n"); 
		query.append("        , NVL(IF_SEQ, 0) + 1 AS IF_SEQ" ).append("\n"); 
		query.append("        , BL_SRC_NO" ).append("\n"); 
		query.append("        , TO_CHAR(SYSDATE,'YYYYMMDD')||LPAD(TO_CHAR(INV_EDI_GLOVIS_MSG_SEQ.NEXTVAL),4,'0')" ).append("\n"); 
		query.append("        , INV_NO" ).append("\n"); 
		query.append("        , INV_SEQ" ).append("\n"); 
		query.append("        , CUST_NM" ).append("\n"); 
		query.append("        , CUST_EML" ).append("\n"); 
		query.append("        , CUST_CNT_CD" ).append("\n"); 
		query.append("        , CUST_SEQ" ).append("\n"); 
		query.append("        , IO_BND_CD" ).append("\n"); 
		query.append("        , SAIL_ARR_DT" ).append("\n"); 
		query.append("        , INV_RMK" ).append("\n"); 
		query.append("        , 'Y'" ).append("\n"); 
		query.append("        , @[cre_usr_id] " ).append("\n"); 
		query.append("        , SYSDATE " ).append("\n"); 
		query.append("        , @[upd_usr_id]" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("        , 'N'" ).append("\n"); 
		query.append("        , SYSDATE" ).append("\n"); 
		query.append("FROM    INV_EDI_GLOVIS_HDR T1" ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("AND     ROWNUM      = 1" ).append("\n"); 

	}
}