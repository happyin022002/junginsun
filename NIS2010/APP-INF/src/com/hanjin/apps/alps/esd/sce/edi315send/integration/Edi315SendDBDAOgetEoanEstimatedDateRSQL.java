/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Edi315SendDBDAOgetEoanEstimatedDateRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOgetEoanEstimatedDateRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DEL Delivery Time 변경 시 자동 전송 로직 추가 요청
	  * EDI Status Code : EOAN은 COP Detail상의 MITYAD(MT)가 아닌 마지막 Arrival에 해당(Activity Code 5자리가 A인) Activity의 Estimated Date를 가져온다.
	  * </pre>
	  */
	public Edi315SendDBDAOgetEoanEstimatedDateRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOgetEoanEstimatedDateRSQL").append("\n"); 
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
		query.append("SELECT /*+ index_desc(SCE_COP_DTL XPKSCE_COP_DTL) */   " ).append("\n"); 
		query.append("	   TO_CHAR(ESTM_DT,'YYYYMMDDHH24MISS') CURR_EVENT_DT" ).append("\n"); 
		query.append("	 , COP_DTL_SEQ CURR_COP_DTL_SEQ" ).append("\n"); 
		query.append("	 , NOD_CD CURR_EVENT_YARD" ).append("\n"); 
		query.append("  FROM SCE_COP_DTL             " ).append("\n"); 
		query.append(" WHERE COP_NO = @[cop_no]" ).append("\n"); 
		query.append("   AND SUBSTR(ACT_CD, 5, 1) = 'A'" ).append("\n"); 
		query.append("   AND ACT_CD NOT IN ('MITYAD','FITZAD')" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}