/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProformaScheduleMgtDBDAOSearchVosiGangInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.21
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.10.21 서창열
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEO CHANG YUL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProformaScheduleMgtDBDAOSearchVosiGangInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchVosiGangInfo
	  * </pre>
	  */
	public ProformaScheduleMgtDBDAOSearchVosiGangInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etb_tm_hrmnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.proformaschedulemgt.integration").append("\n"); 
		query.append("FileName : ProformaScheduleMgtDBDAOSearchVosiGangInfoRSQL").append("\n"); 
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
		query.append("SELECT	NVL((				/* 입력 받은 PORT, GANG WORK START TIME이 일치 : 'N', 불일치 : 'Y' 표시. */" ).append("\n"); 
		query.append("SELECT	'N'			/* P/F SKD 작성시 'N'일 경우를 정상 작업 가능 시간으로 판단한다.		*/" ).append("\n"); 
		query.append("FROM	DUAL" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("AND	EXISTS (SELECT	'X'" ).append("\n"); 
		query.append("FROM	VSK_PORT_GNG_STRC S" ).append("\n"); 
		query.append("WHERE	S.LOC_CD		= @[port_cd]" ).append("\n"); 
		query.append("AND	S.GNG_WRK_ST_HRMNT	= @[etb_tm_hrmnt]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("), 'Y')  AS CHECK_WK_TM," ).append("\n"); 
		query.append("TRIM(MAX( DECODE(SEQ, 01, TM))	/* 최대 20까지 GANG 정보를 감안함 */" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 02), 1, CHR(10)|| MAX( DECODE(SEQ, 02, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 03), 1, CHR(10)|| MAX( DECODE(SEQ, 03, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 04), 1, CHR(10)|| MAX( DECODE(SEQ, 04, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 05), 1, CHR(10)|| MAX( DECODE(SEQ, 05, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 06), 1, CHR(10)|| MAX( DECODE(SEQ, 06, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 07), 1, CHR(10)|| MAX( DECODE(SEQ, 07, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 08), 1, CHR(10)|| MAX( DECODE(SEQ, 08, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 09), 1, CHR(10)|| MAX( DECODE(SEQ, 09, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 10), 1, CHR(10)|| MAX( DECODE(SEQ, 10, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 11), 1, CHR(10)|| MAX( DECODE(SEQ, 11, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 12), 1, CHR(10)|| MAX( DECODE(SEQ, 12, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 13), 1, CHR(10)|| MAX( DECODE(SEQ, 13, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 14), 1, CHR(10)|| MAX( DECODE(SEQ, 14, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 15), 1, CHR(10)|| MAX( DECODE(SEQ, 15, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 16), 1, CHR(10)|| MAX( DECODE(SEQ, 16, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 17), 1, CHR(10)|| MAX( DECODE(SEQ, 17, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 18), 1, CHR(10)|| MAX( DECODE(SEQ, 18, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 19), 1, CHR(10)|| MAX( DECODE(SEQ, 19, TM)))" ).append("\n"); 
		query.append("|| DECODE(SIGN(CNT + 1 - 20), 1, CHR(10)|| MAX( DECODE(SEQ, 20, TM)))" ).append("\n"); 
		query.append(") AS CRANE_WK_TM" ).append("\n"); 
		query.append("FROM	(SELECT	ROW_NUMBER() OVER (ORDER BY CRN_SEQ) AS SEQ" ).append("\n"); 
		query.append(", SUBSTR(GNG_WRK_ST_HRMNT, 1, 2) || ':' || SUBSTR(GNG_WRK_ST_HRMNT, 3, 2) AS TM" ).append("\n"); 
		query.append(", COUNT(*) OVER () AS CNT" ).append("\n"); 
		query.append(", GNG_WRK_ST_HRMNT" ).append("\n"); 
		query.append("FROM	VSK_PORT_GNG_STRC" ).append("\n"); 
		query.append("WHERE	LOC_CD	= @[port_cd]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY CNT" ).append("\n"); 

	}
}