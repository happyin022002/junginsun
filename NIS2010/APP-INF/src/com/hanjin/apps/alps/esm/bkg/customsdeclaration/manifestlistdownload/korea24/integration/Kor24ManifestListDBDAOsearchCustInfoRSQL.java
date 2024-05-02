/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Kor24ManifestListDBDAOsearchCustInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.04.07 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24ManifestListDBDAOsearchCustInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Custinfo  조회
	  * </pre>
	  */
	public Kor24ManifestListDBDAOsearchCustInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration ").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOsearchCustInfoRSQL").append("\n");
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
		query.append("SELECT NVL(MAX(DECODE(BKG_CUST_TP_CD,'S',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_NM,' '),CHR(13)||CHR(10),' '))),0),0,'N','Y'),'N')), 'N') SHPR_NAME" ).append("\n");
		query.append(", NVL(MAX(DECODE(BKG_CUST_TP_CD,'S',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_ADDR,' '),CHR(13)||CHR(10),' '))),0),0,'N','Y'),'N')),'N') SHPR_ADDR" ).append("\n");
		query.append(", NVL(MAX(DECODE(BKG_CUST_TP_CD,'C',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_NM,' '),CHR(13)||CHR(10),' '))),0),0,'N','Y'),'N')), 'N') CNEE_NAME" ).append("\n");
		query.append(", NVL(MAX(DECODE(BKG_CUST_TP_CD,'C',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_ADDR,' '),CHR(13)||CHR(10),' '))),0),0,'N','Y'),'N')),'N') CNEE_ADDR" ).append("\n");
		query.append(", NVL(MAX(DECODE(BKG_CUST_TP_CD,'N',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_NM,' '),CHR(13)||CHR(10),' '))),0),0,'N','Y'),'N')), 'N') NTFY_NAME" ).append("\n");
		query.append(", NVL(MAX(DECODE(BKG_CUST_TP_CD,'N',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_ADDR,' '),CHR(13)||CHR(10),' '))),0),0,'N','Y'),'N')),'N') NTFY_ADDR" ).append("\n");
		query.append(", NVL(SUBSTR(MAX(DECODE(@[in_bound],'O',DECODE(BKG_CUST_TP_CD,'S',NVL(CUST_NM,' '),' ')," ).append("\n");
		query.append("DECODE(BKG_CUST_TP_CD,'C',NVL(CUST_NM,' '),' '))),1,35),' ') USRS14" ).append("\n");
		query.append("FROM BKG_CUSTOMER" ).append("\n");
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("AND BKG_CUST_TP_CD IN ('S','C','N')" ).append("\n");

	}
}