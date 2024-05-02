/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOaddCstmEntryTpListCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.10 박상훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KoreaCustomsReportDBDAOaddCstmEntryTpListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * B/L의 통관 Type Code List INSERT
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOaddCstmEntryTpListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("entr_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_entr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration").append("\n");
		query.append("FileName : KoreaCustomsReportDBDAOaddCstmEntryTpListCSQL").append("\n");
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
		query.append("INSERT" ).append("\n");
		query.append("INTO BKG_CSTMS_CLR_ENTR_TP" ).append("\n");
		query.append("(" ).append("\n");
		query.append("CNT_CD" ).append("\n");
		query.append(", CSTMS_ENTR_CD" ).append("\n");
		query.append(", ENTR_NM" ).append("\n");
		query.append(", CRE_USR_ID" ).append("\n");
		query.append(", UPD_USR_ID" ).append("\n");
		query.append(")" ).append("\n");
		query.append("VALUES (" ).append("\n");
		query.append("@[cnt_cd]" ).append("\n");
		query.append(", @[cstms_entr_cd]" ).append("\n");
		query.append(", @[entr_nm]" ).append("\n");
		query.append(", @[usr_id]" ).append("\n");
		query.append(", @[usr_id]" ).append("\n");
		query.append(")" ).append("\n");

	}
}