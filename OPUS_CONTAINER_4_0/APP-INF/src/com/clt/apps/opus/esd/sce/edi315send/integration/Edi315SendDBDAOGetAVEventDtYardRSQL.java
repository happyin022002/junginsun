/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Edi315SendDBDAOGetAVEventDtYardRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2017.01.23 김성욱
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

public class Edi315SendDBDAOGetAVEventDtYardRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetAVEventDtYard
	  * </pre>
	  */
	public Edi315SendDBDAOGetAVEventDtYardRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_event_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_event_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetAVEventDtYardRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(D XPKSCE_COP_DTL) */   " ).append("\n"); 
		query.append("       H.COP_NO, H.BKG_NO, H.CNTR_NO, H.POD_NOD_CD, D.ACT_CD, D.ACT_STS_CD, D.EDI_MSG_TP_CD" ).append("\n"); 
		query.append("     , D.STND_EDI_STS_CD CURR_STS" ).append("\n"); 
		query.append("     , TO_CHAR( CASE WHEN TO_CHAR(D.ESTM_DT,'mi') >= '01' AND TO_CHAR(D.ESTM_DT,'mi') <= '30' " ).append("\n"); 
		query.append("                          THEN D.ESTM_DT + NUMTODSINTERVAL(30 - TO_NUMBER(TO_CHAR(D.ESTM_DT,'mi')), 'MINUTE') " ).append("\n"); 
		query.append("                     WHEN TO_CHAR(D.ESTM_DT,'mi') >= '31' AND TO_CHAR(D.ESTM_DT,'mi') <= '59' " ).append("\n"); 
		query.append("                          THEN D.ESTM_DT + NUMTODSINTERVAL(60 - TO_NUMBER(TO_CHAR(D.ESTM_DT,'mi')),'MINUTE') " ).append("\n"); 
		query.append("                     ELSE D.ESTM_DT " ).append("\n"); 
		query.append("                 END" ).append("\n"); 
		query.append("               , 'YYYYMMDDHH24MISS') CURR_EVENT_DT_" ).append("\n"); 
		query.append("     , (SELECT CASE WHEN ACT_DT > TO_DATE(@[org_event_dt], 'YYYYMMDDHH24MISS') THEN" ).append("\n"); 
		query.append("                           TO_CHAR( CASE WHEN TO_CHAR(ACT_DT,'mi') >= '01' AND TO_CHAR(ACT_DT,'mi') <= '30' " ).append("\n"); 
		query.append("                                              THEN ACT_DT + NUMTODSINTERVAL(30 - TO_NUMBER(TO_CHAR(ACT_DT,'mi')), 'MINUTE') " ).append("\n"); 
		query.append("                                         WHEN TO_CHAR(ACT_DT,'mi') >= '31' AND TO_CHAR(ACT_DT,'mi') <= '59' " ).append("\n"); 
		query.append("                                              THEN ACT_DT + NUMTODSINTERVAL(60 - TO_NUMBER(TO_CHAR(ACT_DT,'mi')),'MINUTE') " ).append("\n"); 
		query.append("                                         ELSE ACT_DT " ).append("\n"); 
		query.append("                                     END" ).append("\n"); 
		query.append("                                   , 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                    ELSE @[org_event_dt]" ).append("\n"); 
		query.append("                END DT" ).append("\n"); 
		query.append("          FROM ( SELECT MAX(R.ACT_DT) AS ACT_DT " ).append("\n"); 
		query.append("                   FROM SCE_EDI_SND_RSLT R, SCE_EDI_MNG_AMS_STS S" ).append("\n"); 
		query.append("                  WHERE R.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                    AND R.EDI_STS_CD IN (@[org_sts_cd],S.EDI_PRE_SNT_STS_CD)" ).append("\n"); 
		query.append("                    AND S.EDI_ORG_STS_CD = @[org_sts_cd]" ).append("\n"); 
		query.append("                    AND S.EDI_EVNT_STS_CD = @[edi_sts_cd]" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("       ) CURR_EVENT_DT" ).append("\n"); 
		query.append("     , D.COP_DTL_SEQ CURR_COP_DTL_SEQ" ).append("\n"); 
		query.append("     , D.NOD_CD CURR_EVENT_YARD" ).append("\n"); 
		query.append("  FROM SCE_COP_HDR H, SCE_COP_DTL D" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND H.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("   AND H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("   AND (  (    @[edi_sts_cd] LIKE 'A%N'" ).append("\n"); 
		query.append("           AND D.ACT_CD LIKE 'FI%AD'" ).append("\n"); 
		query.append("           AND SUBSTR(D.ACT_CD, 4, 1) <> 'Z'" ).append("\n"); 
		query.append("           AND SUBSTR(H.POD_NOD_CD,1,5) <> SUBSTR(D.NOD_CD,1,5)" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("        OR" ).append("\n"); 
		query.append("          (    @[edi_sts_cd] LIKE 'A%L'" ).append("\n"); 
		query.append("           AND D.ACT_CD LIKE 'F%'" ).append("\n"); 
		query.append("           AND SUBSTR(H.POD_NOD_CD,1,5) = SUBSTR(D.NOD_CD,1,5)" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("        OR" ).append("\n"); 
		query.append("          (    @[edi_sts_cd] LIKE 'A%M'" ).append("\n"); 
		query.append("           AND D.ACT_CD LIKE 'F%'" ).append("\n"); 
		query.append("           AND SUBSTR(D.NOD_CD,1,5) = SUBSTR(@[org_event_yd], 1, 5)" ).append("\n"); 
		query.append("           AND 1 =1" ).append("\n"); 
		query.append("          )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}