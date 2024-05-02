/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOcancelBkgTroDtlBySplitUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.10.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOcancelBkgTroDtlBySplitUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cancelBkgTroDtlBySplit
	  * </pre>
	  */
	public TransferOrderIssueDBDAOcancelBkgTroDtlBySplitUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOcancelBkgTroDtlBySplitUSQL").append("\n"); 
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
		query.append("UPDATE BKG_TRO_DTL A" ).append("\n"); 
		query.append("SET CXL_FLG = 'Y'" ).append("\n"); 
		query.append(",SPLIT_RMK =" ).append("\n"); 
		query.append("(SELECT BKG_NO" ).append("\n"); 
		query.append("FROM SCE_TRO_MAPG B" ).append("\n"); 
		query.append("WHERE B.BKG_NO IN (${target_bkg_no})" ).append("\n"); 
		query.append("AND B.IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("AND B.TRO_SEQ = A.TRO_SEQ" ).append("\n"); 
		query.append("AND B.TRO_SUB_SEQ = A.TRO_SUB_SEQ" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",UPD_USR_ID = @[usr_id]" ).append("\n"); 
		query.append(",UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE BKG_NO = @[source_bkg_no]" ).append("\n"); 
		query.append("AND (BKG_NO, IO_BND_CD, TRO_SEQ, TRO_SUB_SEQ)" ).append("\n"); 
		query.append("NOT IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",TRO_SEQ" ).append("\n"); 
		query.append(",TRO_SUB_SEQ" ).append("\n"); 
		query.append("FROM SCE_TRO_MAPG B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.IO_BND_CD = B.IO_BND_CD" ).append("\n"); 
		query.append("AND A.TRO_SEQ = B.TRO_SEQ" ).append("\n"); 
		query.append("AND A.TRO_SUB_SEQ = B.TRO_SUB_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("FROM BKG_TRO C" ).append("\n"); 
		query.append("WHERE C.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND C.TRO_SEQ = A.TRO_SEQ" ).append("\n"); 
		query.append("AND C.IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("AND C.CFM_FLG = 'Y')" ).append("\n"); 

	}
}