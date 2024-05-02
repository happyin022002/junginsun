/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnAuditDBDAOSearchFFCmpnDetailChargebyBlListRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.16
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.08.16 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.ffcmpnaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FFCmpnAuditDBDAOSearchFFCmpnDetailChargebyBlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * SearchFFCmpnDetailChargebyBlList
	  * </pre>
	  */
	public FFCmpnAuditDBDAOSearchFFCmpnDetailChargebyBlListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmaudit.ffcmpnaudit.integration").append("\n");
		query.append("FileName : FFCmpnAuditDBDAOSearchFFCmpnDetailChargebyBlListRSQL").append("\n");
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
		query.append("SELECT C.CHG_CD," ).append("\n");
		query.append("       C.BKG_CHG_AMT" ).append("\n");
		query.append("  FROM ACM_AGN_BKG_INFO A," ).append("\n");
		query.append("       ACM_FF_CMPN B," ).append("\n");
		query.append("       ACM_FF_CMPN_REV C" ).append("\n");
		query.append(" WHERE A.BKG_NO = B.BKG_NO" ).append("\n");
		query.append("   AND B.CRE_USR_ID != 'COST'" ).append("\n");
		query.append("   AND B.FF_CMPN_SEQ = (SELECT /*+INDEX_DESC(x XPKACM_FF_CMPN)*/" ).append("\n");
		query.append("                               X.FF_CMPN_SEQ" ).append("\n");
		query.append("                          FROM ACM_FF_CMPN X" ).append("\n");
		query.append("                         WHERE X.BKG_NO = A.BKG_NO" ).append("\n");
		query.append("                           AND ROWNUM < 2)" ).append("\n");
		query.append("   AND B.BKG_NO = C.BKG_NO" ).append("\n");
		query.append("   AND B.FF_CMPN_SEQ = C.FF_CMPN_SEQ" ).append("\n");
		query.append("#if (${bkg_no} != '')" ).append("\n");
		query.append("   AND A.BKG_NO = @[bkg_no]" ).append("\n");
		query.append("#end" ).append("\n");
		query.append("#if (${bl_no} != '')" ).append("\n");
		query.append("   AND A.BL_NO = NVL (@[bl_no], A.BL_NO)" ).append("\n");
		query.append("#end" ).append("\n");

	}
}