/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchRtnTroEdiCntrRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.06.19 이남경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchRtnTroEdiCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * TransferOrderIssueDBDAOSearchRtnTroEdiCntr
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchRtnTroEdiCntrRSQL(){
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
		query.append("SELECT '{CNTR_INFO'	                 ||CHR(10)||" ).append("\n");
		query.append("'CNTR_NO:'	||CNTR_NO        ||CHR(10)||" ).append("\n");
		query.append("'CNTR_TPSZ:'||CNTR_TPSZ_CD   ||CHR(10)||" ).append("\n");
		query.append("'}CNTR_INFO'			     ||CHR(10) AS STR_FLATFILE" ).append("\n");
		query.append("FROM BKG_TRO_DTL" ).append("\n");
		query.append("WHERE BKG_NO	    = @[bkg_no]" ).append("\n");
		query.append("AND RTN_TRO_FLG  = @[rtn_tro_flg]" ).append("\n");
		query.append("AND IO_BND_CD    = 'O'" ).append("\n");
		query.append("AND TRO_SEQ	    = @[tro_seq]" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n");
		query.append("FileName : TransferOrderIssueDBDAOSearchRtnTroEdiCntrRSQL").append("\n");
		query.append("*/").append("\n");
	}
}