/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchJapanEdiStsCodeRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.26
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.03.26 조원주
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchJapanEdiStsCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 신규 : 9
	  * 수정 : 5
	  * 삭제 : 1
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchJapanEdiStsCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration ").append("\n");
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchJapanEdiStsCodeRSQL").append("\n");
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
		query.append("SELECT INTG_CD_VAL_DP_DESC STS_CD" ).append("\n");
		query.append("FROM COM_INTG_CD_DTL " ).append("\n");
		query.append("WHERE INTG_CD_ID = 'CD03002'" ).append("\n");
		query.append("  AND INTG_CD_VAL_CTNT=@[in_sts_cd]" ).append("\n");

	}
}