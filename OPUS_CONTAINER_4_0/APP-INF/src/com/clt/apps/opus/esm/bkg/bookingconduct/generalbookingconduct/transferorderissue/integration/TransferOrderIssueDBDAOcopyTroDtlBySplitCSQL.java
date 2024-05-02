/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOcopyTroDtlBySplitCSQL.java
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

public class TransferOrderIssueDBDAOcopyTroDtlBySplitCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * copyTroDtlBySplit
	  * </pre>
	  */
	public TransferOrderIssueDBDAOcopyTroDtlBySplitCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("target_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : TransferOrderIssueDBDAOcopyTroDtlBySplitCSQL").append("\n"); 
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
		query.append("INSERT" ).append("\n"); 
		query.append("INTO BKG_TRO_DTL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",RTN_TRO_FLG" ).append("\n"); 
		query.append(",TRO_SEQ" ).append("\n"); 
		query.append(",TRO_SUB_SEQ" ).append("\n"); 
		query.append(",CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",TRO_QTY" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",DOR_ARR_DT" ).append("\n"); 
		query.append(",PKUP_LOC_CD" ).append("\n"); 
		query.append(",PKUP_YD_CD" ).append("\n"); 
		query.append(",RTN_LOC_CD" ).append("\n"); 
		query.append(",RTN_YD_CD" ).append("\n"); 
		query.append(",CMDT_CD" ).append("\n"); 
		query.append(",PCTL_NO" ).append("\n"); 
		query.append(",CXL_FLG" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[target_bkg_no]" ).append("\n"); 
		query.append(",A.IO_BND_CD" ).append("\n"); 
		query.append(",A.RTN_TRO_FLG" ).append("\n"); 
		query.append(",A.TRO_SEQ" ).append("\n"); 
		query.append(",A.TRO_SUB_SEQ" ).append("\n"); 
		query.append(",A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",A.TRO_QTY" ).append("\n"); 
		query.append(",A.CNTR_NO" ).append("\n"); 
		query.append(",A.DOR_ARR_DT" ).append("\n"); 
		query.append(",A.PKUP_LOC_CD" ).append("\n"); 
		query.append(",A.PKUP_YD_CD" ).append("\n"); 
		query.append(",A.RTN_LOC_CD" ).append("\n"); 
		query.append(",A.RTN_YD_CD" ).append("\n"); 
		query.append(",A.CMDT_CD" ).append("\n"); 
		query.append(",A.PCTL_NO" ).append("\n"); 
		query.append(",A.CXL_FLG" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("FROM BKG_TRO_DTL A" ).append("\n"); 
		query.append(",SCE_TRO_MAPG B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[source_bkg_no]" ).append("\n"); 
		query.append("AND B.BKG_NO = @[target_bkg_no]" ).append("\n"); 
		query.append("AND A.IO_BND_CD = B.IO_BND_CD" ).append("\n"); 
		query.append("AND A.TRO_SEQ = B.TRO_SEQ" ).append("\n"); 
		query.append("AND A.TRO_SUB_SEQ = B.TRO_SUB_SEQ" ).append("\n"); 
		query.append("AND EXISTS (SELECT 'X'" ).append("\n"); 
		query.append("FROM BKG_TRO C" ).append("\n"); 
		query.append("WHERE C.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("AND C.TRO_SEQ = A.TRO_SEQ" ).append("\n"); 
		query.append("AND C.IO_BND_CD = A.IO_BND_CD" ).append("\n"); 
		query.append("AND C.CFM_FLG = 'Y')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}