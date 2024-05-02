/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralCodeSearchMgtDBDAOsearchMnrAgmtHdrDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.13
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.04.13 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeSearchMgtDBDAOsearchMnrAgmtHdrDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Agreement Header Version 정보를 조회한다.
	  * </pre>
	  */
	public GeneralCodeSearchMgtDBDAOsearchMnrAgmtHdrDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("searchkey",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("searchcon",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeSearchMgtDBDAOsearchMnrAgmtHdrDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.AGMT_VER_NO AS CD_ID" ).append("\n"); 
		query.append(",TO_CHAR(GLOBALDATE_PKG.TIME_CONV_OFC_FNC(MNR_COMMON_PKG.MNR_GET_HOOFC_FNC(), A.CRE_DT, A.AGMT_OFC_CD),'YYYY-MM-DD HH24:MI:SS') AS CD_DESC" ).append("\n"); 
		query.append("FROM MNR_AGMT_HDR A" ).append("\n"); 
		query.append("WHERE A.AGMT_OFC_CTY_CD = SUBSTR(@[searchkey], 1, 3)" ).append("\n"); 
		query.append("AND   A.AGMT_SEQ        = TO_NUMBER(SUBSTR(@[searchkey], 4))" ).append("\n"); 
		query.append("AND   A.AGMT_OFC_CD     = @[searchcon]" ).append("\n"); 
		query.append("ORDER BY A.AGMT_VER_NO DESC" ).append("\n"); 

	}
}