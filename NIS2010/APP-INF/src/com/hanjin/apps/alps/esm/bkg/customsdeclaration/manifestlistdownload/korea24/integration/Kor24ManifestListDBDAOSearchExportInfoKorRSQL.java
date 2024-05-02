/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Kor24ManifestListDBDAOSearchExportInfoKorRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.16
*@LastModifier :
*@LastVersion : 1.0
* 2010.09.16
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

public class Kor24ManifestListDBDAOSearchExportInfoKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * ExportInfo  조회
	  * </pre>
	  */
	public Kor24ManifestListDBDAOSearchExportInfoKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.integration").append("\n");
		query.append("FileName : Kor24ManifestListDBDAOSearchExportInfoKorRSQL").append("\n");
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
		query.append("SELECT DECODE(COUNT(*),0,'N','Y') ELNO_CHECK" ).append("\n");
		query.append(", TO_CHAR(NVL(TRUNC(SUM(NVL(CNTR_WGT,0)),0),0),'FM00000000') ELNO_WGT" ).append("\n");
		query.append(", TO_CHAR(NVL(TRUNC(SUM(NVL(PCK_QTY,0)),0),0), 'FM000000') PCK_QTY" ).append("\n");
		query.append("FROM   BKG_CSTMS_ADV_KR_XPT_LIC" ).append("\n");
		query.append("WHERE  BKG_NO = @[a_bkg_no]" ).append("\n");
		query.append("AND    CSTMS_DECL_TP_CD = @[a_tr_cd]" ).append("\n");
		query.append("AND    DMST_PORT_CD = @[kt_port]" ).append("\n");
		query.append("AND    TRNS_SEQ = @[a_kt_seq]" ).append("\n");

	}
}