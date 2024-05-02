/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOSearchIsCurrCopDtlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.18
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.05.18 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchIsCurrCopDtlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Edi315SendDBDAOSearchIsCurrCopDtlRSQL
	  * </pre>
	  */
	public Edi315SendDBDAOSearchIsCurrCopDtlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_event_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_edi_sts",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchIsCurrCopDtlRSQL").append("\n"); 
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
		query.append("SELECT  TO_CHAR(DECODE(@[e_edi_sts] ,'VE',d.ESTM_DT,'AG',d.ESTM_DT ,'AD',d.ESTM_DT,d.ACT_DT),'yyyymmddhh24miss') CURR_EVENT_DT" ).append("\n"); 
		query.append("      , d.NOD_CD                                      CURR_EVENT_YARD" ).append("\n"); 
		query.append("      , d.COP_DTL_SEQ                                 CURR_COP_DTL_SEQ" ).append("\n"); 
		query.append("	  ,'' CURR_STS" ).append("\n"); 
		query.append("  FROM SCE_COP_DTL d, SCE_COP_HDR h, BKG_BOOKING b " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND d.COP_NO = @[e_cop_no]" ).append("\n"); 
		query.append("   AND d.COP_NO = h.COP_NO" ).append("\n"); 
		query.append("   AND h.BKG_NO = b.BKG_NO" ).append("\n"); 
		query.append("#if(${e_edi_sts} == 'AG' || ${e_edi_sts} == 'AD')" ).append("\n"); 
		query.append("   AND d.ACT_CD = 'FITZAD'  " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND (d.STND_EDI_STS_CD = DECODE(@[e_edi_sts] ,'VE','VAD',@[e_edi_sts])" ).append("\n"); 
		query.append("    OR d.ACT_CD = @[e_edi_sts]" ).append("\n"); 
		query.append("    OR d.ACT_STS_MAPG_CD = @[e_edi_sts]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND SUBSTR(d.NOD_CD,1,5) = DECODE(@[e_edi_sts] ,'VE',SUBSTR(d.NOD_CD,1,5)" ).append("\n"); 
		query.append("									,'AG',SUBSTR(d.NOD_CD,1,5)" ).append("\n"); 
		query.append("									,'AD',SUBSTR(d.NOD_CD,1,5)" ).append("\n"); 
		query.append("					  ,SUBSTR(@[e_event_yard],1,5))" ).append("\n"); 

	}
}