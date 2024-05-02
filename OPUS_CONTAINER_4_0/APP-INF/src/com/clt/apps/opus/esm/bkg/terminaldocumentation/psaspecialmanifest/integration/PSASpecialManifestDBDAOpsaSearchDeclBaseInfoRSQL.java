/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : PSASpecialManifestDBDAOpsaSearchDeclBaseInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.12
*@LastModifier :
*@LastVersion : 1.0
* 2011.10.12
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SungJin Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PSASpecialManifestDBDAOpsaSearchDeclBaseInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Decl 기본정보를 조회한다.
	  * </pre>
	  */
	public PSASpecialManifestDBDAOpsaSearchDeclBaseInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("d_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("reason_resending",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("first_msg_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.integration").append("\n");
		query.append("FileName : PSASpecialManifestDBDAOpsaSearchDeclBaseInfoRSQL").append("\n");
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
		query.append("SELECT " ).append("\n");
		query.append("     '89N' DOC_NAME" ).append("\n");
		query.append("    ,@[d_type] HANDLING" ).append("\n");
		query.append("    ,(" ).append("\n");
		query.append("        SELECT DECODE(COUNT(*), 0, 'O', 'U') SEND_STATUS" ).append("\n");
		query.append("        FROM BKG_CSTMS_PSA_DG_SND" ).append("\n");
		query.append("        WHERE PSA_EDI_MSG_TP_ID = 'IFD'" ).append("\n");
		query.append("        AND   PSA_DG_DECL_TP_CD = @[d_type]" ).append("\n");
		query.append("		AND   VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n");
		query.append("		AND   SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n");
		query.append("		AND   SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n");
		query.append("		AND   PORT_CD     = @[port_cd]" ).append("\n");
		query.append("    ) STATUS -- Cancel전송 클릭 시 'C', 최초전송이면 'O', BKG_CSTMS_EUR_DG_SND_LOG에 존재하면 'U'" ).append("\n");
		query.append("    ,NVL(@[reason_resending], '') REASON" ).append("\n");
		query.append("    ,'' USER_REF -- 전송로그 MSN_SND_NO를 사용함" ).append("\n");
		query.append("    ,'' OLD_USER_REF" ).append("\n");
		query.append("    ,''  FIRST_USER_REF" ).append("\n");
		query.append("    ,(SELECT /*+ INDEX_DESC(BKG_CSTMS_EUR_DG_RCV XPKBKG_CSTMS_EUR_DG_RCV)*/ SCR_FILE_NO" ).append("\n");
		query.append("      FROM BKG_CSTMS_PSA_DG_RCV" ).append("\n");
		query.append("      WHERE PSA_EDI_MSG_TP_ID = 'IFD'" ).append("\n");
		query.append("      AND MSG_RCV_NO = @[first_msg_snd_no]" ).append("\n");
		query.append("	  AND ROWNUM = 1" ).append("\n");
		query.append("	) SEC_FILE_NBR" ).append("\n");
		query.append("    ,'' FF_REF -- 확인 요망" ).append("\n");
		query.append("" ).append("\n");
		query.append("FROM DUAL" ).append("\n");

	}
}