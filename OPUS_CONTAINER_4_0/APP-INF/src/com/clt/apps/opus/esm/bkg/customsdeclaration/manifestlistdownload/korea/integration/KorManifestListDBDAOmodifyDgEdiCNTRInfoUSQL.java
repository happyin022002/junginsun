/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOmodifyDgEdiCNTRInfoUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.11.19 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOmodifyDgEdiCNTRInfoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * EDI 전송후 컨테이너 정보 UPDATE
	  * </pre>
	  */
	public KorManifestListDBDAOmodifyDgEdiCNTRInfoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n");
		query.append("FileName : KorManifestListDBDAOmodifyDgEdiCNTRInfoUSQL").append("\n");
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
		query.append("UPDATE  BKG_CSTMS_KR_DG_CGO" ).append("\n");
		query.append("SET     SND_DT      =   SYSDATE," ).append("\n");
		query.append("SND_USR_ID  =   @[user_id]" ).append("\n");
		query.append("WHERE   (BKG_NO, CSTMS_DECL_TP_CD, CNTR_NO, CNTR_SEQ)" ).append("\n");
		query.append("IN  (   SELECT BKG_NO, CSTMS_DECL_TP_CD, CNTR_NO, MAX(CNTR_SEQ)" ).append("\n");
		query.append("FROM    BKG_CSTMS_KR_DG_CGO" ).append("\n");
		query.append("WHERE   VSL_CD      =   SUBSTR(@[vvd], 1, 4)" ).append("\n");
		query.append("AND     SKD_VOY_NO  =   SUBSTR(@[vvd], 5, 4)" ).append("\n");
		query.append("AND     SKD_DIR_CD  =   SUBSTR(@[vvd], 9, 1)" ).append("\n");
		query.append("AND     ((@[io_bnd_cd] = 'I' AND CSTMS_DECL_TP_CD IN ('I', 'T')) OR" ).append("\n");
		query.append("(@[io_bnd_cd] = 'O' AND CSTMS_DECL_TP_CD IN ('E', 'R')))" ).append("\n");
		query.append("GROUP BY BKG_NO, CSTMS_DECL_TP_CD, CNTR_NO" ).append("\n");
		query.append(")" ).append("\n");

	}
}