/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Kor24ManifestListDBDAOSearchCustomerInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.04
*@LastModifier :
*@LastVersion : 1.0
* 2010.08.04
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOSearchCustomerInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 한국세관 테이블에 Bkg Customer정보를 Insert/Update하기 위해 조회한다.
	  * </pre>
	  */
	public Kor24ManifestListDBDAOSearchCustomerInfoRSQL(){
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

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOSearchCustomerInfoRSQL").append("\n");
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
		query.append("SELECT T.BCS C_BCS_TP " ).append("\n");
		query.append(", BC.CNT C_CNT_CD " ).append("\n");
		query.append(", BC.CUST C_CUST_CD " ).append("\n");
		query.append(", BC.NM C_CUST_NAME " ).append("\n");
		query.append(", BC.ADDR C_CUST_ADDR " ).append("\n");
		query.append(", ' ' C_CUST_TEL " ).append("\n");
		query.append("FROM (SELECT 'S' BCS, 1 ORD " ).append("\n");
		query.append("FROM DUAL " ).append("\n");
		query.append("UNION ALL " ).append("\n");
		query.append("SELECT 'C', 2 " ).append("\n");
		query.append("FROM DUAL " ).append("\n");
		query.append("UNION ALL " ).append("\n");
		query.append("SELECT 'N', 3 " ).append("\n");
		query.append("FROM DUAL) T, " ).append("\n");
		query.append("(SELECT BKG_CUST_TP_CD BCS " ).append("\n");
		query.append(", NVL(CUST_CNT_CD,' ') CNT " ).append("\n");
		query.append(", NVL(CUST_SEQ,0) CUST " ).append("\n");
		query.append(", NVL(BKG_SPCLCHAR_CONV_FNC(CUST_NM,'Y'),' ') NM " ).append("\n");
		query.append(", NVL(BKG_SPCLCHAR_CONV_FNC(TRIM(CUST_ADDR),'Y'),' ') ADDR " ).append("\n");
		query.append("FROM BKG_CUSTOMER " ).append("\n");
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND BKG_CUST_TP_CD IN ('S','C','N')) BC " ).append("\n");
		query.append("WHERE  T.BCS = BC.BCS(+) " ).append("\n");
		query.append("ORDER BY T.ORD" ).append("\n");

	}
}