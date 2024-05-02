/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TransferOrderIssueDBDAOModifyEurTroMltSeqUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.06 
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

public class TransferOrderIssueDBDAOModifyEurTroMltSeqUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOModifyEurTroMltSeq
	  * </pre>
	  */
	public TransferOrderIssueDBDAOModifyEurTroMltSeqUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOModifyEurTroMltSeqUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_EUR_TRO_DTL A" ).append("\n"); 
		query.append("USING " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        BKG_NO," ).append("\n"); 
		query.append("        IO_BND_CD," ).append("\n"); 
		query.append("        TRO_SEQ," ).append("\n"); 
		query.append("        TRO_SUB_SEQ," ).append("\n"); 
		query.append("        ROW_NUMBER () OVER(PARTITION BY BKG_NO, IO_BND_CD, TRO_SEQ ORDER BY TRO_SUB_SEQ ASC) AS NEW_MLT_STOP_SEQ" ).append("\n"); 
		query.append("    FROM  BKG_EUR_TRO_DTL" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(")  B   " ).append("\n"); 
		query.append("ON (A.BKG_NO = B.BKG_NO AND A.IO_BND_CD = B.IO_BND_CD AND A.TRO_SEQ = B.TRO_SEQ AND A.TRO_SUB_SEQ = B.TRO_SUB_SEQ)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE SET" ).append("\n"); 
		query.append("MLT_STOP_SEQ = NEW_MLT_STOP_SEQ" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND TRO_SEQ = @[tro_seq]" ).append("\n"); 

	}
}