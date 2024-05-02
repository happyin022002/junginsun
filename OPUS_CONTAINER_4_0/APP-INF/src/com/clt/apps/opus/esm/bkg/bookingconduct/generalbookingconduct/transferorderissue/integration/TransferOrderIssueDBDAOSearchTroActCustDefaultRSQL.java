/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchTroActCustDefaultRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.06.19 이남경
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

public class TransferOrderIssueDBDAOSearchTroActCustDefaultRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 905_초기화면 파라미터 조회용
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchTroActCustDefaultRSQL(){
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
		params.put("dor_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT SH.CUST_CNT_CD" ).append("\n");
		query.append(", SH.CUST_SEQ" ).append("\n");
		query.append(", (SELECT LOC.EQ_CTRL_OFC_CD" ).append("\n");
		query.append("FROM MDM_LOCATION LOC" ).append("\n");
		query.append("WHERE lOC.LOC_CD = @[dor_loc_cd]" ).append("\n");
		query.append(") EQ_CTRL_OFC_CD" ).append("\n");
		query.append("FROM BKG_BOOKING BK" ).append("\n");
		query.append(", BKG_CUSTOMER SH" ).append("\n");
		query.append("WHERE BK.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND BK.BKG_NO = SH.BKG_NO" ).append("\n");
		query.append("AND SH.BKG_CUST_TP_CD = 'S'" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n");
		query.append("FileName : TransferOrderIssueDBDAOSearchTroActCustDefaultRSQL").append("\n");
		query.append("*/").append("\n");
	}
}