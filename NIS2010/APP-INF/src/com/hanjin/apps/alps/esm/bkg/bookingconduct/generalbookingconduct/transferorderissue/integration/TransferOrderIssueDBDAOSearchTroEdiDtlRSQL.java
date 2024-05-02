/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchTroEdiDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.26 
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

public class TransferOrderIssueDBDAOSearchTroEdiDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOSearchTroEdiDtl
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchTroEdiDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchTroEdiDtlRSQL").append("\n"); 
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
		query.append("SELECT RPAD(NVL(TO_CHAR(DOR_ARR_DT, 'RRRRMMDDHH24'), ' '), 10) ||" ).append("\n"); 
		query.append("RPAD(NVL(TO_CHAR(DOR_ARR_DT, 'RRRRMMDDHH24'), ' '), 10) ||" ).append("\n"); 
		query.append("RPAD(CNTR_TPSZ_CD, 2)                                    ||" ).append("\n"); 
		query.append("RPAD(TRUNC(NVL(TRO_QTY, '0')), 3)                        ||" ).append("\n"); 
		query.append("RPAD(SUBSTR(NVL(PKUP_YD_CD, '     '), 3, 5), 5)          ||" ).append("\n"); 
		query.append("RPAD(SUBSTR(NVL(RTN_YD_CD,  '     '), 3, 5), 5)          ||" ).append("\n"); 
		query.append("RPAD('  ', 7) AS STR_FLATFILE" ).append("\n"); 
		query.append("FROM BKG_TRO_DTL" ).append("\n"); 
		query.append("WHERE BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND IO_BND_CD    = 'O'" ).append("\n"); 
		query.append("AND RTN_TRO_FLG  = @[rtn_tro_flg]" ).append("\n"); 
		query.append("AND TRO_SEQ      = @[tro_seq]" ).append("\n"); 
		query.append("AND TRO_QTY 		<> 0" ).append("\n"); 

	}
}