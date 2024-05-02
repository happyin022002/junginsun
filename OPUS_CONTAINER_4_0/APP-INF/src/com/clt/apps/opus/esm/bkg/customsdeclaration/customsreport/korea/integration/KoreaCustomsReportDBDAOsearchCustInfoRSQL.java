/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOsearchCustInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.14 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOsearchCustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Customer Type , NAME 조회
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOsearchCustInfoRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration ").append("\n");
		query.append("FileName : KoreaCustomsReportDBDAOsearchCustInfoRSQL").append("\n");
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
		query.append("SELECT MAX(DECODE(BKG_CUST_TP_CD, 'C', replace(replace(NVL(CUST_NM, ' '), '\"', '\"\"'), CHR(10), ' '), ' ')) CUST_C_NM" ).append("\n");
		query.append(", MAX(DECODE(BKG_CUST_TP_CD, 'N', replace(replace(NVL(CUST_NM, ' '), '\"', '\"\"'), CHR(10), ' '), ' ')) CUST_N_NM" ).append("\n");
		query.append("FROM BKG_CUSTOMER" ).append("\n");
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND BKG_CUST_TP_CD in ('C','N')" ).append("\n");

	}
}