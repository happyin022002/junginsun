/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HoldNoticeDBDAOsearchHldNtcCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.15
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HoldNoticeDBDAOsearchHldNtcCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Hold Code정보를 조회한다.
	  * </pre>
	  */
	public HoldNoticeDBDAOsearchHldNtcCodeRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : HoldNoticeDBDAOsearchHldNtcCodeRSQL").append("\n"); 
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
		query.append("SELECT A.CSTMS_DSPO_CD AS VAL" ).append("\n"); 
		query.append("      ,A.CSTMS_DSPO_CD || DECODE(B.ATTR_CTNT4,NULL,'','/') || B.ATTR_CTNT4    AS NAME" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_DSPO     A" ).append("\n"); 
		query.append("      ,BKG_CSTMS_CD_CONV_CTNT B" ).append("\n"); 
		query.append(" WHERE A.CNT_CD        = @[cnt_cd]" ).append("\n"); 
		query.append("   AND A.DSPO_TP_CD    LIKE 'H%'" ).append("\n"); 
		query.append("   AND B.ATTR_CTNT1    = 'HOLD'" ).append("\n"); 
		query.append("   AND B.CNT_CD        = B.CNT_CD" ).append("\n"); 
		query.append("   AND B.ATTR_CTNT3    = A.CSTMS_DSPO_CD" ).append("\n"); 

	}
}