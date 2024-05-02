/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgentCanalTransitFeeBCDBDAOsearchCanalTzVVDListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 손흥식
*@LastVersion : 1.0
* 2009.09.15 손흥식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Heung Sik
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgentCanalTransitFeeBCDBDAOsearchCanalTzVVDListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCanalTzVVDList
	  * </pre>
	  */
	public AgentCanalTransitFeeBCDBDAOsearchCanalTzVVDListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("revyrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("transymd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.integration").append("\n"); 
		query.append("FileName : AgentCanalTransitFeeBCDBDAOsearchCanalTzVVDListRSQL").append("\n"); 
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
		query.append("SELECT (SELECT VSL_ENG_NM FROM MDM_VSL_CNTR WHERE VSL_CD = A.VSL_CD) VSL_NM" ).append("\n"); 
		query.append(",A.VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append(",A.SLAN_CD LANE" ).append("\n"); 
		query.append(",A.YD_CD" ).append("\n"); 
		query.append(",A.TRNS_DT" ).append("\n"); 
		query.append(",(SELECT TO_CHAR(X.DUE_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append("FROM PSO_CHARGE X" ).append("\n"); 
		query.append("WHERE X.ISS_CTY_CD = A.ISS_CTY_CD" ).append("\n"); 
		query.append("AND X.SO_SEQ = A.SO_SEQ" ).append("\n"); 
		query.append(") PY_DUE_DT" ).append("\n"); 
		query.append(",ADV_PY_STS  --'A', 'P'" ).append("\n"); 
		query.append(",(SELECT NTC_YRMON FROM PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("WHERE A.VSL_CD =VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SKD_DIR_CD" ).append("\n"); 
		query.append("AND PSO_BZTP_CD = 5" ).append("\n"); 
		query.append("AND CNL_TZ_BZTP_CD = 'E'" ).append("\n"); 
		query.append(") ADV_PY_REV_MON" ).append("\n"); 
		query.append(",(SELECT NVL(MAX(CALL_SEQ),'1') FROM PSO_CNL_TZ_FEE  --존재하지 않을때 초기값 1, 실제로는 존재하지 않을 수 없다." ).append("\n"); 
		query.append("WHERE VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("AND SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND YD_CD        = A.YD_CD" ).append("\n"); 
		query.append("AND 'E'          = CNL_TZ_BZTP_CD) ESEQ" ).append("\n"); 
		query.append(",(SELECT NVL(MAX(CALL_SEQ),'2')+1 FROM PSO_CNL_TZ_FEE  --존재하지 않을때 초기값2, 실제로는 존재하지 않을 수 없다. \"추가되는 값 =(존재하는MAX값+1)\" 이 된다." ).append("\n"); 
		query.append("WHERE VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("AND SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND YD_CD        = A.YD_CD" ).append("\n"); 
		query.append("AND 'I'          = CNL_TZ_BZTP_CD) ISEQ" ).append("\n"); 
		query.append(",'' REVYRMON" ).append("\n"); 
		query.append(",'' TRANSYMD" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT  A.VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append(",A.SLAN_CD" ).append("\n"); 
		query.append(",C.YD_CD" ).append("\n"); 
		query.append(",A.VPS_PORT_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.VPS_ETA_DT,'YYYY-MM-DD') TRNS_DT" ).append("\n"); 
		query.append(",(SELECT ISS_CTY_CD" ).append("\n"); 
		query.append("FROM PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("WHERE VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("AND SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND YD_CD        = C.YD_CD" ).append("\n"); 
		query.append("AND 'E'          = CNL_TZ_BZTP_CD" ).append("\n"); 
		query.append(") ISS_CTY_CD" ).append("\n"); 
		query.append(",(SELECT SO_SEQ" ).append("\n"); 
		query.append("FROM PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("WHERE VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("AND SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND YD_CD        = C.YD_CD" ).append("\n"); 
		query.append("AND 'E'          = CNL_TZ_BZTP_CD" ).append("\n"); 
		query.append(") SO_SEQ" ).append("\n"); 
		query.append(",(SELECT CNL_TZ_PROC_STS_CD" ).append("\n"); 
		query.append("FROM PSO_CNL_TZ_FEE" ).append("\n"); 
		query.append("WHERE VSL_CD       = A.VSL_CD" ).append("\n"); 
		query.append("AND SKD_VOY_NO   = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND SKD_DIR_CD   = A.SKD_DIR_CD" ).append("\n"); 
		query.append("AND YD_CD        = C.YD_CD" ).append("\n"); 
		query.append("AND 'E'          = CNL_TZ_BZTP_CD" ).append("\n"); 
		query.append(") AS ADV_PY_STS" ).append("\n"); 
		query.append(",C.VNDR_SEQ" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD A, MDM_VSL_SVC_LANE B, PSO_CNL_TZ_FEE C, VSK_VSL_SKD D" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VPS_PORT_CD = (SELECT decode(vndr_cnt_cd,'PA','PAPAC','EGSUZ') FROM MDM_VENDOR WHERE VNDR_SEQ=@[vndr_seq])" ).append("\n"); 
		query.append("AND VPS_ETA_DT BETWEEN TO_DATE(@[transymd],'YYYYMMDD')-7 AND TO_DATE(@[transymd],'YYYYMMDD')+7" ).append("\n"); 
		query.append("AND B.VSL_SLAN_CD = D.VSL_SLAN_CD" ).append("\n"); 
		query.append("AND B.CNL_AGN_VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND A.VSL_CD = C.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = C.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = C.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.YD_CD = C.YD_CD" ).append("\n"); 
		query.append("AND C.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND C.NTC_YRMON < @[revyrmon]" ).append("\n"); 
		query.append("AND C.CNL_TZ_BZTP_CD = 'I'" ).append("\n"); 
		query.append("AND C.PSO_BZTP_CD = 5" ).append("\n"); 
		query.append("AND C.CNL_TZ_PROC_STS_CD ='A'" ).append("\n"); 
		query.append("AND D.VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("AND D.SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("AND D.SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("GROUP BY A.VSL_CD" ).append("\n"); 
		query.append(",A.SKD_VOY_NO" ).append("\n"); 
		query.append(",A.SKD_DIR_CD" ).append("\n"); 
		query.append(",A.SLAN_CD" ).append("\n"); 
		query.append(",C.YD_CD" ).append("\n"); 
		query.append(",A.VPS_PORT_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.VPS_ETA_DT,'YYYY-MM-DD')" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(") A" ).append("\n"); 

	}
}