/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChinaManifestListDownloadDBDAOsearchBlCustListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.23
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.23
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaManifestListDownloadDBDAOsearchBlCustListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * BkgCstmsChnCustVO
	  * </pre>
	  */
	public ChinaManifestListDownloadDBDAOsearchBlCustListRSQL(){
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
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.integration").append("\n");
		query.append("FileName : ChinaManifestListDownloadDBDAOsearchBlCustListRSQL").append("\n");
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
		query.append("SELECT  BB.BL_NO					AS BL_NO," ).append("\n");
		query.append("BC.BKG_CUST_TP_CD			AS BKG_CUST_TP_CD," ).append("\n");
		query.append("NVL(BC.CUST_CNT_CD, ' ')	AS CNT_CD," ).append("\n");
		query.append("NVL(BC.CUST_SEQ, 0)			AS CUST_SEQ," ).append("\n");
		query.append("NVL(REPLACE(REPLACE(REPLACE(BC.CUST_NM ,CHR(34)),CHR(9),' '), CHR(10),' '), REPLACE(REPLACE(REPLACE(CNEE.CUST_NM ,CHR(34)),CHR(9),' '), CHR(10),' ')) AS CUST_NM," ).append("\n");
		query.append("DECODE(BC.BKG_CUST_TP_CD," ).append("\n");
		query.append("'S', NVL(REPLACE(REPLACE(REPLACE(BC.CUST_ADDR ,CHR(34)),CHR(9),' '), CHR(10),' '), ' ')" ).append("\n");
		query.append(", 'N', DECODE(TRIM(BC.CUST_ADDR), NULL, REPLACE(REPLACE(REPLACE(CNEE.CUST_ADDR ,CHR(34)),CHR(9),' '), CHR(10),' '), NVL(REPLACE(REPLACE(REPLACE(BC.CUST_ADDR ,CHR(34)),CHR(9),' '), CHR(10),' '), ' '))" ).append("\n");
		query.append(", 'C', DECODE(BB.CUST_TO_ORD_FLG, 'Y', 'TO ORDER', NVL(REPLACE(REPLACE(REPLACE(BC.CUST_ADDR ,CHR(34)),CHR(9),' '), CHR(10),' '), ' '))" ).append("\n");
		query.append(", NULL" ).append("\n");
		query.append(") CUST_ADDR," ).append("\n");
		query.append("@[trans_mode] 				AS CHN_MF_SND_IND_CD," ).append("\n");
		query.append("@[usr_id]					AS CRE_USR_ID," ).append("\n");
		query.append("@[usr_id]					AS UPD_USR_ID" ).append("\n");
		query.append("FROM    BKG_CUSTOMER BC," ).append("\n");
		query.append("BKG_CUSTOMER CNEE," ).append("\n");
		query.append("BKG_BOOKING BB" ).append("\n");
		query.append("WHERE   1=1" ).append("\n");
		query.append("AND ( #foreach($field_id in ${field_list})" ).append("\n");
		query.append("#if($velocityCount > 1)" ).append("\n");
		query.append("OR #end      BB.BKG_NO IN ( $field_id )" ).append("\n");
		query.append("#end" ).append("\n");
		query.append(")" ).append("\n");
		query.append("#if (${bkg_cgo_tp_cd} != '')" ).append("\n");
		query.append("AND     DECODE(BB.BKG_CGO_TP_CD,'P','P','F') = @[bkg_cgo_tp_cd]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("AND     BB.BKG_NO = BC.BKG_NO" ).append("\n");
		query.append("AND     BB.BKG_NO = CNEE.BKG_NO" ).append("\n");
		query.append("AND     BC.BKG_CUST_TP_CD IN ('S', 'C', 'N')" ).append("\n");
		query.append("AND     CNEE.BKG_CUST_TP_CD = 'C'" ).append("\n");

	}
}