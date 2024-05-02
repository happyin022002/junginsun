/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchCntrforNewBkgSeqRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.20
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.03.20 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchCntrforNewBkgSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchCntrforNewBkgSeq
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchCntrforNewBkgSeqRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n");
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchCntrforNewBkgSeqRSQL").append("\n");
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
		query.append("SELECT MAX(BKG_SKD_SEQ+1) max_seq" ).append("\n");
		query.append("FROM BKG_TML_EDI_JP_CNTR" ).append("\n");
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n");
		query.append("--   AND CNTR_NO = [cntr_no]" ).append("\n");

	}
}