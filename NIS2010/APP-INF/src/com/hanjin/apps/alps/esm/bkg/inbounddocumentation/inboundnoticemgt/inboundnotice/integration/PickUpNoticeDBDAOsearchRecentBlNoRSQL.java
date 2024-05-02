/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PickUpNoticeDBDAOsearchRecentBlNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.02
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2010.02.02 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mi Ok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOsearchRecentBlNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container번호로 가장 최근 BKG No 를 가져 온다
	  * </pre>
	  */
	public PickUpNoticeDBDAOsearchRecentBlNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOsearchRecentBlNoRSQL").append("\n"); 
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
		query.append("SELECT BL_NO" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("        SELECT /*+ ORDERED USE_NL(A B) INDEX(A XAK1BKG_CONTAINER) */ " ).append("\n"); 
		query.append("               B.BL_NO" ).append("\n"); 
		query.append("              ,TO_CHAR(ROW_NUMBER() OVER(ORDER BY B.BKG_CRE_DT DESC)) RNUM " ).append("\n"); 
		query.append("          FROM BKG_CONTAINER A, BKG_BOOKING B" ).append("\n"); 
		query.append("         WHERE A.CNTR_NO    LIKE @[cntr_no] || '%'" ).append("\n"); 
		query.append("           AND B.BKG_NO     = A.BKG_NO" ).append("\n"); 
		query.append("           AND B.BKG_STS_CD IN ('F', 'W', 'A')" ).append("\n"); 
		query.append("           AND (B.POD_CD LIKE 'US%' OR B.POD_CD LIKE 'CA%')" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append(" WHERE RNUM = '1'" ).append("\n"); 

	}
}