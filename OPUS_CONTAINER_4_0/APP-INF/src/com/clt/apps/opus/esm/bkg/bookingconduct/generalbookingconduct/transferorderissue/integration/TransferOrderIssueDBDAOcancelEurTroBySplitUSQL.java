/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOcancelEurTroBySplitUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.02
*@LastModifier : 
*@LastVersion : 1.0
* 2010.09.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOcancelEurTroBySplitUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cancelEurTroBySplit
	  * </pre>
	  */
	public TransferOrderIssueDBDAOcancelEurTroBySplitUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("source_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOcancelEurTroBySplitUSQL").append("\n"); 
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
		query.append("UPDATE BKG_EUR_TRO A" ).append("\n"); 
		query.append("SET CXL_FLG = 'Y'" ).append("\n"); 
		query.append(",CFM_FLG = 'N'" ).append("\n"); 
		query.append(",SPLIT_RMK =" ).append("\n"); 
		query.append("(SELECT BKG_NO" ).append("\n"); 
		query.append("FROM SCE_TRO_MAPG B" ).append("\n"); 
		query.append("WHERE B.BKG_NO IN (${target_bkg_no})" ).append("\n"); 
		query.append("AND B.IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("AND B.TRO_SEQ = A.TRO_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(",UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[source_bkg_no]" ).append("\n"); 
		query.append("AND (BKG_NO, IO_BND_CD, TRO_SEQ)" ).append("\n"); 
		query.append("NOT IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",TRO_SEQ" ).append("\n"); 
		query.append("FROM SCE_TRO_MAPG B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.IO_BND_CD = B.IO_BND_CD" ).append("\n"); 
		query.append("AND A.TRO_SEQ = B.TRO_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND CFM_FLG = 'Y'" ).append("\n"); 

	}
}