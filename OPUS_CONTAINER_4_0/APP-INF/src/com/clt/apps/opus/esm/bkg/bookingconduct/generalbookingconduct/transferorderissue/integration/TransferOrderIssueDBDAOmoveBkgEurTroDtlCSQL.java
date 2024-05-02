/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOmoveBkgEurTroDtlCSQL.java
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

public class TransferOrderIssueDBDAOmoveBkgEurTroDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * combine시 tro를 옮겨 준다
	  * </pre>
	  */
	public TransferOrderIssueDBDAOmoveBkgEurTroDtlCSQL(){
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
		params.put("org_tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOmoveBkgEurTroDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_EUR_TRO_dtl" ).append("\n"); 
		query.append("(BKG_NO" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",TRO_SEQ" ).append("\n"); 
		query.append(",TRO_SUB_SEQ" ).append("\n"); 
		query.append(",DOR_ADDR_TP_CD" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",ZN_CD" ).append("\n"); 
		query.append(",LOD_REF_NO" ).append("\n"); 
		query.append(",DOR_ZIP_ID" ).append("\n"); 
		query.append(",DOR_ADDR" ).append("\n"); 
		query.append(",ARR_DT" ).append("\n"); 
		query.append(",CNTC_PSON_NM" ).append("\n"); 
		query.append(",CNTC_PHN_NO" ).append("\n"); 
		query.append(",CNTC_EML" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT)" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("@[new_bkg_no]" ).append("\n"); 
		query.append(",IO_BND_CD" ).append("\n"); 
		query.append(",to_number(@[new_tro_seq])" ).append("\n"); 
		query.append(",TRO_SUB_SEQ" ).append("\n"); 
		query.append(",DOR_ADDR_TP_CD" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",ZN_CD" ).append("\n"); 
		query.append(",LOD_REF_NO" ).append("\n"); 
		query.append(",DOR_ZIP_ID" ).append("\n"); 
		query.append(",DOR_ADDR" ).append("\n"); 
		query.append(",ARR_DT" ).append("\n"); 
		query.append(",CNTC_PSON_NM" ).append("\n"); 
		query.append(",CNTC_PHN_NO" ).append("\n"); 
		query.append(",CNTC_EML" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO_dtl source" ).append("\n"); 
		query.append("WHERE BKG_NO = @[org_bkg_no]" ).append("\n"); 
		query.append("AND tro_seq = @[org_tro_seq]" ).append("\n"); 

	}
}