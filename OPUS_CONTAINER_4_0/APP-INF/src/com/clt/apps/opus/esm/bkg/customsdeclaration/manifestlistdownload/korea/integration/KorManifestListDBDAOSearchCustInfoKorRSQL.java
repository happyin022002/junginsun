/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorManifestListDBDAOSearchCustInfoKorRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.04
*@LastModifier :
*@LastVersion : 1.0
* 2010.08.04
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOSearchCustInfoKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchCustInfoKor
	  * </pre>
	  */
	public KorManifestListDBDAOSearchCustInfoKorRSQL(){
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
		params.put("a_kt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a_tr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOSearchCustInfoKorRSQL").append("\n");
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
		query.append("SELECT NVL(MAX(DECODE(BKG_CUST_TP_CD,'S',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_NM,' '),CHR(10),' '))),0),0,'N','Y'),'N')),'N') SHPR_N" ).append("\n");
		query.append("     , NVL(MAX(DECODE(BKG_CUST_TP_CD,'S',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_ADDR,' '),CHR(10),' '))),0),0,'N','Y'),'N')),'N') SHPR_A" ).append("\n");
		query.append("     , NVL(MAX(DECODE(BKG_CUST_TP_CD,'C',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_NM,' '),CHR(10),' '))),0),0,'N','Y'),'N')),'N') CNEE_N" ).append("\n");
		query.append("     , NVL(MAX(DECODE(BKG_CUST_TP_CD,'C',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_ADDR,' '),CHR(10),' '))),0),0,'N','Y'),'N')),'N') CNEE_A" ).append("\n");
		query.append("     , NVL(MAX(DECODE(BKG_CUST_TP_CD,'N',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_NM,' '),CHR(10),' '))),0),0,'N','Y'),'N')),'N') NTFY_N" ).append("\n");
		query.append("     , NVL(MAX(DECODE(BKG_CUST_TP_CD,'N',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_ADDR,' '),CHR(10),' '))),0),0,'N','Y'),'N')),'N') NTFY_A" ).append("\n");
		query.append("     , NVL(SUBSTR(MAX(DECODE(@[in_bound],'O',DECODE(BKG_CUST_TP_CD,'S',REPLACE(NVL(CUST_NM,' '),CHR(10),' '),' ')," ).append("\n");
		query.append("          DECODE(BKG_CUST_TP_CD,'C',REPLACE(NVL(CUST_NM,' '),CHR(10),' '),' '))),1,35), ' ') CUST_NAME" ).append("\n");
		query.append("  FROM BKG_CSTMS_KR_CUST" ).append("\n");
		query.append(" WHERE BKG_NO = @[a_bkg_no]" ).append("\n");
		query.append("   AND CSTMS_DECL_TP_CD = @[a_tr_cd]" ).append("\n");
		query.append("   AND DMST_PORT_CD = @[kt_port]" ).append("\n");
		query.append("   AND TRNS_SEQ = @[a_kt_seq]" ).append("\n");

	}
}