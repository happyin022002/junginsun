/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchAwkSeqRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.06
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.07.06 이남경
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Nam Kyung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchAwkSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ESM_BKG_0079_02A awk 콤보목록 조회
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchAwkSeqRSQL(){
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
		query.append("SELECT AWK_CGO_SEQ AS AWK_SEQ" ).append("\n");
		query.append("FROM BKG_AWK_CGO" ).append("\n");
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("ORDER BY AWK_SEQ" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n");
		query.append("FileName : TransferOrderIssueDBDAOSearchAwkSeqRSQL").append("\n");
		query.append("*/").append("\n");
	}
}