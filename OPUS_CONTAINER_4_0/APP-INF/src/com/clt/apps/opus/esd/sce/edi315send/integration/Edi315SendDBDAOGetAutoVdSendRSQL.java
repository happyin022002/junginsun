/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOGetAutoVdSendRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.07
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.04.07 이윤정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGetAutoVdSendRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetAutoVdSend
	  * </pre>
	  */
	public Edi315SendDBDAOGetAutoVdSendRSQL(){
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
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetAutoVdSendRSQL").append("\n"); 
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
		query.append("SELECT  /*+ index_desc(SCE_COP_DTL XPKSCE_COP_DTL) */" ).append("\n"); 
		query.append("STND_EDI_STS_CD CURR_STS" ).append("\n"); 
		query.append(", to_char(EDI_ACT_SND_DT,'YYYYMMDDHH24MISS')CURR_EVENT_DT" ).append("\n"); 
		query.append(", COP_DTL_SEQ CURR_COP_DTL_SEQ" ).append("\n"); 
		query.append(", NOD_CD      CURR_EVENT_YARD" ).append("\n"); 
		query.append("FROM    SCE_COP_DTL" ).append("\n"); 
		query.append("WHERE   COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND     STND_EDI_STS_CD LIKE 'VD%'" ).append("\n"); 
		query.append("AND     EDI_ACT_SND_DT IS NOT NULL" ).append("\n"); 
		query.append("AND     ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}