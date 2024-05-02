/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KorManifestListDBDAOSearchCntrNoKorRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.07
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.08.07 조원주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOSearchCntrNoKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SELECT CNTR_NO
	  *         FROM   BKG_CSTMS_KR_CNTR
	  *         WHERE  BKG_NO = SUBSTR(:a_bkg_no[i],1,11)
	  *         AND    BKG_NO_SPLIT = SUBSTR(:a_bkg_no[i],12,2)
	  *         AND    CSTMS_DECL_TP_CD = :a_tr_cd[i]
	  *         AND    PORT_CD = :kt_port
	  *         AND    TRNS_SEQ = :a_kt_seq[i]
	  * </pre>
	  */
	public KorManifestListDBDAOSearchCntrNoKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("tr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n");
		query.append("FileName : KorManifestListDBDAOSearchCntrNoKorRSQL").append("\n");
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
		query.append("SELECT CNTR_NO" ).append("\n");
		query.append("  FROM BKG_CSTMS_KR_CNTR" ).append("\n");
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("   AND CSTMS_DECL_TP_CD = @[tr_cd]" ).append("\n");
		query.append("   AND DMST_PORT_CD = @[kt_port]" ).append("\n");
		query.append("   AND TRNS_SEQ = @[kt_seq]" ).append("\n");

	}
}