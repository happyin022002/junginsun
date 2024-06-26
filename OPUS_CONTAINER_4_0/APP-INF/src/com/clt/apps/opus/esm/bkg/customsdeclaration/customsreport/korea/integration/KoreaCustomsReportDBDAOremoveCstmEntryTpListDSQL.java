/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KoreaCustomsReportDBDAOremoveCstmEntryTpListDSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.10 박상훈
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

public class KoreaCustomsReportDBDAOremoveCstmEntryTpListDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 한국/인도 세관에 적하 목록 전송할 때 B/L의 통관 Type Code를 Delete한다.
	  * </pre>
	  */
	public KoreaCustomsReportDBDAOremoveCstmEntryTpListDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.integration ").append("\n");
		query.append("FileName : KoreaCustomsReportDBDAOremoveCstmEntryTpListDSQL").append("\n");
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
		query.append("DELETE BKG_CSTMS_CLR_ENTR_TP" ).append("\n");
		query.append("WHERE CNT_CD = @[cnt_cd]" ).append("\n");
		query.append("AND CSTMS_ENTR_CD = @[cstms_entr_cd]" ).append("\n");

	}
}